package com.tutorial.projects.intermediate.employee;

/**
 * Employee Class - Employee Management System
 * 
 * This class represents an employee with personal and professional information,
 * including salary, department, and employment details.
 * 
 * LEARNING OBJECTIVES:
 * - Implement complex object modeling
 * - Use enums for department and position
 * - Apply encapsulation and data validation
 * - Implement comparable interface for sorting
 * - Build a complete employee management system
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class Employee implements Comparable<Employee> {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Department department;
    private Position position;
    private double salary;
    private String hireDate;
    private boolean isActive;
    
    /**
     * Constructor to create a new employee
     */
    public Employee(int employeeId, String firstName, String lastName, String email, 
                   String phoneNumber, Department department, Position position, 
                   double salary, String hireDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
        this.isActive = true;
    }
    
    /**
     * Get full name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    /**
     * Update salary
     */
    public void updateSalary(double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
            System.out.println("Salary updated successfully for " + getFullName());
        } else {
            System.out.println("Invalid salary amount. Salary must be positive.");
        }
    }
    
    /**
     * Transfer employee to different department
     */
    public void transferDepartment(Department newDepartment) {
        this.department = newDepartment;
        System.out.println(getFullName() + " transferred to " + newDepartment + " department");
    }
    
    /**
     * Promote employee to new position
     */
    public void promote(Position newPosition) {
        this.position = newPosition;
        System.out.println(getFullName() + " promoted to " + newPosition);
    }
    
    /**
     * Deactivate employee
     */
    public void deactivate() {
        this.isActive = false;
        System.out.println(getFullName() + " has been deactivated");
    }
    
    /**
     * Activate employee
     */
    public void activate() {
        this.isActive = true;
        System.out.println(getFullName() + " has been activated");
    }
    
    // Getters
    public int getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public Department getDepartment() { return department; }
    public Position getPosition() { return position; }
    public double getSalary() { return salary; }
    public String getHireDate() { return hireDate; }
    public boolean isActive() { return isActive; }
    
    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setHireDate(String hireDate) { this.hireDate = hireDate; }
    
    /**
     * Display employee information
     */
    public void displayInfo() {
        System.out.println("\n=== Employee Information ===");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + getFullName());
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Department: " + department);
        System.out.println("Position: " + position);
        System.out.println("Salary: $" + salary);
        System.out.println("Hire Date: " + hireDate);
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("==========================\n");
    }
    
    /**
     * Compare employees by salary for sorting
     */
    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }
    
    /**
     * String representation of employee
     */
    @Override
    public String toString() {
        return "Employee{id=" + employeeId + ", name='" + getFullName() + 
               "', department=" + department + ", position=" + position + 
               ", salary=$" + salary + ", active=" + isActive + "}";
    }
    
    /**
     * Check if two employees are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return employeeId == employee.employeeId;
    }
    
    /**
     * Hash code for employee
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(employeeId);
    }
}

/**
 * Department enumeration
 */
enum Department {
    HUMAN_RESOURCES, FINANCE, MARKETING, SALES, 
    INFORMATION_TECHNOLOGY, OPERATIONS, CUSTOMER_SERVICE
}

/**
 * Position enumeration
 */
enum Position {
    INTERN, JUNIOR, SENIOR, LEAD, MANAGER, DIRECTOR, VP, CEO
}
