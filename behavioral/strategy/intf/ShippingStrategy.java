package strategy.intf;

import strategy.model.Order;

/**
 * Strategy interface.
 * Each implementation provides a different way to calculate shipping cost for the same Order.
 */
public interface ShippingStrategy {
    /**
     * Preferred method name: implementations return the shipping cost for the given order.
     */
    double calculateShippingCost(Order order);

    /**
     * Backward-compatible alias used by some demos.
     */
    default double calculateCost(Order order) {
        return calculateShippingCost(order);
    }
}