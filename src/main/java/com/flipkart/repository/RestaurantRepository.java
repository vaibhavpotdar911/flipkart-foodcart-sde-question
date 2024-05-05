package com.flipkart.repository;

import com.flipkart.model.Restaurant;

import java.util.*;

public class RestaurantRepository {

    public static List<Restaurant> allRestaurants = new ArrayList<>();

    public static void addRestaurant(Restaurant restaurant){
        allRestaurants.add(restaurant);
    }

    public static String getUserIdForRestaurant(String restaurantName) {
        for(Restaurant restaurant: allRestaurants) {
            if(restaurant.getRestaurantName().equalsIgnoreCase(restaurantName)) {
                return restaurant.getOwnerUserId();
            }
        }
        return "";
    }

    public static void addQuantity(String restaurantName, int addQuantityNumber) {
        int index = 0;
        for(Restaurant restaurant: allRestaurants) {
            if(restaurant.getRestaurantName().equalsIgnoreCase(restaurantName)) {
                int newQuantity = restaurant.getInitialQuantity() + addQuantityNumber;
                restaurant.setInitialQuantity(newQuantity);
                allRestaurants.set(index, restaurant);
            }
            index++;
        }
    }

    public static Restaurant getRestaurant(String restaurantName) {
        for(Restaurant restaurant: allRestaurants) {
            if(restaurantName.equalsIgnoreCase(restaurant.getRestaurantName())) {
                return restaurant;
            }
        }
        return  null;
    }

    public static List<Restaurant> getRestaurantForSpecificPinCode(String pinCode) {
        List<Restaurant> allRestaurantsForThisPincode = new ArrayList<>();
        for(Restaurant restaurant: allRestaurants) {
            String[] pinCodesForSelectedRestaurant = restaurant.getServicablePinCodes().split("/");
            for (String pin : pinCodesForSelectedRestaurant) {
                if (pin.equalsIgnoreCase(pinCode)) {
                    allRestaurantsForThisPincode.add(restaurant);
                }
            }
        }
        return  allRestaurantsForThisPincode;
    }

    public static Map<Double, Restaurant> getAllRestaurantsByRating(String pinCode) {
        Map<Double, Restaurant> sortedByRating = new TreeMap<>(Comparator.reverseOrder());
        for (Restaurant thisRestaurant : getRestaurantForSpecificPinCode(pinCode)) {
            double rating = RatingRepository.getOverallRatingForRestaurant(thisRestaurant.getRestaurantName());
            sortedByRating.put(rating, thisRestaurant);
        }
        return sortedByRating;
    }

    public static Map<Integer, Restaurant> getAllRestaurantsByPrice(String pinCode) {
        Map<Integer, Restaurant> sortedByPrice = new TreeMap<>(Comparator.reverseOrder());
        for(Restaurant restaurant: getRestaurantForSpecificPinCode(pinCode)) {
            int price = restaurant.getFoodItemPrice();
            sortedByPrice.put(price, restaurant);
        }
        return sortedByPrice;
    }


}

