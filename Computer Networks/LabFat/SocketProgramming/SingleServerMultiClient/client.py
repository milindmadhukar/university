import socket

def main():
    host = '127.0.0.1'
    port = 2356
    BUFFER_SIZE = 2048

    print(f"Connecting to server at {host}:{port}")
    
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect((host, port))
    
    print("Connected to server. Type 'quit' to exit.")

    while True:
        message = input("Enter message: ")
        
        if message.lower() == 'quit':
            break
        
        client_socket.send(message.encode('utf-8'))

        try:
            data = client_socket.recv(BUFFER_SIZE).decode('utf-8')
            print(f"Server response: {data}")
        except ConnectionResetError:
            print("Connection was reset by the server.")
            break
    
    print("Closing connection")
    client_socket.close()

if __name__ == "__main__":
    main()
