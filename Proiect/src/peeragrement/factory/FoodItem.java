package peeragrement.factory;

public interface FoodItem {
    void prepare() throws InterruptedException;

    void cook() throws InterruptedException;

    void serve() throws InterruptedException;
}
