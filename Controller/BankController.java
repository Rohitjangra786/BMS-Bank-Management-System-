package BankManageMentSystem.Controller;

import java.util.List;
import BankManageMentSystem.Model.BankDAO;
import BankManageMentSystem.Model.Transaction;
import BankManageMentSystem.View.BankView;

public class BankController {
    private BankDAO bankDAO;
    private BankView bankView;

    public BankController(BankDAO bankDAO, BankView bankView) {
        this.bankDAO = bankDAO;
        this.bankView = bankView;
    }

    public void createAccount(String accountHolderName) {
        bankDAO.createAccount(accountHolderName);
        bankView.displayAccountCreatedMessage();
    }

    public void deposit(int accountId, double amount) {
        bankDAO.deposit(accountId, amount);
        bankView.displayDepositMessage();
    }

    public void withdraw(int accountId, double amount) {
        bankDAO.withdraw(accountId, amount);
        bankView.displayWithdrawalMessage();
    }

    public void checkAccountBalance(int accountId) {
        double balance = bankDAO.getAccountBalance(accountId);
        bankView.displayAccountBalance(balance);
    }

    public void getTransactionHistory(int accountId) {
        List<Transaction> transactions = bankDAO.getTransactionHistory(accountId);
        bankView.displayTransactionHistory(transactions);
    }
}