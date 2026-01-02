package adapter;

/**
 * Legacy payment gateway with an older API.
 * Notice it exposes executeTransaction(), checkStatus(ref) and getTransactionReference().
 * The adapter wraps this API so modern code (PaymentProcessor) can use it.
 */
public class LegacyPaymentGateway {
    private long transactionReference;
    private boolean isPaymentSuccessful;

    public void executeTransaction(double totalAmount, String currency) {
        // Simulate processing payment
        System.out.println("LegacyGateway: Processing payment of "
                + totalAmount + " " + currency);
        transactionReference = System.nanoTime();
        isPaymentSuccessful = true;
        System.out.println("LegacyGateway: Transaction executed successfully. Txn ID: "
                + transactionReference);
    }

    public boolean checkStatus(long transactionReference) {
        System.out.println("LegacyGateway: Checking status for ref: " + transactionReference);
        return isPaymentSuccessful;
    }

    public long getTransactionReference() {
        return transactionReference;
    }
}