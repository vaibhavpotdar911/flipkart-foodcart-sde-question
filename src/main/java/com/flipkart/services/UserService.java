package com.flipkart.services;

import com.flipkart.exception.UserNotFoundException;
import com.flipkart.model.User;
import com.flipkart.repository.UserRepository;

import java.util.List;

public class UserService {

    public static String registerUser(String userName, String gender, String phoneNumber, String pinCode) {
        User user = new User(userName, phoneNumber, gender, pinCode);

        if( UserRepository.registerUser(user)) {
            return "User successfully registered!";
        } else {
            return "Phone number already exists!";
        }
    }

    public static List<User> getAllUsers() {
        return UserRepository.getAllUsers();
    }

    public static String loginUser(String phoneNumber) throws Exception {
        for (User user : UserRepository.allUsers) {
            if (phoneNumber.equalsIgnoreCase(user.getPhoneNumber())) {
                UserRepository.loggedInUser = user;
                return "User successfully logged in!";
            }
        }
        throw new UserNotFoundException();
    }

    public static User getLoggedInUser() {
        if(UserRepository.loggedInUser != null) {
            return UserRepository.loggedInUser;
        }
        return null;
    }


}
