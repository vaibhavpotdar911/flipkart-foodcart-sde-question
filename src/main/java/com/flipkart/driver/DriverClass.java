package com.flipkart.driver;

import com.flipkart.exception.RatingOutOfBoundsException;
import com.flipkart.model.Order;
import com.flipkart.model.Restaurant;
import com.flipkart.repository.OrderRepository;
import com.flipkart.services.OrderService;
import com.flipkart.services.RatingService;
import com.flipkart.services.RestaurantService;
import com.flipkart.services.UserService;

import java.util.List;
import java.util.Map;

public class DriverClass {

    public static void main(String[] args) throws Exception {

        //To register user
        registerUser("Pralove", "M", "78247837583", "HSR");
        registerUser("Vaibhav", "M", "43634573", "KOR");
        registerUser("Nitesh", "M", "7845737583", "BTM");

        loginUser("782478375834353");

        registerRestaurant("Food Court-1", "BTM/HSR", "NI Thali", 100, 5);
        registerRestaurant("Food Court-2", "BTM", "Burger", 120, 3);

        loginUser("43634573");
        registerRestaurant("Food Court-3", "HSR/KOR", "SI Thali", 150, 1);

        loginUser("7845737583");

        showRestaurant("price");

        placeOrder("Food Court-2", 2);

        showRestaurant("price");


        createReview("Food Court-2", 3, "Good Food");
        createReview("Food Court-1", 5, "Nice Food");

        showRestaurant("rating");

        loginUser("78247837583");

        updateQuantity("Food Court-2", 5);

        updateLocation("Food Court-2", "BTM/KOR/HSR");

//        Bonus question
        getAllOrdersForLoggedInUser();


    }

    public static void registerUser(String userName, String gender, String phoneNumber, String pinCode) {
        UserService.registerUser(userName, gender, phoneNumber, pinCode);
    }

    public static void loginUser(String phoneNumber) throws Exception {
        UserService.loginUser(phoneNumber);
    }

    public static void registerRestaurant(String restaurantName, String servicablePinCodes, String foodItemName, int foodItemPrice, int initialQuantity) {
        RestaurantService.registerRestaurant(restaurantName, servicablePinCodes, foodItemName, foodItemPrice, initialQuantity);
    }

    public static void showRestaurant(String sortBy) {
        Map<?, Restaurant> restaurants = RestaurantService.showRestaurant(sortBy);
        for (Map.Entry<?, Restaurant> entry : restaurants.entrySet()) {
            System.out.println(entry.getValue().getRestaurantName() + ", " + entry.getValue().getFoodItemName() + ", " + entry.getValue().getInitialQuantity());
        }
    }

    public static void placeOrder(String restaurantName, int quantity) {
        if (OrderService.placeOrder(restaurantName, quantity)) {
            System.out.println("Order Placed Successfully.");
        } else {
            System.out.println("Cannot place order.");
        }
    }

    public static void createReview(String restaurantName, int rating, String comments) throws RatingOutOfBoundsException {
        RatingService.rateRestaurant(restaurantName, rating, comments);
    }

    public static void updateQuantity(String restaurantName, int addQuantity) throws Exception {
        Restaurant restaurant = RestaurantService.updateQuantity(restaurantName, addQuantity);
        System.out.println(restaurant.getRestaurantName() + ", " + restaurant.getServicablePinCodes() + ", " + restaurant.getFoodItemName() + "-" + restaurant.getInitialQuantity());
    }

    public static void updateLocation(String restaurantName, String newLocation) {
        Restaurant restaurant = RestaurantService.updateLocation(restaurantName, newLocation);
        System.out.println(restaurant.getRestaurantName() + ", " + restaurant.getServicablePinCodes() + ", " + restaurant.getFoodItemName() + "-" + restaurant.getInitialQuantity());

    }

    //Bonus Question

    public static void getAllOrdersForLoggedInUser(){
        List<Order> allOrders = OrderService.getOrdersByUserId();
        for(Order order: allOrders) {
            System.out.println(order.getRestaurantName() + ", "+ order.getQuantity());
        }
    }

}
