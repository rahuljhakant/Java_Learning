package com.tutorial.advanced.frameworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.*;

/**
 * Spring Boot Basics - Enterprise Application Framework
 * 
 * This comprehensive tutorial demonstrates Spring Boot framework,
 * including dependency injection, REST controllers, services,
 * and Spring Boot features.
 * 
 * LEARNING OBJECTIVES:
 * - Understand Spring Boot concepts
 * - Implement dependency injection
 * - Create REST controllers and services
 * - Use Spring Boot annotations
 * - Apply Spring Boot best practices
 * - Build enterprise applications
 * 
 * KEY CONCEPTS:
 * 1. Dependency Injection: @Autowired, @Component, @Service
 * 2. REST Controllers: @RestController, @RequestMapping
 * 3. Configuration: @Configuration, @Bean
 * 4. Application Properties: Configuration management
 * 5. Auto-configuration: Spring Boot magic
 * 6. Best Practices: Enterprise application patterns
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
@SpringBootApplication
public class SpringBootBasics {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootBasics.class, args);
    }
}

/**
 * REST Controller for User Management
 */
@RestController
@RequestMapping("/api/users")
class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

/**
 * Service Layer for User Operations
 */
@Service
class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
    
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

/**
 * Repository Interface for User Data Access
 */
interface UserRepository {
    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
}

/**
 * In-Memory User Repository Implementation
 */
@Component
class InMemoryUserRepository implements UserRepository {
    
    private Map<Long, User> users = new HashMap<>();
    private Long nextId = 1L;
    
    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
    
    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }
    
    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(nextId++);
        }
        users.put(user.getId(), user);
        return user;
    }
    
    @Override
    public void deleteById(Long id) {
        users.remove(id);
    }
}

/**
 * User Entity Class
 */
class User {
    private Long id;
    private String name;
    private String email;
    
    public User() {}
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}

/**
 * Custom Exception for User Not Found
 */
class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}

/**
 * Configuration Class
 */
@Configuration
class AppConfig {
    
    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }
}

/**
 * Product Controller for E-commerce Example
 */
@RestController
@RequestMapping("/api/products")
class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }
}

/**
 * Product Service
 */
@Service
class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }
    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
}

/**
 * Product Repository Interface
 */
interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    List<Product> findByCategory(String category);
}

/**
 * In-Memory Product Repository
 */
@Component
class InMemoryProductRepository implements ProductRepository {
    
    private Map<Long, Product> products = new HashMap<>();
    private Long nextId = 1L;
    
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }
    
    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }
    
    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(nextId++);
        }
        products.put(product.getId(), product);
        return product;
    }
    
    @Override
    public List<Product> findByCategory(String category) {
        return products.values().stream()
                .filter(product -> category.equals(product.getCategory()))
                .toList();
    }
}

/**
 * Product Entity Class
 */
class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    
    public Product() {}
    
    public Product(String name, String description, double price, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', description='" + description + 
               "', price=" + price + ", category='" + category + "'}";
    }
}

/**
 * Custom Exception for Product Not Found
 */
class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

/**
 * Application Properties Example
 */
class ApplicationProperties {
    
    /*
    # application.properties
    server.port=8080
    spring.application.name=java-tutorial-spring-boot
    
    # Database Configuration
    spring.datasource.url=jdbc:mysql://localhost:3306/javatutorial
    spring.datasource.username=root
    spring.datasource.password=password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    
    # JPA Configuration
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    
    # Logging Configuration
    logging.level.com.tutorial.advanced.frameworks=DEBUG
    logging.level.org.springframework.web=DEBUG
    
    # Custom Properties
    app.name=Java Tutorial Spring Boot
    app.version=1.0.0
    app.description=Comprehensive Java Tutorial with Spring Boot
    */
}
