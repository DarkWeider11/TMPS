package peeragrement.builder;

import peeragrement.factory.FoodItem;

import java.util.List;

public class OrderBuilder {
    private FoodItem foodItem;
    private int quantity;
    private List<String> options;

    public OrderBuilder setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
        return this;
    }

    public OrderBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderBuilder addOption(String option) {
        this.options.add(option);
        return this;
    }

    public Order build() {
        return new Order(foodItem, quantity, options);
    }
}
