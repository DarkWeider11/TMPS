package TMPS.Lab1.Factory.Product;

public class Apartment implements House {
    @Override
    public void constructHouse() {
        System.out.println("Building apartment");
    }
}
