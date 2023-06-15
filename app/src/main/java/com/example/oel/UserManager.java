package com.example.oel;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    public List<User> userList;

    public UserManager() {
        userList = new ArrayList<>();
        User user1 = new User("ibrahimUser", "ibrahim@gmail.com", "Ibrahim","User");
        User user2 = new User("ibrahimResponder", "ibrahim1@gmail.com", "Ibrahim","Responder");
        userList.add(user1);
        userList.add(user2);
    }

    public boolean login(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Credentials matched, login successful
            }
        }
        return false; // Invalid credentials
    }

    public boolean signup(User user) {
        // Check if username or email already exists
        for (User existingUser : userList) {
            if (existingUser.getUsername().equals(user.getUsername()) ||
                    existingUser.getEmail().equals(user.getEmail())) {
                return false; // Username or email already exists, signup failed
            }
        }

        // Add the user to the list
        userList.add(user);
        return true; // Signup successful
    }

    public String getUserRole(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user.getRole();
            }
        }
        return null; // User not found
    }
}

