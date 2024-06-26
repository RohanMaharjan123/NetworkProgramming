package Lab._20240607;
// Implement the methods of URL Class
// URL u = new URL("http://www.google.com");
// System.out.println(u.getProtocol());

import java.net.*;

// For getProtocol
@SuppressWarnings("deprecation")
public class URLinfo {
    public static void main(String[] args) throws Exception {
        URL u = new URL("https://www.google.com:443/search?q=computer+engineer&sclient=gws-wiz");

        // For getProtocol
        System.out.print("For getProtocol: ");
        System.out.println(u.getProtocol());

        // For getHost
        System.out.print("For getHost: ");
        System.out.println(u.getHost());

        // For getPort
        System.out.print("For getPort: ");
        System.out.println(u.getPort());

        // For getFile
        System.out.print("For getFile: ");
        System.out.println(u.getFile());

        // For getAuthority
        System.out.print("For getAuthority: ");
        System.out.println(u.getAuthority());

        // For getQuery
        System.out.print("For getQuery: ");
        System.out.println(u.getQuery());

        // For getDefaultPort
        System.out.print("For getDefaultPort: ");
        System.out.println(u.getDefaultPort());
    }
}