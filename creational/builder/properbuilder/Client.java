package builder.properbuilder;

import builder.properbuilder.concretebuilder.CementHouseBuilder;
import builder.properbuilder.concretebuilder.IglooHouseBuilder;
import builder.properbuilder.director.CivilEngineer;
import builder.properbuilder.intf.HouseBuilder;
import builder.properbuilder.product.House;

/**
 * Simple client demonstrating how to use the Builder pattern.
 * Swap builders (CementHouseBuilder or IglooHouseBuilder) to
 * produce different House variants without changing the director.
 */
public class Client {
    public static void main(String[] args) {
        HouseBuilder builder = new CementHouseBuilder();
//        HouseBuilder builder = new IglooHouseBuilder();

        CivilEngineer engineer = new CivilEngineer(builder);
        House house = engineer.constructHouse();
        System.out.println(house);
    }
}
