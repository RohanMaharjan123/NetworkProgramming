package Lab._20240626;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

public class URLResolver {
    private static final Logger logger = Logger.getLogger(URLResolver.class.getName());

    public static void main(String[] args) {
        if (args.length != 2) {
            logger.severe("Usage: java URLResolver <base_url> <relative_url>");
            System.exit(1);
        }

        String baseUrl = args[0];
        String relativeUrl = args[1];

        try {
            URI baseURI = new URI(baseUrl);
            URI resolvedURI = baseURI.resolve(relativeUrl);

            if (logger.isLoggable(java.util.logging.Level.INFO)) {
                logger.info(() -> String.format("Resolved URL: %s", resolvedURI.toString()));
            }
        } catch (URISyntaxException e) {
            logger.severe(() -> String.format("Invalid URL: %s", e.getMessage()));
        }
    }
}
