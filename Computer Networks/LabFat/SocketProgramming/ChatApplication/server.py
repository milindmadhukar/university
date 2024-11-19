import socket
from threading import Thread, Lock

class ClientThread(Thread):
    def __init__(self, conn, ip, port, clients, lock):
        Thread.__init__(self)
        self.conn = conn
        self.ip = ip
        self.port = port
        self.clients = clients
        self.lock = lock
        self.username = None
        print(f"[+] New connection from {ip}:{port}")

    def run(self):
        # Get username
        self.username = self.conn.recv(2048).decode('utf-8').strip()
        print(f"{self.username} has joined the chat.")
        self.broadcast(f"SERVER: {self.username} has joined the chat.")

        while True:
            try:
                data = self.conn.recv(2048).decode('utf-8')
                if not data:
                    break
                print(f"Received from {self.username}: {data}")
                self.broadcast(f"{self.username}: {data}")
            except ConnectionResetError:
                break
        
        print(f"{self.username} has left the chat.")
        self.broadcast(f"SERVER: {self.username} has left the chat.")
        self.remove_client()

    def broadcast(self, message):
        with self.lock:
            for client in self.clients:
                if client != self:
                    try:
                        client.conn.send(message.encode('utf-8'))
                    except:
                        self.remove_client(client)

    def remove_client(self, client=None):
        with self.lock:
            if client is None:
                client = self
            if client in self.clients:
                self.clients.remove(client)
                client.conn.close()

def main():
    TCP_IP = '127.0.0.1'
    TCP_PORT = 2356
    
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    server_socket.bind((TCP_IP, TCP_PORT))
    server_socket.listen(5)
    
    print(f"Chat server is listening on {TCP_IP}:{TCP_PORT}")
    
    clients = []
    lock = Lock()
    
    try:
        while True:
            conn, (ip, port) = server_socket.accept()
            new_client = ClientThread(conn, ip, port, clients, lock)
            clients.append(new_client)
            new_client.start()
    
    except KeyboardInterrupt:
        print("\nServer is shutting down...")
    
    finally:
        server_socket.close()
        for client in clients:
            client.conn.close()

if __name__ == "__main__":
    main()
