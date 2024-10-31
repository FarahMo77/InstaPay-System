package Bills;

import Users.DatabaseMemory;

public class GasBill implements BillStrategy {
    private final DatabaseMemory databaseMemory;

    public GasBill(DatabaseMemory databaseMemory) {
        this.databaseMemory = databaseMemory;
    }

    @Override
    public void payBill() {
        String gasAccount = "gasAccount101";
        double billAmount = 90.0;

        // Check if the gas account exists in the DatabaseMemory
        if (databaseMemory.getGasAccountBalances().containsKey(gasAccount)) {
            double currentBalance = databaseMemory.getGasAccountBalances().get(gasAccount);

            // Check if the account has sufficient balance
            if (currentBalance >= billAmount) {
                // Deduct the bill amount from the account balance
                databaseMemory.getGasAccountBalances().put(gasAccount, currentBalance - billAmount);

                // Print the updated balance
                System.out.println("Gas bill payment successful. New balance for " + gasAccount + ": "
                        + databaseMemory.getGasAccountBalances().get(gasAccount));
            } else {
                System.out.println("Insufficient balance for gas account: " + gasAccount);
            }
        } else {
            System.out.println("Gas account does not exist.");
        }
    }
}
