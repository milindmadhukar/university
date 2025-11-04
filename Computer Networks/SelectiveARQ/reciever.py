# Selective Repeat ARQ Receiver
import socket
import random


# Receiver configuration
RECEIVER_ADDRESS = ('localhost', 12345)
PACKET_SIZE = 1024
WINDOW_SIZE = 4
ACK_LOSS_PROBABILITY = 0.2


def create_ack(seq_num):
    return f"ACK:{seq_num}".encode()


def extract_seq_num(packet):
    return int(packet.decode().split(':')[0])


def extract_data(packet):
    return packet.decode().split(':', 1)[1]


def simulate_ack_loss():
    return random.random() < ACK_LOSS_PROBABILITY


def send_ack(sock, seq_num, address):
    ack = create_ack(seq_num)
    if not simulate_ack_loss():
        sock.sendto(ack, address)
        print(f"Sent ACK: {ack.decode()}")
    else:
        print(f"ACK lost: {ack.decode()}")


def receiver():
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    sock.bind(RECEIVER_ADDRESS)
    print(f"Receiver listening on {RECEIVER_ADDRESS}")


    expected_seq_num = 0
    received_buffer = {}


    while True:
        packet, address = sock.recvfrom(PACKET_SIZE)
        seq_num = extract_seq_num(packet)
        data = extract_data(packet)
        print(f"Received packet: {packet.decode()}")


        if expected_seq_num <= seq_num < expected_seq_num + WINDOW_SIZE:
            send_ack(sock, seq_num, address)
            if seq_num not in received_buffer:
                received_buffer[seq_num] = data


            # Deliver packets in order and slide the window
            while expected_seq_num in received_buffer:
                print(f"Delivered data: {received_buffer[expected_seq_num]}")
                del received_buffer[expected_seq_num]
                expected_seq_num += 1
        elif seq_num < expected_seq_num:
            # If packet is out of the current window, still acknowledge it
            send_ack(sock, seq_num, address)


if __name__ == "__main__":
    receiver()
