package com.tutorial.projects;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Member class representing a library member
 */
public class Member {
    private String id;
    private String name;
    private String email;
    private String phone;
    private Map<String, LocalDate> borrowedBooks; // bookId -> dueDate
    
    public Member(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.borrowedBooks = new HashMap<>();
    }
    
    // Getters
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public Map<String, LocalDate> getBorrowedBooks() {
        return new HashMap<>(borrowedBooks);
    }
    
    // Methods
    public void borrowBook(String bookId, LocalDate dueDate) {
        borrowedBooks.put(bookId, dueDate);
    }
    
    public void returnBook(String bookId) {
        borrowedBooks.remove(bookId);
    }
    
    public boolean hasBook(String bookId) {
        return borrowedBooks.containsKey(bookId);
    }
    
    public int getBorrowedBookCount() {
        return borrowedBooks.size();
    }
    
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Email: %s | Phone: %s | Borrowed Books: %d",
                id, name, email, phone, borrowedBooks.size());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Member member = (Member) obj;
        return id.equals(member.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
