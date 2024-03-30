package designpatternpractice;

/**
 * strategy to process domestic payment
 * 
 * @author namanmalhotra
 */
public class DomesticPaymentStrategy implements PaymentProcessingStrategy {
    @Override
    public void processPayment(Double amount) {
        System.out.println("Processing domestic payment of $" + amount);
        // Implement logic for domestic payment processing
        Double totalAmount = amount + PaymentAppConstants.TransactionFees.DOMESTIC_FEE;
        System.out.println("Applied domestic transaction fee: $" + PaymentAppConstants.TransactionFees.DOMESTIC_FEE);
        System.out.println("Total amount to be charged: $" + totalAmount);
    }
}
