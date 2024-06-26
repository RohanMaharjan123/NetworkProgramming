package Lab._20240602._0;

import java.net.*;

public class CheckIp{
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("FF03:0000:1000:FEA0:0001:FF88:8081:0001");
            // InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("IP Address: " + address.getHostAddress());
            System.out.println("Host Name: " + address.getHostName());

            byte[] add = address.getAddress();
            if(add.length == 4){
                System.out.println("Address type: IPv4");
            } else if(add.length == 16){
                System.out.println("Address type: IPv6");
            } else {
                System.out.println("Unknown address type");
            }
        } catch (UnknownHostException e) {
            System.out.println("Could not find address ");
        }
    }
}
