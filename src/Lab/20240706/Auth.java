// Implementation of Authenticator class
package Lab._20240706;

import java.net.*;
import java.util.logging.*;

public class Auth {
    // Initialize logger
    private static final Logger logger = Logger.getLogger(Auth.class.getName());

    public static void main(String[] args) throws Exception {
        // Set the custom Authenticator
        Authenticator.setDefault(new CustomAuthenticator());

        URI uri = new URI("http", "www.nccs.edu.np", "/", null);
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
        connection.setRequestMethod("GET");
        
        // Log the request details
        logger.info("Sending GET request to: " + uri.toString());

        int responseCode = connection.getResponseCode();
        System.out.println("Response code: " + responseCode);
    }

    static class CustomAuthenticator extends Authenticator {
        protected PasswordAuthentication getPasswordAuthentication() {
            // This is just an example, you should replace with your own logic to retrieve the username and password
            String username = "myusername";
            String password = "mypassword";

            // Log authentication attempt (for illustration purposes)
            logger.info("Authenticating with username: " + username);

            return new PasswordAuthentication(username, password.toCharArray());
        }
    }
}