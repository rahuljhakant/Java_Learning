# 🔐 Cryptography - Java Security Implementation

This section covers cryptographic operations in Java including encryption, decryption, hashing, and digital signatures.

## 🎯 Learning Objectives

- ✅ Implement encryption and decryption
- ✅ Use hashing algorithms for data integrity
- ✅ Create and verify digital signatures
- ✅ Handle cryptographic keys securely
- ✅ Apply cryptographic best practices
- ✅ Use Java Cryptography Architecture (JCA)

## 📚 Tutorial Files

### EncryptionDemo.java
**Purpose**: Demonstrating encryption and decryption

**Key Topics**:
- Symmetric encryption (AES)
- Asymmetric encryption (RSA)
- Key generation and management
- Encryption modes and padding

### HashingDemo.java
**Purpose**: Demonstrating hashing algorithms

**Key Topics**:
- MD5, SHA-1, SHA-256 hashing
- Password hashing with salt
- Message authentication codes (MAC)
- Hash-based message authentication

## 🔧 Key Concepts

### Encryption Types
- **Symmetric**: Same key for encryption and decryption
- **Asymmetric**: Different keys for encryption and decryption
- **Hash Functions**: One-way cryptographic functions
- **Digital Signatures**: Authentication and integrity verification

### Java Cryptography
```java
Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
byte[] encrypted = cipher.doFinal(plaintext);
```

## 🚀 Hands-On Practice

### Exercise 1: File Encryption
Encrypt and decrypt files using AES encryption.

### Exercise 2: Password Hashing
Implement secure password hashing with salt.

### Exercise 3: Digital Signatures
Create and verify digital signatures for documents.

## Author

**Created by: Rahul Kant Jha**
- Comprehensive Cryptography Tutorial
- Industry-standard implementations with detailed explanations

---

**Master cryptography for secure Java applications! 🚀**
