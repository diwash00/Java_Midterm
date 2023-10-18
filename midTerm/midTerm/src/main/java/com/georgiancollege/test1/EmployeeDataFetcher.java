package com.georgiancollege.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataFetcher {
    private static final String DB_USERNAME = "Diwash200542953";
    private static final String DB_PASSWORD = "q3nREdBmMz";
    private static final String DB_URL = "jdbc:mysql://172.31.22.43:3306/midTermEmployee";

    public List<Employee> fetchEmployeesFromDatabase() {
        List<Employee> employees = new ArrayList<>();

        String query = "SELECT * FROM Diwash200542953.midTermEmployee;";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employeeId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String province = resultSet.getString("province");
                String phoneNo = resultSet.getString("phoneNo");

                Employee employee = new Employee(employeeId, firstName, lastName, address, city, province, phoneNo);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately in your application
        }

        return employees;
    }

    public static void main(String[] args) {
        EmployeeDataFetcher dataFetcher = new EmployeeDataFetcher();
        List<Employee> employees = dataFetcher.fetchEmployeesFromDatabase();

        // Ensure you have a way to handle and use the retrieved Employee objects
        // E.g., you can print the details of each employee
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getEmployeeId());
            System.out.println("First Name: " + employee.getFirstName());
            System.out.println("Last Name: " + employee.getLastName());
            System.out.println("Address: " + employee.getAddress());
            System.out.println("City: " + employee.getCity());
            System.out.println("Province: " + employee.getProvince());
            System.out.println("Phone Number: " + employee.getPhoneNo());
            System.out.println("===========================");
        }
    }
}
