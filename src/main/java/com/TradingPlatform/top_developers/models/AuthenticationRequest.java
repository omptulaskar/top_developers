package com.TradingPlatform.top_developers.models;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AuthenticationRequest {
    private static final int MIN_USERNAME_LENGTH = 4;
    private static final int MAX_USERNAME_LENGTH = 20;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private String username;
    private String password;
    private String email;

    public AuthenticationRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticationRequest that = (AuthenticationRequest) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email);
    }

    public boolean isValidUsername() {
        return username != null
                && username.length() >= MIN_USERNAME_LENGTH
                && username.length() <= MAX_USERNAME_LENGTH
                && username.matches("^[a-zA-Z0-9]+$");
    }

    public boolean isValidPassword() {
        return password != null
                && password.length() >= MIN_PASSWORD_LENGTH
                && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }

    public boolean isValidEmail() {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String getUsernameErrorMessage() {
        if (username == null || username.length() < MIN_USERNAME_LENGTH) {
            return "Username must be at least " + MIN_USERNAME_LENGTH + " characters long.";
        } else if (username.length() > MAX_USERNAME_LENGTH) {
            return "Username must be no more than " + MAX_USERNAME_LENGTH + " characters long.";
        } else if (!username.matches("^[a-zA-Z0-9]+$")) {
            return "Username can only contain letters and numbers.";
        }
        return "";
    }

    public String getPasswordErrorMessage() {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            return "Password must be at least " + MIN_PASSWORD_LENGTH + " characters long.";
        } else if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            return "Password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character.";
        }
        return "";
    }

    public String getEmailErrorMessage() {
        if (email == null || !isValidEmail()) {
            return "Invalid email address.";
        }
        return "";
    }
}