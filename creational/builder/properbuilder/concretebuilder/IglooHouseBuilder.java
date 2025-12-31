package builder.properbuilder.concretebuilder;

import builder.properbuilder.intf.HouseBuilder;
import builder.properbuilder.product.House;

/**
 * Concrete builder that assembles a House made of ice (an igloo).
 * Implements the same steps but provides different parts.
 */
public class IglooHouseBuilder implements HouseBuilder {

    private House house;

    public IglooHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildWalls() {
        house.setWalls("Ice Walls");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Ice Roof");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Ice Interior");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
