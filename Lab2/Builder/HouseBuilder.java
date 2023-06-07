package TMPS.Lab1.Builder;

public interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    void paintHouse();
    void furnishHouse();

    House getHouse();

}
