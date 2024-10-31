package Core;

import Core.BillStrategy;

import java.sql.Connection;
import java.util.Random;

public class ElectricityBill implements BillStrategy {

    @Override
    public void payBill(Connection connection, String billType, double amount, String isPaid) {
        if (isPaid == null) {
            System.out.println("Payment can't be performed because the payment status is null.");
        } else {
            if (isPaid.equalsIgnoreCase("Yes")) {
                // Example: Perform actual bill payment logic using the provided Connection
                System.out.println("Bill payment logic using the database connection...");

                // Example: Generate and print a random value
                double randomValue = generateRandomAmount(amount);
                System.out.println("Random value for payment: " + randomValue);
            } else {
                System.out.println("Bill is not paid. Payment can't be performed.");
            }
        }
    }

    private double generateRandomAmount(double baseAmount) {
        // Use java.util.Random for generating random numbers
        Random random = new Random();
        return baseAmount * (1 + random.nextDouble());
    }
}
