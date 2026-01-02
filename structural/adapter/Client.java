package adapter;

import adapter.objectadapter.LegacyGatewayAdapterV1;

// Demo client showing three scenarios:
// 1) Using the in-house payment processor directly
// 2) Using a legacy payment gateway via an object adapter
// 3) Using a legacy payment gateway via a class adapter
public class Client {
    public static void main(String[] args) {
        // Current Payment Gateway
        PaymentProcessor processor = new InHousePaymentGateway();
        CheckoutService modernCheckout = new CheckoutService(processor);
        System.out.println("--- Using In house payment gateway ---");
        modernCheckout.checkout(199.99, "USD");

        // Adapting Legacy Payment Gateway (Object Adapter)
        System.out.println("\n--- Using Legacy Gateway via Object Adapter ---");
        LegacyPaymentGateway legacy = new LegacyPaymentGateway();
        processor = new LegacyGatewayAdapterV1(legacy);
        CheckoutService legacyCheckout = new CheckoutService(processor);
        legacyCheckout.checkout(75.50, "USD");

        // Adapting Legacy Payment Gateway (Class Adapter)
        System.out.println("--- Using Legacy Gateway via Class Adapter ---");
        processor = new adapter.classadapter.LegacyGatewayAdapterV2();
        CheckoutService legacyCheckoutV2 = new CheckoutService(processor);
        legacyCheckoutV2.checkout(120.00, "EUR");
    }
}