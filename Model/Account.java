package BankManageMentSystem.Model;

public class Account {
    private int accountId;
    private String accountHolderName;
    private double accountBalance;

    public Account(int accountId, String accountHolderName, double accountBalance) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    // Getters and setters
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
