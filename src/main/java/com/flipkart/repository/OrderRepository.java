package com.flipkart.repository;

import com.flipkart.exception.OutOfQuantityException;
import com.flipkart.model.Order;
import com.flipkart.model.Restaurant;
import com.flipkart.services.RestaurantService;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public static List<Order> allOrders = new ArrayList<>();

    public static void addOrder(Order order) {
        String restaurantName = order.getRestaurantName();
        Restaurant selectedRestaurant = RestaurantRepository.getRestaurant(restaurantName);
        int availableQuantityForSelectedRestaurant = selectedRestaurant.getInitialQuantity();
        if(order.getQuantity() < availableQuantityForSelectedRestaurant) {
            allOrders.add(order);
        } else {
            throw new OutOfQuantityException();
        }
    }

}
