package Lab._20240705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLConnectionDemo {
    private static final Logger logger = Logger.getLogger(URLConnectionDemo.class.getName());

    public static void main(String[] args) throws IOException {
        String location = "https://likehome.neocities.org";

        // Create URI and URL objects
        URI uri;
        try {
            uri = new URI(location);
            URL url = uri.toURL();

            URLConnection conn = url.openConnection();
            conn.connect();

            // Log headers
            Map<String, List<String>> headers = conn.getHeaderFields();
            headers.forEach((key, values) -> {
                if (key != null) {
                    logger.log(Level.SEVERE, String.format("%s: %s", key, values));
                } else {
                    logger.log(Level.SEVERE, values.toString());
                }
            });

            // Log content information
            logger.log(Level.INFO, String.format("Content: %s", conn.getContent()));
            logger.log(Level.INFO, String.format("Content Type: %s", conn.getContentType()));
            logger.log(Level.INFO, String.format("Content Length: %d", conn.getContentLength()));
            logger.log(Level.INFO, String.format("Content Encoding: %s", conn.getContentEncoding()));

            // Read and output content
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            while ((output = reader.readLine()) != null) {
                System.out.println(output);
            }
            reader.close();

        } catch (Exception e) {
            logger.log(Level.SEVERE, String.format("Error occurred: %s", e.getMessage()), e);
        }
    }
}