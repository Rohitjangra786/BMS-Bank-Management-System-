package BankManageMentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTheTable {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/rohit";
            String user = "postgres";
            String pwd = "tiger";

            Connection connection = DriverManager.getConnection(url, user, pwd);
            PreparedStatement p = connection.prepareStatement("CREATE TABLE accounts ( account_id SERIAL PRIMARY KEY, account_holder_name VARCHAR(255) NOT NULL, account_balance DECIMAL(10, 2) NOT NULL DEFAULT 0.00);");
            PreparedStatement pp = connection.prepareStatement("CREATE TABLE transactions (transaction_id INT PRIMARY KEY,account_id INT,transaction_type VARCHAR(20),transaction_amount DECIMAL(10, 2),transaction_date DATE,FOREIGN KEY (account_id) REFERENCES accounts(account_id));");
            PreparedStatement p3 = connection.prepareStatement("CREATE TABLE employees (employee_id SERIAL PRIMARY KEY,employee_name VARCHAR(50) NOT NULL,employee_role VARCHAR(50) NOT NULL,employee_email VARCHAR(100) NOT NULL,employee_phone_number VARCHAR(20) NOT NULL);");
            
                p.execute();
                pp.execute();
                p3.execute();
                System.out.println("Table Creation Done");
                
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Other Exception: " + e.getMessage());
            } 
    }
}
