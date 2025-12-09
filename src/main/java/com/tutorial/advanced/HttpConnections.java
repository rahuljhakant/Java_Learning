package com.tutorial.advanced;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * HTTP Connections - RESTful API Communication
 * 
 * This comprehensive tutorial demonstrates HTTP connections in Java,
 * including RESTful API communication, HTTP methods, headers,
 * and web service integration.
 * 
 * LEARNING OBJECTIVES:
 * - Implement HTTP client connections
 * - Use different HTTP methods (GET, POST, PUT, DELETE)
 * - Handle HTTP headers and responses
 * - Work with RESTful APIs
 * - Implement error handling for HTTP operations
 * - Apply HTTP communication best practices
 * 
 * KEY CONCEPTS:
 * 1. HTTP Methods: GET, POST, PUT, DELETE operations
 * 2. HTTP Headers: Request and response headers
 * 3. RESTful APIs: Representational State Transfer
 * 4. JSON Communication: Data exchange format
 * 5. Error Handling: HTTP status codes and exceptions
 * 6. Best Practices: Secure and efficient HTTP communication
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class HttpConnections {
    
    public static void main(String[] args) {
        System.out.println("=== HTTP Connections Demo ===");
        System.out.println();
        
        // 1. Basic HTTP GET Request
        demonstrateHttpGetRequest();
        
        // 2. HTTP POST Request
        demonstrateHttpPostRequest();
        
        // 3. HTTP PUT Request
        demonstrateHttpPutRequest();
        
        // 4. HTTP DELETE Request
        demonstrateHttpDeleteRequest();
        
        // 5. HTTP Headers
        demonstrateHttpHeaders();
        
        // 6. Error Handling
        demonstrateErrorHandling();
        
        // 7. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates HTTP GET request
     */
    private static void demonstrateHttpGetRequest() {
        System.out.println("1. HTTP GET Request:");
        System.out.println("===================");
        
        try {
            URL url = new URL("https://httpbin.org/get");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set request method
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Java HTTP Client");
            
            // Get response
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                System.out.println("Response: " + response.toString());
            }
            
            connection.disconnect();
            
        } catch (IOException e) {
            System.err.println("HTTP GET error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates HTTP POST request
     */
    private static void demonstrateHttpPostRequest() {
        System.out.println("2. HTTP POST Request:");
        System.out.println("====================");
        
        try {
            URL url = new URL("https://httpbin.org/post");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set request method and properties
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("User-Agent", "Java HTTP Client");
            connection.setDoOutput(true);
            
            // Prepare request body
            String requestBody = "{\"name\":\"John Doe\",\"email\":\"john@example.com\"}";
            
            // Send request
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            
            // Get response
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                System.out.println("Response: " + response.toString());
            }
            
            connection.disconnect();
            
        } catch (IOException e) {
            System.err.println("HTTP POST error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates HTTP PUT request
     */
    private static void demonstrateHttpPutRequest() {
        System.out.println("3. HTTP PUT Request:");
        System.out.println("===================");
        
        try {
            URL url = new URL("https://httpbin.org/put");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set request method and properties
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("User-Agent", "Java HTTP Client");
            connection.setDoOutput(true);
            
            // Prepare request body
            String requestBody = "{\"id\":1,\"name\":\"Jane Doe\",\"email\":\"jane@example.com\"}";
            
            // Send request
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            
            // Get response
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                System.out.println("Response: " + response.toString());
            }
            
            connection.disconnect();
            
        } catch (IOException e) {
            System.err.println("HTTP PUT error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates HTTP DELETE request
     */
    private static void demonstrateHttpDeleteRequest() {
        System.out.println("4. HTTP DELETE Request:");
        System.out.println("======================");
        
        try {
            URL url = new URL("https://httpbin.org/delete");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set request method
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("User-Agent", "Java HTTP Client");
            
            // Get response
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                System.out.println("Response: " + response.toString());
            }
            
            connection.disconnect();
            
        } catch (IOException e) {
            System.err.println("HTTP DELETE error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates HTTP headers
     */
    private static void demonstrateHttpHeaders() {
        System.out.println("5. HTTP Headers:");
        System.out.println("===============");
        
        try {
            URL url = new URL("https://httpbin.org/headers");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set custom headers
            connection.setRequestProperty("User-Agent", "Java HTTP Client");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer token123");
            connection.setRequestProperty("X-Custom-Header", "Custom Value");
            
            // Get response
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Print response headers
                Map<String, List<String>> headers = connection.getHeaderFields();
                System.out.println("Response Headers:");
                for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                    System.out.println("  " + entry.getKey() + ": " + entry.getValue());
                }
                
                // Print response body
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                System.out.println("Response Body: " + response.toString());
            }
            
            connection.disconnect();
            
        } catch (IOException e) {
            System.err.println("HTTP Headers error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates error handling
     */
    private static void demonstrateErrorHandling() {
        System.out.println("6. Error Handling:");
        System.out.println("=================");
        
        // Handle different HTTP status codes
        try {
            URL url = new URL("https://httpbin.org/status/404");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            if (responseCode >= 200 && responseCode < 300) {
                System.out.println("Success: " + responseCode);
            } else if (responseCode >= 300 && responseCode < 400) {
                System.out.println("Redirection: " + responseCode);
            } else if (responseCode >= 400 && responseCode < 500) {
                System.out.println("Client Error: " + responseCode);
            } else if (responseCode >= 500) {
                System.out.println("Server Error: " + responseCode);
            }
            
            connection.disconnect();
            
        } catch (IOException e) {
            System.err.println("HTTP Error handling: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("7. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use appropriate HTTP methods for operations");
        System.out.println("✓ Set proper Content-Type headers");
        System.out.println("✓ Handle different HTTP status codes");
        System.out.println("✓ Implement proper error handling");
        System.out.println("✓ Use HTTPS for secure communication");
        System.out.println("✓ Implement authentication and authorization");
        System.out.println("✓ Use connection pooling for better performance");
        System.out.println("✓ Set appropriate timeouts");
        System.out.println("✓ Validate input data before sending");
        System.out.println("✓ Use proper logging for debugging");
        System.out.println("✓ Implement retry logic for failed requests");
        System.out.println("✓ Use appropriate buffer sizes");
        System.out.println("✓ Consider using HTTP/2 for better performance");
        
        System.out.println();
    }
}
