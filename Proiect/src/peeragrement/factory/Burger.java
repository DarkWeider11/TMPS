package peeragrement.factory;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Burger implements FoodItem {
    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Burgher-ul se pregateste ! asteptati 10 secunde");
        TimeUnit.SECONDS.sleep(10);
    }

    @Override
    public void cook() throws InterruptedException {
        System.out.println("Burgher-ul se coace ! asteptati 10 secunde");
        TimeUnit.SECONDS.sleep(10);
    }

    @Override
    public void serve() throws InterruptedException {
        System.out.println("Burgher-ul se livreaza !");
        int randomNum = ThreadLocalRandom.current().nextInt(15, 45  + 1);
        TimeUnit.SECONDS.sleep(randomNum);
        System.out.println("Livrare finisata !");
    }
    // Implementation of Burger class
}
