package peeragrement.builder;

import peeragrement.factory.FoodItem;
import peeragrement.observer.Customer;
import peeragrement.observer.OrderStatusObserver;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private FoodItem foodItem;
    private int quantity;
    private List<String> options;
    private List<Customer> observers;
    private String status;

    public Order(FoodItem foodItem, int quantity, List<String> options) {
        observers = new ArrayList<>();
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.options = options;
    }

    public void addObserver(Customer observer) {
        observers.add(observer);
    }

    public void removeObserver(Customer observer) {
        observers.remove(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Customer observer : observers) {
            observer.update(this);
        }
    }

    public String getStatus() {
        return status;
    }

    // Getters and other methods
}
