/**
 * Mockito Framework - Comprehensive Mocking Tutorial
 * 
 * This comprehensive tutorial demonstrates Mockito, the popular mocking framework
 * for Java unit testing. Mockito allows you to create mock objects, stub methods,
 * and verify interactions, making it easier to write isolated unit tests.
 * 
 * LEARNING OBJECTIVES:
 * - Understand mocking concepts and benefits
 * - Learn how to create and configure mocks
 * - Master method stubbing and return values
 * - Understand verification and interaction testing
 * - Learn argument matchers and advanced features
 * - Practice spy objects and partial mocking
 * - Understand best practices for mocking
 * 
 * KEY CONCEPTS:
 * 1. Mock Objects: Simulated objects for testing
 * 2. Stubbing: Defining mock behavior and return values
 * 3. Verification: Checking method calls and interactions
 * 4. Argument Matchers: Flexible parameter matching
 * 5. Spy Objects: Partial mocking of real objects
 * 6. Argument Captors: Capturing method arguments
 * 7. Mock Annotations: @Mock, @Spy, @InjectMocks
 * 8. Best Practices: When and how to use mocks effectively
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.InjectMocks;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Mockito Basics Demo - Main demonstration class
 * 
 * This class demonstrates various Mockito features including mock creation,
 * stubbing, verification, and advanced mocking techniques.
 */
public class MockitoBasics {
    
    // Mock annotations
    @Mock
    private UserService userService;
    
    @Mock
    private EmailService emailService;
    
    @Spy
    private List<String> spyList;
    
    @InjectMocks
    private UserController userController;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        spyList = new ArrayList<>();
    }
    
    /**
     * Demonstrates Mockito introduction and basic concepts
     */
    @Test
    @DisplayName("Mockito Introduction and Basic Concepts")
    void demonstrateMockitoIntroduction() {
        System.out.println("=== Mockito Introduction ===");
        
        System.out.println("Mockito Benefits:");
        System.out.println("✓ Create mock objects easily");
        System.out.println("✓ Stub method behavior");
        System.out.println("✓ Verify method interactions");
        System.out.println("✓ Reduce test dependencies");
        System.out.println("✓ Improve test isolation");
        System.out.println("✓ Faster test execution");
        
        System.out.println("\nMaven Dependency:");
        System.out.println("<dependency>");
        System.out.println("    <groupId>org.mockito</groupId>");
        System.out.println("    <artifactId>mockito-core</artifactId>");
        System.out.println("    <version>4.11.0</version>");
        System.out.println("    <scope>test</scope>");
        System.out.println("</dependency>");
        
        System.out.println("\nKey Concepts:");
        System.out.println("• Mock: Simulated object with defined behavior");
        System.out.println("• Stub: Define what methods return");
        System.out.println("• Verify: Check if methods were called");
        System.out.println("• Spy: Partial mock of real object");
    }
    
    /**
     * Demonstrates basic mock creation and stubbing
     */
    @Test
    @DisplayName("Basic Mock Creation and Stubbing")
    void demonstrateBasicMockCreation() {
        System.out.println("=== Basic Mock Creation ===");
        
        // Create mock using annotation
        System.out.println("Mock created with @Mock annotation");
        
        // Stub method behavior
        when(userService.getUserById(1L)).thenReturn(new User(1L, "John Doe", "john@example.com"));
        when(userService.getUserById(2L)).thenReturn(new User(2L, "Jane Smith", "jane@example.com"));
        when(userService.getUserById(999L)).thenReturn(null);
        
        // Test the stubbed behavior
        User user1 = userService.getUserById(1L);
        assertNotNull(user1);
        assertEquals("John Doe", user1.getName());
        assertEquals("john@example.com", user1.getEmail());
        
        User user2 = userService.getUserById(2L);
        assertNotNull(user2);
        assertEquals("Jane Smith", user2.getName());
        
        User user999 = userService.getUserById(999L);
        assertNull(user999);
        
        System.out.println("Mock stubbing and behavior verification successful");
    }
    
    /**
     * Demonstrates exception stubbing
     */
    @Test
    @DisplayName("Exception Stubbing")
    void demonstrateExceptionStubbing() {
        System.out.println("=== Exception Stubbing ===");
        
        // Stub method to throw exception
        when(userService.getUserById(-1L)).thenThrow(new IllegalArgumentException("Invalid user ID"));
        
        // Test exception handling
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getUserById(-1L);
        });
        
        // Stub void method to throw exception
        doThrow(new RuntimeException("Email service unavailable"))
            .when(emailService).sendEmail(anyString(), anyString());
        
        assertThrows(RuntimeException.class, () -> {
            emailService.sendEmail("test@example.com", "Test message");
        });
        
        System.out.println("Exception stubbing successful");
    }
    
    /**
     * Demonstrates method verification
     */
    @Test
    @DisplayName("Method Verification")
    void demonstrateMethodVerification() {
        System.out.println("=== Method Verification ===");
        
        // Stub method behavior
        when(userService.getUserById(1L)).thenReturn(new User(1L, "John Doe", "john@example.com"));
        
        // Call the method
        User user = userService.getUserById(1L);
        assertNotNull(user);
        
        // Verify method was called
        verify(userService).getUserById(1L);
        
        // Verify method was called exactly once
        verify(userService, times(1)).getUserById(1L);
        
        // Verify method was never called with different parameter
        verify(userService, never()).getUserById(2L);
        
        // Verify no more interactions
        verifyNoMoreInteractions(userService);
        
        System.out.println("Method verification successful");
    }
    
    /**
     * Demonstrates argument matchers
     */
    @Test
    @DisplayName("Argument Matchers")
    void demonstrateArgumentMatchers() {
        System.out.println("=== Argument Matchers ===");
        
        // Stub with argument matchers
        when(userService.getUserById(anyLong())).thenReturn(new User(1L, "Any User", "any@example.com"));
        when(userService.getUserByName(anyString())).thenReturn(new User(2L, "Name User", "name@example.com"));
        when(userService.getUserByEmail(contains("@example.com"))).thenReturn(new User(3L, "Email User", "email@example.com"));
        
        // Test with various arguments
        User user1 = userService.getUserById(100L);
        assertNotNull(user1);
        assertEquals("Any User", user1.getName());
        
        User user2 = userService.getUserByName("Test User");
        assertNotNull(user2);
        assertEquals("Name User", user2.getName());
        
        User user3 = userService.getUserByEmail("test@example.com");
        assertNotNull(user3);
        assertEquals("Email User", user3.getName());
        
        // Verify with argument matchers
        verify(userService).getUserById(anyLong());
        verify(userService).getUserByName(anyString());
        verify(userService).getUserByEmail(contains("@example.com"));
        
        System.out.println("Argument matchers demonstration successful");
    }
    
    /**
     * Demonstrates spy objects
     */
    @Test
    @DisplayName("Spy Objects")
    void demonstrateSpyObjects() {
        System.out.println("=== Spy Objects ===");
        
        // Create spy list
        List<String> spyList = spy(new ArrayList<>());
        
        // Add some elements
        spyList.add("element1");
        spyList.add("element2");
        
        // Stub size method
        when(spyList.size()).thenReturn(100);
        
        // Test spy behavior
        assertEquals(100, spyList.size()); // Stubbed behavior
        assertEquals("element1", spyList.get(0)); // Real behavior
        assertEquals("element2", spyList.get(1)); // Real behavior
        
        // Verify interactions
        verify(spyList).add("element1");
        verify(spyList).add("element2");
        verify(spyList).size();
        verify(spyList).get(0);
        verify(spyList).get(1);
        
        System.out.println("Spy objects demonstration successful");
    }
    
    /**
     * Demonstrates argument captors
     */
    @Test
    @DisplayName("Argument Captors")
    void demonstrateArgumentCaptors() {
        System.out.println("=== Argument Captors ===");
        
        // Create argument captor
        ArgumentCaptor<String> emailCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);
        
        // Call method
        emailService.sendEmail("test@example.com", "Hello World");
        
        // Capture arguments
        verify(emailService).sendEmail(emailCaptor.capture(), messageCaptor.capture());
        
        // Verify captured arguments
        assertEquals("test@example.com", emailCaptor.getValue());
        assertEquals("Hello World", messageCaptor.getValue());
        
        System.out.println("Argument captors demonstration successful");
    }
    
    /**
     * Demonstrates static method mocking
     */
    @Test
    @DisplayName("Static Method Mocking")
    void demonstrateStaticMethodMocking() {
        System.out.println("=== Static Method Mocking ===");
        
        try (MockedStatic<UtilityClass> mockedStatic = mockStatic(UtilityClass.class)) {
            // Stub static method
            mockedStatic.when(UtilityClass::getCurrentTime).thenReturn("2024-01-01 12:00:00");
            mockedStatic.when(() -> UtilityClass.formatString(anyString())).thenReturn("FORMATTED");
            
            // Test static method calls
            String time = UtilityClass.getCurrentTime();
            assertEquals("2024-01-01 12:00:00", time);
            
            String formatted = UtilityClass.formatString("test");
            assertEquals("FORMATTED", formatted);
            
            // Verify static method calls
            mockedStatic.verify(UtilityClass::getCurrentTime);
            mockedStatic.verify(() -> UtilityClass.formatString("test"));
        }
        
        System.out.println("Static method mocking demonstration successful");
    }
    
    /**
     * Demonstrates advanced mocking techniques
     */
    @Test
    @DisplayName("Advanced Mocking Techniques")
    void demonstrateAdvancedMocking() {
        System.out.println("=== Advanced Mocking Techniques ===");
        
        // Stub with different return values for multiple calls
        when(userService.getUserById(1L))
            .thenReturn(new User(1L, "First Call", "first@example.com"))
            .thenReturn(new User(1L, "Second Call", "second@example.com"))
            .thenThrow(new RuntimeException("Third call fails"));
        
        // Test multiple calls
        User user1 = userService.getUserById(1L);
        assertEquals("First Call", user1.getName());
        
        User user2 = userService.getUserById(1L);
        assertEquals("Second Call", user2.getName());
        
        assertThrows(RuntimeException.class, () -> {
            userService.getUserById(1L);
        });
        
        // Stub with custom answer
        when(userService.getUserById(anyLong())).thenAnswer(invocation -> {
            Long id = invocation.getArgument(0);
            return new User(id, "User " + id, "user" + id + "@example.com");
        });
        
        User user3 = userService.getUserById(5L);
        assertEquals("User 5", user3.getName());
        assertEquals("user5@example.com", user3.getEmail());
        
        System.out.println("Advanced mocking techniques demonstration successful");
    }
    
    /**
     * Demonstrates mocking best practices
     */
    @Test
    @DisplayName("Mocking Best Practices")
    void demonstrateMockingBestPractices() {
        System.out.println("=== Mocking Best Practices ===");
        
        System.out.println("Best Practices:");
        System.out.println("✓ Mock external dependencies, not the class under test");
        System.out.println("✓ Use mocks for expensive operations (database, network)");
        System.out.println("✓ Stub only the methods you need for the test");
        System.out.println("✓ Verify important interactions");
        System.out.println("✓ Use argument matchers for flexibility");
        System.out.println("✓ Keep mocks simple and focused");
        System.out.println("✓ Don't mock value objects or data classes");
        System.out.println("✓ Use spies sparingly, prefer mocks");
        
        // Example of good mocking practice
        when(userService.getUserById(1L)).thenReturn(new User(1L, "John Doe", "john@example.com"));
        
        User user = userService.getUserById(1L);
        assertNotNull(user);
        
        verify(userService).getUserById(1L);
        
        System.out.println("Mocking best practices demonstration successful");
    }
}

/**
 * User class for testing demonstrations
 */
class User {
    private Long id;
    private String name;
    private String email;
    
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}

/**
 * UserService interface for mocking demonstrations
 */
interface UserService {
    User getUserById(Long id);
    User getUserByName(String name);
    User getUserByEmail(String email);
    void saveUser(User user);
    void deleteUser(Long id);
}

/**
 * EmailService interface for mocking demonstrations
 */
interface EmailService {
    void sendEmail(String to, String message);
    boolean isEmailValid(String email);
}

/**
 * UserController class for dependency injection demonstrations
 */
class UserController {
    private UserService userService;
    private EmailService emailService;
    
    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }
    
    public User getUser(Long id) {
        return userService.getUserById(id);
    }
    
    public void sendWelcomeEmail(Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            emailService.sendEmail(user.getEmail(), "Welcome!");
        }
    }
}

/**
 * Utility class for static method mocking demonstrations
 */
class UtilityClass {
    public static String getCurrentTime() {
        return java.time.LocalDateTime.now().toString();
    }
    
    public static String formatString(String input) {
        return input.toUpperCase();
    }
}
