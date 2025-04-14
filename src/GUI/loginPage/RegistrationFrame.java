package gui.loginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import constructor.User;
import constructor.UserDatabase;

public class RegistrationFrame extends JFrame {
    private JTextField userText;
    private JPasswordField passwordText;

    public RegistrationFrame() {
        setTitle("SignUp");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 220);
        setLocationRelativeTo(null);
        setResizable(false);

        // Load and Set the image to the Frame
        try {
            ImageIcon icon = new ImageIcon("src\\images\\LibraryIcon.png");

            Image resizedImage = icon.getImage().getScaledInstance(199, 199, Image.SCALE_SMOOTH);

            ImageIcon resizedIcon = new ImageIcon(resizedImage);

            setIconImage(resizedIcon.getImage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a panel for components
        JPanel panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);

        // Create a username label
        JLabel userLabel = new JLabel("Enter your username:");
        userLabel.setBounds(10, 20, 150, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(170, 20, 165, 25);
        panel.add(userText);

        // Create a password label
        JLabel passwordLabel = new JLabel("Enter your password:");
        passwordLabel.setBounds(10, 50, 150, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(170, 50, 165, 25);
        panel.add(passwordText);

        // Create a password confirm label
        JLabel passwordConfirmationLabel = new JLabel("Confirm Your password");
        passwordConfirmationLabel.setBounds(10, 80, 150, 25);
        panel.add(passwordConfirmationLabel);

        JPasswordField confirmPasswordText = new JPasswordField(20);
        confirmPasswordText.setBounds(170, 80, 165, 25);
        panel.add(confirmPasswordText);

        // Create signUp button
        JButton signUpButton = new JButton("SignUp");
        signUpButton.setBounds(135, 120, 80, 25);
        panel.add(signUpButton);

        // Create logInbutton
        JButton logInButton = new JButton("<html><u><font color='blue'>Login</font></u></html>");
        logInButton.setBounds(270, 140, 80, 30);
        logInButton.setBackground(Color.WHITE);
        logInButton.setBorderPainted(false);
        logInButton.setFocusPainted(false);
        logInButton.setContentAreaFilled(false);
        logInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(logInButton);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                String confirmPassword = new String(confirmPasswordText.getPassword());

                // Check if the username is admin
                if (username.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Cannot register as admin user");
                    return; // Stop registration process
                } else if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username or Password cannot be empty");
                    return; // Stop registration process
                } else if (!PasswordChecklist.isStrongPassword(password)) {
                    JOptionPane.showMessageDialog(null,
                            "Password is not strong enough. It must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit.");
                    return; // Stop registration process
                }

                // Check if the password and confirm password match
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(RegistrationFrame.this, "Passwords do not match!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return; // Stop registration process
                }

                // Add the new user to the database
                User newUser = new User(username, password);
                UserDatabase.addUser(newUser);

                // Save database changes to CSV file
                UserDatabase.saveUsers();

                // Show registration success message and clear input fields...
                JOptionPane.showMessageDialog(RegistrationFrame.this, "Registration successful!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                userText.setText("");
                passwordText.setText("");
                confirmPasswordText.setText("");

                // Go to login page if registration is successful
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new LoginFrame().setVisible(true);
                    }
                });
            }
        });

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new LoginFrame().setVisible(true);
                    }
                });
            }
        });
    }

    public static void starter() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegistrationFrame().setVisible(true);
            }
        });
    }
}
