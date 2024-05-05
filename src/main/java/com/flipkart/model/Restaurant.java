package com.flipkart.model;

import java.util.List;

public class Restaurant {

    private String restaurantName;
    private String servicablePinCodes;
    private String foodItemName;
    private int foodItemPrice;
    private int initialQuantity;
    private String ownerUserId;

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getServicablePinCodes() {
        return servicablePinCodes;
    }

    public void setServicablePinCodes(String servicablePinCodes) {
        this.servicablePinCodes = servicablePinCodes;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public int getFoodItemPrice() {
        return foodItemPrice;
    }

    public void setFoodItemPrice(int foodItemPrice) {
        this.foodItemPrice = foodItemPrice;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public Restaurant(String ownerUserId, String restaurantName, String servicablePinCodes, String foodItemName, int foodItemPrice, int initialQuantity) {
        this.restaurantName = restaurantName;
        this.servicablePinCodes = servicablePinCodes;
        this.foodItemName = foodItemName;
        this.foodItemPrice = foodItemPrice;
        this.initialQuantity = initialQuantity;
        this.ownerUserId = ownerUserId;
    }

    public Restaurant() {
    }
}
