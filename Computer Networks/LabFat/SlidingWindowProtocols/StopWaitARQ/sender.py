import socket
import random

RECEIVER_ADDR = ('localhost', 12345)
PACKET_SIZE = 2048
TIMEOUT = 2
PACKET_LOSS_PROBABILITY = 0.2

def create_packet(seq_num, data):
    return f"{seq_num}:{data}".encode()

def send_packet(sock, packet):
    if random.random() < PACKET_LOSS_PROBABILITY:
        print(f"Packet {packet} lost")
        return

    print(f"Sending packet {packet}")
    sock.sendto(packet, RECEIVER_ADDR)

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

    seq_num = 0

    messages = ["Hello", "World", "Stop", "and", "Wait", "ARQ"]

    for message in messages:
        packet = create_packet(seq_num, message)
        while True:
            send_packet(sock, packet)
            ack_seq_num = receive_ack(sock)
            if ack_seq_num == seq_num:
                print(f"ACK {seq_num} received successfully")
                seq_num = 1 - seq_num
                break
            else:
                print(f"ACK {seq_num} not received. Retransmitting...")

    sock.close()

if __name__ == "__main__":
    main()
