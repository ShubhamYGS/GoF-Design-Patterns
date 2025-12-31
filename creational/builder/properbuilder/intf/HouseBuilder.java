package builder.properbuilder.intf;

import builder.properbuilder.product.House;

/**
 * Builder interface for creating different kinds of House objects.
 * Defines the steps (buildWalls, buildRoof, buildInterior) and a
 * method to return the finished product.
 */
public interface HouseBuilder {
    void buildWalls();
    void buildRoof();
    void buildInterior();
    House getHouse();
}
