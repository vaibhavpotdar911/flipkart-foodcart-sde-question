package com.flipkart.services;

import com.flipkart.exception.DifferentUserLoggedInException;
import com.flipkart.exception.NoLoginFoundException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.model.Restaurant;
import com.flipkart.model.User;
import com.flipkart.repository.RestaurantRepository;

import java.util.Map;

public class RestaurantService {

    public static void registerRestaurant(String restaurantName, String serviceablePinCodes, String foodItemName, int foodItemPrice, int initialQuantity) {
        User loggedInUser = UserService.getLoggedInUser();
        if(loggedInUser != null) {
            Restaurant restaurant = new Restaurant();
            restaurant.setOwnerUserId(loggedInUser.getPhoneNumber());
            restaurant.setRestaurantName(restaurantName);
            restaurant.setFoodItemName(foodItemName);
            restaurant.setFoodItemPrice(foodItemPrice);
            restaurant.setServicablePinCodes(serviceablePinCodes);
            restaurant.setInitialQuantity(initialQuantity);
            RestaurantRepository.addRestaurant(restaurant);
        }
    }

    public static Restaurant updateQuantity(String restaurantName, int addQuantity) {
        User loggedInUser = UserService.getLoggedInUser();
        if(loggedInUser != null ) {
            if(RestaurantRepository.getUserIdForRestaurant(restaurantName).equalsIgnoreCase(loggedInUser.getPhoneNumber())) {
                RestaurantRepository.addQuantity(restaurantName, addQuantity);
                return RestaurantRepository.getRestaurant(restaurantName);
            } else {
                throw new DifferentUserLoggedInException();
            }
        } else  {
           throw new UserNotFoundException();
        }
    }

    public static Map<?,Restaurant> showRestaurant(String sortBy) {
        User loggedInUser = UserService.getLoggedInUser();
        Map<?, Restaurant> allRestaurantsSorted = null;
        if(loggedInUser != null ) {
            String pinCode = loggedInUser.getPinCode();
            if(sortBy.equalsIgnoreCase("rating")) {
            allRestaurantsSorted = RestaurantRepository.getAllRestaurantsByRating(pinCode);
            } else if(sortBy.equalsIgnoreCase("price")) {
            allRestaurantsSorted = RestaurantRepository.getAllRestaurantsByPrice(pinCode);
            }
        } else {
            throw new NoLoginFoundException();
        }
        return allRestaurantsSorted;
    }

    public static Restaurant updateLocation(String restaurantName, String newLocation) {
        int index = 0;
        for(Restaurant restaurant: RestaurantRepository.allRestaurants) {
            if(restaurant.getRestaurantName().equalsIgnoreCase(restaurantName)) {
                restaurant.setServicablePinCodes(newLocation);
                RestaurantRepository.allRestaurants.set(index, restaurant);
                return restaurant;
            }
            index++;
        }
        return null;
    }


}
