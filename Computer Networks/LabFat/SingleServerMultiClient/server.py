import socket
import threading

def handle_client(client_socket, address):
    print(f"New connection from {address}")
    
    while True:
        try:
            data = client_socket.recv(2048).decode('utf-8')
            if not data:
                break
            print(f"Received from {address}: {data}")
        except ConnectionResetError:
            print(f"Connection reset by {address}")
            break
        except Exception as e:
            print(f"Error handling client {address}: {e}")
            break
    
    print(f"Connection from {address} closed")
    client_socket.close()

def main():
    host = '127.0.0.1'
    port = 2356
    
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind((host, port))
    server_socket.listen(5)
    
    print(f"Server listening on {host}:{port}")
    
    while True:
        client_socket, address = server_socket.accept()
        client_thread = threading.Thread(target=handle_client, args=(client_socket, address))
        client_thread.start()

if __name__ == "__main__":
    main()
