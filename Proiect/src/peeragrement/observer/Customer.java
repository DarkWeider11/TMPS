package peeragrement.observer;

import peeragrement.builder.Order;

public class Customer implements OrderStatusObserver {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println(order.getStatus());
        // Handle order status update for the customer
    }
}
