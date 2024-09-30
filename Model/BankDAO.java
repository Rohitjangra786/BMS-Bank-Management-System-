package BankManageMentSystem.Model;

import java.util.List;

public interface BankDAO {
    void createAccount(String accountHolderName);
    void deposit(int accountId, double amount);
    void withdraw(int accountId, double amount);
    double getAccountBalance(int accountId);
    List<Transaction> getTransactionHistory(int accountId);
}
