package TMPS.Lab1.AbstractFactory.app;

import TMPS.Lab1.AbstractFactory.doors.Door;
import TMPS.Lab1.AbstractFactory.factories.HouseFactory;
import TMPS.Lab1.AbstractFactory.floors.Floor;

public class Construction {
    private Floor floor;
    private Door door;

    public Construction(HouseFactory factory) {
        floor = factory.buildFloor();
        door = factory.installDoor();
    }

    public void build() {
        floor.constructFloor();
        door.installingDoor();
    }
}
