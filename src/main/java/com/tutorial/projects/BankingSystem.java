package com.tutorial.projects;

import java.util.*;

/**
 * Banking System - Main Application
 * 
 * This class demonstrates a simple banking system with account management,
 * including creating accounts, performing transactions, and managing multiple accounts.
 * 
 * LEARNING OBJECTIVES:
 * - Implement a complete banking system
 * - Manage multiple accounts using collections
 * - Handle user input and menu-driven interface
 * - Apply object-oriented programming principles
 * - Build a real-world application
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class BankingSystem {
    private Map<String, Account> accounts;
    private Scanner scanner;
    
    public BankingSystem() {
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.run();
    }
    
    /**
     * Main application loop
     */
    public void run() {
        System.out.println("=== Welcome to Simple Banking System ===");
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    transfer();
                    break;
                case 6:
                    displayAllAccounts();
                    break;
                case 7:
                    running = false;
                    System.out.println("Thank you for using our banking system!");
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
    private void displayMenu() {
        System.out.println("\n=== Banking System Menu ===");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Transfer Money");
        System.out.println("6. Display All Accounts");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
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
    
    /**
     * Create a new account
     */
    private void createAccount() {
        System.out.println("\n=== Create New Account ===");
        
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account number already exists!");
            return;
        }
        
        System.out.print("Enter account holder name: ");
        scanner.nextLine(); // Consume newline
        String accountHolderName = scanner.nextLine();
        
        System.out.print("Enter initial balance: $");
        double initialBalance = scanner.nextDouble();
        
        System.out.print("Enter account type (Savings/Checking): ");
        String accountType = scanner.next();
        
        Account account = new Account(accountNumber, accountHolderName, initialBalance, accountType);
        accounts.put(accountNumber, account);
        
        System.out.println("Account created successfully!");
        account.displayAccountInfo();
    }
    
    /**
     * Deposit money into an account
     */
    private void deposit() {
        System.out.println("\n=== Deposit Money ===");
        
        Account account = getAccount();
        if (account == null) return;
        
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        
        account.deposit(amount);
    }
    
    /**
     * Withdraw money from an account
     */
    private void withdraw() {
        System.out.println("\n=== Withdraw Money ===");
        
        Account account = getAccount();
        if (account == null) return;
        
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        
        account.withdraw(amount);
    }
    
    /**
     * Check account balance
     */
    private void checkBalance() {
        System.out.println("\n=== Check Balance ===");
        
        Account account = getAccount();
        if (account == null) return;
        
        account.displayAccountInfo();
    }
    
    /**
     * Transfer money between accounts
     */
    private void transfer() {
        System.out.println("\n=== Transfer Money ===");
        
        System.out.println("From Account:");
        Account fromAccount = getAccount();
        if (fromAccount == null) return;
        
        System.out.println("To Account:");
        Account toAccount = getAccount();
        if (toAccount == null) return;
        
        if (fromAccount.getAccountNumber().equals(toAccount.getAccountNumber())) {
            System.out.println("Cannot transfer to the same account!");
            return;
        }
        
        System.out.print("Enter amount to transfer: $");
        double amount = scanner.nextDouble();
        
        fromAccount.transfer(toAccount, amount);
    }
    
    /**
     * Display all accounts
     */
    private void displayAllAccounts() {
        System.out.println("\n=== All Accounts ===");
        
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        
        for (Account account : accounts.values()) {
            account.displayAccountInfo();
        }
    }
    
    /**
     * Get account by account number
     */
    private Account getAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
        }
        
        return account;
    }
}
