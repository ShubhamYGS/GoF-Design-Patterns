package strategy.impl;

import strategy.intf.ShippingStrategy;
import strategy.model.Order;

/**
 * Concrete Strategy: estimates shipping based on destination "zone" (a simple distance group).
 */
public class DistanceBasedShipping implements ShippingStrategy {
    private double ratePerKm;

    public DistanceBasedShipping(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    @Override
    public double calculateShippingCost(Order order) {
        System.out.println("Calculating with Distance-Based strategy for zone: " + order.getDestinationZone());

        // Each zone maps to an assumed distance (km). This keeps the demo simple.
        return switch (order.getDestinationZone()) {
            case "ZoneA" -> ratePerKm * 5.0;
            case "ZoneB" -> ratePerKm * 7.0;
            default -> ratePerKm * 10.0;
        };
    }
}