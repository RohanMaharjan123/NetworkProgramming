package Lab._20240627;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URIResolver {
    private static final Logger logger = Logger.getLogger(URIResolver.class.getName());

    public static void main(String[] args) {
        if (args.length != 2) {
            logger.severe("Usage: java URIResolver <base_uri> <relative_uri>");
            System.exit(1);
        }

        String baseUriString = args[0];
        String relativeUriString = args[1];

        try {
            URI baseURI = new URI(baseUriString);
            URI resolvedURI = baseURI.resolve(relativeUriString);

            if (logger.isLoggable(Level.INFO)) {
                logger.info(() -> String.format("Base URI: %s", baseURI.toString()));
                logger.info(() -> String.format("Relative URI: %s", relativeUriString));
                logger.info(() -> String.format("Resolved URI: %s", resolvedURI.toString()));
            }
        } catch (URISyntaxException e) {
            logger.severe(() -> String.format("Invalid URI: %s", e.getMessage()));
        }
    }
}
