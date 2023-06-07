package TMPS.Lab1.Factory.Creator;

import TMPS.Lab1.Factory.Product.Apartment;
import TMPS.Lab1.Factory.Product.House;
import TMPS.Lab1.Factory.Product.Villa;

public class HouseFactory implements BaseHouseFactory {
    @Override
    public House createHouse(String type) {
        House house;

        switch (type) {
            case "villa":
                house = new Villa();
                break;
            case "apartment":
                house = new Apartment();
                break;
            default:
                throw new IllegalArgumentException("No such house available");
        }
        house.constructHouse();
        return house;
    }
}
