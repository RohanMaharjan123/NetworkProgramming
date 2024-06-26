package Lab._20240602;

import java.net.*;
import java.util.Scanner;

public class UserIP {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
    System.out.print("Enter domain name: ");
        String domain = myObj.nextLine();
            try {
                InetAddress address = InetAddress.getByName(domain);
                System.out.println(address);

            } catch (UnknownHostException ex) {
                System.out.println(domain+ " couldn\'t be found");
            }
        myObj.close();
    }
}