package TMPS.Lab1.Prototype;

public class Apartment extends Construction {
    public Apartment() {
        type = "apartemnt";
    }

    @Override
    public void build() {
        System.out.println("Inside Apartemnt: build() method");
    }
}
