package TMPS.Lab1.Factory.Product;

public class Villa implements House {
    @Override
    public void constructHouse() {
        System.out.println("Building Villa");
    }
}
