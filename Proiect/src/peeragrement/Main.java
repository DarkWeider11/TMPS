package peeragrement;

import peeragrement.builder.OrderBuilder;
import peeragrement.singleton.OrderManager;

public class Main {

    public static void main(String[] args) {
        OrderManager om = OrderManager.getInstance();
        om.UserOrder(1, new String[]{"pizza", "burger", "pizza"}, "Studentilor 32");
    }
}
