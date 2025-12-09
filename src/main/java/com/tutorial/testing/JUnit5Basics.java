/**
 * JUnit 5 Testing Framework - Comprehensive Tutorial
 * 
 * This comprehensive tutorial demonstrates JUnit 5, the modern testing framework
 * for Java applications. JUnit 5 provides a powerful and flexible testing platform
 * with improved architecture, better annotations, and enhanced features for
 * writing effective unit tests.
 * 
 * LEARNING OBJECTIVES:
 * - Understand JUnit 5 architecture and components
 * - Learn JUnit 5 annotations and their usage
 * - Master assertions and test validation
 * - Understand test lifecycle and setup/teardown
 * - Learn parameterized testing with multiple data sets
 * - Practice advanced testing features and techniques
 * - Understand testing best practices and patterns
 * 
 * KEY CONCEPTS:
 * 1. JUnit 5 Architecture: Platform, Jupiter, Vintage components
 * 2. Annotations: @Test, @BeforeEach, @AfterEach, @DisplayName
 * 3. Assertions: Built-in assertions and third-party libraries
 * 4. Test Lifecycle: Setup, execution, and teardown methods
 * 5. Parameterized Tests: Testing with multiple data sets
 * 6. Nested Tests: Organizing related tests
 * 7. Dynamic Tests: Runtime test generation
 * 8. Test Interfaces: Reusable test behavior
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

/**
 * JUnit 5 Basics Demo - Main demonstration class
 * 
 * This class demonstrates various JUnit 5 features including annotations,
 * assertions, test lifecycle, and advanced testing techniques.
 */
public class JUnit5Basics {
    
    // Test data and setup
    private List<String> testList;
    private Calculator calculator;
    
    /**
     * Demonstrates JUnit 5 introduction and architecture
     */
    @Test
    @DisplayName("JUnit 5 Introduction and Architecture")
    void demonstrateJUnit5Introduction() {
        System.out.println("=== JUnit 5 Introduction ===");
        
        System.out.println("JUnit 5 Architecture:");
        System.out.println("• JUnit Platform: Test execution engine");
        System.out.println("• JUnit Jupiter: Programming model and extension model");
        System.out.println("• JUnit Vintage: Support for JUnit 3 and 4 tests");
        
        System.out.println("\nKey Benefits:");
        System.out.println("✓ Modern Java features (Java 8+)");
        System.out.println("✓ Improved annotations and assertions");
        System.out.println("✓ Better test organization and lifecycle");
        System.out.println("✓ Enhanced parameterized testing");
        System.out.println("✓ Extensible architecture");
        System.out.println("✓ Better IDE integration");
        
        System.out.println("\nMaven Dependencies:");
        System.out.println("<dependency>");
        System.out.println("    <groupId>org.junit.jupiter</groupId>");
        System.out.println("    <artifactId>junit-jupiter-engine</artifactId>");
        System.out.println("    <version>5.9.2</version>");
        System.out.println("    <scope>test</scope>");
        System.out.println("</dependency>");
    }
    
    /**
     * Demonstrates basic JUnit 5 annotations
     */
    @Test
    @DisplayName("Basic JUnit 5 Annotations")
    void demonstrateBasicAnnotations() {
        System.out.println("=== JUnit 5 Annotations ===");
        
        System.out.println("Core Annotations:");
        System.out.println("• @Test: Marks a method as a test method");
        System.out.println("• @DisplayName: Custom display name for test");
        System.out.println("• @BeforeEach: Executed before each test method");
        System.out.println("• @AfterEach: Executed after each test method");
        System.out.println("• @BeforeAll: Executed once before all test methods");
        System.out.println("• @AfterAll: Executed once after all test methods");
        System.out.println("• @Disabled: Disables a test method or class");
        
        System.out.println("\nAnnotation Examples:");
        System.out.println("@Test");
        System.out.println("@DisplayName(\"Should add two numbers correctly\")");
        System.out.println("void testAddition() {");
        System.out.println("    // Test implementation");
        System.out.println("}");
        
        // This test will pass
        Assertions.assertTrue(true, "Basic annotation test should pass");
    }
    
    /**
     * Demonstrates JUnit 5 assertions
     */
    @Test
    @DisplayName("JUnit 5 Assertions")
    void demonstrateAssertions() {
        System.out.println("=== JUnit 5 Assertions ===");
        
        System.out.println("Built-in Assertions:");
        System.out.println("• assertEquals(expected, actual)");
        System.out.println("• assertNotEquals(unexpected, actual)");
        System.out.println("• assertTrue(condition)");
        System.out.println("• assertFalse(condition)");
        System.out.println("• assertNull(object)");
        System.out.println("• assertNotNull(object)");
        System.out.println("• assertSame(expected, actual)");
        System.out.println("• assertNotSame(unexpected, actual)");
        System.out.println("• assertThrows(exception, executable)");
        System.out.println("• assertAll(grouped assertions)");
        
        // Basic assertions
        Assertions.assertEquals(5, 2 + 3, "Addition should work correctly");
        Assertions.assertNotEquals(0, 5, "Value should not be zero");
        Assertions.assertTrue(10 > 5, "10 should be greater than 5");
        Assertions.assertFalse(3 > 5, "3 should not be greater than 5");
        
        // Null assertions
        String nullString = null;
        String notNullString = "Hello";
        Assertions.assertNull(nullString, "String should be null");
        Assertions.assertNotNull(notNullString, "String should not be null");
        
        // Exception assertions
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0;
        }, "Should throw ArithmeticException");
        
        // Grouped assertions
        Assertions.assertAll("Grouped assertions",
            () -> Assertions.assertEquals(4, 2 * 2),
            () -> Assertions.assertEquals(8, 2 * 4),
            () -> Assertions.assertTrue(10 > 5)
        );
    }
    
    /**
     * Demonstrates test lifecycle methods
     */
    @BeforeAll
    static void setUpAll() {
        System.out.println("=== Test Lifecycle - BeforeAll ===");
        System.out.println("This method runs once before all test methods");
        System.out.println("Use for expensive setup operations");
    }
    
    @BeforeEach
    void setUp() {
        System.out.println("\n=== Test Lifecycle - BeforeEach ===");
        System.out.println("This method runs before each test method");
        
        // Initialize test data
        testList = new ArrayList<>();
        testList.add("item1");
        testList.add("item2");
        
        calculator = new Calculator();
        
        System.out.println("Test data initialized");
    }
    
    @Test
    @DisplayName("Test Lifecycle - Test Method")
    void testLifecycleExample() {
        System.out.println("=== Test Lifecycle - Test Method ===");
        System.out.println("This is a test method execution");
        
        // Test the initialized data
        Assertions.assertEquals(2, testList.size(), "List should have 2 items");
        Assertions.assertNotNull(calculator, "Calculator should be initialized");
        
        // Test calculator functionality
        int result = calculator.add(5, 3);
        Assertions.assertEquals(8, result, "Calculator should add correctly");
    }
    
    @AfterEach
    void tearDown() {
        System.out.println("\n=== Test Lifecycle - AfterEach ===");
        System.out.println("This method runs after each test method");
        System.out.println("Use for cleanup operations");
        
        // Clean up test data
        testList.clear();
        calculator = null;
        
        System.out.println("Test data cleaned up");
    }
    
    @AfterAll
    static void tearDownAll() {
        System.out.println("\n=== Test Lifecycle - AfterAll ===");
        System.out.println("This method runs once after all test methods");
        System.out.println("Use for final cleanup operations");
    }
    
    /**
     * Demonstrates parameterized testing
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Parameterized Test with ValueSource")
    void testParameterizedWithValueSource(int value) {
        System.out.println("Testing with value: " + value);
        
        // Test that all values are positive
        Assertions.assertTrue(value > 0, "Value should be positive");
        
        // Test that values are within expected range
        Assertions.assertTrue(value <= 5, "Value should be <= 5");
    }
    
    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "10, 20, 30",
        "0, 5, 5",
        "-1, 1, 0"
    })
    @DisplayName("Parameterized Test with CsvSource")
    void testParameterizedWithCsvSource(int a, int b, int expected) {
        System.out.println("Testing: " + a + " + " + b + " = " + expected);
        
        Calculator calc = new Calculator();
        int result = calc.add(a, b);
        
        Assertions.assertEquals(expected, result, 
            "Addition should work correctly for " + a + " + " + b);
    }
    
    @ParameterizedTest
    @MethodSource("provideTestData")
    @DisplayName("Parameterized Test with MethodSource")
    void testParameterizedWithMethodSource(TestData data) {
        System.out.println("Testing: " + data.getDescription());
        
        Calculator calc = new Calculator();
        int result = calc.multiply(data.getA(), data.getB());
        
        Assertions.assertEquals(data.getExpected(), result, 
            "Multiplication should work correctly");
    }
    
    /**
     * Provides test data for parameterized tests
     */
    static Stream<TestData> provideTestData() {
        return Stream.of(
            new TestData(2, 3, 6, "2 * 3 = 6"),
            new TestData(4, 5, 20, "4 * 5 = 20"),
            new TestData(0, 10, 0, "0 * 10 = 0"),
            new TestData(-2, 3, -6, "-2 * 3 = -6")
        );
    }
    
    /**
     * Demonstrates nested tests for better organization
     */
    @Nested
    @DisplayName("Calculator Tests")
    class CalculatorTests {
        
        private Calculator calculator;
        
        @BeforeEach
        void setUp() {
            calculator = new Calculator();
        }
        
        @Test
        @DisplayName("Should add two positive numbers")
        void testAddPositiveNumbers() {
            int result = calculator.add(5, 3);
            Assertions.assertEquals(8, result);
        }
        
        @Test
        @DisplayName("Should add negative numbers")
        void testAddNegativeNumbers() {
            int result = calculator.add(-5, -3);
            Assertions.assertEquals(-8, result);
        }
        
        @Test
        @DisplayName("Should multiply two numbers")
        void testMultiply() {
            int result = calculator.multiply(4, 5);
            Assertions.assertEquals(20, result);
        }
        
        @Test
        @DisplayName("Should divide two numbers")
        void testDivide() {
            double result = calculator.divide(10, 2);
            Assertions.assertEquals(5.0, result);
        }
        
        @Test
        @DisplayName("Should throw exception when dividing by zero")
        void testDivideByZero() {
            Assertions.assertThrows(ArithmeticException.class, () -> {
                calculator.divide(10, 0);
            });
        }
    }
    
    /**
     * Demonstrates dynamic tests
     */
    @TestFactory
    @DisplayName("Dynamic Tests")
    Stream<DynamicTest> testDynamicTests() {
        return Stream.of(
            DynamicTest.dynamicTest("Dynamic test 1", () -> {
                Assertions.assertTrue(true);
            }),
            DynamicTest.dynamicTest("Dynamic test 2", () -> {
                Assertions.assertEquals(4, 2 * 2);
            }),
            DynamicTest.dynamicTest("Dynamic test 3", () -> {
                Assertions.assertNotNull("Hello");
            })
        );
    }
    
    /**
     * Demonstrates disabled tests
     */
    @Test
    @Disabled("This test is disabled for demonstration")
    @DisplayName("Disabled Test")
    void testDisabled() {
        System.out.println("This test is disabled and will not run");
        Assertions.fail("This test should not run");
    }
    
    /**
     * Demonstrates test interfaces for reusable behavior
     */
    @Test
    @DisplayName("Test Interface Example")
    void testInterfaceExample() {
        System.out.println("=== Test Interface Example ===");
        
        // Implement test interface behavior
        TestableInterface testable = new TestableImplementation();
        
        Assertions.assertTrue(testable.isValid("valid"));
        Assertions.assertFalse(testable.isValid(""));
        Assertions.assertFalse(testable.isValid(null));
    }
}

/**
 * Calculator class for testing demonstrations
 */
class Calculator {
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return (double) a / b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
}

/**
 * Test data class for parameterized tests
 */
class TestData {
    private final int a;
    private final int b;
    private final int expected;
    private final String description;
    
    public TestData(int a, int b, int expected, String description) {
        this.a = a;
        this.b = b;
        this.expected = expected;
        this.description = description;
    }
    
    public int getA() { return a; }
    public int getB() { return b; }
    public int getExpected() { return expected; }
    public String getDescription() { return description; }
}

/**
 * Test interface for reusable test behavior
 */
interface TestableInterface {
    boolean isValid(String input);
}

/**
 * Implementation of test interface
 */
class TestableImplementation implements TestableInterface {
    
    @Override
    public boolean isValid(String input) {
        return input != null && !input.trim().isEmpty();
    }
}
