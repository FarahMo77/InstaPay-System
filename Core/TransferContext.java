package Core;

public class TransferContext {
    private String destination;
    private double amount;
    private TransferStrategy transferStrategy;

    public void setTransferStrategy(TransferStrategy transferStrategy)
    {
        this.transferStrategy = transferStrategy;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public void setDestination(String destination)
    {
        this.destination =destination;
    }

    public String getDestination()
    {
        return this.destination;
    }
    public double getAmount()
    {
        return this.amount;
    }
    public void performTransfer()
    {
        transferStrategy.Transfer();
    }

}
