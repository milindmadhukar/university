import threading
import sys

class ThreadHandler(threading.Thread):
    def __init__(self, con, IP):
        self.con = con
        self.IP = IP

        super(ThreadHandler, self).__init__()

    def run(self):
        msge =""
        while msge != 'quit':
            msge = self.recvdata()
            print(msge)

        print("Client termination with", self.IP)

    def recvdata(self):
        msge = self.con.recv(1024)
        return msge.decode('utf-8')
    
    def recvBtdata(self):
        msge = self.con.recv(1024)
        return msge

    def senddata(self, data):
        try:
            data = data.encode('utf-8')
            self.con.send(data)
            return True
        except:
            print('Error: ', str(sys.exec_info()[0]))
            return False
