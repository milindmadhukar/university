# Create a TCP socket ad bind to localhost on port 2356
# Listen for incoming connections
# For each client that connects
# Send an initial message confirming the connection
# Enter a loop to receive messages from the client, prepend them with "Server message: " and send them back
# Close connection when the client disconnects

# Use threads to handle multiple clients concurrently
# Close the server socket when all clients have been handled

import socket
import threading
