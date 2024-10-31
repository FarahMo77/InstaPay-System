package Verification;

import java.util.HashMap;
import java.util.Map;

public class VerificationOTP {
    private final Map<String, String> mobileNumberToOtp;

    public VerificationOTP() {
        // Initialize the map with sample data
        mobileNumberToOtp = new HashMap<>();
        mobileNumberToOtp.put("0123456789", "123456");
        mobileNumberToOtp.put("9876543210", "654321");
        mobileNumberToOtp.put("1234567890", "987654");
    }

    public boolean verifyOtp(String mobileNumber, String otp) {
        // Simulate OTP verification by checking if the provided OTP is correct
        return mobileNumberToOtp.containsKey(mobileNumber)
                && mobileNumberToOtp.get(mobileNumber).equals(otp);
    }
}

