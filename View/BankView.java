package BankManageMentSystem.View;

import java.util.List;
import BankManageMentSystem.Model.Employee;
import BankManageMentSystem.Model.Transaction;

public class BankView {
    public void displayMenu() {
        System.out.println("Bank Management System");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Check Account Balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Manage Employees");
        System.out.println();
        System.out.println("7. Exit");
    }

    public void displayAccountCreatedMessage() {
        System.out.println("Account created successfully!");
    }

    public void displayDepositMessage() {
        System.out.println("Funds deposited successfully!");
    }

    public void displayWithdrawalMessage() {
        System.out.println("Funds withdrawn successfully!");
    }

    public void displayAccountBalance(double balance) {
        System.out.println("Account balance: " + balance);
    }

    public void displayTransactionHistory(List<Transaction> transactions) {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getTransactionId() + " - " + transaction.getTransactionType() + " - " + transaction.getTransactionAmount() + " - " + transaction.getTransactionDate());
        }
    }

    public void displayEmployeeMenu() {
        System.out.println("Employee Management");
        System.out.println("1. Create Employee");
        System.out.println("2. Get Employee");
        System.out.println("3. Get All Employees");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println();
        System.out.println("6. Back to Main Menu");
    }

    public void displayEmployeeCreatedMessage() {
        System.out.println("Employee created successfully!");
    }

    public void displayEmployeeInfo(Employee employee) {
        System.out.println("Employee Information:");
        System.out.println("ID: " + employee.getEmployeeId());
        System.out.println("Name: " + employee.getEmployeeName());
        System.out.println("Role: " + employee.getEmployeeRole());
        System.out.println("Email: " + employee.getEmployeeEmail());
        System.out.println("Phone Number: " + employee.getEmployeePhoneNumber());
    }

    public void displayEmployees(List<Employee> employees) {
        System.out.println("Employees:");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getEmployeeId() + ", Name: " + employee.getEmployeeName());
        }
    }
}