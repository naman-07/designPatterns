package designpatternpractice;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * main class to handle bank operations
 * 
 * @author namanmalhotra
 */
public class BankOperations {
    private static final String HDFC_BANK = "HDFC";
    private static final String SBI_BANK = "SBI";

    public static void main(String[] args) {
        // Create thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);
        /*
         * User 1 withdraws cash from HDFC ATM: as limit and atm balance is more
         * than withdraw amount-> sucessfully
         */
        executor.submit(() -> {
            BankATM hdfcATM = BankATM.getInstance(HDFC_BANK, new BigDecimal(20000), new BigDecimal(10000));
            BigDecimal withdrawAmount = new BigDecimal(2000);
            String userName = "naman";
            if (hdfcATM.withdrawCash(userName, withdrawAmount)) {
                System.out.println(
                        "User " + userName + " sucessfully  withdrew " + withdrawAmount + " amount from: " + HDFC_BANK);
            } else {
                System.out.println("User " + userName + "'s" + "  withdrawal of amount " + withdrawAmount
                        + " failed from: " + HDFC_BANK);
            }
        });
        /*
         * User 2 withdraws cash from SBI ATM : withdrawal fails as limit for
         * sbi bank is exeeded
         */
        executor.submit(() -> {
            BankATM sbiATM = BankATM.getInstance(SBI_BANK, new BigDecimal(5000), new BigDecimal(3000));
            BigDecimal withdrawAmount = new BigDecimal(3200);
            String userName = "Harjot";
            if (sbiATM.withdrawCash(userName, withdrawAmount)) {
                System.out.println(
                        "User " + userName + " sucessfully  withdrew " + withdrawAmount + " amount from: " + SBI_BANK);
            } else {
                System.out.println("User " + userName + "'s" + "  withdrawal of amount " + withdrawAmount
                        + " failed from: " + SBI_BANK);
            }
        });
        // User 3 tries to withdraw cash from HDFC ATM again
        /*
         * it tries to create a seprate instance but as bank is same both total
         * avaliable amount and limit will remain same as for user 1 and is
         * tries to withdraw more than the avaliable amount i.e->18000 than will
         * get error
         */
        executor.submit(() -> {
            BankATM hdfcATM = BankATM.getInstance(HDFC_BANK, new BigDecimal(20000), new BigDecimal(12000));
            String userName = "Raveesh";
            BigDecimal withdrawAmount = new BigDecimal(19000);
            if (hdfcATM.withdrawCash(userName, withdrawAmount)) {
                System.out.println(
                        "User " + userName + " sucessfully  withdrew " + withdrawAmount + " amount from: " + HDFC_BANK);
            } else {
                System.out.println("User " + userName + "'s" + "  withdrawal of amount " + withdrawAmount
                        + " failed from: " + HDFC_BANK + "as avaliable cash :" + hdfcATM.getAvaliableCash());
            }
        });
        // Bank employee replenishes cash in HDFC ATM
        /**
         * after replenish amount will be 19000 and not 23000 as there is only a
         * single instance and is only killed when all java processes using that
         * are over
         */
        executor.submit(() -> {
            BankATM hdfcATM = BankATM.getInstance(HDFC_BANK, new BigDecimal(22000), new BigDecimal(10000));
            BigDecimal replenishAmount = new BigDecimal(1000);
            hdfcATM.replenishCash(replenishAmount);
            System.out.println("Amount replenished: " + replenishAmount + " to bank: " + HDFC_BANK);
        });
        // Shutdown thread pool
        executor.shutdown();
    }
}
