package com.tutorial.testing.bestpractices;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Best Practices - Quality Testing Strategies
 * 
 * This comprehensive tutorial demonstrates best practices for writing
 * effective, maintainable, and reliable tests in Java. Learn how to
 * structure tests, apply proper testing patterns, and implement
 * comprehensive testing strategies.
 * 
 * LEARNING OBJECTIVES:
 * - Apply the AAA (Arrange, Act, Assert) pattern
 * - Write clear and descriptive test names
 * - Organize tests for maintainability
 * - Use proper test isolation techniques
 * - Implement effective mocking strategies
 * - Manage test data and fixtures
 * - Apply testing best practices in real scenarios
 * 
 * KEY CONCEPTS:
 * 1. AAA Pattern: Arrange, Act, Assert structure
 * 2. Test Naming: Clear and descriptive test names
 * 3. Test Isolation: Independent and isolated tests
 * 4. Test Organization: Logical grouping and structure
 * 5. Mocking Strategy: When and how to use mocks
 * 6. Test Data Management: Managing test data effectively
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
@DisplayName("Testing Best Practices Demo")
public class TestingBestPractices {
    
    private UserService userService;
    private EmailService emailService;
    private UserRepository userRepository;
    
    @BeforeEach
    void setUp() {
        // Arrange: Set up test dependencies
        userRepository = new MockUserRepository();
        emailService = new MockEmailService();
        userService = new UserService(userRepository, emailService);
    }
    
    @Nested
    @DisplayName("User Creation Tests")
    class UserCreationTests {
        
        @Test
        @DisplayName("Should create user successfully when valid data provided")
        void should_CreateUser_When_ValidDataProvided() {
            // Arrange
            String username = "john.doe";
            String email = "john@example.com";
            User expectedUser = new User(username, email);
            
            // Act
            User actualUser = userService.createUser(username, email);
            
            // Assert
            assertNotNull(actualUser, "User should be created");
            assertEquals(expectedUser.getUsername(), actualUser.getUsername(), 
                "Username should match");
            assertEquals(expectedUser.getEmail(), actualUser.getEmail(), 
                "Email should match");
            assertTrue(actualUser.getId() > 0, "User should have valid ID");
        }
        
        @Test
        @DisplayName("Should throw exception when username is null")
        void should_ThrowException_When_UsernameIsNull() {
            // Arrange
            String username = null;
            String email = "john@example.com";
            
            // Act & Assert
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.createUser(username, email),
                "Should throw IllegalArgumentException for null username"
            );
            
            assertEquals("Username cannot be null or empty", exception.getMessage(),
                "Exception message should be descriptive");
        }
        
        @Test
        @DisplayName("Should throw exception when email is invalid")
        void should_ThrowException_When_EmailIsInvalid() {
            // Arrange
            String username = "john.doe";
            String email = "invalid-email";
            
            // Act & Assert
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.createUser(username, email),
                "Should throw IllegalArgumentException for invalid email"
            );
            
            assertEquals("Invalid email format", exception.getMessage(),
                "Exception message should be descriptive");
        }
    }
    
    @Nested
    @DisplayName("User Retrieval Tests")
    class UserRetrievalTests {
        
        @Test
        @DisplayName("Should return user when valid ID provided")
        void should_ReturnUser_When_ValidIdProvided() {
            // Arrange
            User existingUser = userService.createUser("jane.doe", "jane@example.com");
            Long userId = existingUser.getId();
            
            // Act
            User retrievedUser = userService.getUserById(userId);
            
            // Assert
            assertNotNull(retrievedUser, "User should be retrieved");
            assertEquals(existingUser.getId(), retrievedUser.getId(), 
                "User ID should match");
            assertEquals(existingUser.getUsername(), retrievedUser.getUsername(), 
                "Username should match");
        }
        
        @Test
        @DisplayName("Should return null when user not found")
        void should_ReturnNull_When_UserNotFound() {
            // Arrange
            Long nonExistentId = 999L;
            
            // Act
            User retrievedUser = userService.getUserById(nonExistentId);
            
            // Assert
            assertNull(retrievedUser, "Should return null for non-existent user");
        }
    }
    
    @Nested
    @DisplayName("User Update Tests")
    class UserUpdateTests {
        
        @Test
        @DisplayName("Should update user successfully when valid data provided")
        void should_UpdateUser_When_ValidDataProvided() {
            // Arrange
            User user = userService.createUser("original.user", "original@example.com");
            String newEmail = "updated@example.com";
            
            // Act
            User updatedUser = userService.updateUserEmail(user.getId(), newEmail);
            
            // Assert
            assertNotNull(updatedUser, "Updated user should not be null");
            assertEquals(newEmail, updatedUser.getEmail(), 
                "Email should be updated");
            assertEquals(user.getUsername(), updatedUser.getUsername(), 
                "Username should remain unchanged");
        }
        
        @Test
        @DisplayName("Should throw exception when updating non-existent user")
        void should_ThrowException_When_UpdatingNonExistentUser() {
            // Arrange
            Long nonExistentId = 999L;
            String newEmail = "updated@example.com";
            
            // Act & Assert
            assertThrows(
                UserNotFoundException.class,
                () -> userService.updateUserEmail(nonExistentId, newEmail),
                "Should throw UserNotFoundException for non-existent user"
            );
        }
    }
    
    @Nested
    @DisplayName("Email Service Integration Tests")
    class EmailServiceIntegrationTests {
        
        @Test
        @DisplayName("Should send welcome email when user is created")
        void should_SendWelcomeEmail_When_UserCreated() {
            // Arrange
            String username = "new.user";
            String email = "new@example.com";
            
            // Act
            User user = userService.createUser(username, email);
            
            // Assert
            assertTrue(((MockEmailService) emailService).wasEmailSent(),
                "Welcome email should be sent");
            assertEquals(email, ((MockEmailService) emailService).getLastEmailAddress(),
                "Email should be sent to correct address");
        }
        
        @Test
        @DisplayName("Should handle email service failure gracefully")
        void should_HandleEmailServiceFailure_Gracefully() {
            // Arrange
            ((MockEmailService) emailService).setShouldFail(true);
            String username = "test.user";
            String email = "test@example.com";
            
            // Act
            User user = userService.createUser(username, email);
            
            // Assert
            assertNotNull(user, "User should still be created despite email failure");
            assertFalse(((MockEmailService) emailService).wasEmailSent(),
                "Email should not be sent when service fails");
        }
    }
    
    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesAndBoundaryTests {
        
        @Test
        @DisplayName("Should handle empty string username")
        void should_HandleEmptyStringUsername() {
            // Arrange
            String username = "";
            String email = "test@example.com";
            
            // Act & Assert
            assertThrows(
                IllegalArgumentException.class,
                () -> userService.createUser(username, email),
                "Should throw exception for empty username"
            );
        }
        
        @Test
        @DisplayName("Should handle whitespace-only username")
        void should_HandleWhitespaceOnlyUsername() {
            // Arrange
            String username = "   ";
            String email = "test@example.com";
            
            // Act & Assert
            assertThrows(
                IllegalArgumentException.class,
                () -> userService.createUser(username, email),
                "Should throw exception for whitespace-only username"
            );
        }
        
        @Test
        @DisplayName("Should handle maximum length username")
        void should_HandleMaximumLengthUsername() {
            // Arrange
            String username = "a".repeat(50); // 50 character username
            String email = "test@example.com";
            
            // Act
            User user = userService.createUser(username, email);
            
            // Assert
            assertNotNull(user, "User should be created with maximum length username");
            assertEquals(username, user.getUsername(), 
                "Username should match exactly");
        }
    }
    
    /**
     * User class for testing
     */
    public static class User {
        private Long id;
        private String username;
        private String email;
        
        public User(String username, String email) {
            this.username = username;
            this.email = email;
        }
        
        // Getters and setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }
    
    /**
     * UserService class for testing
     */
    public static class UserService {
        private final UserRepository userRepository;
        private final EmailService emailService;
        
        public UserService(UserRepository userRepository, EmailService emailService) {
            this.userRepository = userRepository;
            this.emailService = emailService;
        }
        
        public User createUser(String username, String email) {
            validateUserData(username, email);
            
            User user = new User(username, email);
            user.setId(System.currentTimeMillis());
            
            userRepository.save(user);
            
            try {
                emailService.sendWelcomeEmail(email);
            } catch (EmailServiceException e) {
                // Log error but don't fail user creation
                System.err.println("Failed to send welcome email: " + e.getMessage());
            }
            
            return user;
        }
        
        public User getUserById(Long id) {
            return userRepository.findById(id);
        }
        
        public User updateUserEmail(Long id, String newEmail) {
            validateEmail(newEmail);
            
            User user = userRepository.findById(id);
            if (user == null) {
                throw new UserNotFoundException("User not found with ID: " + id);
            }
            
            user.setEmail(newEmail);
            userRepository.save(user);
            
            return user;
        }
        
        private void validateUserData(String username, String email) {
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("Username cannot be null or empty");
            }
            validateEmail(email);
        }
        
        private void validateEmail(String email) {
            if (email == null || !email.contains("@") || !email.contains(".")) {
                throw new IllegalArgumentException("Invalid email format");
            }
        }
    }
    
    /**
     * UserRepository interface
     */
    public interface UserRepository {
        void save(User user);
        User findById(Long id);
    }
    
    /**
     * EmailService interface
     */
    public interface EmailService {
        void sendWelcomeEmail(String email) throws EmailServiceException;
    }
    
    /**
     * Mock UserRepository implementation
     */
    public static class MockUserRepository implements UserRepository {
        private final java.util.Map<Long, User> users = new java.util.HashMap<>();
        
        @Override
        public void save(User user) {
            users.put(user.getId(), user);
        }
        
        @Override
        public User findById(Long id) {
            return users.get(id);
        }
    }
    
    /**
     * Mock EmailService implementation
     */
    public static class MockEmailService implements EmailService {
        private boolean emailSent = false;
        private String lastEmailAddress;
        private boolean shouldFail = false;
        
        @Override
        public void sendWelcomeEmail(String email) throws EmailServiceException {
            if (shouldFail) {
                throw new EmailServiceException("Email service unavailable");
            }
            
            this.emailSent = true;
            this.lastEmailAddress = email;
        }
        
        public boolean wasEmailSent() {
            return emailSent;
        }
        
        public String getLastEmailAddress() {
            return lastEmailAddress;
        }
        
        public void setShouldFail(boolean shouldFail) {
            this.shouldFail = shouldFail;
        }
    }
    
    /**
     * Custom exceptions
     */
    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
    
    public static class EmailServiceException extends Exception {
        public EmailServiceException(String message) {
            super(message);
        }
    }
}
