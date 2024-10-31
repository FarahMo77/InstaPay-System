package Users;

import Verification.VerificationOTP;
import Verification.VerificationStrategy;
import Verification.VerifyMobileNum;

import java.util.Map;
import java.util.Scanner;

public class WalletUser extends User {
    private final String walletProvider;

    public WalletUser(String username, String password, String mobileNumber, double balance, String walletProvider, DatabaseMemory userHashMap) {
        super(username, password, mobileNumber, balance, userHashMap);
        this.walletProvider = walletProvider;
    }

    @Override
    public void signUp() {
        DatabaseMemory databaseMemory = getUserHashMap();
        Map<String, String> userWalletAccounts = databaseMemory.getUserWalletAccounts();

        VerificationStrategy verificationStrategy = new VerifyMobileNum(databaseMemory);
        setVerificationStrategy(verificationStrategy);

        Scanner scanner = new Scanner(System.in);

        // Additional logic for signing up a wallet user
        System.out.println("Enter a unique username:");
        String username = scanner.next();
        System.out.println("Enter a password:");
        String password = scanner.next();

        setUsername(username);
        setPassword(password);

        // Verify mobile number with the wallet provider
        if (databaseMemory.verifyMobileNumberWithWalletProvider(getMobileNumber(), walletProvider)) {
            // Send OTP and verify ownership
            System.out.println("Sending OTP to " + getMobileNumber());
            String otp = "654321";  // Use a dummy OTP
            if (databaseMemory.verifyMobileNumberOwnership(getMobileNumber(), otp)) {
                if (!userWalletAccounts.containsKey(walletProvider)) {
                    System.out.println("Wallet user OTP verification successful.");
                    System.out.println("Wallet user signed up. Wallet Provider: " + walletProvider);

                    // Add the user to the userHashMap with the provided username using the put method
                    databaseMemory.put(getUsername(), this);
                    // Add the wallet provider to the userWalletAccounts map
                    userWalletAccounts.put(walletProvider, getMobileNumber());
                } else {
                    System.out.println("Wallet provider already in use.");
                }
            } else {
                System.out.println("Wallet user OTP verification failed.");
            }
        } else {
            System.out.println("Mobile number verification with wallet provider failed.");
        }
    }




    @Override
    public User signIn(String username, String password) {
        // Check if the user exists in the userHashMap based on the username
        if (getUserHashMap().userExists(username)) {
            User user = getUserHashMap().get(username); // Corrected line

            // Check if the provided password matches the stored password
            if ((user != null) && user.getPassword().equals(password)) {
                System.out.println("Wallet user signed in. Welcome, " + user.getUsername() + "!");
                return user;
            } else {
                System.out.println("Invalid password for user: " + username);
            }
        } else {
            System.out.println("User not found: " + username);
        }

        return null;
    }

    @Override
    public void inquireBalance() {
        // Implementation for inquiring balance for a wallet user
        System.out.println("Wallet user balance: " + getBalance());
    }

    @Override
    public String getAccountNumber() {
        return null;
    }

    @Override
    public void loadUserProfile() {
        // Implementation for loading user profile for a wallet user
        System.out.println("Loading Wallet user profile...");
        System.out.println("Username: " + getUsername());
        System.out.println("Mobile Number: " + getMobileNumber());
        System.out.println("Wallet Provider: " + walletProvider);
        System.out.println("Balance: " + getBalance());
    }
}
