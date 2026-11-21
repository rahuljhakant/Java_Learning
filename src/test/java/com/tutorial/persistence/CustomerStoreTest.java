package com.tutorial.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class CustomerStoreTest {
    @Test
    void appliesMigrationAndPersistsCustomerAcrossEntityManagers() {
        String url = "jdbc:h2:mem:test_" + UUID.randomUUID() + ";DB_CLOSE_DELAY=-1";

        try (CustomerStore store = new CustomerStore(url)) {
            Customer saved = store.create("  Grace Hopper ", "grace@example.test");

            assertEquals("Grace Hopper", saved.getName());
            assertEquals(1, store.findAll().size());
            assertEquals("grace@example.test", store.findAll().get(0).getEmail());
            assertThrows(IllegalArgumentException.class, () -> store.create(" ", "invalid"));
        }
    }
}
