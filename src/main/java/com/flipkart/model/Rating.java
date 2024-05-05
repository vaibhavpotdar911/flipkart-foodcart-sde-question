package com.flipkart.model;

public class Rating {

    String restaurantName;
    int rating;
    String comment;
    String userId;

    public Rating() {
    }

    public Rating(String restaurantName, int rating, String comment, String userId) {
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.comment = comment;
        this.userId = userId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
