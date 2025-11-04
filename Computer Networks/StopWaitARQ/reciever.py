import socket
import random


# Receiver configuration
RECEIVER_ADDRESS = ('localhost', 12345)
PACKET_SIZE = 1024
ACK_LOSS_PROBABILITY = 0.2


def create_ack(seq_num):
    return f"ACK:{seq_num}".encode()


def extract_seq_num(packet):
    try:
        return int(packet.decode().split(':')[0])
    except (IndexError, ValueError):
        print(f"Invalid packet format: {packet}")
        return None


def extract_data(packet):
    try:
        return packet.decode().split(':', 1)[1]
    except IndexError:
        print(f"Invalid packet format: {packet}")
        return None


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


    while True:
        packet, address = sock.recvfrom(PACKET_SIZE)
        seq_num = extract_seq_num(packet)
        if seq_num is None:
            continue
        
        data = extract_data(packet)
        if data is None:
            continue
        
        print(f"Received packet: {packet.decode()}")


        if seq_num == expected_seq_num:
            print(f"Delivered data: {data}")
            expected_seq_num = 1 - expected_seq_num  # Toggle expected sequence number
        else:
            print("Duplicate packet, discarding")


        send_ack(sock, seq_num, address)


if __name__ == "__main__":
    receiver()
