package gui.loginPage;

import javax.swing.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import constructor.UserDatabase;
import gui.MainApplicationFrame;
import gui.admin.AdminMainApplicationFrame;

public class LoginFrame extends JFrame {
    private JTextField userText;
    private JPasswordField passwordText;

    public LoginFrame() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 190);
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

        // Create a logInButton
        JButton logInButton = new JButton("Log In");
        logInButton.setBounds(135, 90, 80, 25);
        panel.add(logInButton);

        // Add SignUp button
        JButton signUpButton = new JButton("<html><u><font color='blue'>SignUp</font></u></html>");
        signUpButton.setBounds(260, 110, 80, 30);
        signUpButton.setBackground(Color.WHITE);
        signUpButton.setBorderPainted(false);
        signUpButton.setFocusPainted(false);
        signUpButton.setContentAreaFilled(false);
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(signUpButton);

        // Login button functionality
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (username.equals("admin") && password.equals("admin")) {
                    dispose();
                    AdminMainApplicationFrame.starter();
                } else if (UserDatabase.checkCredentials(username, password)) {
                    dispose();
                    MainApplicationFrame.Starter();
                    // Start application
                    // Code to start the main application goes here
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            }
        });

        // SignUp button functionality
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new RegistrationFrame().setVisible(true);
                    }
                });
            }
        });
    }

    // Starter
    public static void starter() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
