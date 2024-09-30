package BankManageMentSystem.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankDAOImpl implements BankDAO {
    private Connection conn;

    public BankDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rohit", "postgres", "tiger");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    @Override
    public void createAccount(String accountHolderName) {
        String query = "INSERT INTO accounts (account_holder_name, account_balance) VALUES (?, 0.0)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, accountHolderName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }
    }

    @Override
    public void deposit(int accountId, double amount) {
        String query = "UPDATE accounts SET account_balance = account_balance + ? WHERE account_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error depositing funds: " + e.getMessage());
        }
    }

    @Override
    public void withdraw(int accountId, double amount) {
        String query = "UPDATE accounts SET account_balance = account_balance - ? WHERE account_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error withdrawing funds: " + e.getMessage());
        }
    }

    @Override
    public double getAccountBalance(int accountId) {
        String query = "SELECT account_balance FROM accounts WHERE account_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, accountId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("account_balance");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving account balance: " + e.getMessage());
        }
        return 0.0;
    }

    @Override
    public List<Transaction> getTransactionHistory(int accountId) {
        String query = "SELECT * FROM transactions WHERE account_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, accountId);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<Transaction> transactions = new ArrayList<>();
                while (rs.next()) {
                    Transaction transaction = new Transaction(
                            rs.getInt("transaction_id"),
                            rs.getInt("account_id"),
                            rs.getString("transaction_type"),
                            rs.getDouble("transaction_amount"),
                            rs.getDate("transaction_date")
                    );
                    transactions.add(transaction);
                    System.out.println("Added transaction: " + transaction); // Debug statement
                }
                System.out.println("Transactions list size: " + transactions.size()); // Debug statement
                return transactions;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving transaction history: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing database connection: " + e.getMessage());
        }
    }
}
