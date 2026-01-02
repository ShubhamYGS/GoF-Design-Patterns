package adapter;

/**
 * Adapter target interface used by the modern CheckoutService.
 * Implementations (in-house or adapter wrappers) must provide
 * a uniform API: processPayment(), status check and transaction id.
 */
public interface PaymentProcessor {
    void processPayment(double amount, String currency);

    boolean isPaymentSuccessful();

    String getTransactionId();
}