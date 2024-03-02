package designpatternpractice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * singelton instance to handle multiple bank operations
 * 
 * @author namanmalhotra
 */
public class BankATM {
    private static Map<String, BankATM> instances = new HashMap<>();
    private String bankName;
    private BigDecimal cash;
    private List<String> transactionHistory;
    private BigDecimal maxWithdrawalLimit;

    /**
     * constructor for singelton class is private and cannot be invoked from
     * outside the class
     * 
     * @param bankName
     * @param initialCash
     * @param maxWithdrawalLimit
     */
    private BankATM(String bankName, BigDecimal initialCash, BigDecimal maxWithdrawalLimit) {
        this.bankName = bankName;
        this.cash = initialCash;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * public method create a single instance and use that for all the threads
     * based on bank name
     * 
     * @param bankName
     * @param initialCash
     * @param maxWithdrawalLimit
     * @return
     */
    public static BankATM getInstance(String bankName, BigDecimal initialCash, BigDecimal maxWithdrawalLimit) {
        instances.putIfAbsent(bankName, new BankATM(bankName, initialCash, maxWithdrawalLimit));
        return instances.get(bankName);
    }

    public Boolean withdrawCash(String user, BigDecimal amount) {
        synchronized (this) {
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("Invalid withdrawal amount: " + amount);
                return false;
            }
            if (amount.compareTo(cash) > 0 || amount.compareTo(maxWithdrawalLimit) > 0) {
                return false;
            }
            cash = cash.subtract(amount);
            transactionHistory.add("Withdrawal of " + amount + " by " + user);
            System.out.println(
                    "Withdrawal of " + amount + " successful from " + bankName + " ATM. Remaining cash: " + cash);
            return true;
        }
    }

    /**
     * add cash back to atm
     * 
     * @param amount
     */
    public void replenishCash(BigDecimal amount) {
        synchronized (this) {
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("Invalid replenishment amount: " + amount);
                return;
            }
            cash = cash.add(amount);
            transactionHistory.add("Cash replenished by bank employee: " + amount);
            System.out.println("Cash replenished in " + bankName + " ATM. Current cash: " + cash);
        }
    }

    /**
     * get the list of transactions
     * 
     * @return
     */
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    /**
     * get the max withdrawal limit
     * 
     * @return
     */
    public BigDecimal getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    /**
     * get the cash available
     * 
     * @return
     */
    public BigDecimal getAvaliableCash() {
        return cash;
    }
}
