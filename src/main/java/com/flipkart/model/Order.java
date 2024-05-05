package com.flipkart.model;

public class Order {

    String restaurantName;
    int quantity;
    String userId;

    public Order() {
    }

    public Order(String restaurantName, int quantity, String userId) {
        this.restaurantName = restaurantName;
        this.quantity = quantity;
        this.userId = userId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
