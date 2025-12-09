package com.tutorial.projects;

import java.util.*;

/**
 * Department Class - Employee Management System
 * 
 * This class represents a department with employees and management functionality,
 * including employee management, department statistics, and reporting.
 * 
 * LEARNING OBJECTIVES:
 * - Implement department management
 * - Use collections for employee management
 * - Calculate department statistics
 * - Apply object-oriented design principles
 * - Build comprehensive management systems
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class Department {
    private String departmentName;
    private String managerName;
    private List<Employee> employees;
    private double budget;
    
    /**
     * Constructor to create a new department
     */
    public Department(String departmentName, String managerName, double budget) {
        this.departmentName = departmentName;
        this.managerName = managerName;
        this.budget = budget;
        this.employees = new ArrayList<>();
    }
    
    /**
     * Add employee to department
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println(employee.getFullName() + " added to " + departmentName + " department");
    }
    
    /**
     * Remove employee from department
     */
    public void removeEmployee(Employee employee) {
        if (employees.remove(employee)) {
            System.out.println(employee.getFullName() + " removed from " + departmentName + " department");
        } else {
            System.out.println("Employee not found in " + departmentName + " department");
        }
    }
    
    /**
     * Get total number of employees
     */
    public int getTotalEmployees() {
        return employees.size();
    }
    
    /**
     * Get number of active employees
     */
    public int getActiveEmployees() {
        return (int) employees.stream().filter(Employee::isActive).count();
    }
    
    /**
     * Calculate total salary cost
     */
    public double getTotalSalaryCost() {
        return employees.stream()
                .filter(Employee::isActive)
                .mapToDouble(Employee::getSalary)
                .sum();
    }
    
    /**
     * Calculate average salary
     */
    public double getAverageSalary() {
        long activeCount = employees.stream().filter(Employee::isActive).count();
        if (activeCount == 0) return 0;
        return getTotalSalaryCost() / activeCount;
    }
    
    /**
     * Get highest paid employee
     */
    public Employee getHighestPaidEmployee() {
        return employees.stream()
                .filter(Employee::isActive)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }
    
    /**
     * Get lowest paid employee
     */
    public Employee getLowestPaidEmployee() {
        return employees.stream()
                .filter(Employee::isActive)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }
    
    /**
     * Get employees by position
     */
    public List<Employee> getEmployeesByPosition(Position position) {
        return employees.stream()
                .filter(emp -> emp.getPosition() == position)
                .toList();
    }
    
    /**
     * Sort employees by salary
     */
    public void sortEmployeesBySalary() {
        employees.sort(Comparator.comparing(Employee::getSalary));
    }
    
    /**
     * Sort employees by name
     */
    public void sortEmployeesByName() {
        employees.sort(Comparator.comparing(Employee::getFullName));
    }
    
    /**
     * Display department information
     */
    public void displayDepartmentInfo() {
        System.out.println("\n=== Department Information ===");
        System.out.println("Department: " + departmentName);
        System.out.println("Manager: " + managerName);
        System.out.println("Budget: $" + budget);
        System.out.println("Total Employees: " + getTotalEmployees());
        System.out.println("Active Employees: " + getActiveEmployees());
        System.out.println("Total Salary Cost: $" + String.format("%.2f", getTotalSalaryCost()));
        System.out.println("Average Salary: $" + String.format("%.2f", getAverageSalary()));
        System.out.println("=============================\n");
    }
    
    /**
     * Display all employees in department
     */
    public void displayAllEmployees() {
        System.out.println("\n=== Employees in " + departmentName + " ===");
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
        System.out.println("===============================\n");
    }
    
    /**
     * Generate department report
     */
    public void generateReport() {
        System.out.println("\n=== Department Report: " + departmentName + " ===");
        displayDepartmentInfo();
        
        Employee highestPaid = getHighestPaidEmployee();
        Employee lowestPaid = getLowestPaidEmployee();
        
        if (highestPaid != null) {
            System.out.println("Highest Paid Employee: " + highestPaid.getFullName() + 
                             " ($" + highestPaid.getSalary() + ")");
        }
        
        if (lowestPaid != null) {
            System.out.println("Lowest Paid Employee: " + lowestPaid.getFullName() + 
                             " ($" + lowestPaid.getSalary() + ")");
        }
        
        System.out.println("\nEmployees by Position:");
        for (Position position : Position.values()) {
            List<Employee> employeesInPosition = getEmployeesByPosition(position);
            if (!employeesInPosition.isEmpty()) {
                System.out.println("  " + position + ": " + employeesInPosition.size() + " employees");
            }
        }
        
        System.out.println("==========================================\n");
    }
    
    // Getters and setters
    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    
    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
    
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
    
    public List<Employee> getEmployees() { return new ArrayList<>(employees); }
}
