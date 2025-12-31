package builder.properbuilder.concretebuilder;

import builder.properbuilder.intf.HouseBuilder;
import builder.properbuilder.product.House;

/**
 * Concrete builder that assembles a House with cement parts.
 * Each build* method sets a specific part on the product.
 */
public class CementHouseBuilder implements HouseBuilder {
    private House house;

    public CementHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildWalls() {
        house.setWalls("Cement Walls");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Cement Roof");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Cement Interior");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
