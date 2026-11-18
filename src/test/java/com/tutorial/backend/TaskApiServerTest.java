package com.tutorial.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.Test;

class TaskApiServerTest {
    private final HttpClient client = HttpClient.newHttpClient();

    @Test
    void createsListsAndValidatesTasksOverHttp() throws Exception {
        HttpServer server = new TaskApiServer().start(0);
        try {
            URI base = URI.create("http://127.0.0.1:" + server.getAddress().getPort());
            HttpResponse<String> created = client.send(
                    HttpRequest.newBuilder(base.resolve("/api/tasks"))
                            .header("Content-Type", "application/json; charset=utf-8")
                            .POST(HttpRequest.BodyPublishers.ofString("{\"title\":\"Learn REST\"}"))
                            .build(),
                    HttpResponse.BodyHandlers.ofString());
            assertEquals(201, created.statusCode());
            assertTrue(created.body().contains("\"title\":\"Learn REST\""));

            HttpResponse<String> fetched = client.send(
                    HttpRequest.newBuilder(base.resolve("/api/tasks/1")).GET().build(),
                    HttpResponse.BodyHandlers.ofString());
            assertEquals(200, fetched.statusCode());

            HttpResponse<String> invalid = client.send(
                    HttpRequest.newBuilder(base.resolve("/api/tasks"))
                            .header("Content-Type", "application/json")
                            .POST(HttpRequest.BodyPublishers.ofString("{\"title\":\"  \"}"))
                            .build(),
                    HttpResponse.BodyHandlers.ofString());
            assertEquals(400, invalid.statusCode());

            HttpResponse<String> unsupported = client.send(
                    HttpRequest.newBuilder(base.resolve("/api/tasks"))
                            .PUT(HttpRequest.BodyPublishers.ofString("{}"))
                            .build(),
                    HttpResponse.BodyHandlers.ofString());
            assertEquals(405, unsupported.statusCode());
        } finally {
            server.stop(0);
        }
    }
}
