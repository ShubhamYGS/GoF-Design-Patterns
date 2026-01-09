package strategy.impl;

import strategy.intf.ShippingStrategy;
import strategy.model.Order;

/**
 * Concrete Strategy: always charges the same shipping amount.
 */
public class FlatRateShipping implements ShippingStrategy {
    private double rate;

    public FlatRateShipping(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculateShippingCost(Order order) {
        // Order is ignored because the cost is fixed.
        System.out.println("Calculating with Flat Rate strategy ($" + rate + ")");
        return rate;
    }
}