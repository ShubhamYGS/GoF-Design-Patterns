package adapter.classadapter;

import adapter.LegacyPaymentGateway;
import adapter.PaymentProcessor;

/**
 * Class Adapter: adapts LegacyPaymentGateway by extending it and
 * implementing the PaymentProcessor target interface.
 * This style couples the adapter to the legacy implementation class.
 */
public class LegacyGatewayAdapterV2 extends LegacyPaymentGateway implements PaymentProcessor {
    private long currentRef;

    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("Using LegacyGatewayAdapter to process payment of " + amount + " " + currency);
        super.executeTransaction(amount, currency);
        currentRef = getTransactionReference();
    }

    @Override
    public boolean isPaymentSuccessful() {
        return super.checkStatus(currentRef);
    }

    @Override
    public String getTransactionId() {
        return "LEGACY_TXN_" + currentRef;
    }
}
