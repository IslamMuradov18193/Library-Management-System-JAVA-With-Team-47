package constructor;



public class User {
    private String username;
    private String password;
    private String status;
    private int timeSpent;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.status = "Not started"; // Default status
        this.timeSpent = 0; // Default time spent
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    @Override
    public String toString() {
        return "Username: " + username + "\nPassword: " + password + "\nStatus: " + status + "\nTime Spent: " + timeSpent;
    }
}


