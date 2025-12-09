package com.tutorial.advanced;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 * Hibernate Basics - Object-Relational Mapping (ORM)
 * 
 * This comprehensive tutorial demonstrates Hibernate ORM framework,
 * including entity mapping, relationships, queries, and Hibernate features.
 * 
 * LEARNING OBJECTIVES:
 * - Understand Hibernate ORM concepts
 * - Map Java objects to database tables
 * - Implement entity relationships
 * - Use Hibernate queries and criteria
 * - Apply Hibernate best practices
 * - Build data-driven applications
 * 
 * KEY CONCEPTS:
 * 1. Entity Mapping: @Entity, @Table, @Column
 * 2. Relationships: @OneToMany, @ManyToOne, @ManyToMany
 * 3. Queries: HQL, Criteria API, Native SQL
 * 4. Session Management: Session, SessionFactory
 * 5. Lazy Loading: Performance optimization
 * 6. Best Practices: Efficient ORM usage
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class HibernateBasics {
    
    public static void main(String[] args) {
        System.out.println("=== Hibernate Basics Demo ===");
        System.out.println();
        
        // 1. Entity Mapping
        demonstrateEntityMapping();
        
        // 2. Relationships
        demonstrateRelationships();
        
        // 3. Queries
        demonstrateQueries();
        
        // 4. Session Management
        demonstrateSessionManagement();
        
        // 5. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates entity mapping
     */
    private static void demonstrateEntityMapping() {
        System.out.println("1. Entity Mapping:");
        System.out.println("=================");
        
        System.out.println("Entity Mapping Annotations:");
        System.out.println("• @Entity: Marks class as JPA entity");
        System.out.println("• @Table: Specifies table name");
        System.out.println("• @Id: Marks primary key field");
        System.out.println("• @GeneratedValue: Auto-generates primary key");
        System.out.println("• @Column: Maps field to column");
        System.out.println("• @Temporal: Maps date/time fields");
        System.out.println("• @Enumerated: Maps enum fields");
        
        System.out.println();
    }
    
    /**
     * Demonstrates relationships
     */
    private static void demonstrateRelationships() {
        System.out.println("2. Relationships:");
        System.out.println("================");
        
        System.out.println("Relationship Types:");
        System.out.println("• @OneToOne: One-to-one relationship");
        System.out.println("• @OneToMany: One-to-many relationship");
        System.out.println("• @ManyToOne: Many-to-one relationship");
        System.out.println("• @ManyToMany: Many-to-many relationship");
        System.out.println("• @JoinColumn: Specifies join column");
        System.out.println("• @JoinTable: Specifies join table");
        
        System.out.println();
    }
    
    /**
     * Demonstrates queries
     */
    private static void demonstrateQueries() {
        System.out.println("3. Queries:");
        System.out.println("==========");
        
        System.out.println("Query Types:");
        System.out.println("• HQL (Hibernate Query Language)");
        System.out.println("• Criteria API");
        System.out.println("• Native SQL");
        System.out.println("• Named Queries");
        System.out.println("• JPQL (Java Persistence Query Language)");
        
        System.out.println();
    }
    
    /**
     * Demonstrates session management
     */
    private static void demonstrateSessionManagement() {
        System.out.println("4. Session Management:");
        System.out.println("=====================");
        
        System.out.println("Session Management Concepts:");
        System.out.println("• Session: Hibernate session for database operations");
        System.out.println("• SessionFactory: Factory for creating sessions");
        System.out.println("• Transaction: Database transaction management");
        System.out.println("• Lazy Loading: Load data on demand");
        System.out.println("• Eager Loading: Load all data immediately");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("5. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use appropriate fetch strategies");
        System.out.println("✓ Implement proper transaction management");
        System.out.println("✓ Use connection pooling");
        System.out.println("✓ Optimize queries and avoid N+1 problems");
        System.out.println("✓ Use appropriate cascade types");
        System.out.println("✓ Implement proper exception handling");
        System.out.println("✓ Use second-level caching when appropriate");
        System.out.println("✓ Monitor and tune performance");
        System.out.println("✓ Use batch operations for bulk updates");
        System.out.println("✓ Implement proper logging and debugging");
        
        System.out.println();
    }
}

/**
 * Student Entity
 */
@Entity
@Table(name = "students")
class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @Column(name = "age")
    private Integer age;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "grade")
    private Grade grade;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollments = new ArrayList<>();
    
    // Constructors
    public Student() {}
    
    public Student(String firstName, String lastName, String email, Integer age, Grade grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.grade = grade;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    
    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public List<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(List<Enrollment> enrollments) { this.enrollments = enrollments; }
    
    @Override
    public String toString() {
        return "Student{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + 
               "', email='" + email + "', age=" + age + ", grade=" + grade + "}";
    }
}

/**
 * Course Entity
 */
@Entity
@Table(name = "courses")
class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "course_name", nullable = false, length = 100)
    private String courseName;
    
    @Column(name = "description", length = 500)
    private String description;
    
    @Column(name = "credits")
    private Integer credits;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "department")
    private Department department;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollments = new ArrayList<>();
    
    // Constructors
    public Course() {}
    
    public Course(String courseName, String description, Integer credits, Department department) {
        this.courseName = courseName;
        this.description = description;
        this.credits = credits;
        this.department = department;
    }
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Integer getCredits() { return credits; }
    public void setCredits(Integer credits) { this.credits = credits; }
    
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
    
    public List<Enrollment> getEnrollments() { return enrollments; }
    public void setEnrollments(List<Enrollment> enrollments) { this.enrollments = enrollments; }
    
    @Override
    public String toString() {
        return "Course{id=" + id + ", courseName='" + courseName + "', description='" + description + 
               "', credits=" + credits + ", department=" + department + "}";
    }
}

/**
 * Enrollment Entity (Many-to-Many with additional fields)
 */
@Entity
@Table(name = "enrollments")
class Enrollment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    
    @Column(name = "enrollment_date")
    private LocalDateTime enrollmentDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EnrollmentStatus status;
    
    @Column(name = "grade")
    private String grade;
    
    // Constructors
    public Enrollment() {}
    
    public Enrollment(Student student, Course course, EnrollmentStatus status) {
        this.student = student;
        this.course = course;
        this.status = status;
        this.enrollmentDate = LocalDateTime.now();
    }
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    
    public LocalDateTime getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDateTime enrollmentDate) { this.enrollmentDate = enrollmentDate; }
    
    public EnrollmentStatus getStatus() { return status; }
    public void setStatus(EnrollmentStatus status) { this.status = status; }
    
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    
    @Override
    public String toString() {
        return "Enrollment{id=" + id + ", student=" + student.getFirstName() + " " + student.getLastName() + 
               ", course=" + course.getCourseName() + ", status=" + status + ", grade='" + grade + "'}";
    }
}

/**
 * Grade Enumeration
 */
enum Grade {
    FRESHMAN, SOPHOMORE, JUNIOR, SENIOR, GRADUATE
}

/**
 * Department Enumeration
 */
enum Department {
    COMPUTER_SCIENCE, MATHEMATICS, PHYSICS, CHEMISTRY, BIOLOGY, ENGLISH, HISTORY
}

/**
 * Enrollment Status Enumeration
 */
enum EnrollmentStatus {
    ENROLLED, COMPLETED, DROPPED, FAILED
}

/**
 * Hibernate Configuration Example
 */
class HibernateConfig {
    
    /*
    # hibernate.cfg.xml
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
    
    <hibernate-configuration>
        <session-factory>
            <!-- Database connection settings -->
            <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
            <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/javatutorial</property>
            <property name="hibernate.connection.username">root</property>
            <property name="hibernate.connection.password">password</property>
            
            <!-- SQL dialect -->
            <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
            
            <!-- Echo all executed SQL to stdout -->
            <property name="hibernate.show_sql">true</property>
            <property name="hibernate.format_sql">true</property>
            
            <!-- Drop and re-create the database schema on startup -->
            <property name="hibernate.hbm2ddl.auto">update</property>
            
            <!-- Connection pool settings -->
            <property name="hibernate.connection.pool_size">10</property>
            <property name="hibernate.connection.autocommit">false</property>
            
            <!-- Caching -->
            <property name="hibernate.cache.use_second_level_cache">true</property>
            <property name="hibernate.cache.use_query_cache">true</property>
            <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
            
            <!-- Entity mappings -->
            <mapping class="com.tutorial.advanced.frameworks.Student"/>
            <mapping class="com.tutorial.advanced.frameworks.Course"/>
            <mapping class="com.tutorial.advanced.frameworks.Enrollment"/>
        </session-factory>
    </hibernate-configuration>
    */
}
