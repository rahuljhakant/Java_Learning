package com.tutorial.testing.coverage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Code Coverage Tools - Using JaCoCo and Coverage Analysis
 * 
 * This comprehensive tutorial demonstrates how to use code coverage tools
 * like JaCoCo to measure and analyze test coverage in Java applications.
 * Learn how to configure coverage tools, generate reports, and integrate
 * coverage analysis into your development workflow.
 * 
 * LEARNING OBJECTIVES:
 * - Configure and use JaCoCo for code coverage
 * - Generate and interpret coverage reports
 * - Set coverage goals and thresholds
 * - Integrate coverage with Maven and Gradle
 * - Use coverage in CI/CD pipelines
 * - Apply coverage best practices
 * 
 * KEY CONCEPTS:
 * 1. JaCoCo Configuration: Setting up coverage analysis
 * 2. Coverage Reports: HTML, XML, and CSV report generation
 * 3. Coverage Thresholds: Setting and enforcing coverage goals
 * 4. Build Integration: Maven and Gradle plugin configuration
 * 5. CI/CD Integration: Automated coverage reporting
 * 6. Coverage Analysis: Interpreting and acting on coverage data
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class CoverageTools {
    
    private BankAccount bankAccount;
    private TransactionService transactionService;
    
    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount("123456789", 1000.0);
        transactionService = new TransactionService();
    }
    
    /**
     * Test deposit functionality for coverage analysis
     */
    @Test
    void testDeposit() {
        // Test normal deposit
        double initialBalance = bankAccount.getBalance();
        double depositAmount = 500.0;
        
        bankAccount.deposit(depositAmount);
        
        assertEquals(initialBalance + depositAmount, bankAccount.getBalance(), 
            "Balance should increase by deposit amount");
        
        // Test deposit with zero amount
        double balanceBeforeZero = bankAccount.getBalance();
        bankAccount.deposit(0.0);
        assertEquals(balanceBeforeZero, bankAccount.getBalance(), 
            "Zero deposit should not change balance");
        
        // Test deposit with negative amount (should throw exception)
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(-100.0);
        }, "Negative deposit should throw exception");
    }
    
    /**
     * Test withdrawal functionality for coverage analysis
     */
    @Test
    void testWithdrawal() {
        // Test normal withdrawal
        double initialBalance = bankAccount.getBalance();
        double withdrawalAmount = 200.0;
        
        boolean success = bankAccount.withdraw(withdrawalAmount);
        
        assertTrue(success, "Withdrawal should succeed");
        assertEquals(initialBalance - withdrawalAmount, bankAccount.getBalance(), 
            "Balance should decrease by withdrawal amount");
        
        // Test withdrawal exceeding balance
        double largeAmount = bankAccount.getBalance() + 1000.0;
        boolean failure = bankAccount.withdraw(largeAmount);
        
        assertFalse(failure, "Withdrawal exceeding balance should fail");
        
        // Test withdrawal with zero amount
        double balanceBeforeZero = bankAccount.getBalance();
        boolean zeroWithdrawal = bankAccount.withdraw(0.0);
        
        assertTrue(zeroWithdrawal, "Zero withdrawal should succeed");
        assertEquals(balanceBeforeZero, bankAccount.getBalance(), 
            "Zero withdrawal should not change balance");
        
        // Test withdrawal with negative amount
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(-100.0);
        }, "Negative withdrawal should throw exception");
    }
    
    /**
     * Test transaction service for comprehensive coverage
     */
    @Test
    void testTransactionService() {
        // Test successful transaction
        Transaction transaction = new Transaction("TXN001", 100.0, "DEPOSIT");
        boolean success = transactionService.processTransaction(transaction);
        
        assertTrue(success, "Valid transaction should succeed");
        assertTrue(transactionService.getTransactionHistory().contains(transaction), 
            "Transaction should be added to history");
        
        // Test invalid transaction
        Transaction invalidTransaction = new Transaction("", -50.0, "WITHDRAWAL");
        boolean failure = transactionService.processTransaction(invalidTransaction);
        
        assertFalse(failure, "Invalid transaction should fail");
        
        // Test transaction with null ID
        Transaction nullIdTransaction = new Transaction(null, 100.0, "DEPOSIT");
        assertThrows(IllegalArgumentException.class, () -> {
            transactionService.processTransaction(nullIdTransaction);
        }, "Transaction with null ID should throw exception");
    }
    
    /**
     * Test account validation for branch coverage
     */
    @Test
    void testAccountValidation() {
        // Test valid account
        assertTrue(bankAccount.isValid(), "Valid account should pass validation");
        
        // Test account with zero balance
        BankAccount zeroBalanceAccount = new BankAccount("987654321", 0.0);
        assertTrue(zeroBalanceAccount.isValid(), "Zero balance account should be valid");
        
        // Test account with negative balance
        BankAccount negativeBalanceAccount = new BankAccount("111111111", -100.0);
        assertFalse(negativeBalanceAccount.isValid(), "Negative balance account should be invalid");
        
        // Test account with null account number
        BankAccount nullAccountNumber = new BankAccount(null, 1000.0);
        assertFalse(nullAccountNumber.isValid(), "Account with null number should be invalid");
        
        // Test account with empty account number
        BankAccount emptyAccountNumber = new BankAccount("", 1000.0);
        assertFalse(emptyAccountNumber.isValid(), "Account with empty number should be invalid");
    }
    
    /**
     * Test transaction history for method coverage
     */
    @Test
    void testTransactionHistory() {
        // Add multiple transactions
        Transaction t1 = new Transaction("TXN001", 100.0, "DEPOSIT");
        Transaction t2 = new Transaction("TXN002", 50.0, "WITHDRAWAL");
        Transaction t3 = new Transaction("TXN003", 200.0, "DEPOSIT");
        
        transactionService.processTransaction(t1);
        transactionService.processTransaction(t2);
        transactionService.processTransaction(t3);
        
        // Test history retrieval
        var history = transactionService.getTransactionHistory();
        assertEquals(3, history.size(), "History should contain 3 transactions");
        
        // Test history clearing
        transactionService.clearHistory();
        assertTrue(transactionService.getTransactionHistory().isEmpty(), 
            "History should be empty after clearing");
    }
    
    /**
     * Test edge cases for comprehensive coverage
     */
    @Test
    void testEdgeCases() {
        // Test account with maximum balance
        BankAccount maxBalanceAccount = new BankAccount("MAX001", Double.MAX_VALUE);
        assertTrue(maxBalanceAccount.isValid(), "Account with max balance should be valid");
        
        // Test account with minimum balance
        BankAccount minBalanceAccount = new BankAccount("MIN001", Double.MIN_VALUE);
        assertTrue(minBalanceAccount.isValid(), "Account with min balance should be valid");
        
        // Test transaction with maximum amount
        Transaction maxTransaction = new Transaction("MAX_TXN", Double.MAX_VALUE, "DEPOSIT");
        boolean maxSuccess = transactionService.processTransaction(maxTransaction);
        assertTrue(maxSuccess, "Transaction with max amount should succeed");
        
        // Test transaction with minimum amount
        Transaction minTransaction = new Transaction("MIN_TXN", Double.MIN_VALUE, "WITHDRAWAL");
        boolean minSuccess = transactionService.processTransaction(minTransaction);
        assertTrue(minSuccess, "Transaction with min amount should succeed");
    }
    
    /**
     * Test error handling for exception coverage
     */
    @Test
    void testErrorHandling() {
        // Test bank account with null account number
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(null, 1000.0);
        }, "Bank account with null number should throw exception");
        
        // Test transaction service with null transaction
        assertThrows(IllegalArgumentException.class, () -> {
            transactionService.processTransaction(null);
        }, "Processing null transaction should throw exception");
        
        // Test transaction with invalid type
        Transaction invalidTypeTransaction = new Transaction("TXN001", 100.0, "INVALID");
        assertThrows(IllegalArgumentException.class, () -> {
            transactionService.processTransaction(invalidTypeTransaction);
        }, "Transaction with invalid type should throw exception");
    }
    
    /**
     * BankAccount class for coverage testing
     */
    public static class BankAccount {
        private String accountNumber;
        private double balance;
        
        public BankAccount(String accountNumber, double initialBalance) {
            if (accountNumber == null || accountNumber.trim().isEmpty()) {
                throw new IllegalArgumentException("Account number cannot be null or empty");
            }
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }
        
        public void deposit(double amount) {
            if (amount < 0) {
                throw new IllegalArgumentException("Deposit amount cannot be negative");
            }
            this.balance += amount;
        }
        
        public boolean withdraw(double amount) {
            if (amount < 0) {
                throw new IllegalArgumentException("Withdrawal amount cannot be negative");
            }
            if (amount > this.balance) {
                return false;
            }
            this.balance -= amount;
            return true;
        }
        
        public double getBalance() {
            return balance;
        }
        
        public String getAccountNumber() {
            return accountNumber;
        }
        
        public boolean isValid() {
            return accountNumber != null && 
                   !accountNumber.trim().isEmpty() && 
                   balance >= 0;
        }
    }
    
    /**
     * Transaction class for coverage testing
     */
    public static class Transaction {
        private String transactionId;
        private double amount;
        private String type;
        
        public Transaction(String transactionId, double amount, String type) {
            if (transactionId == null || transactionId.trim().isEmpty()) {
                throw new IllegalArgumentException("Transaction ID cannot be null or empty");
            }
            if (type == null || (!type.equals("DEPOSIT") && !type.equals("WITHDRAWAL"))) {
                throw new IllegalArgumentException("Transaction type must be DEPOSIT or WITHDRAWAL");
            }
            this.transactionId = transactionId;
            this.amount = amount;
            this.type = type;
        }
        
        // Getters
        public String getTransactionId() { return transactionId; }
        public double getAmount() { return amount; }
        public String getType() { return type; }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Transaction that = (Transaction) obj;
            return Double.compare(that.amount, amount) == 0 &&
                   transactionId.equals(that.transactionId) &&
                   type.equals(that.type);
        }
        
        @Override
        public int hashCode() {
            return java.util.Objects.hash(transactionId, amount, type);
        }
    }
    
    /**
     * TransactionService class for coverage testing
     */
    public static class TransactionService {
        private java.util.List<Transaction> transactionHistory = new java.util.ArrayList<>();
        
        public boolean processTransaction(Transaction transaction) {
            if (transaction == null) {
                throw new IllegalArgumentException("Transaction cannot be null");
            }
            if (transaction.getTransactionId() == null || transaction.getTransactionId().trim().isEmpty()) {
                return false;
            }
            if (transaction.getAmount() < 0) {
                return false;
            }
            
            transactionHistory.add(transaction);
            return true;
        }
        
        public java.util.List<Transaction> getTransactionHistory() {
            return new java.util.ArrayList<>(transactionHistory);
        }
        
        public void clearHistory() {
            transactionHistory.clear();
        }
    }
}
