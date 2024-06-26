package Lab._20240607;
// Implement the methods of URL Class
// URL u = new URL("http://www.google.com");
// System.out.println(u.getProtocol());
import java.net.*;
import java.util.logging.*;

@SuppressWarnings("deprecation")
public class URLinfo {
    private static final Logger logger = Logger.getLogger(URLinfo.class.getName());

    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.google.com:443/search?q=computer+engineer&sclient=gws-wiz");

            // For getProtocol
            logger.info(() -> "For getProtocol: " + u.getProtocol());

            // For getHost
            logger.info(() -> "For getHost: " + u.getHost());

            // For getPort
            logger.info(() -> "For getPort: " + u.getPort());

            // For getFile
            logger.info(() -> "For getFile: " + u.getFile());

            // For getAuthority
            logger.info(() -> "For getAuthority: " + u.getAuthority());

            // For getQuery
            logger.info(() -> "For getQuery: " + u.getQuery());

            // For getDefaultPort
            logger.info(() -> "For getDefaultPort: " + u.getDefaultPort());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred", e);
        }
    }
}
