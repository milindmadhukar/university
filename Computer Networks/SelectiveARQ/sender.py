# Selective Repeat ARQ Sender
import socket
import time
import random


# Sender configuration
RECEIVER_ADDRESS = ('localhost', 12345)
PACKET_SIZE = 1024
TIMEOUT = 2.0
WINDOW_SIZE = 4
PACKET_LOSS_PROBABILITY = 0.2


def create_packet(seq_num, data):
    return f"{seq_num}:{data}".encode()


def extract_seq_num(packet):
    return int(packet.decode().split(':')[0])


def simulate_packet_loss():
    return random.random() < PACKET_LOSS_PROBABILITY


def send_packet(sock, packet):
    if not simulate_packet_loss():
        sock.sendto(packet, RECEIVER_ADDRESS)
        print(f"Sent packet: {packet.decode()}")
    else:
        print(f"Packet lost: {packet.decode()}")


def receive_ack(sock):
    try:
        ack, _ = sock.recvfrom(PACKET_SIZE)
        print(f"Received ACK: {ack.decode()}")
        return extract_seq_num(ack)
    except socket.timeout:
        print("ACK timeout")
        return None


def sender():
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    sock.settimeout(TIMEOUT)


    base = 0
    next_seq_num = 0
    messages = ["Message" + str(i) for i in range(20)]
    buffer = {}
    timers = {}


    while base < len(messages):
        # Send packets within the window
        while next_seq_num < base + WINDOW_SIZE and next_seq_num < len(messages):
            if next_seq_num not in buffer:  # Avoid resending already buffered packets
                packet = create_packet(next_seq_num, messages[next_seq_num])
                send_packet(sock, packet)
                buffer[next_seq_num] = packet
                timers[next_seq_num] = time.time()
            next_seq_num += 1


        # Wait for ACK or timeout
        try:
            ack = receive_ack(sock)
            if ack is not None:
                if ack >= base and ack < next_seq_num:
                    print(f"ACK {ack} received, sliding window")
                    del buffer[ack]
                    del timers[ack]
                    while base not in buffer and base < next_seq_num:
                        base += 1
        except socket.timeout:
            pass


        # Check for timeouts and retransmit packets if necessary
        current_time = time.time()
        for seq_num in list(timers.keys()):
            if current_time - timers[seq_num] > TIMEOUT:
                print(f"Timeout for packet {seq_num}, resending")
                send_packet(sock, buffer[seq_num])
                timers[seq_num] = current_time


    sock.close()


if __name__ == "__main__":
    sender()
