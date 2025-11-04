import socket

s = socket.socket()
print("Socket created successfully")

port = 12345
s.bind(("", port))

print("Socket binded to port:", port)

s.listen(5)
print("Socket is listening for connections")

while True:
    c, addr = s.accept()
    print("Got connection from", addr)
    c.send("Thank you for connecting".encode())
    c.close()

