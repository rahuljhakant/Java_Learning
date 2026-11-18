# Spring Boot User API example

The Java files in this directory illustrate controller and service patterns,
but this folder does not contain a Spring Boot application descriptor,
dependencies, or a runnable entry point. Do not run `mvn spring-boot:run` from
this directory.

For a complete runnable HTTP/JSON API with request validation and tests, use
the repository's [Backend Development lesson](../../../../14_Backend_Development/).
The Spring files can be used as reading material while comparing framework
controllers with the JDK `HttpServer` example.

Before adapting these snippets, remove permissive CORS settings, avoid broad
exception swallowing, validate requests with framework validation support, and
add authentication and authorization. The current service uses in-memory data
and does not implement these production controls.
