package BankManageMentSystem.Model;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String employeeRole;
    private String employeeEmail;
    private String employeePhoneNumber;

    public Employee(int employeeId, String employeeName, String employeeRole, String employeeEmail, String employeePhoneNumber) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
        this.employeeEmail = employeeEmail;
        this.employeePhoneNumber = employeePhoneNumber;
    }

    // Getters and setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeRole='" + employeeRole + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeePhoneNumber='" + employeePhoneNumber + '\'' +
                '}';
    }
}