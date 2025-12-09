package com.tutorial.projects;

import java.util.*;

/**
 * Employee Manager - Main Application
 * 
 * This class demonstrates a comprehensive employee management system
 * with department management, employee operations, and reporting features.
 * 
 * LEARNING OBJECTIVES:
 * - Implement a complete employee management system
 * - Use collections and data structures effectively
 * - Handle complex business logic and operations
 * - Apply object-oriented design patterns
 * - Build a real-world enterprise application
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class EmployeeManager {
    private Map<Integer, Employee> employees;
    private Map<String, Department> departments;
    private Scanner scanner;
    private int nextEmployeeId;
    
    public EmployeeManager() {
        employees = new HashMap<>();
        departments = new HashMap<>();
        scanner = new Scanner(System.in);
        nextEmployeeId = 1;
        initializeDepartments();
    }
    
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.run();
    }
    
    /**
     * Initialize default departments
     */
    private void initializeDepartments() {
        departments.put("HR", new Department("Human Resources", "John Smith", 500000));
        departments.put("IT", new Department("Information Technology", "Jane Doe", 1000000));
        departments.put("FINANCE", new Department("Finance", "Bob Johnson", 750000));
        departments.put("MARKETING", new Department("Marketing", "Alice Brown", 600000));
    }
    
    /**
     * Main application loop
     */
    public void run() {
        System.out.println("=== Welcome to Employee Management System ===");
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    manageEmployees();
                    break;
                case 2:
                    manageDepartments();
                    break;
                case 3:
                    generateReports();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using Employee Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Display main menu
     */
    private void displayMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Manage Employees");
        System.out.println("2. Manage Departments");
        System.out.println("3. Generate Reports");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    
    /**
     * Employee management menu
     */
    private void manageEmployees() {
        boolean inEmployeeMenu = true;
        while (inEmployeeMenu) {
            System.out.println("\n=== Employee Management ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. View Employee");
            System.out.println("5. List All Employees");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    viewEmployee();
                    break;
                case 5:
                    listAllEmployees();
                    break;
                case 6:
                    inEmployeeMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Department management menu
     */
    private void manageDepartments() {
        boolean inDepartmentMenu = true;
        while (inDepartmentMenu) {
            System.out.println("\n=== Department Management ===");
            System.out.println("1. View Department");
            System.out.println("2. List All Departments");
            System.out.println("3. Transfer Employee");
            System.out.println("4. Department Statistics");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = getChoice();
            switch (choice) {
                case 1:
                    viewDepartment();
                    break;
                case 2:
                    listAllDepartments();
                    break;
                case 3:
                    transferEmployee();
                    break;
                case 4:
                    departmentStatistics();
                    break;
                case 5:
                    inDepartmentMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Reports menu
     */
    private void generateReports() {
        boolean inReportsMenu = true;
        while (inReportsMenu) {
            System.out.println("\n=== Reports ===");
            System.out.println("1. Employee Report");
            System.out.println("2. Department Report");
            System.out.println("3. Salary Report");
            System.out.println("4. Company Overview");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = getChoice();
            switch (choice) {
                case 1:
                    generateEmployeeReport();
                    break;
                case 2:
                    generateDepartmentReport();
                    break;
                case 3:
                    generateSalaryReport();
                    break;
                case 4:
                    generateCompanyOverview();
                    break;
                case 5:
                    inReportsMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Add new employee
     */
    private void addEmployee() {
        System.out.println("\n=== Add New Employee ===");
        
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        
        System.out.print("Enter email: ");
        String email = scanner.next();
        
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.next();
        
        System.out.println("Available departments:");
        departments.keySet().forEach(System.out::println);
        System.out.print("Enter department: ");
        String deptKey = scanner.next().toUpperCase();
        
        if (!departments.containsKey(deptKey)) {
            System.out.println("Invalid department!");
            return;
        }
        
        System.out.println("Available positions:");
        Arrays.stream(Position.values()).forEach(System.out::println);
        System.out.print("Enter position: ");
        String positionStr = scanner.next().toUpperCase();
        
        try {
            Position position = Position.valueOf(positionStr);
            
            System.out.print("Enter salary: $");
            double salary = scanner.nextDouble();
            
            System.out.print("Enter hire date (YYYY-MM-DD): ");
            String hireDate = scanner.next();
            
            Employee employee = new Employee(nextEmployeeId++, firstName, lastName, email, 
                                           phoneNumber, Department.valueOf(deptKey), position, 
                                           salary, hireDate);
            
            employees.put(employee.getEmployeeId(), employee);
            departments.get(deptKey).addEmployee(employee);
            
            System.out.println("Employee added successfully!");
            employee.displayInfo();
            
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid position!");
        }
    }
    
    /**
     * Remove employee
     */
    private void removeEmployee() {
        System.out.println("\n=== Remove Employee ===");
        
        Employee employee = getEmployeeById();
        if (employee == null) return;
        
        departments.get(employee.getDepartment().name()).removeEmployee(employee);
        employees.remove(employee.getEmployeeId());
        
        System.out.println("Employee removed successfully!");
    }
    
    /**
     * Update employee
     */
    private void updateEmployee() {
        System.out.println("\n=== Update Employee ===");
        
        Employee employee = getEmployeeById();
        if (employee == null) return;
        
        System.out.println("1. Update Salary");
        System.out.println("2. Transfer Department");
        System.out.println("3. Promote Employee");
        System.out.println("4. Deactivate/Activate Employee");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        switch (choice) {
            case 1:
                System.out.print("Enter new salary: $");
                double newSalary = scanner.nextDouble();
                employee.updateSalary(newSalary);
                break;
            case 2:
                System.out.println("Available departments:");
                departments.keySet().forEach(System.out::println);
                System.out.print("Enter new department: ");
                String newDept = scanner.next().toUpperCase();
                if (departments.containsKey(newDept)) {
                    departments.get(employee.getDepartment().name()).removeEmployee(employee);
                    employee.transferDepartment(Department.valueOf(newDept));
                    departments.get(newDept).addEmployee(employee);
                } else {
                    System.out.println("Invalid department!");
                }
                break;
            case 3:
                System.out.println("Available positions:");
                Arrays.stream(Position.values()).forEach(System.out::println);
                System.out.print("Enter new position: ");
                String newPosition = scanner.next().toUpperCase();
                try {
                    employee.promote(Position.valueOf(newPosition));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid position!");
                }
                break;
            case 4:
                if (employee.isActive()) {
                    employee.deactivate();
                } else {
                    employee.activate();
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    /**
     * View employee details
     */
    private void viewEmployee() {
        System.out.println("\n=== View Employee ===");
        
        Employee employee = getEmployeeById();
        if (employee == null) return;
        
        employee.displayInfo();
    }
    
    /**
     * List all employees
     */
    private void listAllEmployees() {
        System.out.println("\n=== All Employees ===");
        
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        
        employees.values().forEach(System.out::println);
    }
    
    /**
     * View department details
     */
    private void viewDepartment() {
        System.out.println("\n=== View Department ===");
        
        Department department = getDepartment();
        if (department == null) return;
        
        department.displayDepartmentInfo();
        department.displayAllEmployees();
    }
    
    /**
     * List all departments
     */
    private void listAllDepartments() {
        System.out.println("\n=== All Departments ===");
        
        departments.values().forEach(Department::displayDepartmentInfo);
    }
    
    /**
     * Transfer employee between departments
     */
    private void transferEmployee() {
        System.out.println("\n=== Transfer Employee ===");
        
        Employee employee = getEmployeeById();
        if (employee == null) return;
        
        System.out.println("Available departments:");
        departments.keySet().forEach(System.out::println);
        System.out.print("Enter new department: ");
        String newDept = scanner.next().toUpperCase();
        
        if (departments.containsKey(newDept)) {
            departments.get(employee.getDepartment().name()).removeEmployee(employee);
            employee.transferDepartment(Department.valueOf(newDept));
            departments.get(newDept).addEmployee(employee);
        } else {
            System.out.println("Invalid department!");
        }
    }
    
    /**
     * Department statistics
     */
    private void departmentStatistics() {
        System.out.println("\n=== Department Statistics ===");
        
        Department department = getDepartment();
        if (department == null) return;
        
        department.generateReport();
    }
    
    /**
     * Generate employee report
     */
    private void generateEmployeeReport() {
        System.out.println("\n=== Employee Report ===");
        
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        
        long activeCount = employees.values().stream().filter(Employee::isActive).count();
        double totalSalary = employees.values().stream()
                .filter(Employee::isActive)
                .mapToDouble(Employee::getSalary)
                .sum();
        double averageSalary = activeCount > 0 ? totalSalary / activeCount : 0;
        
        System.out.println("Total Employees: " + employees.size());
        System.out.println("Active Employees: " + activeCount);
        System.out.println("Total Salary Cost: $" + String.format("%.2f", totalSalary));
        System.out.println("Average Salary: $" + String.format("%.2f", averageSalary));
    }
    
    /**
     * Generate department report
     */
    private void generateDepartmentReport() {
        System.out.println("\n=== Department Report ===");
        
        departments.values().forEach(Department::generateReport);
    }
    
    /**
     * Generate salary report
     */
    private void generateSalaryReport() {
        System.out.println("\n=== Salary Report ===");
        
        List<Employee> sortedEmployees = new ArrayList<>(employees.values());
        sortedEmployees.sort(Comparator.comparing(Employee::getSalary).reversed());
        
        System.out.println("Top 5 Highest Paid Employees:");
        sortedEmployees.stream().limit(5).forEach(emp -> 
            System.out.println(emp.getFullName() + ": $" + emp.getSalary()));
        
        System.out.println("\nBottom 5 Lowest Paid Employees:");
        sortedEmployees.stream().skip(Math.max(0, sortedEmployees.size() - 5))
                .forEach(emp -> System.out.println(emp.getFullName() + ": $" + emp.getSalary()));
    }
    
    /**
     * Generate company overview
     */
    private void generateCompanyOverview() {
        System.out.println("\n=== Company Overview ===");
        
        System.out.println("Total Employees: " + employees.size());
        System.out.println("Total Departments: " + departments.size());
        
        double totalBudget = departments.values().stream().mapToDouble(Department::getBudget).sum();
        System.out.println("Total Budget: $" + String.format("%.2f", totalBudget));
        
        double totalSalary = employees.values().stream()
                .filter(Employee::isActive)
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total Salary Cost: $" + String.format("%.2f", totalSalary));
        
        System.out.println("\nDepartment Breakdown:");
        departments.values().forEach(dept -> {
            System.out.println(dept.getDepartmentName() + ": " + 
                             dept.getTotalEmployees() + " employees, $" + 
                             String.format("%.2f", dept.getTotalSalaryCost()) + " salary cost");
        });
    }
    
    /**
     * Get employee by ID
     */
    private Employee getEmployeeById() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        
        Employee employee = employees.get(id);
        if (employee == null) {
            System.out.println("Employee not found!");
        }
        
        return employee;
    }
    
    /**
     * Get department by name
     */
    private Department getDepartment() {
        System.out.println("Available departments:");
        departments.keySet().forEach(System.out::println);
        System.out.print("Enter department: ");
        String deptKey = scanner.next().toUpperCase();
        
        Department department = departments.get(deptKey);
        if (department == null) {
            System.out.println("Department not found!");
        }
        
        return department;
    }
    
    /**
     * Get user choice
     */
    private int getChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }
}
