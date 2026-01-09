package strategy;

import strategy.impl.DistanceBasedShipping;
import strategy.impl.FlatRateShipping;
import strategy.impl.ThirdPartyApiShipping;
import strategy.impl.WeightBasedShipping;
import strategy.intf.ShippingStrategy;
import strategy.model.Order;

/**
 * Strategy Pattern demo.
 * The client picks a ShippingStrategy and can swap it at runtime without changing the service code.
 */
public class Client {
    public static void main(String[] args) {
        // Example order (normally it would come from a checkout screen).
        Order order1 = new Order();

        // Concrete strategies: each one knows a different way to calculate shipping.
        ShippingStrategy flatRate = new FlatRateShipping(10.0);
        ShippingStrategy weightBased = new WeightBasedShipping(2.5);
        ShippingStrategy distanceBased = new DistanceBasedShipping(5.0);
        ShippingStrategy thirdParty = new ThirdPartyApiShipping(7.5, 0.02);

        // Context: delegates the calculation to the currently selected strategy.
        ShippingCostService shippingService = new ShippingCostService(flatRate);

        System.out.println("--- Order 1: Using Flat Rate (initial) ---");
        shippingService.calculateShippingCost(order1);

        System.out.println("\n--- Order 1: Changing to Weight-Based ---");
        shippingService.setStrategy(weightBased);
        shippingService.calculateShippingCost(order1);

        System.out.println("\n--- Order 1: Changing to Distance-Based ---");
        shippingService.setStrategy(distanceBased);
        shippingService.calculateShippingCost(order1);

        System.out.println("\n--- Order 1: Changing to Third-Party API ---");
        shippingService.setStrategy(thirdParty);
        shippingService.calculateShippingCost(order1);

        // Adding a NEW strategy is easy:
        // 1. Create a new class implementing ShippingStrategy (e.g., FreeShippingStrategy)
        // 2. Instantiate it and set it on the context:
        //    ShippingStrategy freeShipping = new FreeShippingStrategy();
        //    shippingService.setStrategy(freeShipping);
        //    shippingService.calculateShippingCost(primeMemberOrder);
        // No modification to ShippingCostService is needed.
    }
}