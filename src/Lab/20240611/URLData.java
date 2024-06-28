package Lab._20240611;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Methods for retrieving data from URL
// public InputStream openStream() throws IOException
// public URLConnection openConnection() throws IOException
// public URLConnection openConnection(Proxy proxy) throws IOException
// public Object getContent() throws IOException
// public Object getContent(Class[] classes) throws IOException
@SuppressWarnings("deprecation")
public class URLData {
    private static final Logger logger = Logger.getLogger(URLData.class.getName());

    public static void main(String[] args) throws MalformedURLException {
        try {
            URL url = new URL("https://likehome.neocities.org/");
            logger.info(() -> "Fetching data from URL: " + url.toString());

            InputStream in = url.openStream();
            int c;
            StringBuilder content = new StringBuilder();

            while ((c = in.read()) != -1) {
                content.append((char) c);
            }

            logger.info(() -> "Content fetched from URL:\n" + content.toString());
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "An error occurred while fetching data from the URL", ex);
        }
    }
}
