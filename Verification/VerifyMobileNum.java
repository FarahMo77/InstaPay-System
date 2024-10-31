package Verification;

import Users.DatabaseMemory;

import java.util.Map;

public class VerifyMobileNum implements VerificationStrategy {
    private final Map<String, String> userWalletAccounts; // Map to store user wallet accounts and mobile numbers

    public VerifyMobileNum(DatabaseMemory databaseMemory) {
        // Initialize the map with the user wallet accounts from the DatabaseMemory
        this.userWalletAccounts = databaseMemory.getUserWalletAccounts();
    }


    @Override
    public void verify(String walletProvider, String mobileNumber) {
        // Check if the provided wallet provider and mobile number match
        if (userWalletAccounts.containsKey(walletProvider) && userWalletAccounts.get(walletProvider).equals(mobileNumber)) {
            System.out.println("Wallet user verification successful.");
        } else {
            System.out.println("Wallet user verification failed. Please check the provided wallet provider and mobile number.");
        }
    }
}