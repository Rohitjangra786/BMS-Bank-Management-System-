package BankManageMentSystem;

import BankManageMentSystem.Controller.BankController;
import BankManageMentSystem.Controller.EmployeeController;
import BankManageMentSystem.Model.BankDAO;
import BankManageMentSystem.Model.BankDAOImpl;
import BankManageMentSystem.Model.Employee;
import BankManageMentSystem.Model.EmployeeDAO;
import BankManageMentSystem.Model.EmployeeDAOImpl;
import BankManageMentSystem.View.BankView;

public class Main {
    public static void main(String[] args) {
        BankDAO bankDAO = new BankDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        BankView bankView = new BankView();
        BankController bankController = new BankController(bankDAO, bankView);
        EmployeeController employeeController = new EmployeeController(employeeDAO);

        while (true) {
            bankView.displayMenu();
            int choice = Integer.parseInt(System.console().readLine("Enter your choice: "));

            switch (choice) {
                case 1:
                    String accountHolderName = System.console().readLine("Enter account holder name: ");
                    bankController.createAccount(accountHolderName);
                    break;
                case 2:
                    int accountId = Integer.parseInt(System.console().readLine("Enter account ID: "));
                    double depositAmount = Double.parseDouble(System.console().readLine("Enter deposit amount: "));
                    bankController.deposit(accountId, depositAmount);
                    break;
                case 3:
                    accountId = Integer.parseInt(System.console().readLine("Enter account ID: "));
                    double withdrawalAmount = Double.parseDouble(System.console().readLine("Enter withdrawal amount: "));
                    bankController.withdraw(accountId, withdrawalAmount);
                    break;
                case 4:
                    accountId = Integer.parseInt(System.console().readLine("Enter account ID: "));
                    bankController.checkAccountBalance(accountId);
                    break;
                case 5:
                    accountId = Integer.parseInt(System.console().readLine("Enter account ID: "));
                    bankController.getTransactionHistory(accountId);
                    break;
                case 6:
                    String employeeName = System.console().readLine("Enter employee name: ");
                    String employeeRole = System.console().readLine("Enter employee role: ");
                    String employeeEmail = System.console().readLine("Enter employee email: ");
                    String employeePhoneNumber = System.console().readLine("Enter employee phone number: ");
                    Employee employee = new Employee(0, employeeName, employeeRole, employeeEmail, employeePhoneNumber);
                    employeeController.createEmployee(employee);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}