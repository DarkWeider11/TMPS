package TMPS.Lab1.AbstractFactory.factories;

import TMPS.Lab1.AbstractFactory.doors.BlueDoor;
import TMPS.Lab1.AbstractFactory.doors.Door;
import TMPS.Lab1.AbstractFactory.floors.Floor;
import TMPS.Lab1.AbstractFactory.floors.TwoFloor;

public class TwoFloorBlue implements HouseFactory {
    @Override
    public Floor buildFloor() {
        return new TwoFloor();
    }

    @Override
    public Door installDoor() {
        return new BlueDoor();
    }
}
