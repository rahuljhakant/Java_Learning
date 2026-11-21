package com.tutorial.persistence;

import java.util.List;
import java.util.Map;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.flywaydb.core.Flyway;

public final class CustomerStore implements AutoCloseable {
    private final EntityManagerFactory entityManagerFactory;

    public CustomerStore(String jdbcUrl) {
        Flyway.configure()
                .dataSource(jdbcUrl, "sa", "")
                .load()
                .migrate();
        entityManagerFactory = Persistence.createEntityManagerFactory(
                "learning", Map.of(
                        "jakarta.persistence.jdbc.url", jdbcUrl,
                        "jakarta.persistence.jdbc.user", "sa",
                        "jakarta.persistence.jdbc.password", ""));
    }

    public Customer create(String name, String email) {
        if (name == null || name.isBlank() || email == null || email.isBlank()) {
            throw new IllegalArgumentException("name and email are required");
        }
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            manager.getTransaction().begin();
            Customer customer = new Customer(name.trim(), email.trim());
            manager.persist(customer);
            manager.getTransaction().commit();
            return customer;
        } catch (RuntimeException exception) {
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw exception;
        } finally {
            manager.close();
        }
    }

    public List<Customer> findAll() {
        try (EntityManager manager = entityManagerFactory.createEntityManager()) {
            return manager.createQuery("select c from Customer c order by c.id", Customer.class)
                    .getResultList();
        }
    }

    @Override
    public void close() {
        entityManagerFactory.close();
    }
}
