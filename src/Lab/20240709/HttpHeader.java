package Lab._20240709;

import java.net.*;
import java.util.*;
import java.util.logging.*;

public class HttpHeader {
    // Create logger for HttpHeader class
    private static final Logger logger = Logger.getLogger(HttpHeader.class.getName());

    public static void main(String[] args) {
        // Configure logger to print to console with appropriate log level
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the URL: ");
        String urlString = sc.nextLine();
        sc.close();

        try {
            // Append http:// if no scheme is provided
            if (!urlString.startsWith("http://") && !urlString.startsWith("https://")) {
                urlString = "http://" + urlString;
            }

            URI uri = new URI(urlString);
            URL url = uri.toURL();
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            for (int i = 1;; i++) {
                String headerName = urlConnection.getHeaderFieldKey(i);
                String headerValue = urlConnection.getHeaderField(i);
                if (headerName == null && headerValue == null) {
                    break;
                }
                if (headerName == null) {
                    System.out.println(headerValue);
                } else {
                    System.out.println(headerName + ": " + headerValue);
                }
            }
        } catch (Exception e) {
            // Log the error message
            logger.log(Level.SEVERE, "Error occurred: " + e.getMessage(), e);
        }
    }
}