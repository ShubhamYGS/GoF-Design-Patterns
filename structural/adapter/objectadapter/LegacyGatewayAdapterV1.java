package adapter.objectadapter;

import adapter.LegacyPaymentGateway;
import adapter.PaymentProcessor;

/**
 * Object Adapter that wraps a LegacyPaymentGateway and adapts its API to
 * the modern PaymentProcessor interface used by CheckoutService.
 */
public class LegacyGatewayAdapterV1 implements PaymentProcessor {
    private final LegacyPaymentGateway legacyPaymentGateway;
    private long currentRef;

    public LegacyGatewayAdapterV1(LegacyPaymentGateway legacyPaymentGateway) {
        this.legacyPaymentGateway = legacyPaymentGateway;
    }

    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("Using LegacyGatewayAdapter to process payment of " + amount + " " + currency);
        // Delegate to legacy API and store its reference for later status checks
        legacyPaymentGateway.executeTransaction(amount, currency);
        currentRef = legacyPaymentGateway.getTransactionReference();
    }

    @Override
    public boolean isPaymentSuccessful() {
        // Ask the legacy gateway about the status of the stored transaction reference
        return legacyPaymentGateway.checkStatus(currentRef);
    }

    @Override
    public String getTransactionId() {
        // Convert legacy reference into a modern-looking transaction id
        return "LEGACY_TXN_" + currentRef;
    }
}