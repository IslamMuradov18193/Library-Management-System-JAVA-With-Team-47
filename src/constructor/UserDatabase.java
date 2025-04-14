package constructor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static final String CSV_FILE_PATH = "src\\csvfiles\\LoginDatabase.csv";
    private static final List<User> users = new ArrayList<>();

    static {
        // Load user data from the CSV file
        loadUsers();
    }

    // Load user data from the CSV file
    private static void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    users.add(new User(data[0], data[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a user to the database
    public static void addUser(User user) {
        users.add(user);
    }

    // Check if a user exists with given credentials
    public static boolean checkCredentials(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Check if a username already exists
    public static boolean checkUsernameExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (User user : users) {
                writer.append(user.getUsername() + "," + user.getPassword());
                writer.newLine();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}