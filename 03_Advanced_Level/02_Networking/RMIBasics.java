package com.tutorial.advanced.networking;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

/**
 * RMI Basics - Remote Method Invocation
 * 
 * This comprehensive tutorial demonstrates Java RMI (Remote Method Invocation),
 * including creating remote interfaces, implementing remote objects,
 * and building distributed applications.
 * 
 * LEARNING OBJECTIVES:
 * - Understand RMI architecture and concepts
 * - Create remote interfaces and implementations
 * - Set up RMI registry and services
 * - Handle remote method calls
 * - Apply RMI best practices
 * - Build distributed applications
 * 
 * KEY CONCEPTS:
 * 1. Remote Interface: Defines remote methods
 * 2. Remote Implementation: Implements remote interface
 * 3. RMI Registry: Service registry for remote objects
 * 4. Stub and Skeleton: Client and server proxies
 * 5. Serialization: Object transmission over network
 * 6. Best Practices: Secure and efficient RMI usage
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class RMIBasics {
    
    public static void main(String[] args) {
        System.out.println("=== RMI Basics Demo ===");
        System.out.println();
        
        // 1. RMI Architecture Overview
        demonstrateRMIArchitecture();
        
        // 2. Remote Interface Definition
        demonstrateRemoteInterface();
        
        // 3. Remote Implementation
        demonstrateRemoteImplementation();
        
        // 4. RMI Registry
        demonstrateRMIRegistry();
        
        // 5. Client-Server Communication
        demonstrateClientServerCommunication();
        
        // 6. Error Handling
        demonstrateErrorHandling();
        
        // 7. Best Practices
        demonstrateBestPractices();
    }
    
    /**
     * Demonstrates RMI architecture
     */
    private static void demonstrateRMIArchitecture() {
        System.out.println("1. RMI Architecture Overview:");
        System.out.println("============================");
        
        System.out.println("RMI Components:");
        System.out.println("• Remote Interface: Defines remote methods");
        System.out.println("• Remote Implementation: Implements remote interface");
        System.out.println("• RMI Registry: Service registry for remote objects");
        System.out.println("• Stub: Client-side proxy for remote object");
        System.out.println("• Skeleton: Server-side proxy for remote object");
        System.out.println("• RMI Runtime: Handles remote method calls");
        
        System.out.println();
        System.out.println("RMI Process:");
        System.out.println("1. Server creates remote object");
        System.out.println("2. Server registers object with RMI registry");
        System.out.println("3. Client looks up remote object in registry");
        System.out.println("4. Client calls methods on remote object");
        System.out.println("5. RMI runtime handles method invocation");
        
        System.out.println();
    }
    
    /**
     * Demonstrates remote interface definition
     */
    private static void demonstrateRemoteInterface() {
        System.out.println("2. Remote Interface Definition:");
        System.out.println("==============================");
        
        System.out.println("Remote Interface Requirements:");
        System.out.println("• Must extend java.rmi.Remote");
        System.out.println("• All methods must throw RemoteException");
        System.out.println("• Method parameters must be serializable");
        System.out.println("• Method return types must be serializable");
        
        System.out.println();
        System.out.println("Example Remote Interface:");
        System.out.println("public interface Calculator extends Remote {");
        System.out.println("    int add(int a, int b) throws RemoteException;");
        System.out.println("    int subtract(int a, int b) throws RemoteException;");
        System.out.println("    int multiply(int a, int b) throws RemoteException;");
        System.out.println("    int divide(int a, int b) throws RemoteException;");
        System.out.println("}");
        
        System.out.println();
    }
    
    /**
     * Demonstrates remote implementation
     */
    private static void demonstrateRemoteImplementation() {
        System.out.println("3. Remote Implementation:");
        System.out.println("========================");
        
        System.out.println("Remote Implementation Requirements:");
        System.out.println("• Must implement remote interface");
        System.out.println("• Must extend UnicastRemoteObject");
        System.out.println("• Must provide default constructor");
        System.out.println("• Must handle RemoteException");
        
        System.out.println();
        System.out.println("Example Remote Implementation:");
        System.out.println("public class CalculatorImpl extends UnicastRemoteObject implements Calculator {");
        System.out.println("    public CalculatorImpl() throws RemoteException {");
        System.out.println("        super();");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    public int add(int a, int b) throws RemoteException {");
        System.out.println("        return a + b;");
        System.out.println("    }");
        System.out.println("}");
        
        System.out.println();
    }
    
    /**
     * Demonstrates RMI registry
     */
    private static void demonstrateRMIRegistry() {
        System.out.println("4. RMI Registry:");
        System.out.println("===============");
        
        System.out.println("RMI Registry Operations:");
        System.out.println("• Start RMI registry: rmiregistry");
        System.out.println("• Bind remote object: registry.bind(name, remoteObject)");
        System.out.println("• Lookup remote object: registry.lookup(name)");
        System.out.println("• Unbind remote object: registry.unbind(name)");
        System.out.println("• List bound objects: registry.list()");
        
        System.out.println();
        System.out.println("Registry Ports:");
        System.out.println("• Default port: 1099");
        System.out.println("• Custom port: rmiregistry 1098");
        System.out.println("• Programmatic: LocateRegistry.createRegistry(1099)");
        
        System.out.println();
    }
    
    /**
     * Demonstrates client-server communication
     */
    private static void demonstrateClientServerCommunication() {
        System.out.println("5. Client-Server Communication:");
        System.out.println("==============================");
        
        System.out.println("Server Side:");
        System.out.println("1. Create remote object implementation");
        System.out.println("2. Start RMI registry");
        System.out.println("3. Bind remote object to registry");
        System.out.println("4. Wait for client requests");
        
        System.out.println();
        System.out.println("Client Side:");
        System.out.println("1. Look up remote object in registry");
        System.out.println("2. Cast to remote interface type");
        System.out.println("3. Call remote methods");
        System.out.println("4. Handle RemoteException");
        
        System.out.println();
    }
    
    /**
     * Demonstrates error handling
     */
    private static void demonstrateErrorHandling() {
        System.out.println("6. Error Handling:");
        System.out.println("=================");
        
        System.out.println("Common RMI Exceptions:");
        System.out.println("• RemoteException: General remote method call error");
        System.out.println("• NotBoundException: Remote object not found in registry");
        System.out.println("• AlreadyBoundException: Object already bound to name");
        System.out.println("• ConnectException: Cannot connect to remote host");
        System.out.println("• MarshalException: Error marshaling parameters");
        System.out.println("• UnmarshalException: Error unmarshaling parameters");
        
        System.out.println();
        System.out.println("Error Handling Best Practices:");
        System.out.println("• Always handle RemoteException");
        System.out.println("• Implement retry logic for network failures");
        System.out.println("• Use timeouts for remote calls");
        System.out.println("• Log errors for debugging");
        System.out.println("• Implement fallback mechanisms");
        
        System.out.println();
    }
    
    /**
     * Demonstrates best practices
     */
    private static void demonstrateBestPractices() {
        System.out.println("7. Best Practices:");
        System.out.println("=================");
        
        System.out.println("✓ Use meaningful names for remote objects");
        System.out.println("✓ Implement proper error handling");
        System.out.println("✓ Use connection pooling for better performance");
        System.out.println("✓ Implement security policies");
        System.out.println("✓ Use appropriate serialization");
        System.out.println("✓ Monitor RMI registry and objects");
        System.out.println("✓ Implement proper logging");
        System.out.println("✓ Use RMI over SSL for secure communication");
        System.out.println("✓ Implement proper cleanup and resource management");
        System.out.println("✓ Use RMI activation for persistent objects");
        System.out.println("✓ Consider using modern alternatives (REST, gRPC)");
        System.out.println("✓ Test RMI applications thoroughly");
        System.out.println("✓ Use proper exception handling");
        
        System.out.println();
    }
    
    // Example remote interface
    public interface Calculator extends Remote {
        int add(int a, int b) throws RemoteException;
        int subtract(int a, int b) throws RemoteException;
        int multiply(int a, int b) throws RemoteException;
        int divide(int a, int b) throws RemoteException;
    }
    
    // Example remote implementation
    public static class CalculatorImpl extends UnicastRemoteObject implements Calculator {
        public CalculatorImpl() throws RemoteException {
            super();
        }
        
        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }
        
        @Override
        public int subtract(int a, int b) throws RemoteException {
            return a - b;
        }
        
        @Override
        public int multiply(int a, int b) throws RemoteException {
            return a * b;
        }
        
        @Override
        public int divide(int a, int b) throws RemoteException {
            if (b == 0) {
                throw new RemoteException("Division by zero");
            }
            return a / b;
        }
    }
}
