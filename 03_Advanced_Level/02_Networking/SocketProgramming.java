package com.tutorial.advanced.networking;

import java.io.*;
import java.net.*;

/**
 * Socket Programming - TCP/UDP Communication
 * 
 * This comprehensive tutorial demonstrates socket programming in Java,
 * including TCP and UDP communication, client-server architecture,
 * and network programming best practices.
 * 
 * LEARNING OBJECTIVES:
 * - Implement TCP client-server communication
 * - Use UDP for datagram communication
 * - Handle network connections and data transfer
 * - Apply socket programming best practices
 * - Implement error handling for network operations
 * - Build real-world network applications
 * 
 * KEY CONCEPTS:
 * 1. TCP Sockets: Reliable, connection-oriented communication
 * 2. UDP Sockets: Fast, connectionless communication
 * 3. Client-Server Architecture: Network application design
 * 4. Data Transfer: Sending and receiving data over network
 * 5. Error Handling: Network exception management
 * 6. Best Practices: Secure and efficient network programming
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class SocketProgramming {
    
    public static void main(String[] args) {
        System.out.println("=== Socket Programming Demo ===");
        System.out.println();
        
        // 1. TCP Socket Programming
        demonstrateTCPSockets();
        
        // 2. UDP Socket Programming
        demonstrateUDPSockets();
        
        // 3. Client-Server Communication
        demonstrateClientServerCommunication();
        
        // 4. Error Handling
        demonstrateErrorHandling();
        
        // 5. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates TCP socket programming
     */
    private static void demonstrateTCPSockets() {
        System.out.println("1. TCP Socket Programming:");
        System.out.println("=========================");
        
        // TCP Server
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(8080)) {
                System.out.println("TCP Server started on port 8080");
                
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                
                // Send data to client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Hello from TCP Server!");
                
                // Receive data from client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message = in.readLine();
                System.out.println("Received from client: " + message);
                
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("TCP Server error: " + e.getMessage());
            }
        }).start();
        
        // Wait for server to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // TCP Client
        try (Socket clientSocket = new Socket("localhost", 8080)) {
            System.out.println("TCP Client connected to server");
            
            // Send data to server
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello from TCP Client!");
            
            // Receive data from server
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println("Received from server: " + message);
            
        } catch (IOException e) {
            System.err.println("TCP Client error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates UDP socket programming
     */
    private static void demonstrateUDPSockets() {
        System.out.println("2. UDP Socket Programming:");
        System.out.println("=========================");
        
        // UDP Server
        new Thread(() -> {
            try (DatagramSocket serverSocket = new DatagramSocket(8081)) {
                System.out.println("UDP Server started on port 8081");
                
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                
                serverSocket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("UDP Server received: " + message);
                
                // Send response
                String response = "Hello from UDP Server!";
                byte[] responseData = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(
                    responseData, responseData.length, packet.getAddress(), packet.getPort());
                serverSocket.send(responsePacket);
                
            } catch (IOException e) {
                System.err.println("UDP Server error: " + e.getMessage());
            }
        }).start();
        
        // Wait for server to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // UDP Client
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            System.out.println("UDP Client created");
            
            // Send data to server
            String message = "Hello from UDP Client!";
            byte[] data = message.getBytes();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, 8081);
            clientSocket.send(packet);
            
            // Receive response from server
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("UDP Client received: " + response);
            
        } catch (IOException e) {
            System.err.println("UDP Client error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates client-server communication
     */
    private static void demonstrateClientServerCommunication() {
        System.out.println("3. Client-Server Communication:");
        System.out.println("==============================");
        
        // Multi-threaded TCP Server
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(8082)) {
                System.out.println("Multi-threaded TCP Server started on port 8082");
                
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    new Thread(() -> handleClient(clientSocket)).start();
                }
            } catch (IOException e) {
                System.err.println("Multi-threaded TCP Server error: " + e.getMessage());
            }
        }).start();
        
        // Wait for server to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Multiple clients
        for (int i = 0; i < 3; i++) {
            final int clientId = i;
            new Thread(() -> {
                try (Socket clientSocket = new Socket("localhost", 8082)) {
                    System.out.println("Client " + clientId + " connected");
                    
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println("Hello from Client " + clientId);
                    
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String response = in.readLine();
                    System.out.println("Client " + clientId + " received: " + response);
                    
                } catch (IOException e) {
                    System.err.println("Client " + clientId + " error: " + e.getMessage());
                }
            }).start();
        }
        
        System.out.println();
    }
    
    /**
     * Handles individual client connections
     */
    private static void handleClient(Socket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            String message = in.readLine();
            System.out.println("Server received: " + message);
            
            out.println("Echo: " + message);
            
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates error handling
     */
    private static void demonstrateErrorHandling() {
        System.out.println("4. Error Handling:");
        System.out.println("=================");
        
        // Connection timeout
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", 9999), 1000);
        } catch (IOException e) {
            System.out.println("Connection timeout handled: " + e.getMessage());
        }
        
        // Port already in use
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Port 8080 is available");
        } catch (IOException e) {
            System.out.println("Port already in use: " + e.getMessage());
        }
        
        // Invalid host
        try (Socket socket = new Socket("invalid-host", 8080)) {
            System.out.println("Connected to invalid host");
        } catch (IOException e) {
            System.out.println("Invalid host handled: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("5. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use try-with-resources for automatic resource management");
        System.out.println("✓ Handle network exceptions properly");
        System.out.println("✓ Use appropriate timeouts for connections");
        System.out.println("✓ Implement proper error handling and logging");
        System.out.println("✓ Use thread pools for handling multiple clients");
        System.out.println("✓ Validate input data from network");
        System.out.println("✓ Use secure protocols (HTTPS, SSL/TLS) for sensitive data");
        System.out.println("✓ Implement proper authentication and authorization");
        System.out.println("✓ Use connection pooling for database connections");
        System.out.println("✓ Monitor network performance and resources");
        System.out.println("✓ Implement proper cleanup and resource management");
        System.out.println("✓ Use appropriate buffer sizes for data transfer");
        System.out.println("✓ Consider using NIO for high-performance applications");
        
        System.out.println();
    }
}
