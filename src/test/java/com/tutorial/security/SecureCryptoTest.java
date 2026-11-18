package com.tutorial.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.GeneralSecurityException;
import java.util.Base64;
import org.junit.jupiter.api.Test;

class SecureCryptoTest {
    @Test
    void encryptsWithFreshNonceAndDetectsTampering() throws Exception {
        var key = SecureCrypto.newAesKey();
        var first = SecureCrypto.encrypt("private note", key);
        var second = SecureCrypto.encrypt("private note", key);

        assertEquals("private note", SecureCrypto.decrypt(first, key));
        assertNotEquals(first.nonce(), second.nonce());
        var changed = new SecureCrypto.EncryptedMessage(first.nonce(), tamper(first.ciphertext()));
        assertThrows(GeneralSecurityException.class, () -> SecureCrypto.decrypt(changed, key));
    }

    @Test
    void usesSaltedPasswordHashAndVerifiesWithoutPlainSha() throws Exception {
        char[] password = "correct horse battery staple".toCharArray();
        String first = SecureCrypto.hashPassword(password);
        String second = SecureCrypto.hashPassword(password);

        assertNotEquals(first, second);
        assertTrue(SecureCrypto.verifyPassword(password, first));
        assertFalse(SecureCrypto.verifyPassword("incorrect".toCharArray(), first));
        assertFalse(SecureCrypto.verifyPassword(password, "sha256$bad"));
    }

    private static String tamper(String value) {
        byte[] ciphertext = Base64.getDecoder().decode(value);
        ciphertext[0] ^= 1;
        return Base64.getEncoder().encodeToString(ciphertext);
    }
}
