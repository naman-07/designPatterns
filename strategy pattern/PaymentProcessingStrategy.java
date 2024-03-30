package designpatternpractice;

/**
 * interface for payment processing
 * 
 * @author namanmalhotra
 */
public interface PaymentProcessingStrategy {
    void processPayment(Double amount);
}
