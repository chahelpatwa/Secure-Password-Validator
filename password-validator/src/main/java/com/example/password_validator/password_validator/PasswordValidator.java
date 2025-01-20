package com.example.password_validator.password_validator;

import java.util.Set;

public class PasswordValidator {

    public static String evaluatePasswordStrength(String password) {
        StringBuilder feedback = new StringBuilder();

        if (password.length() < 8) {
            feedback.append("Weak: Password is too short. It should be at least 8 characters long.\n");
        }
        if (!containsUpperCase(password)) {
            feedback.append("Weak: Add at least one uppercase letter.\n");
        }
        if (!containsLowerCase(password)) {
            feedback.append("Weak: Add at least one lowercase letter.\n");
        }
        if (!containsDigit(password)) {
            feedback.append("Weak: Add at least one digit.\n");
        }
        if (!containsSpecialChar(password)) {
            feedback.append("Weak: Add at least one special character (e.g., !, @, #, $, %, etc.).\n");
        }

        if (feedback.length() == 0) {
            return "Strong: Your password is strong!";
        } else {
            return feedback.toString().trim();
        }
    }

    private static boolean containsUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSpecialChar(String password) {
        Set<Character> specialChars = Set.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '[', ']', '{', '}', '|', ';', ':', '\'', '\"', ',', '.', '<', '>', '?', '/', '`', '~');
        for (int i = 0; i < password.length(); i++) {
            if (specialChars.contains(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}