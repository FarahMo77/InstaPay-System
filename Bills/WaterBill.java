package Bills;

import Users.DatabaseMemory;

public class WaterBill implements BillStrategy {
    private final DatabaseMemory databaseMemory;

    public WaterBill(DatabaseMemory databaseMemory) {
        this.databaseMemory = databaseMemory;
    }

    @Override
    public void payBill() {
        String waterAccount = "waterAccount9";
        double billAmount = 80.0;

        // Check if the water account exists in the DatabaseMemory
        if (databaseMemory.getWaterAccountBalances().containsKey(waterAccount)) {
            double currentBalance = (double) databaseMemory.getWaterAccountBalances().get(waterAccount);

            // Check if the account has sufficient balance
            if (currentBalance >= billAmount) {
                // Deduct the bill amount from the account balance
                databaseMemory.getWaterAccountBalances().put(waterAccount, currentBalance - billAmount);

                // Print the updated balance
                System.out.println("Water bill payment successful. New balance for " + waterAccount + ": "
                        + databaseMemory.getWaterAccountBalances().get(waterAccount));
            } else {
                System.out.println("Insufficient balance for water account: " + waterAccount);
            }
        } else {
            System.out.println("Water account does not exist.");
        }
    }
}