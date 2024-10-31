package Verification;

public class VerificationContext {
    private String mobileNum;
    private String account;
    private VerificationStrategy verificationStrategy;

    public void setVerificationStrategy(VerificationStrategy verificationStrategy) {
        this.verificationStrategy = verificationStrategy;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public void performVerify() {
        verificationStrategy.verify(account, mobileNum);
    }
}
