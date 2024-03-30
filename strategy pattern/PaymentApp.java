package designpatternpractice;

/**
 * class to explain how strategy pattern works
 * 
 * @author namanmalhotra
 */
public class PaymentApp {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        // Process domestic payment
        processor.processPayment(PaymentAppConstants.PaymentModes.DOMESTIC, 100.00);
        // Process international payment
        processor.processPayment(PaymentAppConstants.PaymentModes.INTERNATIONAL, 200.00);
        // Attempt to process with an invalid payment type
        processor.processPayment(PaymentAppConstants.PaymentModes.NATIONAL, 300.00);
    }
}
