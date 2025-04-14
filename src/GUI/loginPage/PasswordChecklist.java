package gui.loginPage;

public class PasswordChecklist {
    public static final int MIN_PASSWORD_LENGTH = 8;

    public static boolean isStrongPassword(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH && containsUppercase(password) && containsLowercase(password) && containsDigit(password);
    }

    private static boolean containsUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLowercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
