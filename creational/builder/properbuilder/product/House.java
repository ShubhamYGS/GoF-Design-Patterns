package builder.properbuilder.product;

/**
 * Product of the Builder pattern.
 * Simple POJO holding house parts (walls, roof, interior).
 * Builders call the setters to configure the product; Client prints it.
 */
public class House {
    private String walls;
    private String roof;
    private String interior;

    public void setWalls(String walls) {
        this.walls = walls;
    }
    public void setRoof(String roof) {
        this.roof = roof;
    }
    public void setInterior(String interior) {
        this.interior = interior;
    }

    @Override
    public String toString() {
        return "House [walls=" + walls + ", roof=" + roof + ", interior=" + interior + "]";
    }
}
