package peeragrement.decorator;

import peeragrement.factory.FoodItem;

public abstract class FoodItemDecorator implements FoodItem {
    protected FoodItem decoratedFoodItem;

    public FoodItemDecorator(FoodItem decoratedFoodItem) {
        this.decoratedFoodItem = decoratedFoodItem;
    }

    @Override
    public void prepare() throws InterruptedException {
        decoratedFoodItem.prepare();
    }

    @Override
    public void cook() throws InterruptedException {
        decoratedFoodItem.cook();
    }

    @Override
    public void serve() throws InterruptedException {
        decoratedFoodItem.serve();
    }
}

