# Persistence: JDBC, ORM, Migrations, and Tests

The JDBC lessons in `03_Advanced_Level/04_JDBC_Database` introduce connections,
prepared statements, and transactions. This module adds an executable JPA and
Hibernate example backed by H2 and managed by Flyway. H2 is an embedded learning
database, not a production database.

## Run and test

```bash
mvn -DskipTests package dependency:copy-dependencies
java -cp "target/classes:target/dependency/*" com.tutorial.persistence.PersistenceDemo
mvn -Dtest=CustomerStoreTest test
```

The example applies `src/main/resources/db/migration/V1__create_customer.sql`,
then uses Hibernate to insert and read a `Customer` entity. The test applies the
same migration to an isolated in-memory database and verifies data survives an
ORM session boundary.

## What ORM changes (and does not)

JPA is the persistence API; Hibernate is one implementation. Entities map
identity and relationships, while an `EntityManager` tracks changes inside a
transaction. This can remove repetitive row mapping, but it does not remove the
need to understand SQL, indexes, constraints, locking, query plans, or
transaction boundaries.

Practice next:

- Model relations explicitly and choose fetch behavior deliberately; avoid
  accidental N+1 queries.
- Keep transactions around a unit of work, not around an entire web request
  that performs unrelated network calls.
- Use bind parameters for values and database constraints as a final integrity
  boundary. Never concatenate untrusted input into SQL.
- Keep schema changes as reviewed, ordered migrations. Test upgrades from
  realistic prior schemas; avoid automatic production schema mutation.
- Use a disposable database for integration tests, and test repository behavior
  against the same database engine used in production when vendor-specific SQL
  matters.
- Use optimistic locking for conflicting updates where appropriate and define
  retry behavior for transient failures.

The included demo uses a hard-coded local in-memory URL with no credentials.
Configure production endpoints and secrets through a secret manager or
environment-specific configuration, not checked-in files. A real production
setup also needs connection pooling, backups, migration review, access control,
and observability.
