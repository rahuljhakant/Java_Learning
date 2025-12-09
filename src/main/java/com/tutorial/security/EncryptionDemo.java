package com.tutorial.security;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Encryption Demo - Java Cryptography Implementation
 * 
 * This comprehensive tutorial demonstrates encryption and decryption
 * techniques in Java using the Java Cryptography Architecture (JCA).
 * Learn symmetric and asymmetric encryption, key management, and
 * cryptographic best practices.
 * 
 * LEARNING OBJECTIVES:
 * - Implement symmetric encryption (AES)
 * - Use asymmetric encryption (RSA)
 * - Manage cryptographic keys securely
 * - Apply encryption modes and padding
 * - Handle cryptographic exceptions
 * - Implement secure encryption practices
 * 
 * KEY CONCEPTS:
 * 1. Symmetric Encryption: Same key for encryption and decryption
 * 2. Asymmetric Encryption: Different keys for encryption and decryption
 * 3. Key Management: Secure key generation and storage
 * 4. Encryption Modes: ECB, CBC, GCM modes
 * 5. Padding: PKCS5, PKCS7 padding schemes
 * 6. Best Practices: Secure encryption implementation
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class EncryptionDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Encryption Demo ===");
        System.out.println();
        
        // 1. Symmetric Encryption (AES)
        demonstrateSymmetricEncryption();
        
        // 2. Asymmetric Encryption (RSA)
        demonstrateAsymmetricEncryption();
        
        // 3. Key Generation
        demonstrateKeyGeneration();
        
        // 4. Encryption Modes
        demonstrateEncryptionModes();
        
        // 5. Key Management
        demonstrateKeyManagement();
        
        // 6. Security Best Practices
        demonstrateSecurityBestPractices();
    }
    
    /**
     * Demonstrates symmetric encryption using AES
     */
    private static void demonstrateSymmetricEncryption() {
        System.out.println("1. Symmetric Encryption (AES):");
        System.out.println("==============================");
        
        try {
            // Generate AES key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256); // 256-bit key
            SecretKey secretKey = keyGenerator.generateKey();
            
            // Original message
            String originalMessage = "This is a secret message that needs to be encrypted!";
            System.out.println("Original message: " + originalMessage);
            
            // Encrypt the message
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(originalMessage.getBytes());
            String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);
            
            System.out.println("Encrypted message: " + encryptedMessage);
            
            // Decrypt the message
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
            String decryptedMessage = new String(decryptedBytes);
            
            System.out.println("Decrypted message: " + decryptedMessage);
            System.out.println("Encryption successful: " + originalMessage.equals(decryptedMessage));
            
        } catch (Exception e) {
            System.err.println("Symmetric encryption error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates asymmetric encryption using RSA
     */
    private static void demonstrateAsymmetricEncryption() {
        System.out.println("2. Asymmetric Encryption (RSA):");
        System.out.println("===============================");
        
        try {
            // Generate RSA key pair
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048); // 2048-bit key
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            
            // Original message
            String originalMessage = "This is a message encrypted with RSA!";
            System.out.println("Original message: " + originalMessage);
            
            // Encrypt with public key
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = cipher.doFinal(originalMessage.getBytes());
            String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);
            
            System.out.println("Encrypted message: " + encryptedMessage);
            
            // Decrypt with private key
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
            String decryptedMessage = new String(decryptedBytes);
            
            System.out.println("Decrypted message: " + decryptedMessage);
            System.out.println("Encryption successful: " + originalMessage.equals(decryptedMessage));
            
        } catch (Exception e) {
            System.err.println("Asymmetric encryption error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates key generation
     */
    private static void demonstrateKeyGeneration() {
        System.out.println("3. Key Generation:");
        System.out.println("==================");
        
        try {
            // AES key generation
            KeyGenerator aesKeyGen = KeyGenerator.getInstance("AES");
            aesKeyGen.init(256);
            SecretKey aesKey = aesKeyGen.generateKey();
            System.out.println("AES Key: " + Base64.getEncoder().encodeToString(aesKey.getEncoded()));
            
            // RSA key pair generation
            KeyPairGenerator rsaKeyGen = KeyPairGenerator.getInstance("RSA");
            rsaKeyGen.initialize(2048);
            KeyPair rsaKeyPair = rsaKeyGen.generateKeyPair();
            
            System.out.println("RSA Public Key: " + Base64.getEncoder().encodeToString(rsaKeyPair.getPublic().getEncoded()));
            System.out.println("RSA Private Key: " + Base64.getEncoder().encodeToString(rsaKeyPair.getPrivate().getEncoded()));
            
            // DES key generation (deprecated but shown for educational purposes)
            KeyGenerator desKeyGen = KeyGenerator.getInstance("DES");
            SecretKey desKey = desKeyGen.generateKey();
            System.out.println("DES Key: " + Base64.getEncoder().encodeToString(desKey.getEncoded()));
            
        } catch (Exception e) {
            System.err.println("Key generation error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates different encryption modes
     */
    private static void demonstrateEncryptionModes() {
        System.out.println("4. Encryption Modes:");
        System.out.println("===================");
        
        String message = "This is a test message for encryption modes.";
        System.out.println("Original message: " + message);
        
        try {
            // Generate key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey key = keyGenerator.generateKey();
            
            // ECB Mode (Electronic Codebook)
            Cipher ecbCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            ecbCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] ecbEncrypted = ecbCipher.doFinal(message.getBytes());
            System.out.println("ECB Mode: " + Base64.getEncoder().encodeToString(ecbEncrypted));
            
            // CBC Mode (Cipher Block Chaining)
            Cipher cbcCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cbcCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cbcEncrypted = cbcCipher.doFinal(message.getBytes());
            System.out.println("CBC Mode: " + Base64.getEncoder().encodeToString(cbcEncrypted));
            
            // GCM Mode (Galois/Counter Mode)
            Cipher gcmCipher = Cipher.getInstance("AES/GCM/NoPadding");
            gcmCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] gcmEncrypted = gcmCipher.doFinal(message.getBytes());
            System.out.println("GCM Mode: " + Base64.getEncoder().encodeToString(gcmEncrypted));
            
        } catch (Exception e) {
            System.err.println("Encryption modes error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates key management
     */
    private static void demonstrateKeyManagement() {
        System.out.println("5. Key Management:");
        System.out.println("==================");
        
        try {
            // Generate and store key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey originalKey = keyGenerator.generateKey();
            
            // Convert key to bytes for storage
            byte[] keyBytes = originalKey.getEncoded();
            String keyString = Base64.getEncoder().encodeToString(keyBytes);
            
            System.out.println("Original key: " + keyString);
            
            // Reconstruct key from bytes
            SecretKey reconstructedKey = new SecretKeySpec(keyBytes, "AES");
            System.out.println("Reconstructed key: " + Base64.getEncoder().encodeToString(reconstructedKey.getEncoded()));
            
            // Verify keys are equal
            System.out.println("Keys are equal: " + originalKey.equals(reconstructedKey));
            
            // Key derivation from password (simplified example)
            String password = "MySecretPassword123!";
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] passwordHash = digest.digest(password.getBytes());
            SecretKey derivedKey = new SecretKeySpec(passwordHash, "AES");
            
            System.out.println("Derived key from password: " + Base64.getEncoder().encodeToString(derivedKey.getEncoded()));
            
        } catch (Exception e) {
            System.err.println("Key management error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates security best practices
     */
    private static void demonstrateSecurityBestPractices() {
        System.out.println("6. Security Best Practices:");
        System.out.println("===========================");
        
        System.out.println("✓ Use strong encryption algorithms (AES-256, RSA-2048+)");
        System.out.println("✓ Use secure random number generators for key generation");
        System.out.println("✓ Implement proper key management and storage");
        System.out.println("✓ Use authenticated encryption modes (GCM, CCM)");
        System.out.println("✓ Implement proper padding schemes");
        System.out.println("✓ Use secure key derivation functions (PBKDF2, Argon2)");
        System.out.println("✓ Implement proper exception handling");
        System.out.println("✓ Use secure random initialization vectors (IVs)");
        System.out.println("✓ Implement key rotation and expiration");
        System.out.println("✓ Use hardware security modules (HSMs) for key storage");
        System.out.println("✓ Implement proper access controls");
        System.out.println("✓ Use secure communication channels");
        System.out.println("✓ Implement proper logging and monitoring");
        System.out.println("✓ Follow cryptographic standards and best practices");
        
        System.out.println();
    }
    
    /**
     * Utility method to encrypt a string with AES
     */
    public static String encryptAES(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    /**
     * Utility method to decrypt a string with AES
     */
    public static String decryptAES(String encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }
    
    /**
     * Utility method to encrypt a string with RSA
     */
    public static String encryptRSA(String plaintext, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    /**
     * Utility method to decrypt a string with RSA
     */
    public static String decryptRSA(String encryptedText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }
}
