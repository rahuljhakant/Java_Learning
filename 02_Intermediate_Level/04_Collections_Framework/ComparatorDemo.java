package com.tutorial.intermediate.collections;

/**
 * Comparator Demo - Mastering Custom Ordering in Java
 * 
 * This comprehensive tutorial demonstrates the Comparator interface in Java,
 * which provides a way to define custom ordering for objects. Unlike Comparable,
 * Comparator allows multiple ways to sort the same objects and can be used
 * with classes that don't implement Comparable.
 * 
 * LEARNING OBJECTIVES:
 * - Understand what Comparator is and how it differs from Comparable
 * - Learn how to implement the Comparator interface
 * - Master the compare() method and its return values
 * - Practice with real-world examples of Comparator
 * - Learn about lambda expressions with Comparator
 * - Understand chaining and composition of comparators
 * - Learn best practices for implementing Comparator
 * 
 * KEY CONCEPTS:
 * 1. Comparator Interface: Defines custom ordering of objects
 * 2. compare() Method: Core method for comparison
 * 3. Multiple Orderings: Different ways to sort the same objects
 * 4. Lambda Expressions: Modern way to create comparators
 * 5. Method References: Using existing methods as comparators
 * 6. Chaining: Combining multiple comparators
 * 7. Null Handling: Dealing with null values in comparisons
 * 8. Performance: Considerations for comparator performance
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class ComparatorDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Comparator Demo ===");
        System.out.println();
        
        // 1. Basic Comparator Implementation
        demonstrateBasicComparator();
        
        // 2. Comparator vs Comparable
        demonstrateComparatorVsComparable();
        
        // 3. Lambda Expressions with Comparator
        demonstrateLambdaExpressions();
        
        // 4. Method References with Comparator
        demonstrateMethodReferences();
        
        // 5. Chaining Comparators
        demonstrateChainingComparators();
        
        // 6. Null Handling
        demonstrateNullHandling();
        
        // 7. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 8. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic Comparator implementation
     */
    private static void demonstrateBasicComparator() {
        System.out.println("1. Basic Comparator Implementation:");
        System.out.println("=================================");
        
        // Basic string comparator
        System.out.println("Basic String Comparator:");
        System.out.println("----------------------");
        
        java.util.List<String> words = new java.util.ArrayList<>();
        words.add("zebra");
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("date");
        
        System.out.println("Original words: " + words);
        
        // Sort using natural ordering (Comparable)
        java.util.Collections.sort(words);
        System.out.println("Natural ordering: " + words);
        
        // Sort using custom comparator (reverse order)
        java.util.Collections.sort(words, new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1); // Reverse order
            }
        });
        System.out.println("Reverse ordering: " + words);
        
        // Sort by length
        java.util.Collections.sort(words, new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println("By length: " + words);
        
        System.out.println();
    }
    
    /**
     * Demonstrates Comparator vs Comparable
     */
    private static void demonstrateComparatorVsComparable() {
        System.out.println("2. Comparator vs Comparable:");
        System.out.println("===========================");
        
        java.util.List<Person> people = new java.util.ArrayList<>();
        people.add(new Person("Alice", 25, "Engineering"));
        people.add(new Person("Bob", 30, "Marketing"));
        people.add(new Person("Charlie", 20, "Engineering"));
        people.add(new Person("Diana", 35, "Sales"));
        people.add(new Person("Eve", 28, "Engineering"));
        
        System.out.println("Original people:");
        for (Person person : people) {
            System.out.println("  " + person);
        }
        
        // Sort using Comparable (natural ordering by age)
        System.out.println("\nSorting using Comparable (by age):");
        java.util.Collections.sort(people);
        for (Person person : people) {
            System.out.println("  " + person);
        }
        
        // Sort using Comparator (by name)
        System.out.println("\nSorting using Comparator (by name):");
        java.util.Collections.sort(people, new java.util.Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
        for (Person person : people) {
            System.out.println("  " + person);
        }
        
        // Sort using Comparator (by department)
        System.out.println("\nSorting using Comparator (by department):");
        java.util.Collections.sort(people, new java.util.Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getDepartment().compareTo(p2.getDepartment());
            }
        });
        for (Person person : people) {
            System.out.println("  " + person);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates lambda expressions with Comparator
     */
    private static void demonstrateLambdaExpressions() {
        System.out.println("3. Lambda Expressions with Comparator:");
        System.out.println("====================================");
        
        java.util.List<Student> students = new java.util.ArrayList<>();
        students.add(new Student("Alice", 85.5, "Computer Science"));
        students.add(new Student("Bob", 92.0, "Mathematics"));
        students.add(new Student("Charlie", 78.5, "Physics"));
        students.add(new Student("Diana", 95.5, "Computer Science"));
        students.add(new Student("Eve", 88.0, "Mathematics"));
        
        System.out.println("Original students:");
        for (Student student : students) {
            System.out.println("  " + student);
        }
        
        // Sort by name using lambda
        System.out.println("\nSorting by name using lambda:");
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        for (Student student : students) {
            System.out.println("  " + student);
        }
        
        // Sort by grade using lambda
        System.out.println("\nSorting by grade using lambda:");
        students.sort((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade())); // Descending
        for (Student student : students) {
            System.out.println("  " + student);
        }
        
        // Sort by major using lambda
        System.out.println("\nSorting by major using lambda:");
        students.sort((s1, s2) -> s1.getMajor().compareTo(s2.getMajor()));
        for (Student student : students) {
            System.out.println("  " + student);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates method references with Comparator
     */
    private static void demonstrateMethodReferences() {
        System.out.println("4. Method References with Comparator:");
        System.out.println("===================================");
        
        java.util.List<String> words = new java.util.ArrayList<>();
        words.add("zebra");
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("date");
        
        System.out.println("Original words: " + words);
        
        // Sort using method reference
        System.out.println("\nSorting using method reference:");
        words.sort(String::compareTo);
        System.out.println("Natural ordering: " + words);
        
        // Sort by length using method reference
        System.out.println("\nSorting by length using method reference:");
        words.sort(java.util.Comparator.comparing(String::length));
        System.out.println("By length: " + words);
        
        // Sort by length then by natural order
        System.out.println("\nSorting by length then by natural order:");
        words.sort(java.util.Comparator.comparing(String::length).thenComparing(String::compareTo));
        System.out.println("By length then natural: " + words);
        
        System.out.println();
    }
    
    /**
     * Demonstrates chaining comparators
     */
    private static void demonstrateChainingComparators() {
        System.out.println("5. Chaining Comparators:");
        System.out.println("=======================");
        
        java.util.List<Employee> employees = new java.util.ArrayList<>();
        employees.add(new Employee("Alice", "Engineering", 75000, 5));
        employees.add(new Employee("Bob", "Marketing", 65000, 3));
        employees.add(new Employee("Charlie", "Engineering", 80000, 2));
        employees.add(new Employee("Diana", "Sales", 70000, 8));
        employees.add(new Employee("Eve", "Engineering", 75000, 4));
        
        System.out.println("Original employees:");
        for (Employee emp : employees) {
            System.out.println("  " + emp);
        }
        
        // Sort by department, then by salary
        System.out.println("\nSorting by department, then by salary:");
        employees.sort(java.util.Comparator.comparing(Employee::getDepartment)
                                          .thenComparing(Employee::getSalary));
        for (Employee emp : employees) {
            System.out.println("  " + emp);
        }
        
        // Sort by department, then by experience (descending)
        System.out.println("\nSorting by department, then by experience (descending):");
        employees.sort(java.util.Comparator.comparing(Employee::getDepartment)
                                          .thenComparing(java.util.Comparator.comparing(Employee::getExperience).reversed()));
        for (Employee emp : employees) {
            System.out.println("  " + emp);
        }
        
        // Sort by salary (descending), then by name
        System.out.println("\nSorting by salary (descending), then by name:");
        employees.sort(java.util.Comparator.comparing(Employee::getSalary).reversed()
                                          .thenComparing(Employee::getName));
        for (Employee emp : employees) {
            System.out.println("  " + emp);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates null handling in comparators
     */
    private static void demonstrateNullHandling() {
        System.out.println("6. Null Handling:");
        System.out.println("================");
        
        java.util.List<String> wordsWithNulls = new java.util.ArrayList<>();
        wordsWithNulls.add("apple");
        wordsWithNulls.add(null);
        wordsWithNulls.add("banana");
        wordsWithNulls.add(null);
        wordsWithNulls.add("cherry");
        
        System.out.println("Original words with nulls: " + wordsWithNulls);
        
        // Sort with nulls first
        System.out.println("\nSorting with nulls first:");
        wordsWithNulls.sort(java.util.Comparator.nullsFirst(String::compareTo));
        System.out.println("Nulls first: " + wordsWithNulls);
        
        // Sort with nulls last
        System.out.println("\nSorting with nulls last:");
        wordsWithNulls.sort(java.util.Comparator.nullsLast(String::compareTo));
        System.out.println("Nulls last: " + wordsWithNulls);
        
        // Custom null handling
        System.out.println("\nCustom null handling:");
        wordsWithNulls.sort((s1, s2) -> {
            if (s1 == null && s2 == null) return 0;
            if (s1 == null) return 1;
            if (s2 == null) return -1;
            return s1.compareTo(s2);
        });
        System.out.println("Custom null handling: " + wordsWithNulls);
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("7. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: Sorting products by multiple criteria
        System.out.println("Example 1: Sorting Products by Multiple Criteria");
        System.out.println("-----------------------------------------------");
        
        java.util.List<Product> products = new java.util.ArrayList<>();
        products.add(new Product("Laptop", 999.99, 4.5));
        products.add(new Product("Mouse", 29.99, 4.2));
        products.add(new Product("Keyboard", 79.99, 4.8));
        products.add(new Product("Monitor", 299.99, 4.3));
        products.add(new Product("Headphones", 149.99, 4.6));
        
        System.out.println("Original products:");
        for (Product product : products) {
            System.out.println("  " + product);
        }
        
        // Sort by rating (descending), then by price
        System.out.println("\nSorting by rating (descending), then by price:");
        products.sort(java.util.Comparator.comparing(Product::getRating).reversed()
                                         .thenComparing(Product::getPrice));
        for (Product product : products) {
            System.out.println("  " + product);
        }
        
        // Example 2: Sorting books by title length, then alphabetically
        System.out.println("\nExample 2: Sorting Books by Title Length, then Alphabetically");
        System.out.println("------------------------------------------------------------");
        
        java.util.List<Book> books = new java.util.ArrayList<>();
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951));
        
        System.out.println("Original books:");
        for (Book book : books) {
            System.out.println("  " + book);
        }
        
        // Sort by title length, then alphabetically
        System.out.println("\nSorting by title length, then alphabetically:");
        books.sort(java.util.Comparator.comparing((Book b) -> b.getTitle().length())
                                       .thenComparing(Book::getTitle));
        for (Book book : books) {
            System.out.println("  " + book);
        }
        
        // Example 3: Sorting dates by year, then by month
        System.out.println("\nExample 3: Sorting Dates by Year, then by Month");
        System.out.println("-----------------------------------------------");
        
        java.util.List<Date> dates = new java.util.ArrayList<>();
        dates.add(new Date(2024, 12, 25));
        dates.add(new Date(2024, 1, 1));
        dates.add(new Date(2023, 6, 15));
        dates.add(new Date(2024, 3, 10));
        dates.add(new Date(2023, 9, 5));
        
        System.out.println("Original dates:");
        for (Date date : dates) {
            System.out.println("  " + date);
        }
        
        // Sort by year, then by month
        System.out.println("\nSorting by year, then by month:");
        dates.sort(java.util.Comparator.comparing(Date::getYear)
                                       .thenComparing(Date::getMonth));
        for (Date date : dates) {
            System.out.println("  " + date);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices:");
        System.out.println("=================");
        
        System.out.println("Best Practices for Comparator:");
        System.out.println("----------------------------");
        System.out.println("1. Use lambda expressions for simple comparisons");
        System.out.println("2. Use method references when possible");
        System.out.println("3. Chain comparators for multiple criteria");
        System.out.println("4. Handle null values appropriately");
        System.out.println("5. Use existing utility methods");
        System.out.println("6. Consider performance implications");
        System.out.println("7. Make comparators consistent with equals");
        System.out.println("8. Document the ordering clearly");
        
        System.out.println("\nCommon Patterns:");
        System.out.println("---------------");
        System.out.println("• Natural ordering: Comparator.naturalOrder()");
        System.out.println("• Reverse ordering: Comparator.reverseOrder()");
        System.out.println("• Null handling: Comparator.nullsFirst() / nullsLast()");
        System.out.println("• Chaining: thenComparing()");
        System.out.println("• Method references: Class::method");
        
        System.out.println("\nPerformance Tips:");
        System.out.println("---------------");
        System.out.println("• Use primitive comparators when possible");
        System.out.println("• Avoid creating objects in compare() method");
        System.out.println("• Cache frequently used comparators");
        System.out.println("• Use efficient comparison algorithms");
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Comparator provides custom ordering for objects");
        System.out.println("• Allows multiple ways to sort the same objects");
        System.out.println("• Can be used with classes that don't implement Comparable");
        System.out.println("• Lambda expressions make comparators more concise");
        System.out.println("• Method references provide clean, readable code");
        System.out.println("• Chaining allows complex sorting criteria");
        System.out.println("• Null handling is important for robust code");
        System.out.println("• Use existing utility methods when possible");
    }
    
    // Inner classes for demonstration
    
    static class Person implements Comparable<Person> {
        private String name;
        private int age;
        private String department;
        
        public Person(String name, int age, String department) {
            this.name = name;
            this.age = age;
            this.department = department;
        }
        
        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getDepartment() { return department; }
        
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + ", department='" + department + "'}";
        }
    }
    
    static class Student {
        private String name;
        private double grade;
        private String major;
        
        public Student(String name, double grade, String major) {
            this.name = name;
            this.grade = grade;
            this.major = major;
        }
        
        public String getName() { return name; }
        public double getGrade() { return grade; }
        public String getMajor() { return major; }
        
        @Override
        public String toString() {
            return "Student{name='" + name + "', grade=" + grade + ", major='" + major + "'}";
        }
    }
    
    static class Employee {
        private String name;
        private String department;
        private double salary;
        private int experience;
        
        public Employee(String name, String department, double salary, int experience) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.experience = experience;
        }
        
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }
        public int getExperience() { return experience; }
        
        @Override
        public String toString() {
            return "Employee{name='" + name + "', department='" + department + 
                   "', salary=" + salary + ", experience=" + experience + "}";
        }
    }
    
    static class Product {
        private String name;
        private double price;
        private double rating;
        
        public Product(String name, double price, double rating) {
            this.name = name;
            this.price = price;
            this.rating = rating;
        }
        
        public String getName() { return name; }
        public double getPrice() { return price; }
        public double getRating() { return rating; }
        
        @Override
        public String toString() {
            return "Product{name='" + name + "', price=" + price + ", rating=" + rating + "}";
        }
    }
    
    static class Book {
        private String title;
        private String author;
        private int year;
        
        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }
        
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public int getYear() { return year; }
        
        @Override
        public String toString() {
            return "Book{title='" + title + "', author='" + author + "', year=" + year + "}";
        }
    }
    
    static class Date {
        private int year;
        private int month;
        private int day;
        
        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        
        public int getYear() { return year; }
        public int getMonth() { return month; }
        public int getDay() { return day; }
        
        @Override
        public String toString() {
            return String.format("%04d-%02d-%02d", year, month, day);
        }
    }
}
