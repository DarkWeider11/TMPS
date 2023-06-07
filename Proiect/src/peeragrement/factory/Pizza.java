package peeragrement.factory;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Pizza implements FoodItem {
    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Pizza se pregateste ! asteptati 15 secunde");
        TimeUnit.SECONDS.sleep(15);
    }

    @Override
    public void cook() throws InterruptedException {
        System.out.println("Pizza se coace ! asteptati 30 secunde");
        TimeUnit.SECONDS.sleep(30);
    }

    @Override
    public void serve() throws InterruptedException {
        System.out.println("Pizza se livreaza !");
        int randomNum = ThreadLocalRandom.current().nextInt(15, 45  + 1);
        TimeUnit.SECONDS.sleep(randomNum);
        System.out.println("Livrare finisata !");
    }
    // Implementation of Pizza class
}
