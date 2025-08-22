import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://jenkov.com");
            URLConnection urlConnection = url.openConnection();
            InputStream input = urlConnection.getInputStream();

            int data = input.read();
            while(data != -1) {
                System.out.println((char) data);
                data = input.read();
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
   }   
}
