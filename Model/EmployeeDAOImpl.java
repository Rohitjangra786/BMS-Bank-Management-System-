package BankManageMentSystem.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection conn;

    public EmployeeDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rohit", "postgres", "tiger");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    @Override
    public void createEmployee(Employee employee) {
        String query = "INSERT INTO employees (employee_name, employee_role, employee_email, employee_phone_number) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, employee.getEmployeeName());
            pstmt.setString(2, employee.getEmployeeRole());
            pstmt.setString(3, employee.getEmployeeEmail());
            pstmt.setString(4, employee.getEmployeePhoneNumber());
            pstmt.executeUpdate();
            System.out.println("Employee created: " + employee);
        } catch (SQLException e) {
            System.out.println("Error creating employee: " + e.getMessage());
        }
    }

    @Override
    public Employee getEmployee(int employeeId) {
        String query = "SELECT * FROM employees WHERE employee_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Employee employee = new Employee(
                            rs.getInt("employee_id"),
                            rs.getString("employee_name"),
                            rs.getString("employee_role"),
                            rs.getString("employee_email"),
                            rs.getString("employee_phone_number")
                    );
                    return employee;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employee: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String query = "SELECT * FROM employees";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                List<Employee> employees = new ArrayList<>();
                while (rs.next()) {
                    Employee employee = new Employee(
                            rs.getInt("employee_id"),
                            rs.getString("employee_name"),
                            rs.getString("employee_role"),
                            rs.getString("employee_email"),
                            rs.getString("employee_phone_number")
                    );
                    employees.add(employee);
                }
                return employees;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving all employees: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public void updateEmployee(Employee employee) {
        String query = "UPDATE employees SET employee_name = ?, employee_role = ?, employee_email = ?, employee_phone_number = ? WHERE employee_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, employee.getEmployeeName());
            pstmt.setString(2, employee.getEmployeeRole());
            pstmt.setString(3, employee.getEmployeeEmail());
            pstmt.setString(4, employee.getEmployeePhoneNumber());
            pstmt.setInt(5, employee.getEmployeeId());
            pstmt.executeUpdate();
            System.out.println("Employee updated: " + employee);
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String query = "DELETE FROM employees WHERE employee_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            pstmt.executeUpdate();
            System.out.println("Employee deleted: " + employeeId);
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing database connection: " + e.getMessage());
        }
    }
}