import socket
from threading import Thread

class ClientThread(Thread):
    def __init__(self, conn, ip, port):
        Thread.__init__(self)
        self.conn = conn
        self.ip = ip
        self.port = port
        print(f"New client thread started at {ip}:{port}")

    def run(self):
        while True:
            try:
                data = self.conn.recv(2048).decode('utf-8')
                if not data:
                    break
                print(f"{self.ip}:{self.port} -> {data}")
                response = f"Server recieved {data}"

                self.conn.send(response.encode())
            except ConnectionResetError:
                print(f"Connection reset by {self.ip}:{self.port}")

        print(f"Client disconnected:{self.ip}:{self.port}")
        self.conn.close()

def main():
    TCP_IP = '127.0.0.1'
    TCP_PORT = 2356

    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    server_socket.bind((TCP_IP, TCP_PORT))
    server_socket.listen(5)

    print(f"Server is listening on {TCP_IP}:{TCP_PORT}")

    threads = []

    try:
        while True:
            conn, (ip, port) = server_socket.accept()
            new_thread = ClientThread(conn, ip, port)
            new_thread.start()
            threads.append(new_thread)

    except KeyboardInterrupt:
        print("Server is shutting down...")
    finally:
        server_socket.close()
        for t in threads:
            t.join()

if __name__ == '__main__':
    main()
