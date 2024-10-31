package Bills;

import Bills.BillStrategy;

public class UtilityBillContext {
    private double amount ;
    private BillStrategy billStrategy ;

    private boolean isPaid;


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BillStrategy getBillStrategy() {
        return billStrategy;
    }

    public void setBillStrategy(BillStrategy billStrategy) {
        this.billStrategy = billStrategy;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void preformBill(){
        billStrategy.payBill();
    }
}