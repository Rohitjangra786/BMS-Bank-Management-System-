package BankManageMentSystem.Model;
import java.util.List;

public interface EmployeeDAO {
    void createEmployee(Employee employee);
    Employee getEmployee(int employeeId);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
}