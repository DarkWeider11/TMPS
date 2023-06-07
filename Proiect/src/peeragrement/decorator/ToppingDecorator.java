package peeragrement.decorator;

import peeragrement.factory.FoodItem;

public class ToppingDecorator extends FoodItemDecorator {
    public ToppingDecorator(FoodItem decoratedFoodItem) {
        super(decoratedFoodItem);
    }

    @Override
    public void prepare() {
        try {
            super.prepare();
        } catch (Exception err) {
            System.out.println("Problems with toping adding");
        }
        // Add additional topping preparation logic
    }

    // Other methods and decorators
}
