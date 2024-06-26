package Lab._20240602._1;

import java.net.*;

public class getByName {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName(
                    "www.javapoint.com");
            System.out.println(address);

        } catch (UnknownHostException ex) {
            System.out.println("Javapoint couldn\'t be found");
        }
    }
}