package Lab._20240626;

import java.net.URI;
import java.net.URISyntaxException;

public class URLResolver {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java URLResolver <base_url> <relative_url>");
            System.exit(1);
        }

        String baseUrl = args[0];
        String relativeUrl = args[1];

        try {
            URI baseURI = new URI(baseUrl);
            URI resolvedURI = baseURI.resolve(relativeUrl);
            System.out.println("Resolved URL: " + resolvedURI.toString());
        } catch (URISyntaxException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        }
    }
}
