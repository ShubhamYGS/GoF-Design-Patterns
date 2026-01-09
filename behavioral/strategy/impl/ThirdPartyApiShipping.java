package strategy.impl;

import strategy.intf.ShippingStrategy;
import strategy.model.Order;

/**
 * Concrete Strategy: simulates getting the shipping cost from an external provider/API.
 */
public class ThirdPartyApiShipping implements ShippingStrategy {
    private final double baseFee;
    private final double percentageFee;

    public ThirdPartyApiShipping(double baseFee, double percentageFee) {
        this.baseFee = baseFee;
        this.percentageFee = percentageFee;
    }

    @Override
    public double calculateShippingCost(Order order) {
        System.out.println("Calculating with Third-Party API strategy.");
        // Simulated API pricing: base fee + percent of the order value.
        return baseFee + (order.getOrderValue() * percentageFee);
    }
}