# Backend Development with Java

This module extends the socket and Spring introductions with a small, runnable
HTTP/JSON API. It uses the JDK `HttpServer` so the transport is visible rather
than hidden behind a framework. The in-memory store is deliberately limited to
teaching; it loses data on restart and is not suitable for production.

## Run the API

From the repository root, with Java 17 and Maven installed:

```bash
mvn -DskipTests package dependency:copy-dependencies
java -cp "target/classes:target/dependency/*" com.tutorial.backend.TaskApiServer
```

The server listens on `http://localhost:8080`. Set `PORT` to use another local
port. The API has:

| Method | Path | Result |
| --- | --- | --- |
| `GET` | `/api/tasks` | List tasks |
| `GET` | `/api/tasks/{id}` | Fetch a task, or return 404 |
| `POST` | `/api/tasks` | Create a task; invalid JSON or a blank title returns 400 |

Try it with curl:

```bash
curl -i http://localhost:8080/api/tasks
curl -i -H 'Content-Type: application/json' \
  -d '{"title":"Read about REST"}' http://localhost:8080/api/tasks
```

## Concepts to practice

- Keep transport concerns (HTTP status, headers, JSON) separate from the
  `TaskService` validation and storage logic.
- Use resource paths and HTTP methods consistently. A real API should also
  define versioning, pagination, idempotency, and a stable error schema.
- Validate the request on the server even when a client validates too.
- Add authentication and role-based authorization at the application boundary;
  authentication alone does not grant permission to every resource.
- Publish an OpenAPI contract and generate or validate clients against it.
- Use a broker only when asynchronous delivery is needed. Design consumers for
  retries, duplicate messages, dead-letter handling, and idempotency.
- For distributed services, expect partial failure and timeouts. Avoid treating
  a successful local request as proof that a remote side effect completed.

## Security and production boundary

This sample has **no authentication, authorization, TLS, rate limiting, durable
storage, or production-grade error handling**. Bind it only on a trusted local
development environment. Do not put credentials in the source or return
internal exception details to clients. Production services should use a
maintained framework, a threat model, secure configuration, observability, and
automated tests for authorization and validation.
