package Lab._20240602;
import java.net.*;

public class GetIp {
    public static void main(String[] args) {
        String[] data = { "www.javapoint.com", "www.google.com", "www.facebook.com", "www.youtube.com" };
        for (int index = 0; index < data.length; index++) {

            try {
                InetAddress address = InetAddress.getByName(data[index]);
                System.out.println(address);

            } catch (UnknownHostException ex) {
                System.out.println(data[index]+ " couldn\'t be found");
            }

        }
    }
}