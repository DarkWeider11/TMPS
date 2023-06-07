package peeragrement.observer;
import peeragrement.builder.Order;

public interface OrderStatusObserver {
    void update(Order order);
}

