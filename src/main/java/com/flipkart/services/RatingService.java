package com.flipkart.services;

import com.flipkart.exception.RatingOutOfBoundsException;
import com.flipkart.model.Rating;
import com.flipkart.model.User;
import com.flipkart.repository.RatingRepository;
import com.flipkart.repository.UserRepository;

public class RatingService {

    public static void rateRestaurant(String restaurantName, int rating, String comment) throws RatingOutOfBoundsException {
        User loggedInUser =  UserRepository.loggedInUser;
        if(loggedInUser != null ) {
            if(rating > 0 && rating <=5 ) {
                Rating ratingObj = new Rating(restaurantName, rating, comment, loggedInUser.getPhoneNumber());
                RatingRepository.addRating(ratingObj);
            } else {
                throw new RatingOutOfBoundsException();
            }
        }
    }
}
