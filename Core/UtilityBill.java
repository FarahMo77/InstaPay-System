package Core;

import Core.BillStrategy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilityBill {
    String url = "jdbc:sqlite:D:\\College\\4th\\Software Design and Architecture 2023-2024\\InstaPay-Project\\20206054_20206026_20216107\\myDatabase.db";
    private String billType;
    private double amount;
    private String isPaid;
    private BillStrategy billStrategy;

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setBillStrategy(BillStrategy billStrategy) {
        this.billStrategy = billStrategy;
    }

    public void performBillPayment() {
        if (billType == null || amount <= 0.0 || isPaid == null) {
            System.out.println("Invalid bill information. Payment cannot be performed.");
            return;
        }

        // Check if a bill strategy is set
        if (billStrategy == null) {
            System.out.println("No bill strategy set. Payment cannot be performed.");
            return;
        }

        // Perform bill payment using the selected strategy
        try (Connection connection = DriverManager.getConnection(url)) {

            // Your actual bill payment logic using the connection

            // Example: You might want to pass the connection to the bill strategy
            billStrategy.payBill(connection, billType, amount, isPaid);
        } catch (SQLException e) {
            // Handle database-related exceptions
            e.printStackTrace();
        }
    }

    public void performBill() {
        // Assuming you have a connection variable declared somewhere, you should use it here
        try (Connection connection = DriverManager.getConnection(url)) {
            billStrategy.payBill(connection, billType, amount, isPaid);
        } catch (SQLException e) {
            // Handle database-related exceptions
            e.printStackTrace();
        }
    }
}
