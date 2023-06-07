package peeragrement.factory;

public class FoodItemFactory {
    public FoodItem createFoodItem(String type) {
        if (type.equalsIgnoreCase("pizza")) {
            return new Pizza();
        } else if (type.equalsIgnoreCase("burger")) {
            return new Burger();
        }
        // Handle other food item types
        return null;
    }
}
