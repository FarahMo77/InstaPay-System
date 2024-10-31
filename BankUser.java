package Users;

import Verification.VerificationOTP;
import Verification.VerificationStrategy;
import Verification.VerifyBankUser;

import java.util.Scanner;

public class BankUser extends User {
    private final String accountNumber;

    public BankUser(String username, String password, String mobileNumber, double balance, String accountNumber, DatabaseMemory userHashMap) {
        super(username, password, mobileNumber, balance, userHashMap);
        this.accountNumber = accountNumber;
    }

    @Override
    public void signUp() {
        Scanner scanner = new Scanner(System.in);

        // Additional logic for signing up a bank user
        System.out.println("Enter a unique username:");
        String username = scanner.next();
        System.out.println("Enter a password:");
        String password = scanner.next();

        setUsername(username);
        setPassword(password);

        // Verification strategy
        VerificationStrategy verificationStrategy = new VerifyBankUser(getUserHashMap());
        setVerificationStrategy(verificationStrategy);
        getVerificationStrategy().verify(accountNumber, this.getMobileNumber());

        // Simulate OTP verification
        String otp = "123456";  // Use a dummy OTP
        VerificationOTP mobileApi = new VerificationOTP();
        if (mobileApi.verifyOtp(getMobileNumber(), otp)) {
            System.out.println("Bank user OTP verification successful.");
            // Additional logic for signing up a bank user
            System.out.println("Bank user signed up. Account Number: " + accountNumber);

            // Add the user to the userHashMap with the provided username using the put method
            getUserHashMap().put(getUsername(), this);
        } else {
            System.out.println("Bank user OTP verification failed.");
        }
    }

    @Override
    public User signIn(String username, String password) {
        // Check if the user exists in the userHashMap based on the username
        if (userExists(username)) {
            User user = getUserHashMap().get(username);

            // Check if the provided password matches the stored password
            if (user != null && user.getPassword().equals(password)) {
                System.out.println("Bank user signed in. Welcome, " + user.getUsername() + "!");
                return user;
            } else {
                System.out.println("Invalid password for user: " + username);
            }
        } else {
            System.out.println("User not found: " + username);
        }

        return null;
    }

    private boolean userExists(String username) {
        return getUserHashMap().containsKey(username);
    }

    @Override
    public void inquireBalance() {
        // Implementation for inquiring balance for a bank user
        System.out.println("Bank user balance: " + getBalance());
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void loadUserProfile() {
        // Implementation for loading user profile for a bank user
        System.out.println("Loading Bank user profile...");
        System.out.println("Username: " + getUsername());
        System.out.println("Mobile Number: " + getMobileNumber());
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + getBalance());
    }
}
