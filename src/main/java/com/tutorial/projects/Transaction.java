package com.tutorial.projects;

import java.time.LocalDate;

/**
 * Transaction class representing a book transaction (issue/return)
 */
public class Transaction {
    private String id;
    private String bookId;
    private String memberId;
    private LocalDate transactionDate;
    private LocalDate dueDate;
    private String type; // "ISSUED" or "RETURNED"
    
    public Transaction(String id, String bookId, String memberId, LocalDate transactionDate, 
                      LocalDate dueDate, String type) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.transactionDate = transactionDate;
        this.dueDate = dueDate;
        this.type = type;
    }
    
    // Getters
    public String getId() {
        return id;
    }
    
    public String getBookId() {
        return bookId;
    }
    
    public String getMemberId() {
        return memberId;
    }
    
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }
    
    public String getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %s | Book: %s | Member: %s | Date: %s | Due: %s | Type: %s",
                id, bookId, memberId, transactionDate, dueDate, type);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Transaction that = (Transaction) obj;
        return id.equals(that.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
