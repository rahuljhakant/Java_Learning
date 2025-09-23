package com.tutorial.projects.intermediate;

import java.time.LocalDate;

/**
 * Book class representing a book in the library
 */
public class Book {
    private String id;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private int totalCopies;
    private int availableCopies;
    
    public Book(String id, String title, String author, String isbn, String category, int totalCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }
    
    // Getters
    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getCategory() {
        return category;
    }
    
    public int getTotalCopies() {
        return totalCopies;
    }
    
    public int getAvailableCopies() {
        return availableCopies;
    }
    
    // Methods
    public void borrowCopy() {
        if (availableCopies > 0) {
            availableCopies--;
        }
    }
    
    public void returnCopy() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }
    
    public void addCopies(int copies) {
        this.totalCopies += copies;
        this.availableCopies += copies;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %s | Title: %s | Author: %s | ISBN: %s | Category: %s | Available: %d/%d",
                id, title, author, isbn, category, availableCopies, totalCopies);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return id.equals(book.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
