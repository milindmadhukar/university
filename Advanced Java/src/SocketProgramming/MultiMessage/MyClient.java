import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 3333);
        System.out.println("Connected to server at localhost:3333");

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);

        String strToSend = "", strReceived = "";

        while(true) {
            System.out.print("Enter message to send (type 'stop' to end): ");
            strToSend = sc.nextLine();
            dos.writeUTF(strToSend);
            dos.flush();
            if(strToSend.equalsIgnoreCase("stop")) {
                System.out.println("Client ended the chat.");
                break;
            }

            strReceived = din.readUTF();
            if(strReceived.equalsIgnoreCase("stop")) {
                System.out.println("Server ended the chat.");
                break;
            }
            System.out.println("Message from server: " + strReceived);
        }

        din.close();
        dos.close();
        s.close();
    }   
}
