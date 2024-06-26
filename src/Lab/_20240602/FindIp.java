package Lab._20240602;

import java.net.*;

public class FindIp{
    public static void main(String[] args){
        try{
            InetAddress address = InetAddress.getByName("www.nccs.edu.np");
            System.out.println("IP Address: " + address.getHostAddress());
            System.out.println("Host Name: " + address.getHostName());
        }catch(UnknownHostException e){
            System.out.println("Could not find address ");
        }
    }
}
