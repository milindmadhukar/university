import socket
import random
import time

RECEIVER_ADDR = ('localhost', 12345)
PACKET_SIZE = 2048
TIMEOUT = 2
PACKET_LOSS_PROBABILITY = 0.2
WINDOW_SIZE = 4

def create_packet(seq_num, data):
    return f"{seq_num}:{data}".encode()

def send_packet(sock, packet, addr):
    if random.random() < PACKET_LOSS_PROBABILITY:
        print(f"Packet {packet} lost")
        return

    print(f"Sending packet {packet}")
    sock.sendto(packet, addr)

def extract_seq_num(packet):
    try:
        parts = packet.decode().split(":")
        if parts[0] == "ACK":
            return int(parts[1])
        else:
            return int(parts[0])
    except:
        print("Invalid packet format")
        return -1

def receive_ack(sock):
    try:
        ack, addr = sock.recvfrom(PACKET_SIZE)
        ack_seq_num = extract_seq_num(ack)
        print(f"Received ACK {ack_seq_num} from {addr}")
        return ack_seq_num
    except socket.timeout:
        print("Timeout")
        return None

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    sock.settimeout(TIMEOUT)

    base = 0
    next_seq_num = 0
    messages = ["Hello", "World", "This", "Is", "A", "Test", "Message", "For", "Selective", "Repeat", "ARQ"]
    buffer = {}
    timers = {}

    while base < len(messages):
        # Send packets within the window
        while next_seq_num < base + WINDOW_SIZE and next_seq_num < len(messages):
            if next_seq_num not in buffer:
                packet = create_packet(next_seq_num, messages[next_seq_num])
                send_packet(sock, packet, RECEIVER_ADDR)
                buffer[next_seq_num] = packet
                timers[next_seq_num] = time.time()
            next_seq_num += 1

        # Wait for ACK or timeout
        ack_seq_num = receive_ack(sock)
        if ack_seq_num is not None:
            if ack_seq_num >= base and ack_seq_num < next_seq_num:
                print(f"ACK {ack_seq_num} received, removing from buffer")
                del buffer[ack_seq_num]
                del timers[ack_seq_num]
                while base not in buffer and base < next_seq_num:
                    base += 1

        # Check for timeouts and retransmit packets if necessary
        current_time = time.time()
        for seq_num in list(timers.keys()):
            if current_time - timers[seq_num] > TIMEOUT:
                print(f"Timeout for packet {seq_num}, resending")
                send_packet(sock, buffer[seq_num], RECEIVER_ADDR)
                timers[seq_num] = current_time

    sock.close()

if __name__ == "__main__":
    main()
