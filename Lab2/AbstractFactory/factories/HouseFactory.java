package TMPS.Lab1.AbstractFactory.factories;

import TMPS.Lab1.AbstractFactory.doors.Door;
import TMPS.Lab1.AbstractFactory.floors.Floor;

public interface HouseFactory {
    Floor buildFloor();
    Door installDoor();
}
