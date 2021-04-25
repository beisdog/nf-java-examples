package de.beisert.nf.examples.pwdvalidator;

import java.util.Scanner;

/**
 * Utility that validates a password if it satisfies some requirements.
 */
public class PasswordValidator {

    private static final String ERROR_PLEASE_PROVIDE_A_PASSWORD = "Error: Please provide a password. ";
    private static final String ERROR_MINIMUM_LENGTH = "Error: password length needs to be at least %s  but was only %s. ";
    private static final String ERROR_DOES_NOT_CONTAIN_NUMBERS = "Error: password needs to contain at least one number. ";
    private final static String ERROR_DOES_NOT_CONTAIN_UPPER_AND_LOWERCASE = "Error: password does not contain upper and lowercase. ";
    private final static String ERROR_DOES_NOT_CONTAIN_SPECIAL_CHAR = "Error: password does not contain special char. ";

    public static String MESSAGE_VALID = "Valid";
    public static int MINIMUM_LENGTH = 8;
    public static String SPECIAL_CHARS = "{}'\"+*%&/()=?`!¨£$_-:.;,<>";

    public static void main(String[] args) {
        System.out.println("Please enter a password you want to validate and press enter.");
        System.out.println("to exit type: quit");

        Scanner scanner = new Scanner(System.in);
        String line = null;
        do {
            line = scanner.nextLine();
            if (line.trim().equalsIgnoreCase("quit")) {
                System.out.println("Exit");
                System.exit(0);
            } else {
                System.out.println(validatePasswordAndGetMessage(line));
            }
        } while (line != null);
    }

    public static String validatePasswordAndGetMessage(String password) {
        String message = "";
        if (password == null || password.trim().length() == 0) {
            message = ERROR_PLEASE_PROVIDE_A_PASSWORD;
        }
        if (!validatePasswordLength(password, MINIMUM_LENGTH)) {
            message += String.format(ERROR_MINIMUM_LENGTH, MINIMUM_LENGTH, password.length());
        }
        if (!validatePasswordContainsNumbers(password)) {
            message += ERROR_DOES_NOT_CONTAIN_NUMBERS;
        }
        if (!validatePasswordContainsUpperAndLowercase(password)) {
            message += ERROR_DOES_NOT_CONTAIN_UPPER_AND_LOWERCASE;
        }
        if (!validatePasswordContainsSpecialChar(password, SPECIAL_CHARS.toCharArray())) {
            message += ERROR_DOES_NOT_CONTAIN_SPECIAL_CHAR;
        }
        if (message.length() == 0) {
            return MESSAGE_VALID;
        }
        return message;
    }

    public static boolean validatePasswordLength(String password, int passwordMinimumLength) {
        return password.length() >= passwordMinimumLength;
    }

    public static boolean validatePasswordContainsNumbers(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validatePasswordContainsUpperAndLowercase(String password) {
        boolean lowercase = false;
        boolean uppercase = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercase = true;
            }
            if (Character.isUpperCase(c)) {
                uppercase = true;
            }
        }
        return lowercase && uppercase;
    }

    public static boolean validatePasswordContainsSpecialChar(
            String password,
            char[] specialChars
    ) {
        for (char c : password.toCharArray()) {
            for (char specialchar : specialChars) {
                if (c == specialchar) {
                    return true;
                }
            }
        }
        return false;
    }
}
