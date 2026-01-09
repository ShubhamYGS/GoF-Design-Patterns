package strategy.impl;

import strategy.intf.ShippingStrategy;
import strategy.model.Order;

/**
 * Concrete Strategy: cost is based on total weight (kg) times a rate.
 */
public class WeightBasedShipping implements ShippingStrategy {
    private final double ratePerKg;

    public WeightBasedShipping(double ratePerKg) {
        this.ratePerKg = ratePerKg;
    }

    @Override
    public double calculateShippingCost(Order order) {
        System.out.println("Calculating with Weight-Based strategy ($" + ratePerKg + "/kg)");
        return order.getTotalWeight() * ratePerKg;
    }
}