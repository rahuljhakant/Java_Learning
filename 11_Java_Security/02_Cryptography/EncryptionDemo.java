package com.tutorial.security.cryptography;

import com.tutorial.security.SecureCrypto;
import javax.crypto.SecretKey;

public final class EncryptionDemo {
    private EncryptionDemo() {}

    public static void main(String[] args) throws Exception {
        SecretKey key = SecureCrypto.newAesKey();
        String plaintext = "A short message for the local demo";
        SecureCrypto.EncryptedMessage encrypted = SecureCrypto.encrypt(plaintext, key);

        System.out.println("Cipher: AES/GCM/NoPadding");
        System.out.println("Nonce (store with ciphertext): " + encrypted.nonce());
        System.out.println("Ciphertext and authentication tag: " + encrypted.ciphertext());
        System.out.println("Decrypted: " + SecureCrypto.decrypt(encrypted, key));
        System.out.println("See SecureCryptoTest for salted PBKDF2 password hashing and verification.");
    }
}
