package Lab._20240601;

import java.net.*;
import java.lang.*;

public class GetOwnIp {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("IP of this system: " + ip.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
