import socket
import threading

def handle_client(client_socket, client_address):
    print(f"New connection from {client_address}")
    
    # Send initial confirmation message
    client_socket.send("Connection established with the server.".encode())
    
    while True:
        try:
            # Receive data from the client
            data = client_socket.recv(1024).decode()
            if not data:
                print(f"Client {client_address} disconnected")
                break
            
            # Print the received message
            print(f"Received from {client_address}: {data}")
            
            # Prepend "Server message: " and send it back
            response = f"Server message: {data}"
            client_socket.send(response.encode())
            
        except ConnectionResetError:
            print(f"Connection reset by client {client_address}")
            break
    
    # Close the client socket
    client_socket.close()

def main():
    # Create a TCP socket and bind to localhost on port 2356
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind(('localhost', 2356))
    
    # Listen for incoming connections
    server_socket.listen(5)
    print("Server is listening on localhost:2356")
    
    try:
        while True:
            # Accept a client connection
            client_socket, client_address = server_socket.accept()
            
            # Create a new thread to handle the client
            client_thread = threading.Thread(target=handle_client, args=(client_socket, client_address))
            client_thread.start()
    
    except KeyboardInterrupt:
        print("Server is shutting down...")
    
    finally:
        # Close the server socket
        server_socket.close()

if __name__ == "__main__":
    main()
