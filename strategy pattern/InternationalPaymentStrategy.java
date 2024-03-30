package designpatternpractice;

/**
 * strategy to process international payment
 * 
 * @author namanmalhotra
 */
public class InternationalPaymentStrategy implements PaymentProcessingStrategy {
    @Override
    public void processPayment(Double amount) {
        System.out.println("Processing international payment of $" + amount);
        // Implement logic for international payment processing
        Double totalAmount = amount + PaymentAppConstants.TransactionFees.INTERNATIONAL_FEE;
        System.out.println(
                "Applied international transaction fee: $" + PaymentAppConstants.TransactionFees.INTERNATIONAL_FEE);
        System.out.println("Total amount to be charged: $" + totalAmount);
    }
}
