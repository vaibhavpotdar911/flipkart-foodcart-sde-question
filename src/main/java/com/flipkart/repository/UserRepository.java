package com.flipkart.repository;

import com.flipkart.model.User;

import java.util.*;

public class UserRepository {

    public static List<User> allUsers = new ArrayList<>();

    public static Set<String> allPhoneNumbers = new HashSet<>();

    public static User loggedInUser = null;

    public static boolean registerUser(User user) {
        if(allPhoneNumbers.contains(user.getPhoneNumber())) {
            return false;
        } else {
            allUsers.add(user);
            allPhoneNumbers.add(user.getPhoneNumber());
            return true;
        }
    }

    public static List<User> getAllUsers() {
        return allUsers;
    }
}
