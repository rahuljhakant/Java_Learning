package com.tutorial.projects;

/**
 * Account Class - Banking System
 * 
 * This class represents a bank account with basic operations
 * including deposit, withdrawal, and balance inquiry.
 * 
 * LEARNING OBJECTIVES:
 * - Implement encapsulation with private fields
 * - Create methods for account operations
 * - Handle account validation and error checking
 * - Apply object-oriented programming principles
 * - Build a complete banking system
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    
    /**
     * Constructor to create a new account
     */
    public Account(String accountNumber, String accountHolderName, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.accountType = accountType;
    }
    
    /**
     * Deposit money into the account
     */
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
            return true;
        } else {
            System.out.println("Invalid deposit amount. Amount must be positive.");
            return false;
        }
    }
    
    /**
     * Withdraw money from the account
     */
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
            return true;
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Amount must be positive.");
            return false;
        } else {
            System.out.println("Insufficient funds. Current balance: $" + balance);
            return false;
        }
    }
    
    /**
     * Get current balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Get account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    
    /**
     * Get account holder name
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    /**
     * Get account type
     */
    public String getAccountType() {
        return accountType;
    }
    
    /**
     * Display account information
     */
    public void displayAccountInfo() {
        System.out.println("\n=== Account Information ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: $" + balance);
        System.out.println("========================\n");
    }
    
    /**
     * Transfer money to another account
     */
    public boolean transfer(Account recipientAccount, double amount) {
        if (withdraw(amount)) {
            if (recipientAccount.deposit(amount)) {
                System.out.println("Transfer successful.");
                return true;
            } else {
                // If deposit fails, refund the amount
                deposit(amount);
                System.out.println("Transfer failed. Amount refunded.");
                return false;
            }
        }
        return false;
    }
}
