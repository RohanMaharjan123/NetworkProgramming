# Program for implementing Looking up the ipaddress of Localhost

**Name**: Program for implementing Looking up the ipaddress of Localhost

**Date**: July 12th, 2024

## Source Code

```java
package Lab._20240601;

import java.net.*;
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

```

## Output

![Program to Display a JFrame](./output.png)