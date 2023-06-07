package TMPS.Lab1.Factory.Creator;

import TMPS.Lab1.Factory.Product.House;

public interface BaseHouseFactory {
    House createHouse(String type);
}
