package peeragrement.singleton;

import peeragrement.factory.FoodItem;
import peeragrement.factory.FoodItemFactory;

public class OrderManager {
    private static OrderManager instance;

    private OrderManager() {
        // Private constructor to prevent instantiation
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    // Other methods and functionality of the OrderManager class

    public void UserOrder(int idUser, String[] foods, String address){
        FoodItemFactory ff = new FoodItemFactory();
        for (String food:foods) {
            FoodItem fi = ff.createFoodItem(food);
            try {
                fi.prepare();
                fi.cook();
                fi.serve();
            }
            catch( Exception err){
                System.out.println("Error with preparation of food");
            }
        }
    }
}