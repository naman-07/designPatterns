package designpatternpractice;

import java.util.HashMap;
import java.util.Map;

/**
 * class to process any payment based on payment strategy
 * 
 * @author namanmalhotra
 */
public class PaymentProcessor {
    private Map<String, PaymentProcessingStrategy> strategyMap;

    public PaymentProcessor() {
        strategyMap = new HashMap<>();
        strategyMap.put(PaymentAppConstants.PaymentModes.DOMESTIC, new DomesticPaymentStrategy());
        strategyMap.put(PaymentAppConstants.PaymentModes.INTERNATIONAL, new InternationalPaymentStrategy());
    }

    public void processPayment(String paymentType, double amount) {
        PaymentProcessingStrategy strategy = strategyMap.get(paymentType.toLowerCase());
        if (strategy != null) {
            strategy.processPayment(amount);
        } else {
            System.out.println("Invalid payment type: " + paymentType);
        }
    }
}
