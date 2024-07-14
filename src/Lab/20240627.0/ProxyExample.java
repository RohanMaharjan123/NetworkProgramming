// Implementation of Proxy Class and The ProxySelector Class
package Lab._20240627._0;

import java.io.IOException;
import java.net.*;
import java.util.logging.*;

public class ProxyExample {
    // Initialize logger
    private static final Logger logger = Logger.getLogger(ProxyExample.class.getName());

    public static void main(String[] args) throws Exception {
        // Create a custom ProxySelector
        ProxySelector customSelector = new ProxySelector() {
            public java.util.List<Proxy> select(URI uri) {
                // Use a proxy for all requests
                return java.util.Arrays.asList(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("206.189.131.188", 80)));
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                // Log connection failure
                logger.log(Level.SEVERE, "Connection failed for " + uri + " through " + sa, ioe);
            }
        };

        // Set the custom ProxySelector as the default
        ProxySelector.setDefault(customSelector);

        URI uri = new URI("http", "www.apple.com", "/", null);
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();

        // Set the request method and read the response
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        logger.info("Response code: " + responseCode);
    }
}