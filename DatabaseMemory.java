package Users;

import Verification.VerificationOTP;

import java.util.HashMap;
import java.util.Map;

public class DatabaseMemory {
    private final Map<String, User> userHashMap;
    private final Map<String, String> userBankAccounts;
    private final Map<String, String> userWalletAccounts;
    private final Map<String, Double> userWalletBalances;
    private final Map<String, Double> accountBalances;
    private final Map<String, Double> waterAccountBalances;
    private final Map<String, Double> electricityAccountBalances;
    private final Map<String, Double> gasAccountBalances;

    public DatabaseMemory() {
        userHashMap = new HashMap<>();
        userBankAccounts = new HashMap<>();
        userWalletAccounts = new HashMap<>();
        userWalletBalances = new HashMap<>();
        accountBalances = new HashMap<>();
        waterAccountBalances = new HashMap<>();
        electricityAccountBalances = new HashMap<>();
        gasAccountBalances = new HashMap<>();

        // Adding sample data to the hash map
        User user1 = new BankUser("user1", "password1", "0123456789", 1000.0, "accountNumber1", this);
        User user2 = new WalletUser("user2", "password2", "9876543210", 1500.0, "VodaCash", this);
        User user3 = new BankUser("user3", "password3", "1234567890", 2000.0, "accountNumber3", this);

        userHashMap.put(user1.getUsername(), user1);
        userHashMap.put(user2.getUsername(), user2);
        userHashMap.put(user3.getUsername(), user3);

        // Adding sample data to the userBankAccounts map
        userBankAccounts.put("accountNumber1", "0123456789");
        userBankAccounts.put("accountNumber2", "9876543210");
        userBankAccounts.put("accountNumber3", "1234567890");

        // Adding sample data to the userWalletAccounts map
        userWalletAccounts.put("VodaCash", "9876543210");

        // Adding sample data to the userWalletBalances map
        userWalletBalances.put("OrangeCash", 500.0);
        userWalletBalances.put("VodaCash", 800.0);
        userWalletBalances.put("WEcash", 1000.0);

        // Adding sample data to the accountBalances map
        accountBalances.put("user1", 1000.0);
        accountBalances.put("user2", 1500.0);
        accountBalances.put("user3", 2000.0);

        // Adding sample data to the water account balances map
        waterAccountBalances.put("waterAccount1", 1200.0);
        waterAccountBalances.put("waterAccount2", 900.0);
        waterAccountBalances.put("waterAccount3", 1500.0);

        // Adding sample data to the electricity account balances map
        electricityAccountBalances.put("electricityAccount123", 1300.0);
        electricityAccountBalances.put("electricityAccount456", 950.0);
        electricityAccountBalances.put("electricityAccount789", 1600.0);

        // Adding sample data to the gas account balances map
        gasAccountBalances.put("gasAccount101", 1100.0);
        gasAccountBalances.put("gasAccount789", 1200.0);
    }

    public boolean verifyMobileNumberWithWalletProvider(String mobileNumber, String walletProvider) {
        switch (walletProvider.toLowerCase()) {
            case "vodacash":
                return "9876543210".equals(mobileNumber);
            case "orangecash":
                return "1234567890".equals(mobileNumber);
            case "wecash":
                return "01155401141".equals(mobileNumber);
            default:

                return false;
        }
    }


    public boolean verifyMobileNumberOwnership(String mobileNumber, String otp) {
        VerificationOTP mobileApi = new VerificationOTP();
        return mobileApi.verifyOtp(mobileNumber, otp);
    }
    public Map<String, Double> getGasAccountBalances() {
        return gasAccountBalances;
    }

    public Map<String, Double> getElectricityAccountBalances() {
        return electricityAccountBalances;
    }

    public boolean userExists(String username) {
        return userHashMap.containsKey(username);
    }

    public Map<String, Double> getWaterAccountBalances() {
        return waterAccountBalances;
    }

    public Map<String, String> getUserBankAccounts() {
        return userBankAccounts;
    }

    public Map<String, Double> getWalletBalances() {
        return userWalletBalances;
    }

    public Map<String, Double> getAccountBalances() {
        return accountBalances;
    }

    public Map<String, String> getUserWalletAccounts() {
        return userWalletAccounts;
    }

    public Map<String, User> getUserHashMap() {
        return userHashMap;
    }

    public User get(String username) {
        return userHashMap.get(username);
    }

    public void put(String username, User user) {
        userHashMap.put(username, user);
    }

    public boolean containsKey(String username) {
        return userHashMap.containsKey(username);
    }

//    public boolean walletProviderExists(String walletProvider) {
//        return userWalletAccounts.containsKey(walletProvider);
//    }


}
