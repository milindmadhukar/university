import socket
import time
import random


# Sender configuration
RECEIVER_ADDRESS = ('localhost', 12345)
PACKET_SIZE = 1024
TIMEOUT = 2.0
PACKET_LOSS_PROBABILITY = 0.2
ACK_LOSS_PROBABILITY = 0.2


def create_packet(seq_num, data):
    return f"{seq_num}:{data}".encode()


def extract_seq_num(packet):
    try:
        parts = packet.decode().split(':')
        if parts[0] == 'ACK':
            return int(parts[1])
        else:
            return int(parts[0])
    except (IndexError, ValueError):
        print(f"Invalid packet format: {packet}")
        return None


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


    seq_num = 0
    messages = ["Hello", "World", "Stop", "and", "Wait", "ARQ"]


    for message in messages:
        packet = create_packet(seq_num, message)
        while True:
            send_packet(sock, packet)
            ack_seq_num = receive_ack(sock)


            if ack_seq_num == seq_num:
                print(f"Message '{message}' sent successfully")
                seq_num = 1 - seq_num  # Toggle sequence number
                break
            else:
                print("Retransmitting...")


    sock.close()


if __name__ == "__main__":
    sender()
