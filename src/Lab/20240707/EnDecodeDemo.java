// Encoding and Decoding URI

package Lab._20240707;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.*;

public class EnDecodeDemo {
    // static String url = "https://www.google.com/search?q=java";
    static String uri;

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter URI: ");
        uri = sc.nextLine();
        sc.close();
        // Encode
        String encoded = encode(uri);
        System.out.println("Encoded URI: "+encoded);
        // Decode
        String decoded = decode(encoded);
        System.out.println("Decoded URI: "+decoded);

    }

    public static String encode(String uri) throws UnsupportedEncodingException {
        return URLEncoder.encode(uri, "UTF-8");
    }

    public static String decode(String uri) throws UnsupportedEncodingException {
        return URLDecoder.decode(uri, "UTF-8");
    }
}
