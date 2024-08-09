package Lab._20240708;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class PassAuth {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("HTTP Authentication Example");
            frame.setSize(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(3, 2));
            JLabel usernameLabel = new JLabel("Username:");
            JTextField usernameField = new JTextField();
            JLabel passwordLabel = new JLabel("Password:");
            JPasswordField passwordField = new JPasswordField();
            JButton loginButton = new JButton("Login");

            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    char[] password = passwordField.getPassword();

                    Authenticator.setDefault(new CustomAuthenticator(username, password));

                    try {
                        URI uri = new URI("http", "www.example.com", "/", null);
                        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
                        connection.setRequestMethod("GET");

                        int responseCode = connection.getResponseCode();
                        System.out.println("Response code: " + responseCode);

                        // Ensure to disconnect the connection
                        connection.disconnect();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            panel.add(usernameLabel);
            panel.add(usernameField);
            panel.add(passwordLabel);
            panel.add(passwordField);
            panel.add(new JLabel()); // Empty label for spacing
            panel.add(loginButton);

            frame.add(panel);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });
    }

    static class CustomAuthenticator extends Authenticator {
        private String username;
        private char[] password;

        public CustomAuthenticator(String username, char[] password) {
            this.username = username;
            this.password = password;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    }
}