/**
 * Java 11 HTTP Client - Modern HTTP Client API Tutorial
 * 
 * This comprehensive tutorial demonstrates the new HTTP Client API introduced in Java 11,
 * which provides a modern, flexible, and easy-to-use way to send HTTP requests and
 * handle responses. The HTTP Client supports both synchronous and asynchronous operations,
 * HTTP/2, WebSocket, and various authentication mechanisms.
 * 
 * LEARNING OBJECTIVES:
 * - Understand the new HTTP Client API and its benefits
 * - Learn how to send GET, POST, PUT, DELETE requests
 * - Master synchronous and asynchronous HTTP operations
 * - Understand HTTP/2 support and performance benefits
 * - Learn how to handle authentication and headers
 * - Practice error handling and response processing
 * - Master advanced features like WebSocket and streaming
 * 
 * KEY CONCEPTS:
 * 1. HttpClient: Main client for sending HTTP requests
 * 2. HttpRequest: Represents an HTTP request with method, URI, headers
 * 3. HttpResponse: Contains response data, status, headers
 * 4. BodyHandlers: Process response bodies (String, byte[], InputStream)
 * 5. BodyPublishers: Create request bodies from various sources
 * 6. Asynchronous Operations: Non-blocking HTTP operations
 * 7. HTTP/2 Support: Modern protocol with multiplexing
 * 8. Authentication: Basic, Digest, and custom authentication
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
import java.net.http.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.List;
import java.util.Map;

public class HttpClientDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Java 11 HTTP Client Tutorial ===");
        System.out.println();
        
        try {
            // 1. Introduction to HTTP Client
            demonstrateHttpClientIntroduction();
            
            // 2. Basic HTTP operations
            demonstrateBasicHttpOperations();
            
            // 3. Asynchronous operations
            demonstrateAsynchronousOperations();
            
            // 4. Request and response handling
            demonstrateRequestResponseHandling();
            
            // 5. Authentication and headers
            demonstrateAuthenticationAndHeaders();
            
            // 6. Error handling and best practices
            demonstrateErrorHandlingAndBestPractices();
            
        } catch (Exception e) {
            System.err.println("Error in HTTP Client demo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Introduction to HTTP Client and its benefits
     */
    private static void demonstrateHttpClientIntroduction() {
        System.out.println("1. HTTP Client Introduction:");
        System.out.println("===========================");
        
        System.out.println("Java 11 HTTP Client provides:");
        System.out.println("✓ Modern, easy-to-use API");
        System.out.println("✓ Built-in HTTP/2 support");
        System.out.println("✓ Asynchronous operations");
        System.out.println("✓ WebSocket support");
        System.out.println("✓ Connection pooling");
        System.out.println("✓ Request/response interceptors");
        System.out.println("✓ Better performance than HttpURLConnection");
        
        System.out.println("\nKey Components:");
        System.out.println("• HttpClient: Main client for sending requests");
        System.out.println("• HttpRequest: Represents HTTP request");
        System.out.println("• HttpResponse: Contains response data");
        System.out.println("• BodyHandlers: Process response bodies");
        System.out.println("• BodyPublishers: Create request bodies");
        
        System.out.println("\nHTTP/2 Benefits:");
        System.out.println("• Multiplexing: Multiple requests over single connection");
        System.out.println("• Server push: Server can push resources proactively");
        System.out.println("• Header compression: Reduces overhead");
        System.out.println("• Binary protocol: More efficient than HTTP/1.1");
        
        System.out.println();
    }
    
    /**
     * Demonstrates basic HTTP operations (GET, POST, PUT, DELETE)
     */
    private static void demonstrateBasicHttpOperations() throws Exception {
        System.out.println("2. Basic HTTP Operations:");
        System.out.println("========================");
        
        // Create HTTP client
        HttpClient client = HttpClient.newHttpClient();
        
        // GET request
        System.out.println("GET Request:");
        HttpRequest getRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/get"))
            .GET()
            .build();
        
        HttpResponse<String> getResponse = client.send(getRequest, 
            HttpResponse.BodyHandlers.ofString());
        
        System.out.println("Status: " + getResponse.statusCode());
        System.out.println("Response: " + getResponse.body().substring(0, 100) + "...");
        
        // POST request
        System.out.println("\nPOST Request:");
        String postData = "{\"name\":\"Java\",\"version\":\"11\"}";
        HttpRequest postRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/post"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(postData))
            .build();
        
        HttpResponse<String> postResponse = client.send(postRequest, 
            HttpResponse.BodyHandlers.ofString());
        
        System.out.println("Status: " + postResponse.statusCode());
        System.out.println("Response: " + postResponse.body().substring(0, 100) + "...");
        
        // PUT request
        System.out.println("\nPUT Request:");
        String putData = "{\"id\":1,\"name\":\"Updated Java\"}";
        HttpRequest putRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/put"))
            .header("Content-Type", "application/json")
            .PUT(HttpRequest.BodyPublishers.ofString(putData))
            .build();
        
        HttpResponse<String> putResponse = client.send(putRequest, 
            HttpResponse.BodyHandlers.ofString());
        
        System.out.println("Status: " + putResponse.statusCode());
        System.out.println("Response: " + putResponse.body().substring(0, 100) + "...");
        
        // DELETE request
        System.out.println("\nDELETE Request:");
        HttpRequest deleteRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/delete"))
            .DELETE()
            .build();
        
        HttpResponse<String> deleteResponse = client.send(deleteRequest, 
            HttpResponse.BodyHandlers.ofString());
        
        System.out.println("Status: " + deleteResponse.statusCode());
        System.out.println("Response: " + deleteResponse.body().substring(0, 100) + "...");
        
        System.out.println();
    }
    
    /**
     * Demonstrates asynchronous HTTP operations
     */
    private static void demonstrateAsynchronousOperations() throws Exception {
        System.out.println("3. Asynchronous Operations:");
        System.out.println("==========================");
        
        HttpClient client = HttpClient.newHttpClient();
        
        // Asynchronous GET request
        System.out.println("Asynchronous GET Request:");
        HttpRequest asyncRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/delay/1"))
            .GET()
            .build();
        
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(
            asyncRequest, HttpResponse.BodyHandlers.ofString());
        
        System.out.println("Request sent asynchronously...");
        
        // Do other work while request is processing
        System.out.println("Doing other work...");
        Thread.sleep(500);
        System.out.println("Still working...");
        
        // Get the result
        HttpResponse<String> response = future.get();
        System.out.println("Async response received!");
        System.out.println("Status: " + response.statusCode());
        System.out.println("Response: " + response.body().substring(0, 100) + "...");
        
        // Multiple asynchronous requests
        System.out.println("\nMultiple Asynchronous Requests:");
        List<String> urls = List.of(
            "https://httpbin.org/delay/1",
            "https://httpbin.org/delay/2",
            "https://httpbin.org/delay/1"
        );
        
        List<CompletableFuture<HttpResponse<String>>> futures = urls.stream()
            .map(url -> HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build())
            .map(request -> client.sendAsync(request, HttpResponse.BodyHandlers.ofString()))
            .toList();
        
        System.out.println("Sent " + futures.size() + " async requests");
        
        // Wait for all requests to complete
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
            futures.toArray(new CompletableFuture[0]));
        
        allFutures.get(); // Wait for all to complete
        
        System.out.println("All requests completed!");
        for (int i = 0; i < futures.size(); i++) {
            HttpResponse<String> resp = futures.get(i).get();
            System.out.println("Request " + (i + 1) + " status: " + resp.statusCode());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates request and response handling
     */
    private static void demonstrateRequestResponseHandling() throws Exception {
        System.out.println("4. Request and Response Handling:");
        System.out.println("================================");
        
        HttpClient client = HttpClient.newHttpClient();
        
        // Custom headers
        System.out.println("Request with Custom Headers:");
        HttpRequest requestWithHeaders = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/headers"))
            .header("User-Agent", "Java-11-HTTP-Client")
            .header("Accept", "application/json")
            .header("X-Custom-Header", "CustomValue")
            .GET()
            .build();
        
        HttpResponse<String> response = client.send(requestWithHeaders, 
            HttpResponse.BodyHandlers.ofString());
        
        System.out.println("Status: " + response.statusCode());
        System.out.println("Response Headers:");
        response.headers().map().forEach((key, values) -> 
            System.out.println("  " + key + ": " + values));
        
        // Different response body handlers
        System.out.println("\nDifferent Response Body Handlers:");
        
        // String handler
        HttpRequest stringRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/json"))
            .GET()
            .build();
        
        HttpResponse<String> stringResponse = client.send(stringRequest, 
            HttpResponse.BodyHandlers.ofString());
        System.out.println("String response length: " + stringResponse.body().length());
        
        // Byte array handler
        HttpRequest bytesRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/json"))
            .GET()
            .build();
        
        HttpResponse<byte[]> bytesResponse = client.send(bytesRequest, 
            HttpResponse.BodyHandlers.ofByteArray());
        System.out.println("Byte array response length: " + bytesResponse.body().length);
        
        // File handler (save to file)
        System.out.println("\nSaving response to file:");
        HttpRequest fileRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/json"))
            .GET()
            .build();
        
        try {
            HttpResponse<java.nio.file.Path> fileResponse = client.send(fileRequest, 
                HttpResponse.BodyHandlers.ofFile(java.nio.file.Path.of("response.json")));
            System.out.println("File saved to: " + fileResponse.body());
        } catch (Exception e) {
            System.out.println("File save failed: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates authentication and advanced headers
     */
    private static void demonstrateAuthenticationAndHeaders() throws Exception {
        System.out.println("5. Authentication and Headers:");
        System.out.println("=============================");
        
        // Basic authentication
        System.out.println("Basic Authentication:");
        HttpClient client = HttpClient.newBuilder()
            .authenticator(new java.net.Authenticator() {
                @Override
                protected java.net.PasswordAuthentication getPasswordAuthentication() {
                    return new java.net.PasswordAuthentication("user", "pass".toCharArray());
                }
            })
            .build();
        
        HttpRequest authRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/basic-auth/user/pass"))
            .GET()
            .build();
        
        HttpResponse<String> authResponse = client.send(authRequest, 
            HttpResponse.BodyHandlers.ofString());
        System.out.println("Auth status: " + authResponse.statusCode());
        System.out.println("Auth response: " + authResponse.body());
        
        // Custom authentication header
        System.out.println("\nCustom Authentication Header:");
        HttpClient simpleClient = HttpClient.newHttpClient();
        
        HttpRequest customAuthRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/headers"))
            .header("Authorization", "Bearer your-token-here")
            .header("X-API-Key", "your-api-key")
            .GET()
            .build();
        
        HttpResponse<String> customAuthResponse = simpleClient.send(customAuthRequest, 
            HttpResponse.BodyHandlers.ofString());
        System.out.println("Custom auth status: " + customAuthResponse.statusCode());
        System.out.println("Custom auth response: " + customAuthResponse.body().substring(0, 200) + "...");
        
        // Request timeout
        System.out.println("\nRequest Timeout:");
        HttpRequest timeoutRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/delay/5"))
            .timeout(Duration.ofSeconds(2))
            .GET()
            .build();
        
        try {
            HttpResponse<String> timeoutResponse = simpleClient.send(timeoutRequest, 
                HttpResponse.BodyHandlers.ofString());
            System.out.println("Timeout response: " + timeoutResponse.statusCode());
        } catch (java.net.http.HttpTimeoutException e) {
            System.out.println("Request timed out as expected: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates error handling and best practices
     */
    private static void demonstrateErrorHandlingAndBestPractices() throws Exception {
        System.out.println("6. Error Handling and Best Practices:");
        System.out.println("====================================");
        
        HttpClient client = HttpClient.newHttpClient();
        
        // Error handling
        System.out.println("Error Handling:");
        HttpRequest errorRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/status/404"))
            .GET()
            .build();
        
        try {
            HttpResponse<String> errorResponse = client.send(errorRequest, 
                HttpResponse.BodyHandlers.ofString());
            System.out.println("Error status: " + errorResponse.statusCode());
            System.out.println("Error response: " + errorResponse.body());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
        
        // Best practices
        System.out.println("\nBest Practices:");
        System.out.println("✓ Reuse HttpClient instances (they are thread-safe)");
        System.out.println("✓ Use appropriate timeouts for requests");
        System.out.println("✓ Handle HTTP status codes properly");
        System.out.println("✓ Use appropriate body handlers for response types");
        System.out.println("✓ Consider using async operations for better performance");
        System.out.println("✓ Implement proper error handling and retry logic");
        System.out.println("✓ Use connection pooling for multiple requests");
        
        // HTTP/2 configuration
        System.out.println("\nHTTP/2 Configuration:");
        HttpClient http2Client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
        
        HttpRequest http2Request = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/get"))
            .GET()
            .build();
        
        HttpResponse<String> http2Response = http2Client.send(http2Request, 
            HttpResponse.BodyHandlers.ofString());
        System.out.println("HTTP/2 response status: " + http2Response.statusCode());
        System.out.println("HTTP version: " + http2Response.version());
        
        System.out.println("\nPerformance Tips:");
        System.out.println("• Use HTTP/2 for better multiplexing");
        System.out.println("• Implement connection pooling");
        System.out.println("• Use async operations for I/O bound tasks");
        System.out.println("• Cache responses when appropriate");
        System.out.println("• Monitor and log request/response times");
        
        System.out.println();
    }
}

/**
 * HTTP Client Utility Class
 * 
 * This utility class provides helper methods for common HTTP operations
 * using the Java 11 HTTP Client API.
 */
class HttpClientUtils {
    
    /**
     * Send a simple GET request and return the response body as String
     */
    public static String get(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();
        
        HttpResponse<String> response = client.send(request, 
            HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            return response.body();
        } else {
            throw new RuntimeException("HTTP error: " + response.statusCode());
        }
    }
    
    /**
     * Send a POST request with JSON body
     */
    public static String postJson(String url, String jsonBody) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();
        
        HttpResponse<String> response = client.send(request, 
            HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            return response.body();
        } else {
            throw new RuntimeException("HTTP error: " + response.statusCode());
        }
    }
    
    /**
     * Send an asynchronous GET request
     */
    public static CompletableFuture<String> getAsync(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();
        
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(response -> {
                if (response.statusCode() >= 200 && response.statusCode() < 300) {
                    return response.body();
                } else {
                    throw new RuntimeException("HTTP error: " + response.statusCode());
                }
            });
    }
}
