package Verification;

import Users.DatabaseMemory;

import java.util.Map;

public class VerifyBankUser implements VerificationStrategy {
    private final Map<String, String> userBankAccounts;

    public VerifyBankUser(DatabaseMemory databaseMemory) {
        this.userBankAccounts = databaseMemory.getUserBankAccounts();
    }

    @Override
    public void verify(String bankAccount, String mobileNumber) {
        // Check if the provided bank account and mobile number match
        if (userBankAccounts.containsKey(bankAccount) && userBankAccounts.get(bankAccount).equals(mobileNumber)) {
            System.out.println("Bank user verification successful.");
        } else {
            System.out.println("Bank user verification failed. Please check the provided bank account and mobile number.");
        }
    }
}
