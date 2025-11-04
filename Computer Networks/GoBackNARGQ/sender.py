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


    base = 0
    next_seq_num = 0
    messages = ["Message" + str(i) for i in range(20)]
    buffer = []


    while base < len(messages):
        # Send packets within the window
        while next_seq_num < base + WINDOW_SIZE and next_seq_num < len(messages):
            packet = create_packet(next_seq_num, messages[next_seq_num])
            send_packet(sock, packet)
            if next_seq_num == base:
                timer = time.time()
            buffer.append(packet)
            next_seq_num += 1


        # Wait for ACK or timeout
        try:
            ack = receive_ack(sock)
            if ack is not None and ack >= base:
                base = ack + 1
                buffer = buffer[ack - base + 1:]
                timer = time.time()
        except socket.timeout:
            pass


        # Check for timeout
        if time.time() - timer > TIMEOUT:
            print("Timeout, resending window")
            next_seq_num = base
            for packet in buffer:
                send_packet(sock, packet)
            timer = time.time()


    sock.close()


if __name__ == "__main__":
    sender()
