package com.tutorial.projects;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Library Management System
 * 
 * This project demonstrates:
 * - Object-oriented programming concepts
 * - Collections Framework usage
 * - Exception handling
 * - File I/O operations
 * - Date and time handling
 * - Search and filtering operations
 */
public class Library {
    
    private String name;
    private Map<String, Book> books;
    private Map<String, Member> members;
    private List<Transaction> transactions;
    private int nextBookId;
    private int nextMemberId;
    private int nextTransactionId;
    
    public Library(String name) {
        this.name = name;
        this.books = new HashMap<>();
        this.members = new HashMap<>();
        this.transactions = new ArrayList<>();
        this.nextBookId = 1;
        this.nextMemberId = 1;
        this.nextTransactionId = 1;
        
        // Add some sample data
        initializeSampleData();
    }
    
    /**
     * Initializes the library with sample data
     */
    private void initializeSampleData() {
        // Add sample books
        addBook("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Fiction", 5);
        addBook("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 3);
        addBook("1984", "George Orwell", "9780451524935", "Fiction", 4);
        addBook("Pride and Prejudice", "Jane Austen", "9780141439518", "Fiction", 2);
        addBook("The Catcher in the Rye", "J.D. Salinger", "9780316769174", "Fiction", 3);
        addBook("Java: The Complete Reference", "Herbert Schildt", "9781260440232", "Programming", 2);
        addBook("Clean Code", "Robert C. Martin", "9780132350884", "Programming", 1);
        addBook("Design Patterns", "Gang of Four", "9780201633610", "Programming", 1);
        
        // Add sample members
        addMember("John Doe", "john.doe@email.com", "123-456-7890");
        addMember("Jane Smith", "jane.smith@email.com", "098-765-4321");
        addMember("Bob Johnson", "bob.johnson@email.com", "555-123-4567");
    }
    
    /**
     * Adds a new book to the library
     */
    public String addBook(String title, String author, String isbn, String category, int copies) {
        try {
            // Check if book already exists
            for (Book book : books.values()) {
                if (book.getIsbn().equals(isbn)) {
                    book.addCopies(copies);
                    return "Added " + copies + " copies to existing book: " + title;
                }
            }
            
            // Create new book
            String bookId = "B" + String.format("%04d", nextBookId++);
            Book book = new Book(bookId, title, author, isbn, category, copies);
            books.put(bookId, book);
            
            return "Book added successfully with ID: " + bookId;
        } catch (Exception e) {
            return "Error adding book: " + e.getMessage();
        }
    }
    
    /**
     * Adds a new member to the library
     */
    public String addMember(String name, String email, String phone) {
        try {
            // Check if member already exists
            for (Member member : members.values()) {
                if (member.getEmail().equals(email)) {
                    return "Member with this email already exists";
                }
            }
            
            String memberId = "M" + String.format("%04d", nextMemberId++);
            Member member = new Member(memberId, name, email, phone);
            members.put(memberId, member);
            
            return "Member added successfully with ID: " + memberId;
        } catch (Exception e) {
            return "Error adding member: " + e.getMessage();
        }
    }
    
    /**
     * Issues a book to a member
     */
    public String issueBook(String bookId, String memberId) {
        try {
            Book book = books.get(bookId);
            Member member = members.get(memberId);
            
            if (book == null) {
                return "Book not found with ID: " + bookId;
            }
            
            if (member == null) {
                return "Member not found with ID: " + memberId;
            }
            
            if (book.getAvailableCopies() <= 0) {
                return "No copies available for book: " + book.getTitle();
            }
            
            if (member.getBorrowedBooks().size() >= 5) {
                return "Member has reached maximum borrowing limit (5 books)";
            }
            
            // Check if member already has this book
            if (member.getBorrowedBooks().containsKey(bookId)) {
                return "Member already has this book borrowed";
            }
            
            // Issue the book
            book.borrowCopy();
            LocalDate dueDate = LocalDate.now().plusDays(14); // 14 days loan period
            member.borrowBook(bookId, dueDate);
            
            // Create transaction record
            String transactionId = "T" + String.format("%04d", nextTransactionId++);
            Transaction transaction = new Transaction(transactionId, bookId, memberId, 
                LocalDate.now(), dueDate, "ISSUED");
            transactions.add(transaction);
            
            return "Book issued successfully. Due date: " + dueDate;
        } catch (Exception e) {
            return "Error issuing book: " + e.getMessage();
        }
    }
    
    /**
     * Returns a book from a member
     */
    public String returnBook(String bookId, String memberId) {
        try {
            Book book = books.get(bookId);
            Member member = members.get(memberId);
            
            if (book == null) {
                return "Book not found with ID: " + bookId;
            }
            
            if (member == null) {
                return "Member not found with ID: " + memberId;
            }
            
            if (!member.getBorrowedBooks().containsKey(bookId)) {
                return "Member does not have this book borrowed";
            }
            
            // Return the book
            book.returnCopy();
            LocalDate dueDate = member.getBorrowedBooks().get(bookId);
            member.returnBook(bookId);
            
            // Create transaction record
            String transactionId = "T" + String.format("%04d", nextTransactionId++);
            Transaction transaction = new Transaction(transactionId, bookId, memberId, 
                LocalDate.now(), dueDate, "RETURNED");
            transactions.add(transaction);
            
            // Check for overdue
            if (LocalDate.now().isAfter(dueDate)) {
                long daysOverdue = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
                double fine = daysOverdue * 0.50; // $0.50 per day
                return "Book returned successfully. Overdue by " + daysOverdue + 
                       " days. Fine: $" + String.format("%.2f", fine);
            }
            
            return "Book returned successfully";
        } catch (Exception e) {
            return "Error returning book: " + e.getMessage();
        }
    }
    
    /**
     * Searches for books by title
     */
    public List<Book> searchBooksByTitle(String title) {
        List<Book> results = new ArrayList<>();
        String searchTitle = title.toLowerCase();
        
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(searchTitle)) {
                results.add(book);
            }
        }
        
        return results;
    }
    
    /**
     * Searches for books by author
     */
    public List<Book> searchBooksByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        String searchAuthor = author.toLowerCase();
        
        for (Book book : books.values()) {
            if (book.getAuthor().toLowerCase().contains(searchAuthor)) {
                results.add(book);
            }
        }
        
        return results;
    }
    
    /**
     * Searches for books by category
     */
    public List<Book> searchBooksByCategory(String category) {
        List<Book> results = new ArrayList<>();
        String searchCategory = category.toLowerCase();
        
        for (Book book : books.values()) {
            if (book.getCategory().toLowerCase().contains(searchCategory)) {
                results.add(book);
            }
        }
        
        return results;
    }
    
    /**
     * Gets all books
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
    
    /**
     * Gets all members
     */
    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }
    
    /**
     * Gets all transactions
     */
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
    
    /**
     * Gets overdue books
     */
    public List<Map<String, Object>> getOverdueBooks() {
        List<Map<String, Object>> overdueBooks = new ArrayList<>();
        LocalDate today = LocalDate.now();
        
        for (Member member : members.values()) {
            for (Map.Entry<String, LocalDate> entry : member.getBorrowedBooks().entrySet()) {
                String bookId = entry.getKey();
                LocalDate dueDate = entry.getValue();
                
                if (today.isAfter(dueDate)) {
                    Book book = books.get(bookId);
                    Map<String, Object> overdueInfo = new HashMap<>();
                    overdueInfo.put("book", book);
                    overdueInfo.put("member", member);
                    overdueInfo.put("dueDate", dueDate);
                    overdueInfo.put("daysOverdue", ChronoUnit.DAYS.between(dueDate, today));
                    overdueBooks.add(overdueInfo);
                }
            }
        }
        
        return overdueBooks;
    }
    
    /**
     * Gets library statistics
     */
    public Map<String, Object> getLibraryStatistics() {
        Map<String, Object> stats = new HashMap<>();
        
        int totalBooks = books.values().stream().mapToInt(Book::getTotalCopies).sum();
        int availableBooks = books.values().stream().mapToInt(Book::getAvailableCopies).sum();
        int borrowedBooks = totalBooks - availableBooks;
        int totalMembers = members.size();
        int activeMembers = (int) members.values().stream()
            .filter(member -> !member.getBorrowedBooks().isEmpty()).count();
        
        stats.put("totalBooks", totalBooks);
        stats.put("availableBooks", availableBooks);
        stats.put("borrowedBooks", borrowedBooks);
        stats.put("totalMembers", totalMembers);
        stats.put("activeMembers", activeMembers);
        stats.put("totalTransactions", transactions.size());
        
        return stats;
    }
    
    /**
     * Displays library menu and handles user interactions
     */
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\n=== " + name + " Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Books");
            System.out.println("6. View All Books");
            System.out.println("7. View All Members");
            System.out.println("8. View Transactions");
            System.out.println("9. View Overdue Books");
            System.out.println("10. Library Statistics");
            System.out.println("11. Exit");
            System.out.print("Enter your choice (1-11): ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        addBookMenu(scanner);
                        break;
                    case 2:
                        addMemberMenu(scanner);
                        break;
                    case 3:
                        issueBookMenu(scanner);
                        break;
                    case 4:
                        returnBookMenu(scanner);
                        break;
                    case 5:
                        searchBooksMenu(scanner);
                        break;
                    case 6:
                        displayAllBooks();
                        break;
                    case 7:
                        displayAllMembers();
                        break;
                    case 8:
                        displayAllTransactions();
                        break;
                    case 9:
                        displayOverdueBooks();
                        break;
                    case 10:
                        displayLibraryStatistics();
                        break;
                    case 11:
                        running = false;
                        System.out.println("Thank you for using the Library Management System!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    // Menu helper methods
    
    private void addBookMenu(Scanner scanner) {
        System.out.println("\n=== Add Book ===");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter number of copies: ");
        int copies = scanner.nextInt();
        scanner.nextLine();
        
        String result = addBook(title, author, isbn, category, copies);
        System.out.println(result);
    }
    
    private void addMemberMenu(Scanner scanner) {
        System.out.println("\n=== Add Member ===");
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        
        String result = addMember(name, email, phone);
        System.out.println(result);
    }
    
    private void issueBookMenu(Scanner scanner) {
        System.out.println("\n=== Issue Book ===");
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        
        String result = issueBook(bookId, memberId);
        System.out.println(result);
    }
    
    private void returnBookMenu(Scanner scanner) {
        System.out.println("\n=== Return Book ===");
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        
        String result = returnBook(bookId, memberId);
        System.out.println(result);
    }
    
    private void searchBooksMenu(Scanner scanner) {
        System.out.println("\n=== Search Books ===");
        System.out.println("1. Search by title");
        System.out.println("2. Search by author");
        System.out.println("3. Search by category");
        System.out.print("Enter your choice (1-3): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        List<Book> results;
        switch (choice) {
            case 1:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                results = searchBooksByTitle(title);
                break;
            case 2:
                System.out.print("Enter author: ");
                String author = scanner.nextLine();
                results = searchBooksByAuthor(author);
                break;
            case 3:
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                results = searchBooksByCategory(category);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("\nSearch Results:");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }
    
    private void displayAllBooks() {
        System.out.println("\n=== All Books ===");
        List<Book> allBooks = getAllBooks();
        if (allBooks.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : allBooks) {
                System.out.println(book);
            }
        }
    }
    
    private void displayAllMembers() {
        System.out.println("\n=== All Members ===");
        List<Member> allMembers = getAllMembers();
        if (allMembers.isEmpty()) {
            System.out.println("No members registered.");
        } else {
            for (Member member : allMembers) {
                System.out.println(member);
            }
        }
    }
    
    private void displayAllTransactions() {
        System.out.println("\n=== All Transactions ===");
        List<Transaction> allTransactions = getAllTransactions();
        if (allTransactions.isEmpty()) {
            System.out.println("No transactions recorded.");
        } else {
            for (Transaction transaction : allTransactions) {
                System.out.println(transaction);
            }
        }
    }
    
    private void displayOverdueBooks() {
        System.out.println("\n=== Overdue Books ===");
        List<Map<String, Object>> overdueBooks = getOverdueBooks();
        if (overdueBooks.isEmpty()) {
            System.out.println("No overdue books.");
        } else {
            for (Map<String, Object> overdueInfo : overdueBooks) {
                Book book = (Book) overdueInfo.get("book");
                Member member = (Member) overdueInfo.get("member");
                LocalDate dueDate = (LocalDate) overdueInfo.get("dueDate");
                long daysOverdue = (Long) overdueInfo.get("daysOverdue");
                
                System.out.println("Book: " + book.getTitle());
                System.out.println("Member: " + member.getName());
                System.out.println("Due Date: " + dueDate);
                System.out.println("Days Overdue: " + daysOverdue);
                System.out.println("Fine: $" + String.format("%.2f", daysOverdue * 0.50));
                System.out.println("---");
            }
        }
    }
    
    private void displayLibraryStatistics() {
        System.out.println("\n=== Library Statistics ===");
        Map<String, Object> stats = getLibraryStatistics();
        
        System.out.println("Total Books: " + stats.get("totalBooks"));
        System.out.println("Available Books: " + stats.get("availableBooks"));
        System.out.println("Borrowed Books: " + stats.get("borrowedBooks"));
        System.out.println("Total Members: " + stats.get("totalMembers"));
        System.out.println("Active Members: " + stats.get("activeMembers"));
        System.out.println("Total Transactions: " + stats.get("totalTransactions"));
    }
    
    public static void main(String[] args) {
        Library library = new Library("Central Library");
        library.displayMenu();
    }
}
