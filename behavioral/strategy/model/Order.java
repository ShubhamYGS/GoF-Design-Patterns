package strategy.model;

/**
 * Simple data model used by shipping strategies.
 * In a real application this would come from cart/checkout data.
 */
public class Order {
    // Used by ThirdPartyApiShipping (percentage fee).
    private double orderValue;

    // Used by WeightBasedShipping.
    private double totalWeight;

    // Used by DistanceBasedShipping (acts like a simplified destination / distance group).
    private String destinationZone;

    public Order() {
        // Sample defaults so the demo can run without extra setup.
        this.orderValue = 100.0;
        this.totalWeight = 10.0;
        this.destinationZone = "ZoneA";
    }

    public Order(double orderValue, double totalWeight, String destinationZone) {
        this.orderValue = orderValue;
        this.totalWeight = totalWeight;
        this.destinationZone = destinationZone;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getDestinationZone() {
        return destinationZone;
    }

    public void setDestinationZone(String destinationZone) {
        this.destinationZone = destinationZone;
    }
}
