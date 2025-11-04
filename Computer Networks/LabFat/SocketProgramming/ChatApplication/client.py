import socket
import threading

def receive_messages(client_socket):
    while True:
        try:
            message = client_socket.recv(2048).decode('utf-8')
            print(message)
        except:
            print("An error occurred!")
            client_socket.close()
            break

def main():
    host = '127.0.0.1'
    port = 2356

    print(f"Connecting to chat server at {host}:{port}")
    
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect((host, port))
    
    username = input("Enter your username: ")
    client_socket.send(username.encode('utf-8'))

    print("Connected to the chat server. Type 'quit' to exit.")

    # Start a thread to receive messages
    receive_thread = threading.Thread(target=receive_messages, args=(client_socket,))
    receive_thread.start()

    while True:
        message = input()
        
        if message.lower() == 'quit':
            break
        
        client_socket.send(message.encode('utf-8'))
    
    print("Leaving the chat...")
    client_socket.close()

if __name__ == "__main__":
    main()
