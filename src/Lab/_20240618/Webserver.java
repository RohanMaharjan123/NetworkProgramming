package Lab._20240618;
// Process web server logfiles to check for errors
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Webserver {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java Lab._20240618.Webserver <log_file>");
            System.exit(1);
        }

        String logFile = args[0];
        Map<String, Integer> ipAddressCount = new HashMap<>();
        int totalRequests = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                totalRequests++;
                String ipAddress = extractIpAddress(line);
                ipAddressCount.put(ipAddress, ipAddressCount.getOrDefault(ipAddress, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total number of requests: " + totalRequests);
        System.out.println("Number of requests per IP address:");
        for (Map.Entry<String, Integer> entry : ipAddressCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String extractIpAddress(String logLine) {
        // Assuming the log format starts with the IP address
        int spaceIndex = logLine.indexOf(' ');
        return spaceIndex > 0 ? logLine.substring(0, spaceIndex) : logLine;
    }
}