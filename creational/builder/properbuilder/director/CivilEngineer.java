package builder.properbuilder.director;

import builder.properbuilder.intf.HouseBuilder;
import builder.properbuilder.product.House;

/**
 * Director class that knows the order of building steps.
 * It uses a HouseBuilder implementation to construct a House.
 */
public class CivilEngineer {
    private HouseBuilder houseBuilder;

    public CivilEngineer(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        // Execute building steps in the proper order
        houseBuilder.buildWalls();
        houseBuilder.buildRoof();
        houseBuilder.buildInterior();
        return houseBuilder.getHouse();
    }
}
