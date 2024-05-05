package com.flipkart.repository;

import com.flipkart.model.Rating;

import java.util.ArrayList;
import java.util.List;

public class RatingRepository {

    public static List<Rating> allRestaurantRatings = new ArrayList<>();

    public static void addRating(Rating rating) {
        allRestaurantRatings.add(rating);
    }

    public static List<Rating> getAllRatingsForRestaurant(String restaurantName) {
        List<Rating> allRatingsForRestaurant = new ArrayList<>();
        for(Rating rating: allRestaurantRatings) {
            if(restaurantName.equalsIgnoreCase(rating.getRestaurantName())) {
                allRatingsForRestaurant.add(rating);
            }
        }
        return  allRatingsForRestaurant;
    }

    public static double getOverallRatingForRestaurant(String restaurantName) {
        int sumOfRating = 0;
        int counter = 0;
        for(Rating rating: getAllRatingsForRestaurant(restaurantName)) {
            sumOfRating += rating.getRating();
            counter++;
        }
        double averageRating = sumOfRating/counter;
        return averageRating;
    }
}
