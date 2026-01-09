package strategy;

import strategy.intf.ShippingStrategy;
import strategy.model.Order;

/**
 * Context in the Strategy pattern.
 * Holds a reference to a ShippingStrategy and delegates shipping-cost calculation to it.
 */
class ShippingCostService {
    private ShippingStrategy strategy;

    public ShippingCostService(ShippingStrategy strategy) {
        // Start with a default strategy chosen by the client.
        this.strategy = strategy;
    }

    /**
     * Swap the algorithm at runtime (no need to recreate the service).
     */
    public void setStrategy(ShippingStrategy strategy) {
        System.out.println("ShippingCostService: Strategy changed to " + strategy.getClass().getSimpleName());
        this.strategy = strategy;
    }

    /**
     * Delegates the work to the currently selected strategy.
     */
    public double calculateShippingCost(Order order) {
        if (strategy == null) {
            throw new IllegalStateException("Shipping strategy not set.");
        }
        double cost = strategy.calculateShippingCost(order);
        System.out.println("ShippingCostService: Final Calculated Shipping Cost: $" + cost +
                " (using " + strategy.getClass().getSimpleName() + ")");
        return cost;
    }
}