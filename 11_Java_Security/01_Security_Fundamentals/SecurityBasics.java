/**
 * Java Security Fundamentals - Comprehensive Tutorial
 * 
 * This comprehensive tutorial demonstrates Java security fundamentals,
 * including the security model, authentication, authorization, cryptography,
 * and secure coding practices. Understanding Java security is crucial for
 * building secure and robust applications.
 * 
 * LEARNING OBJECTIVES:
 * - Understand Java security architecture and model
 * - Learn about authentication and authorization mechanisms
 * - Master cryptography concepts and implementation
 * - Understand secure coding practices and principles
 * - Learn about common security vulnerabilities and prevention
 * - Practice security testing and validation techniques
 * - Understand security monitoring and incident response
 * 
 * KEY CONCEPTS:
 * 1. Security Model: Java security architecture and principles
 * 2. Authentication: User identity verification
 * 3. Authorization: Access control and permissions
 * 4. Cryptography: Encryption, hashing, and digital signatures
 * 5. Input Validation: Data validation and sanitization
 * 6. Secure Coding: Best practices for secure development
 * 7. Security Testing: Testing for security vulnerabilities
 * 8. Security Monitoring: Runtime security monitoring
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Java Security Fundamentals Demo - Main demonstration class
 * 
 * This class demonstrates various Java security concepts including
 * cryptography, authentication, authorization, and secure coding practices.
 */
public class SecurityBasics {
    
    public static void main(String[] args) {
        System.out.println("=== Java Security Fundamentals Tutorial ===");
        System.out.println();
        
        // 1. Java security model overview
        demonstrateSecurityModel();
        
        // 2. Cryptography basics
        demonstrateCryptography();
        
        // 3. Authentication and authorization
        demonstrateAuthentication();
        
        // 4. Input validation and sanitization
        demonstrateInputValidation();
        
        // 5. Secure coding practices
        demonstrateSecureCoding();
        
        // 6. Security testing and monitoring
        demonstrateSecurityTesting();
    }
    
    /**
     * Demonstrates Java security model and architecture
     */
    private static void demonstrateSecurityModel() {
        System.out.println("1. Java Security Model:");
        System.out.println("======================");
        
        System.out.println("Java Security Architecture:");
        System.out.println("• Security Manager: Access control and permissions");
        System.out.println("• Class Loaders: Secure class loading and verification");
        System.out.println("• Bytecode Verification: Code integrity and security checks");
        System.out.println("• Sandboxing: Isolating untrusted code execution");
        System.out.println("• Cryptography: Built-in cryptographic support");
        System.out.println("• Access Control: Fine-grained permission system");
        
        System.out.println("\nSecurity Principles:");
        System.out.println("• Defense in Depth: Multiple layers of security");
        System.out.println("• Least Privilege: Minimum necessary permissions");
        System.out.println("• Fail Secure: Secure default behavior");
        System.out.println("• Input Validation: Validate all inputs");
        System.out.println("• Output Encoding: Encode all outputs");
        System.out.println("• Error Handling: Secure error handling");
        
        System.out.println("\nSecurity Manager Example:");
        System.out.println("SecurityManager sm = System.getSecurityManager();");
        System.out.println("if (sm != null) {");
        System.out.println("    sm.checkPermission(new FilePermission(\"file.txt\", \"read\"));");
        System.out.println("}");
        
        System.out.println("\nClass Loader Security:");
        System.out.println("• Bootstrap Class Loader: Loads core Java classes");
        System.out.println("• Extension Class Loader: Loads extension classes");
        System.out.println("• Application Class Loader: Loads application classes");
        System.out.println("• Custom Class Loaders: Can implement custom security policies");
        
        System.out.println();
    }
    
    /**
     * Demonstrates cryptography concepts and implementation
     */
    private static void demonstrateCryptography() {
        System.out.println("2. Cryptography:");
        System.out.println("===============");
        
        System.out.println("Cryptography Types:");
        System.out.println("• Symmetric Encryption: Same key for encryption and decryption");
        System.out.println("• Asymmetric Encryption: Different keys for encryption and decryption");
        System.out.println("• Hashing: One-way transformation of data");
        System.out.println("• Digital Signatures: Message authentication and integrity");
        
        // Demonstrate symmetric encryption
        demonstrateSymmetricEncryption();
        
        // Demonstrate hashing
        demonstrateHashing();
        
        // Demonstrate digital signatures
        demonstrateDigitalSignatures();
        
        System.out.println();
    }
    
    /**
     * Demonstrates symmetric encryption
     */
    private static void demonstrateSymmetricEncryption() {
        System.out.println("\nSymmetric Encryption (AES):");
        try {
            // Generate a secret key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256); // 256-bit key
            SecretKey secretKey = keyGenerator.generateKey();
            
            // Create cipher for encryption
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            // Encrypt data
            String plaintext = "This is a secret message";
            byte[] encryptedData = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
            String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedData);
            
            System.out.println("Original: " + plaintext);
            System.out.println("Encrypted: " + encryptedBase64);
            
            // Decrypt data
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedBase64));
            String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);
            
            System.out.println("Decrypted: " + decryptedText);
            
        } catch (Exception e) {
            System.err.println("Encryption error: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates hashing algorithms
     */
    private static void demonstrateHashing() {
        System.out.println("\nHashing (SHA-256):");
        try {
            String input = "Hello, World!";
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            String hashHex = bytesToHex(hash);
            
            System.out.println("Input: " + input);
            System.out.println("SHA-256 Hash: " + hashHex);
            
            // Demonstrate password hashing with salt
            String password = "mypassword";
            String salt = generateSalt();
            String hashedPassword = hashPassword(password, salt);
            
            System.out.println("Password: " + password);
            System.out.println("Salt: " + salt);
            System.out.println("Hashed Password: " + hashedPassword);
            
        } catch (Exception e) {
            System.err.println("Hashing error: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates digital signatures
     */
    private static void demonstrateDigitalSignatures() {
        System.out.println("\nDigital Signatures:");
        try {
            // Generate key pair
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            
            // Create signature
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(keyPair.getPrivate());
            
            String message = "This is a signed message";
            signature.update(message.getBytes(StandardCharsets.UTF_8));
            byte[] signatureBytes = signature.sign();
            String signatureBase64 = Base64.getEncoder().encodeToString(signatureBytes);
            
            System.out.println("Message: " + message);
            System.out.println("Signature: " + signatureBase64);
            
            // Verify signature
            signature.initVerify(keyPair.getPublic());
            signature.update(message.getBytes(StandardCharsets.UTF_8));
            boolean isValid = signature.verify(Base64.getDecoder().decode(signatureBase64));
            
            System.out.println("Signature Valid: " + isValid);
            
        } catch (Exception e) {
            System.err.println("Digital signature error: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates authentication and authorization
     */
    private static void demonstrateAuthentication() {
        System.out.println("3. Authentication and Authorization:");
        System.out.println("===================================");
        
        System.out.println("Authentication Methods:");
        System.out.println("• Username/Password: Traditional authentication");
        System.out.println("• Multi-Factor Authentication: Multiple authentication factors");
        System.out.println("• Certificate-based: Digital certificate authentication");
        System.out.println("• Token-based: JWT, OAuth tokens");
        System.out.println("• Biometric: Fingerprint, face recognition");
        
        System.out.println("\nAuthorization Models:");
        System.out.println("• Role-Based Access Control (RBAC)");
        System.out.println("• Attribute-Based Access Control (ABAC)");
        System.out.println("• Discretionary Access Control (DAC)");
        System.out.println("• Mandatory Access Control (MAC)");
        
        // Demonstrate simple authentication
        System.out.println("\nSimple Authentication Example:");
        String username = "admin";
        String password = "password123";
        
        if (authenticateUser(username, password)) {
            System.out.println("Authentication successful for user: " + username);
            
            // Check authorization
            if (isAuthorized(username, "admin")) {
                System.out.println("User " + username + " is authorized for admin operations");
            } else {
                System.out.println("User " + username + " is not authorized for admin operations");
            }
        } else {
            System.out.println("Authentication failed for user: " + username);
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates input validation and sanitization
     */
    private static void demonstrateInputValidation() {
        System.out.println("4. Input Validation and Sanitization:");
        System.out.println("====================================");
        
        System.out.println("Input Validation Principles:");
        System.out.println("• Validate all inputs at the boundary");
        System.out.println("• Use whitelist validation when possible");
        System.out.println("• Sanitize inputs before processing");
        System.out.println("• Encode outputs to prevent injection");
        System.out.println("• Use parameterized queries for databases");
        
        // Demonstrate input validation
        System.out.println("\nInput Validation Examples:");
        
        String[] testInputs = {
            "john@example.com",
            "admin'; DROP TABLE users; --",
            "<script>alert('XSS')</script>",
            "../../../etc/passwd",
            "normal text"
        };
        
        for (String input : testInputs) {
            System.out.println("Input: " + input);
            System.out.println("  Valid Email: " + isValidEmail(input));
            System.out.println("  Contains SQL Injection: " + containsSQLInjection(input));
            System.out.println("  Contains XSS: " + containsXSS(input));
            System.out.println("  Contains Path Traversal: " + containsPathTraversal(input));
            System.out.println("  Sanitized: " + sanitizeInput(input));
            System.out.println();
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates secure coding practices
     */
    private static void demonstrateSecureCoding() {
        System.out.println("5. Secure Coding Practices:");
        System.out.println("==========================");
        
        System.out.println("Secure Coding Principles:");
        System.out.println("• Never trust user input");
        System.out.println("• Use secure defaults");
        System.out.println("• Implement proper error handling");
        System.out.println("• Use secure communication protocols");
        System.out.println("• Keep dependencies updated");
        System.out.println("• Implement proper logging and monitoring");
        
        System.out.println("\nCommon Security Vulnerabilities (OWASP Top 10):");
        System.out.println("1. Injection (SQL, NoSQL, OS, LDAP)");
        System.out.println("2. Broken Authentication");
        System.out.println("3. Sensitive Data Exposure");
        System.out.println("4. XML External Entities (XXE)");
        System.out.println("5. Broken Access Control");
        System.out.println("6. Security Misconfiguration");
        System.out.println("7. Cross-Site Scripting (XSS)");
        System.out.println("8. Insecure Deserialization");
        System.out.println("9. Using Components with Known Vulnerabilities");
        System.out.println("10. Insufficient Logging & Monitoring");
        
        System.out.println("\nSecure Coding Examples:");
        
        // Demonstrate secure string comparison
        System.out.println("Secure String Comparison:");
        String password1 = "secret123";
        String password2 = "secret123";
        String password3 = "different";
        
        System.out.println("Secure comparison (password1 vs password2): " + 
            secureStringEquals(password1, password2));
        System.out.println("Secure comparison (password1 vs password3): " + 
            secureStringEquals(password1, password3));
        
        // Demonstrate secure random number generation
        System.out.println("\nSecure Random Number Generation:");
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);
        System.out.println("Secure random bytes: " + bytesToHex(randomBytes));
        
        System.out.println();
    }
    
    /**
     * Demonstrates security testing and monitoring
     */
    private static void demonstrateSecurityTesting() {
        System.out.println("6. Security Testing and Monitoring:");
        System.out.println("==================================");
        
        System.out.println("Security Testing Types:");
        System.out.println("• Static Application Security Testing (SAST)");
        System.out.println("• Dynamic Application Security Testing (DAST)");
        System.out.println("• Interactive Application Security Testing (IAST)");
        System.out.println("• Software Composition Analysis (SCA)");
        System.out.println("• Penetration Testing");
        System.out.println("• Code Review");
        
        System.out.println("\nSecurity Monitoring:");
        System.out.println("• Log analysis and monitoring");
        System.out.println("• Intrusion detection");
        System.out.println("• Vulnerability scanning");
        System.out.println("• Incident response");
        System.out.println("• Security metrics and KPIs");
        
        System.out.println("\nSecurity Tools:");
        System.out.println("• OWASP ZAP: Web application security scanner");
        System.out.println("• Burp Suite: Web application security testing");
        System.out.println("• SonarQube: Code quality and security analysis");
        System.out.println("• Checkmarx: Static application security testing");
        System.out.println("• Veracode: Application security platform");
        
        System.out.println("\nSecurity Best Practices:");
        System.out.println("• Regular security assessments");
        System.out.println("• Continuous security monitoring");
        System.out.println("• Incident response planning");
        System.out.println("• Security training and awareness");
        System.out.println("• Regular security updates and patches");
        
        System.out.println();
    }
    
    // Helper methods for demonstrations
    
    /**
     * Converts byte array to hexadecimal string
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
    
    /**
     * Generates a random salt for password hashing
     */
    private static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
    
    /**
     * Hashes a password with salt
     */
    private static String hashPassword(String password, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(Base64.getDecoder().decode(salt));
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Password hashing failed", e);
        }
    }
    
    /**
     * Simple authentication method
     */
    private static boolean authenticateUser(String username, String password) {
        // In real applications, this would check against a secure database
        return "admin".equals(username) && "password123".equals(password);
    }
    
    /**
     * Simple authorization check
     */
    private static boolean isAuthorized(String username, String role) {
        // In real applications, this would check user roles and permissions
        return "admin".equals(username) && "admin".equals(role);
    }
    
    /**
     * Validates email format
     */
    private static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    /**
     * Checks for SQL injection patterns
     */
    private static boolean containsSQLInjection(String input) {
        if (input == null) return false;
        String lowerInput = input.toLowerCase();
        return lowerInput.contains("'") || lowerInput.contains(";") || 
               lowerInput.contains("drop") || lowerInput.contains("delete") ||
               lowerInput.contains("insert") || lowerInput.contains("update");
    }
    
    /**
     * Checks for XSS patterns
     */
    private static boolean containsXSS(String input) {
        if (input == null) return false;
        String lowerInput = input.toLowerCase();
        return lowerInput.contains("<script") || lowerInput.contains("javascript:") ||
               lowerInput.contains("onload=") || lowerInput.contains("onerror=");
    }
    
    /**
     * Checks for path traversal patterns
     */
    private static boolean containsPathTraversal(String input) {
        if (input == null) return false;
        return input.contains("../") || input.contains("..\\") || 
               input.contains("/etc/") || input.contains("\\windows\\");
    }
    
    /**
     * Sanitizes input by removing dangerous characters
     */
    private static String sanitizeInput(String input) {
        if (input == null) return null;
        return input.replaceAll("[<>\"'&;]", "");
    }
    
    /**
     * Secure string comparison to prevent timing attacks
     */
    private static boolean secureStringEquals(String a, String b) {
        if (a == null || b == null) return a == b;
        if (a.length() != b.length()) return false;
        
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            result |= a.charAt(i) ^ b.charAt(i);
        }
        return result == 0;
    }
}
