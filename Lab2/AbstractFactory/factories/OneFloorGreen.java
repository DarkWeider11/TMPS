package TMPS.Lab1.AbstractFactory.factories;

import TMPS.Lab1.AbstractFactory.doors.Door;
import TMPS.Lab1.AbstractFactory.doors.GreenDoor;
import TMPS.Lab1.AbstractFactory.floors.Floor;
import TMPS.Lab1.AbstractFactory.floors.OneFloor;

public class OneFloorGreen implements HouseFactory {
    @Override
    public Floor buildFloor() {
        return new OneFloor();
    }

    @Override
    public Door installDoor() {
        return new GreenDoor();
    }
}
