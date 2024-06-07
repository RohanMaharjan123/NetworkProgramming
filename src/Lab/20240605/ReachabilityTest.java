// InetAddress Method
// isReachable(int timeout)

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ReachabilityTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the address: ");
        String ip1 = sc.nextLine();
        sc.close();
        try {
            InetAddress ip = InetAddress.getByName(ip1);
            if (ip.isReachable(5000)) {
                System.out.println("Host is reachable");
            } else {
                System.out.println("Host is not reachable");
            }
        } catch (UnknownHostException e) {
            System.out.println("Invalid IP Address");
        } catch (IOException ex){
            System.out.println("IO Exception");
        }
    }
}