package com.tutorial.advanced.networking;

/**
 * Networking Example - Mastering Java Networking
 * 
 * This comprehensive tutorial demonstrates Java networking capabilities,
 * including both client and server socket programming. Networking is
 * essential for building distributed applications, web services, and
 * communication between different systems.
 * 
 * LEARNING OBJECTIVES:
 * - Understand socket programming fundamentals
 * - Learn how to create client and server applications
 * - Master TCP and UDP communication
 * - Practice with real-world networking examples
 * - Learn about network security and best practices
 * - Understand error handling in networking
 * - Learn about performance optimization
 * 
 * KEY CONCEPTS:
 * 1. Socket Programming: Basic client-server communication
 * 2. TCP Sockets: Reliable, connection-oriented communication
 * 3. UDP Sockets: Fast, connectionless communication
 * 4. Server Sockets: Accepting client connections
 * 5. Client Sockets: Connecting to servers
 * 6. Data Transmission: Sending and receiving data
 * 7. Error Handling: Network exception handling
 * 8. Security: Network security considerations
 * 
 * @author [Your Name]
 * @version 1.0
 * @since 2024
 */
public class NetworkingExample {
    
    public static void main(String[] args) {
        System.out.println("=== Networking Example ===");
        System.out.println();
        
        // 1. Basic TCP Client-Server
        demonstrateBasicTCPClientServer();
        
        // 2. UDP Communication
        demonstrateUDPCommunication();
        
        // 3. Multi-threaded Server
        demonstrateMultiThreadedServer();
        
        // 4. HTTP Client
        demonstrateHTTPClient();
        
        // 5. Network Utilities
        demonstrateNetworkUtilities();
        
        // 6. Error Handling
        demonstrateErrorHandling();
        
        // 7. Real-world Examples
        demonstrateRealWorldExamples();
        
        // 8. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates basic TCP client-server communication
     */
    private static void demonstrateBasicTCPClientServer() {
        System.out.println("1. Basic TCP Client-Server:");
        System.out.println("===========================");
        
        // Start server in a separate thread
        Thread serverThread = new Thread(() -> {
            try {
                startTCPServer();
            } catch (Exception e) {
                System.err.println("Server error: " + e.getMessage());
            }
        });
        serverThread.start();
        
        // Wait for server to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Start client
        try {
            startTCPClient();
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Starts a basic TCP server
     */
    private static void startTCPServer() throws Exception {
        System.out.println("Starting TCP Server on port 8080...");
        
        try (java.net.ServerSocket serverSocket = new java.net.ServerSocket(8080)) {
            System.out.println("Server listening on port 8080");
            
            // Accept one client connection
            try (java.net.Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                
                // Get input and output streams
                java.io.BufferedReader in = new java.io.BufferedReader(
                    new java.io.InputStreamReader(clientSocket.getInputStream()));
                java.io.PrintWriter out = new java.io.PrintWriter(
                    clientSocket.getOutputStream(), true);
                
                // Read client message
                String clientMessage = in.readLine();
                System.out.println("Received from client: " + clientMessage);
                
                // Send response
                String response = "Hello from server!";
                out.println(response);
                System.out.println("Sent to client: " + response);
                
            } catch (Exception e) {
                System.err.println("Client connection error: " + e.getMessage());
            }
        }
    }
    
    /**
     * Starts a basic TCP client
     */
    private static void startTCPClient() throws Exception {
        System.out.println("Starting TCP Client...");
        
        try (java.net.Socket socket = new java.net.Socket("localhost", 8080)) {
            System.out.println("Connected to server");
            
            // Get input and output streams
            java.io.PrintWriter out = new java.io.PrintWriter(socket.getOutputStream(), true);
            java.io.BufferedReader in = new java.io.BufferedReader(
                new java.io.InputStreamReader(socket.getInputStream()));
            
            // Send message to server
            String message = "Hello from client!";
            out.println(message);
            System.out.println("Sent to server: " + message);
            
            // Read server response
            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);
            
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates UDP communication
     */
    private static void demonstrateUDPCommunication() {
        System.out.println("2. UDP Communication:");
        System.out.println("====================");
        
        // Start UDP server in a separate thread
        Thread serverThread = new Thread(() -> {
            try {
                startUDPServer();
            } catch (Exception e) {
                System.err.println("UDP Server error: " + e.getMessage());
            }
        });
        serverThread.start();
        
        // Wait for server to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Start UDP client
        try {
            startUDPClient();
        } catch (Exception e) {
            System.err.println("UDP Client error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Starts a UDP server
     */
    private static void startUDPServer() throws Exception {
        System.out.println("Starting UDP Server on port 8081...");
        
        try (java.net.DatagramSocket socket = new java.net.DatagramSocket(8081)) {
            System.out.println("UDP Server listening on port 8081");
            
            // Create buffer for receiving data
            byte[] buffer = new byte[1024];
            java.net.DatagramPacket packet = new java.net.DatagramPacket(buffer, buffer.length);
            
            // Receive packet
            socket.receive(packet);
            String receivedData = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received from client: " + receivedData);
            
            // Send response
            String response = "Hello from UDP server!";
            byte[] responseData = response.getBytes();
            java.net.DatagramPacket responsePacket = new java.net.DatagramPacket(
                responseData, responseData.length, packet.getAddress(), packet.getPort());
            socket.send(responsePacket);
            System.out.println("Sent to client: " + response);
            
        } catch (Exception e) {
            System.err.println("UDP Server error: " + e.getMessage());
        }
    }
    
    /**
     * Starts a UDP client
     */
    private static void startUDPClient() throws Exception {
        System.out.println("Starting UDP Client...");
        
        try (java.net.DatagramSocket socket = new java.net.DatagramSocket()) {
            System.out.println("UDP Client started");
            
            // Prepare message
            String message = "Hello from UDP client!";
            byte[] messageData = message.getBytes();
            java.net.InetAddress serverAddress = java.net.InetAddress.getByName("localhost");
            
            // Send packet
            java.net.DatagramPacket packet = new java.net.DatagramPacket(
                messageData, messageData.length, serverAddress, 8081);
            socket.send(packet);
            System.out.println("Sent to server: " + message);
            
            // Receive response
            byte[] buffer = new byte[1024];
            java.net.DatagramPacket responsePacket = new java.net.DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Received from server: " + response);
            
        } catch (Exception e) {
            System.err.println("UDP Client error: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates multi-threaded server
     */
    private static void demonstrateMultiThreadedServer() {
        System.out.println("3. Multi-threaded Server:");
        System.out.println("========================");
        
        // Start multi-threaded server
        Thread serverThread = new Thread(() -> {
            try {
                startMultiThreadedServer();
            } catch (Exception e) {
                System.err.println("Multi-threaded server error: " + e.getMessage());
            }
        });
        serverThread.start();
        
        // Wait for server to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Start multiple clients
        for (int i = 0; i < 3; i++) {
            final int clientId = i + 1;
            Thread clientThread = new Thread(() -> {
                try {
                    startMultiThreadedClient(clientId);
                } catch (Exception e) {
                    System.err.println("Client " + clientId + " error: " + e.getMessage());
                }
            });
            clientThread.start();
        }
        
        // Wait for clients to complete
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println();
    }
    
    /**
     * Starts a multi-threaded server
     */
    private static void startMultiThreadedServer() throws Exception {
        System.out.println("Starting Multi-threaded Server on port 8082...");
        
        try (java.net.ServerSocket serverSocket = new java.net.ServerSocket(8082)) {
            System.out.println("Multi-threaded server listening on port 8082");
            
            // Accept multiple client connections
            for (int i = 0; i < 3; i++) {
                java.net.Socket clientSocket = serverSocket.accept();
                System.out.println("Client " + (i + 1) + " connected: " + clientSocket.getInetAddress());
                
                // Handle each client in a separate thread
                Thread clientHandler = new Thread(() -> {
                    try (java.net.Socket socket = clientSocket) {
                        java.io.BufferedReader in = new java.io.BufferedReader(
                            new java.io.InputStreamReader(socket.getInputStream()));
                        java.io.PrintWriter out = new java.io.PrintWriter(
                            socket.getOutputStream(), true);
                        
                        String clientMessage = in.readLine();
                        System.out.println("Received from client: " + clientMessage);
                        
                        String response = "Hello from multi-threaded server!";
                        out.println(response);
                        System.out.println("Sent to client: " + response);
                        
                    } catch (Exception e) {
                        System.err.println("Client handler error: " + e.getMessage());
                    }
                });
                clientHandler.start();
            }
        }
    }
    
    /**
     * Starts a multi-threaded client
     */
    private static void startMultiThreadedClient(int clientId) throws Exception {
        System.out.println("Starting Client " + clientId + "...");
        
        try (java.net.Socket socket = new java.net.Socket("localhost", 8082)) {
            System.out.println("Client " + clientId + " connected to server");
            
            java.io.PrintWriter out = new java.io.PrintWriter(socket.getOutputStream(), true);
            java.io.BufferedReader in = new java.io.BufferedReader(
                new java.io.InputStreamReader(socket.getInputStream()));
            
            String message = "Hello from client " + clientId + "!";
            out.println(message);
            System.out.println("Client " + clientId + " sent: " + message);
            
            String serverResponse = in.readLine();
            System.out.println("Client " + clientId + " received: " + serverResponse);
            
        } catch (Exception e) {
            System.err.println("Client " + clientId + " error: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates HTTP client
     */
    private static void demonstrateHTTPClient() {
        System.out.println("4. HTTP Client:");
        System.out.println("==============");
        
        try {
            // Create HTTP connection
            java.net.URL url = new java.net.URL("https://httpbin.org/get");
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
            
            // Set request method
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Java HTTP Client");
            
            // Get response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            // Read response
            if (responseCode == 200) {
                java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }
                reader.close();
                System.out.println("Response: " + response.toString());
            }
            
            connection.disconnect();
            
        } catch (Exception e) {
            System.err.println("HTTP Client error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates network utilities
     */
    private static void demonstrateNetworkUtilities() {
        System.out.println("5. Network Utilities:");
        System.out.println("====================");
        
        try {
            // Get local host information
            java.net.InetAddress localHost = java.net.InetAddress.getLocalHost();
            System.out.println("Local Host: " + localHost.getHostName());
            System.out.println("Local IP: " + localHost.getHostAddress());
            
            // Get host information by name
            java.net.InetAddress googleHost = java.net.InetAddress.getByName("www.google.com");
            System.out.println("Google Host: " + googleHost.getHostName());
            System.out.println("Google IP: " + googleHost.getHostAddress());
            
            // Check if host is reachable
            boolean isReachable = googleHost.isReachable(5000);
            System.out.println("Google is reachable: " + isReachable);
            
            // Get all IP addresses for a host
            java.net.InetAddress[] allAddresses = java.net.InetAddress.getAllByName("www.google.com");
            System.out.println("All Google IPs:");
            for (java.net.InetAddress address : allAddresses) {
                System.out.println("  " + address.getHostAddress());
            }
            
        } catch (Exception e) {
            System.err.println("Network utilities error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates error handling
     */
    private static void demonstrateErrorHandling() {
        System.out.println("6. Error Handling:");
        System.out.println("=================");
        
        // Test connection to non-existent server
        try {
            java.net.Socket socket = new java.net.Socket("nonexistent.server.com", 80);
            socket.close();
        } catch (java.net.UnknownHostException e) {
            System.err.println("Unknown host error: " + e.getMessage());
        } catch (java.io.IOException e) {
            System.err.println("IO error: " + e.getMessage());
        }
        
        // Test connection to unreachable port
        try {
            java.net.Socket socket = new java.net.Socket("localhost", 9999);
            socket.close();
        } catch (java.io.IOException e) {
            System.err.println("Connection refused: " + e.getMessage());
        }
        
        // Test timeout
        try {
            java.net.Socket socket = new java.net.Socket();
            socket.connect(new java.net.InetSocketAddress("192.168.1.1", 80), 1000);
            socket.close();
        } catch (java.io.IOException e) {
            System.err.println("Timeout error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates real-world examples
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("7. Real-world Examples:");
        System.out.println("======================");
        
        // Example 1: Simple chat server
        System.out.println("Example 1: Simple Chat Server");
        System.out.println("----------------------------");
        
        // Start chat server
        Thread chatServerThread = new Thread(() -> {
            try {
                startChatServer();
            } catch (Exception e) {
                System.err.println("Chat server error: " + e.getMessage());
            }
        });
        chatServerThread.start();
        
        // Wait for server to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Start chat client
        try {
            startChatClient();
        } catch (Exception e) {
            System.err.println("Chat client error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Starts a simple chat server
     */
    private static void startChatServer() throws Exception {
        System.out.println("Starting Chat Server on port 8083...");
        
        try (java.net.ServerSocket serverSocket = new java.net.ServerSocket(8083)) {
            System.out.println("Chat server listening on port 8083");
            
            try (java.net.Socket clientSocket = serverSocket.accept()) {
                System.out.println("Chat client connected");
                
                java.io.BufferedReader in = new java.io.BufferedReader(
                    new java.io.InputStreamReader(clientSocket.getInputStream()));
                java.io.PrintWriter out = new java.io.PrintWriter(
                    clientSocket.getOutputStream(), true);
                
                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Client: " + clientMessage);
                    
                    if (clientMessage.equals("bye")) {
                        out.println("Goodbye!");
                        break;
                    }
                    
                    String response = "Server: " + clientMessage.toUpperCase();
                    out.println(response);
                }
            }
        }
    }
    
    /**
     * Starts a simple chat client
     */
    private static void startChatClient() throws Exception {
        System.out.println("Starting Chat Client...");
        
        try (java.net.Socket socket = new java.net.Socket("localhost", 8083)) {
            System.out.println("Connected to chat server");
            
            java.io.PrintWriter out = new java.io.PrintWriter(socket.getOutputStream(), true);
            java.io.BufferedReader in = new java.io.BufferedReader(
                new java.io.InputStreamReader(socket.getInputStream()));
            
            // Send a few messages
            String[] messages = {"Hello", "How are you?", "bye"};
            for (String message : messages) {
                out.println(message);
                System.out.println("Sent: " + message);
                
                String response = in.readLine();
                System.out.println("Received: " + response);
                
                if (message.equals("bye")) {
                    break;
                }
            }
        }
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("8. Best Practices:");
        System.out.println("=================");
        
        System.out.println("Networking Best Practices:");
        System.out.println("------------------------");
        System.out.println("1. Always close sockets and streams properly");
        System.out.println("2. Use try-with-resources for automatic resource management");
        System.out.println("3. Handle network exceptions gracefully");
        System.out.println("4. Set appropriate timeouts for connections");
        System.out.println("5. Use buffered streams for better performance");
        System.out.println("6. Implement proper error handling and logging");
        System.out.println("7. Consider security implications of network communication");
        System.out.println("8. Use connection pooling for high-performance applications");
        
        System.out.println("\nSecurity Considerations:");
        System.out.println("----------------------");
        System.out.println("• Validate all input from network sources");
        System.out.println("• Use encryption for sensitive data transmission");
        System.out.println("• Implement proper authentication and authorization");
        System.out.println("• Be aware of network security vulnerabilities");
        System.out.println("• Use secure protocols (HTTPS, SSL/TLS) when possible");
        
        System.out.println("\nPerformance Tips:");
        System.out.println("---------------");
        System.out.println("• Use connection pooling for database connections");
        System.out.println("• Implement proper caching strategies");
        System.out.println("• Use asynchronous I/O for high-throughput applications");
        System.out.println("• Monitor network performance and optimize accordingly");
        System.out.println("• Consider using NIO for non-blocking I/O operations");
        
        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("• Socket programming enables client-server communication");
        System.out.println("• TCP provides reliable, connection-oriented communication");
        System.out.println("• UDP provides fast, connectionless communication");
        System.out.println("• Multi-threading enables handling multiple clients");
        System.out.println("• HTTP clients can communicate with web services");
        System.out.println("• Proper error handling is essential for robust applications");
        System.out.println("• Security and performance considerations are important");
        System.out.println("• Use best practices for production applications");
    }
}
