package Bills;

import Users.DatabaseMemory;

public class ElectricityBill implements BillStrategy {
    private final DatabaseMemory databaseMemory;

    public ElectricityBill(DatabaseMemory databaseMemory) {
        this.databaseMemory = databaseMemory;
    }

    @Override
    public void payBill() {
        String electricityAccount = "electricityAccount123";
        double billAmount = 100.0;

        // Check if the electricity account exists in the DatabaseMemory
        if (databaseMemory.getElectricityAccountBalances().containsKey(electricityAccount)) {
            double currentBalance = (double) databaseMemory.getElectricityAccountBalances().get(electricityAccount);

            // Check if the account has sufficient balance
            if (currentBalance >= billAmount) {
                // Deduct the bill amount from the account balance
                databaseMemory.getElectricityAccountBalances().put(electricityAccount, currentBalance - billAmount);

                // Print the updated balance
                System.out.println("Electricity bill payment successful. New balance for " + electricityAccount + ": "
                        + databaseMemory.getElectricityAccountBalances().get(electricityAccount));
            } else {
                System.out.println("Insufficient balance for electricity account: " + electricityAccount);
            }
        } else {
            System.out.println("Electricity account does not exist.");
        }
    }
}
