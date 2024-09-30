package BankManageMentSystem.Controller;

import BankManageMentSystem.Model.Employee;
import BankManageMentSystem.Model.EmployeeDAO;
import java.util.List;

public class EmployeeController {
    private EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void createEmployee(Employee employee) {
        employeeDAO.createEmployee(employee);
    }

    public Employee getEmployee(int employeeId) {
        return employeeDAO.getEmployee(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
    
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(int employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }
}