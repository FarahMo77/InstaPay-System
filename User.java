package Users;

import Bills.UtilityBillContext;
import Transfer.TransferContext;
import Verification.VerificationStrategy;

public abstract class User {
    private String username;
    private String password;
    private String mobileNumber;
    private double balance;
    private UtilityBillContext bill;
    private TransferContext transfer;
    final DatabaseMemory userHashMap;
    private VerificationStrategy verificationStrategy;

    public User(String username, String password, String mobileNumber, double balance, DatabaseMemory userHashMap) {
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.balance = balance;
        this.userHashMap = userHashMap;
    }

    public abstract void signUp();

    public abstract User signIn(String username, String password);

    public abstract void loadUserProfile();

    public abstract void inquireBalance();

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public DatabaseMemory getUserHashMap() {
        return userHashMap;
    }

    public void setVerificationStrategy(VerificationStrategy verificationStrategy) {
        this.verificationStrategy = verificationStrategy;
    }

    public VerificationStrategy getVerificationStrategy() {
        return verificationStrategy;
    }

    public abstract String getAccountNumber();
}

