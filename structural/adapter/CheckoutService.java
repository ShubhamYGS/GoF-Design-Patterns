package adapter;

/**
 * CheckoutService represents the modern code that depends on the
 * PaymentProcessor interface. Adapters allow it to work with legacy
 * gateways without changing this class.
 */
class CheckoutService {
    private PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount, String currency) {
        paymentProcessor.processPayment(amount, currency);
        if (paymentProcessor.isPaymentSuccessful()) {
            System.out.println("CheckoutService: Order successful! Transaction ID: "
                    + paymentProcessor.getTransactionId());
        } else {
            System.out.println("CheckoutService: Order failed. Payment was not successful.");
        }
    }
}