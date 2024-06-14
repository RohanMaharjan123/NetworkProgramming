package Lab._20240611;
import java.net.*;
import java.io.*;
import java.util.*;

// Methods for retrieving data from URL
// public InputStream openStream() throws IOException
// public URLConnection openConnection() throws IOException
// public URLConnection openConnection(Proxy proxy) throws IOException
// public Object getContent() throws IOException
// public Object getContent(Class[] classes) throws IOException
@SuppressWarnings("deprecation")

public class URLData {
    public static void main(String[] args) throws MalformedURLException {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter URL: ");
        // URL url = new URL(sc.nextLine());
        // sc.close();
        try {
            URL url = new URL("https://likehome.neocities.org/");

            InputStream in = url.openStream();
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
