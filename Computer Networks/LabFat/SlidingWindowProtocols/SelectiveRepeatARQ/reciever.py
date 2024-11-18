import socket
import random

ACK_LOSS_PROBABILITY = 0.2
PACKET_SIZE = 2048
RECEIVER_ADDR = ('localhost', 12345)
WINDOW_SIZE = 4

def create_ack(seq_num):
    return f"ACK:{seq_num}".encode()

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

def extract_data(packet):
    try:
        parts = packet.decode().split(":")
        return parts[1]
    except:
        print("Invalid packet format")
        return ""

def send_ack(sock, seq_num, address):
    if random.random() < ACK_LOSS_PROBABILITY:
        print(f"ACK {seq_num} lost")
        return

    ack = create_ack(seq_num)
    print(f"Sending ACK {seq_num}")
    sock.sendto(ack, address)

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    sock.bind(RECEIVER_ADDR)

    expected_seq_num = 0
    received_buffer = {}

    while True:
        try:
            packet, addr = sock.recvfrom(PACKET_SIZE)
            seq_num = extract_seq_num(packet)
            if seq_num == -1:
                continue

            data = extract_data(packet)
            print(f"Received packet {seq_num}: {data} from {addr}")

            if expected_seq_num <= seq_num < expected_seq_num + WINDOW_SIZE:
                send_ack(sock, seq_num, addr)
                if seq_num not in received_buffer:
                    received_buffer[seq_num] = data

                # Deliver packets in order and slide the window
                while expected_seq_num in received_buffer:
                    print(f"Delivered data: {received_buffer[expected_seq_num]}")
                    del received_buffer[expected_seq_num]
                    expected_seq_num += 1
            elif seq_num < expected_seq_num:
                # If packet is out of the current window, still acknowledge it
                send_ack(sock, seq_num, addr)

        except socket.timeout:
            print("Timeout")
            continue

if __name__ == "__main__":
    main()
