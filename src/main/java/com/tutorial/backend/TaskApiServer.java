package com.tutorial.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public final class TaskApiServer {
    private static final ObjectMapper JSON = new ObjectMapper();
    private final TaskService tasks = new TaskService();

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        String host = System.getenv().getOrDefault("HOST", "127.0.0.1");
        new TaskApiServer().start(host, port);
        System.out.println("Task API listening on http://" + host + ":" + port);
    }

    HttpServer start(int port) throws IOException {
        return start("127.0.0.1", port);
    }

    private HttpServer start(String host, int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(host, port), 0);
        server.createContext("/api/tasks", this::handleTasks);
        server.start();
        return server;
    }

    private void handleTasks(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        String method = exchange.getRequestMethod();
        if ("/api/tasks".equals(path) && "GET".equals(method)) {
            respond(exchange, 200, tasks.findAll());
            return;
        }
        if ("/api/tasks".equals(path) && "POST".equals(method)) {
            createTask(exchange);
            return;
        }
        if (path.matches("/api/tasks/[0-9]+") && "GET".equals(method)) {
            long id = Long.parseLong(path.substring(path.lastIndexOf('/') + 1));
            TaskService.Task task = tasks.findById(id);
            if (task == null) {
                respond(exchange, 404, Map.of("error", "task not found"));
            } else {
                respond(exchange, 200, task);
            }
            return;
        }
        if ("/api/tasks".equals(path) || path.matches("/api/tasks/[0-9]+")) {
            exchange.getResponseHeaders().set(
                    "Allow", "/api/tasks".equals(path) ? "GET, POST" : "GET");
            respond(exchange, 405, Map.of("error", "method not allowed"));
            return;
        }
        respond(exchange, 404, Map.of("error", "route not found"));
    }

    private void createTask(HttpExchange exchange) throws IOException {
        String contentType = exchange.getRequestHeaders().getFirst("Content-Type");
        String mediaType = contentType == null ? "" : contentType.split(";", 2)[0].trim();
        if (contentType == null
                || !"application/json".equalsIgnoreCase(mediaType)) {
            respond(exchange, 415, Map.of("error", "Content-Type must be application/json"));
            return;
        }
        try {
            byte[] request = exchange.getRequestBody().readNBytes(16_385);
            if (request.length > 16_384) {
                respond(exchange, 413, Map.of("error", "request body is too large"));
                return;
            }
            JsonNode body = JSON.readTree(request);
            if (body == null || !body.isObject() || !body.has("title")
                    || !body.get("title").isTextual()) {
                respond(exchange, 400, Map.of("error", "title must be a string"));
                return;
            }
            respond(exchange, 201, tasks.create(body.get("title").textValue()));
        } catch (JsonProcessingException | IllegalArgumentException exception) {
            respond(exchange, 400, Map.of("error", "request body is invalid"));
        }
    }

    private static void respond(HttpExchange exchange, int status, Object body) throws IOException {
        byte[] response = JSON.writeValueAsString(body).getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        exchange.getResponseHeaders().set("X-Content-Type-Options", "nosniff");
        exchange.sendResponseHeaders(status, response.length);
        try (var output = exchange.getResponseBody()) {
            output.write(response);
        }
    }
}
