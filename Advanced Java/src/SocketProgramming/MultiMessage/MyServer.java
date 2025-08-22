import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(3333);
        System.out.println("Server started. Waiting for client to connect...");
        Socket s = ss.accept();
        System.out.println("Client connected: " + s.getInetAddress().getHostAddress());

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);

        String strToSend = "", strReceived = "";

        while(true) {
            strReceived = din.readUTF();
            if(strReceived.equalsIgnoreCase("stop")) {
                System.out.println("Client ended the chat.");
                break;
            }
            System.out.println("Message from client: " + strReceived);

            System.out.print("Enter message to send (type 'stop' to end): ");
            strToSend = sc.nextLine();
            dos.writeUTF(strToSend);
            dos.flush();
            if(strToSend.equalsIgnoreCase("stop")) {
                System.out.println("Server ended the chat.");
                break;
            }
        }

        din.close();
        dos.close();
        s.close();
        ss.close();
        sc.close();
    }   
}