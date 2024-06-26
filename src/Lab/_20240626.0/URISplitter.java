package Lab.20240626._0;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URISplitter {
    private static final Logger logger = Logger.getLogger(URISplitter.class.getName());

    public static void main(String[] args) {
        if (args.length != 1) {
            logger.severe("Usage: java URINormalizer <uri>");
            System.exit(1);
        }

        String uriString = args[0];

        try {
            URI uri = new URI(uriString);
            URI normalizedURI = uri.normalize();

            if (logger.isLoggable(Level.INFO)) {
                logger.info(() -> "Original URI: " + uri.toString());
                logger.info(() -> "Normalized URI: " + normalizedURI.toString());
                logger.info(() -> "Scheme: " + normalizedURI.getScheme());
                logger.info(() -> "Authority: " + normalizedURI.getAuthority());
                logger.info(() -> "Host: " + normalizedURI.getHost());
                logger.info(() -> "Port: " + normalizedURI.getPort());
                logger.info(() -> "Path: " + normalizedURI.getPath());
                logger.info(() -> "Query: " + normalizedURI.getQuery());
                logger.info(() -> "Fragment: " + normalizedURI.getFragment());
            }
        } catch (URISyntaxException e) {
            logger.log(Level.SEVERE, "Invalid URI: {0}", e.getMessage());
        }
    }
}
