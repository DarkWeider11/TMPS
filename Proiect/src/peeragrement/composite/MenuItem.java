package peeragrement.composite;

public class MenuItem implements MenuComponent {
    private String name ;
    private int price ;

    @Override
    public void display() {
        System.out.println("Denumire: " + this.name);
        System.out.println("Pret: " + this.price);
    }
    // Implementation of MenuItem class
}
