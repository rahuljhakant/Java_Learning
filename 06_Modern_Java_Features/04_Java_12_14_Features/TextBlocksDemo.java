package com.tutorial.modern.java.features;

/**
 * Text Blocks Demo - Multi-line String Literals
 * 
 * This comprehensive tutorial demonstrates text blocks introduced in Java 13
 * and finalized in Java 14. Text blocks provide a clean way to write
 * multi-line strings without escape sequences and with better formatting.
 * 
 * LEARNING OBJECTIVES:
 * - Understand text block syntax and benefits
 * - Use text blocks for multi-line strings
 * - Control indentation and formatting
 * - Apply text blocks in real-world scenarios
 * - Handle JSON, SQL, and HTML content
 * - Use text blocks with string methods
 * 
 * KEY CONCEPTS:
 * 1. Text Block Syntax: Triple quotes for multi-line strings
 * 2. Indentation Control: Managing whitespace and indentation
 * 3. Escape Sequences: Using escape sequences in text blocks
 * 4. String Methods: Applying string methods to text blocks
 * 5. Real-world Usage: JSON, SQL, HTML, and configuration files
 * 6. Best Practices: When and how to use text blocks effectively
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class TextBlocksDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Text Blocks Demo ===");
        System.out.println();
        
        // 1. Basic Text Blocks
        demonstrateBasicTextBlocks();
        
        // 2. Indentation Control
        demonstrateIndentationControl();
        
        // 3. JSON Examples
        demonstrateJSONExamples();
        
        // 4. SQL Examples
        demonstrateSQLExamples();
        
        // 5. HTML Examples
        demonstrateHTMLExamples();
        
        // 6. Configuration Examples
        demonstrateConfigurationExamples();
        
        // 7. String Methods with Text Blocks
        demonstrateStringMethods();
        
        // 8. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic text block syntax
     */
    private static void demonstrateBasicTextBlocks() {
        System.out.println("1. Basic Text Blocks:");
        System.out.println("====================");
        
        // Traditional string concatenation
        String traditionalString = "Line 1\n" +
                                 "Line 2\n" +
                                 "Line 3";
        
        // Text block (much cleaner!)
        String textBlock = """
            Line 1
            Line 2
            Line 3
            """;
        
        System.out.println("Traditional String:");
        System.out.println(traditionalString);
        System.out.println();
        
        System.out.println("Text Block:");
        System.out.println(textBlock);
        System.out.println();
    }
    
    /**
     * Demonstrates indentation control in text blocks
     */
    private static void demonstrateIndentationControl() {
        System.out.println("2. Indentation Control:");
        System.out.println("======================");
        
        // Text block with indentation
        String indentedBlock = """
            This is a text block
                with indentation
                    and multiple levels
            """;
        
        System.out.println("Indented Text Block:");
        System.out.println(indentedBlock);
        
        // Using stripIndent() to remove common leading whitespace
        String strippedBlock = """
            This is a text block
                with indentation
                    and multiple levels
            """.stripIndent();
        
        System.out.println("Stripped Indentation:");
        System.out.println(strippedBlock);
        System.out.println();
    }
    
    /**
     * Demonstrates JSON examples with text blocks
     */
    private static void demonstrateJSONExamples() {
        System.out.println("3. JSON Examples:");
        System.out.println("================");
        
        // JSON object using text block
        String jsonObject = """
            {
                "name": "John Doe",
                "age": 30,
                "email": "john@example.com",
                "address": {
                    "street": "123 Main St",
                    "city": "New York",
                    "zipCode": "10001"
                },
                "hobbies": ["reading", "swimming", "coding"]
            }
            """;
        
        System.out.println("JSON Object:");
        System.out.println(jsonObject);
        
        // JSON array using text block
        String jsonArray = """
            [
                {
                    "id": 1,
                    "name": "Product 1",
                    "price": 29.99
                },
                {
                    "id": 2,
                    "name": "Product 2",
                    "price": 39.99
                }
            ]
            """;
        
        System.out.println("JSON Array:");
        System.out.println(jsonArray);
        System.out.println();
    }
    
    /**
     * Demonstrates SQL examples with text blocks
     */
    private static void demonstrateSQLExamples() {
        System.out.println("4. SQL Examples:");
        System.out.println("===============");
        
        // Complex SQL query using text block
        String sqlQuery = """
            SELECT u.id, u.name, u.email, p.title, p.content
            FROM users u
            LEFT JOIN posts p ON u.id = p.user_id
            WHERE u.created_at >= ?
              AND u.status = 'ACTIVE'
              AND (p.published = true OR p.published IS NULL)
            ORDER BY u.name ASC, p.created_at DESC
            LIMIT 100
            """;
        
        System.out.println("SQL Query:");
        System.out.println(sqlQuery);
        
        // SQL INSERT statement
        String insertQuery = """
            INSERT INTO users (name, email, age, created_at)
            VALUES (?, ?, ?, NOW())
            """;
        
        System.out.println("SQL Insert:");
        System.out.println(insertQuery);
        System.out.println();
    }
    
    /**
     * Demonstrates HTML examples with text blocks
     */
    private static void demonstrateHTMLExamples() {
        System.out.println("5. HTML Examples:");
        System.out.println("================");
        
        // HTML template using text block
        String htmlTemplate = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>User Profile</title>
                <style>
                    body { font-family: Arial, sans-serif; }
                    .container { max-width: 800px; margin: 0 auto; }
                    .header { background-color: #f0f0f0; padding: 20px; }
                </style>
            </head>
            <body>
                <div class="container">
                    <div class="header">
                        <h1>Welcome, %s!</h1>
                    </div>
                    <div class="content">
                        <p>Your email: %s</p>
                        <p>Member since: %s</p>
                    </div>
                </div>
            </body>
            </html>
            """;
        
        System.out.println("HTML Template:");
        System.out.println(htmlTemplate);
        System.out.println();
    }
    
    /**
     * Demonstrates configuration file examples
     */
    private static void demonstrateConfigurationExamples() {
        System.out.println("6. Configuration Examples:");
        System.out.println("=========================");
        
        // YAML-like configuration
        String config = """
            # Application Configuration
            app:
              name: "My Java Application"
              version: "1.0.0"
              debug: true
            
            database:
              host: "localhost"
              port: 5432
              name: "myapp_db"
              username: "admin"
              password: "secret"
            
            logging:
              level: "INFO"
              file: "/var/log/myapp.log"
              max_size: "10MB"
            """;
        
        System.out.println("Configuration:");
        System.out.println(config);
        
        // Properties-like configuration
        String properties = """
            # Database Properties
            db.driver=com.mysql.cj.jdbc.Driver
            db.url=jdbc:mysql://localhost:3306/mydb
            db.username=root
            db.password=password
            
            # Server Properties
            server.port=8080
            server.host=localhost
            server.context-path=/api
            """;
        
        System.out.println("Properties:");
        System.out.println(properties);
        System.out.println();
    }
    
    /**
     * Demonstrates string methods with text blocks
     */
    private static void demonstrateStringMethods() {
        System.out.println("7. String Methods with Text Blocks:");
        System.out.println("===================================");
        
        String textBlock = """
            This is a multi-line
            text block with
            various content
            """;
        
        System.out.println("Original Text Block:");
        System.out.println(textBlock);
        
        System.out.println("Length: " + textBlock.length());
        System.out.println("Lines: " + textBlock.lines().count());
        System.out.println("Starts with 'This': " + textBlock.startsWith("This"));
        System.out.println("Contains 'multi': " + textBlock.contains("multi"));
        
        // Using lines() method
        System.out.println("Individual lines:");
        textBlock.lines().forEach(line -> System.out.println("  - " + line.trim()));
        
        // Using stripIndent()
        System.out.println("Stripped indentation:");
        System.out.println(textBlock.stripIndent());
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices for text blocks
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use text blocks for multi-line strings");
        System.out.println("✓ Use text blocks for JSON, SQL, HTML, and configuration");
        System.out.println("✓ Be mindful of indentation and use stripIndent() when needed");
        System.out.println("✓ Use text blocks with string interpolation when available");
        System.out.println("✓ Consider readability over conciseness");
        System.out.println("✓ Use text blocks for templates and formatted content");
        System.out.println("✓ Avoid text blocks for very short strings");
        System.out.println("✓ Use text blocks consistently in your codebase");
        
        System.out.println();
    }
    
    /**
     * Utility method to create a formatted email template
     */
    public static String createEmailTemplate(String recipientName, String message) {
        return """
            Dear %s,
            
            Thank you for your interest in our services.
            
            %s
            
            Best regards,
            The Team
            
            ---
            This is an automated message. Please do not reply.
            """.formatted(recipientName, message);
    }
    
    /**
     * Utility method to create a SQL query template
     */
    public static String createUserQuery(String tableName, String condition) {
        return """
            SELECT id, name, email, created_at
            FROM %s
            WHERE %s
            ORDER BY created_at DESC
            """.formatted(tableName, condition);
    }
    
    /**
     * Utility method to create a JSON response template
     */
    public static String createJsonResponse(String status, String message, Object data) {
        return """
            {
                "status": "%s",
                "message": "%s",
                "data": %s,
                "timestamp": "%s"
            }
            """.formatted(status, message, data, java.time.Instant.now());
    }
}
