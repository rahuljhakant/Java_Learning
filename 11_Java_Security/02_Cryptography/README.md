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

### Runnable demo

The runnable `EncryptionDemo` uses the repository's `SecureCrypto` helper:
AES-GCM provides confidentiality and integrity, with a fresh 96-bit nonce for
each encryption. The password example uses salted PBKDF2-HMAC-SHA-256 and
constant-time comparison; it is deliberately not ordinary SHA-256.

## 🔧 Key Concepts

### Encryption Types
- **Symmetric**: Same key for encryption and decryption
- **Asymmetric**: Different keys for encryption and decryption
- **Hash Functions**: One-way cryptographic functions
- **Digital Signatures**: Authentication and integrity verification

### Java Cryptography
Run `mvn -Dtest=SecureCryptoTest test` to exercise authenticated encryption,
tamper detection, salted password hashes, and incorrect-password rejection.

## Important safety notes

- Never use ECB: it exposes repeated plaintext patterns. CBC alone also does
  not authenticate data. This lesson uses AES-GCM instead.
- Never store passwords with a fast digest such as SHA-256, MD5, or SHA-1.
  Use a password-specific adaptive KDF (prefer Argon2id or scrypt in
  production; PBKDF2 is shown here because it is available in the JDK).
- Keep encryption keys in a managed secret store or KMS. The demo creates a
  throwaway in-memory key, which is lost on exit and is not key management.
- Do not print real plaintext, passwords, private keys, or production
  ciphertext into logs.
- Use a maintained library and a reviewed protocol rather than assembling
  cryptographic primitives for a production feature.

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
