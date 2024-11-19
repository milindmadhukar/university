import socket

s=socket.socket()
print("Socket successfully created")

port = 12345
s.bind(("", port))
print(f"Socket binded to port {port}")

s.listen(5)
print("Socket is listening")

while True:
    c, addr = s.accept()
    print("Got connection from", addr)
    c.send("Thank you for connecting".encode())
    print("Disconnecting...")
    c.close()
