package com.tutorial.persistence;

import java.util.UUID;

public final class PersistenceDemo {
    private PersistenceDemo() {}

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:h2:mem:customers_" + UUID.randomUUID() + ";DB_CLOSE_DELAY=-1";
        try (CustomerStore store = new CustomerStore(jdbcUrl)) {
            store.create("Ada Lovelace", "ada@example.test");
            store.findAll().forEach(customer ->
                    System.out.println(customer.getId() + ": " + customer.getName()
                            + " <" + customer.getEmail() + ">"));
        }
    }
}
