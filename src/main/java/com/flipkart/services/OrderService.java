package com.flipkart.services;

import com.flipkart.exception.NoLoginFoundException;
import com.flipkart.exception.RestaurantNotFoundException;
import com.flipkart.model.Order;
import com.flipkart.model.Restaurant;
import com.flipkart.model.User;
import com.flipkart.repository.OrderRepository;
import com.flipkart.repository.RestaurantRepository;
import com.flipkart.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public static boolean placeOrder(String restaurantName, int quantity) {
        User loggedInUser =  UserRepository.loggedInUser;
        if(loggedInUser != null ) {
            String pinCode = loggedInUser.getPinCode();
            Restaurant selectedRestaurant = RestaurantRepository.getRestaurant(restaurantName);
            if(selectedRestaurant!= null) {
                String[] pinCodesForSelectedRestaurant = selectedRestaurant.getServicablePinCodes().split("/");
                for(String pin: pinCodesForSelectedRestaurant) {
                    if(pin.equalsIgnoreCase(pinCode)) {
                        Order newOrder = new Order(restaurantName, quantity, loggedInUser.getPhoneNumber());
                        OrderRepository.addOrder(newOrder);
                        int negativeQuantity = -quantity;
                        RestaurantRepository.addQuantity(restaurantName, negativeQuantity);
                        return true;
                    }
                }
            } else {
                throw new RestaurantNotFoundException();
            }
        } else {
            throw new NoLoginFoundException();
        }
        return false;
    }

    public static List<Order> getOrdersByUserId() {
        List<Order> allOrders = new ArrayList<>();
        User loggedInUser =  UserRepository.loggedInUser;
        if(loggedInUser != null) {
            String phoneNumber = loggedInUser.getPhoneNumber();
            for(Order order: OrderRepository.allOrders){
                if(order.getUserId().equalsIgnoreCase(phoneNumber)){
                    allOrders.add(order);
                }
            }
        }else {
            throw new NoLoginFoundException();
        }
        return allOrders;
    }
}
