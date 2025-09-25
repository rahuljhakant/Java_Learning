package com.tutorial.advanced.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Event Handling - GUI Event Management
 * 
 * This comprehensive tutorial demonstrates event handling in Java GUI
 * applications, including different event types, event listeners,
 * and event handling patterns.
 * 
 * LEARNING OBJECTIVES:
 * - Understand GUI event handling concepts
 * - Implement different event listeners
 * - Handle user interactions effectively
 * - Apply event handling best practices
 * - Create responsive GUI applications
 * - Use event delegation model
 * 
 * KEY CONCEPTS:
 * 1. Event Types: Action, Mouse, Key, Window events
 * 2. Event Listeners: Interface implementations for event handling
 * 3. Event Delegation: Event handling model
 * 4. Event Handling: Processing user interactions
 * 5. Event Propagation: Event flow and handling
 * 6. Best Practices: Effective event handling patterns
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class EventHandling extends JFrame {
    
    private JButton button;
    private JTextField textField;
    private JLabel statusLabel;
    private JTextArea textArea;
    
    public EventHandling() {
        initializeComponents();
        setupEventHandlers();
        setupLayout();
        configureWindow();
    }
    
    /**
     * Initialize GUI components
     */
    private void initializeComponents() {
        button = new JButton("Click Me!");
        textField = new JTextField(20);
        statusLabel = new JLabel("Status: Ready");
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
    }
    
    /**
     * Setup event handlers
     */
    private void setupEventHandlers() {
        // Action Event Handling
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(e);
            }
        });
        
        // Key Event Handling
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                handleKeyTyped(e);
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPressed(e);
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                handleKeyReleased(e);
            }
        });
        
        // Mouse Event Handling
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClicked(e);
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                handleMousePressed(e);
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                handleMouseReleased(e);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                handleMouseEntered(e);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                handleMouseExited(e);
            }
        });
        
        // Window Event Handling
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                handleWindowOpened(e);
            }
            
            @Override
            public void windowClosing(WindowEvent e) {
                handleWindowClosing(e);
            }
            
            @Override
            public void windowClosed(WindowEvent e) {
                handleWindowClosed(e);
            }
            
            @Override
            public void windowIconified(WindowEvent e) {
                handleWindowIconified(e);
            }
            
            @Override
            public void windowDeiconified(WindowEvent e) {
                handleWindowDeiconified(e);
            }
            
            @Override
            public void windowActivated(WindowEvent e) {
                handleWindowActivated(e);
            }
            
            @Override
            public void windowDeactivated(WindowEvent e) {
                handleWindowDeactivated(e);
            }
        });
        
        // Focus Event Handling
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                handleFocusGained(e);
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                handleFocusLost(e);
            }
        });
    }
    
    /**
     * Setup component layout
     */
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // Top panel
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Enter text:"));
        topPanel.add(textField);
        topPanel.add(button);
        
        // Center panel
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Bottom panel
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(statusLabel);
        
        // Add panels to frame
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Configure window properties
     */
    private void configureWindow() {
        setTitle("Event Handling Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
    }
    
    // Event handling methods
    
    /**
     * Handle button click events
     */
    private void handleButtonClick(ActionEvent e) {
        String text = textField.getText();
        if (!text.isEmpty()) {
            textArea.append("Button clicked: " + text + "\n");
            textField.setText("");
            statusLabel.setText("Status: Button clicked");
        } else {
            textArea.append("Button clicked (no text)\n");
            statusLabel.setText("Status: Button clicked (no text)");
        }
    }
    
    /**
     * Handle key typed events
     */
    private void handleKeyTyped(KeyEvent e) {
        textArea.append("Key typed: " + e.getKeyChar() + "\n");
        statusLabel.setText("Status: Key typed");
    }
    
    /**
     * Handle key pressed events
     */
    private void handleKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            textArea.append("Enter key pressed\n");
            statusLabel.setText("Status: Enter pressed");
        }
    }
    
    /**
     * Handle key released events
     */
    private void handleKeyReleased(KeyEvent e) {
        // Handle key release if needed
    }
    
    /**
     * Handle mouse clicked events
     */
    private void handleMouseClicked(MouseEvent e) {
        textArea.append("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")\n");
        statusLabel.setText("Status: Mouse clicked");
    }
    
    /**
     * Handle mouse pressed events
     */
    private void handleMousePressed(MouseEvent e) {
        textArea.append("Mouse pressed\n");
        statusLabel.setText("Status: Mouse pressed");
    }
    
    /**
     * Handle mouse released events
     */
    private void handleMouseReleased(MouseEvent e) {
        textArea.append("Mouse released\n");
        statusLabel.setText("Status: Mouse released");
    }
    
    /**
     * Handle mouse entered events
     */
    private void handleMouseEntered(MouseEvent e) {
        button.setBackground(Color.YELLOW);
        statusLabel.setText("Status: Mouse entered button");
    }
    
    /**
     * Handle mouse exited events
     */
    private void handleMouseExited(MouseEvent e) {
        button.setBackground(null);
        statusLabel.setText("Status: Mouse exited button");
    }
    
    /**
     * Handle window opened events
     */
    private void handleWindowOpened(WindowEvent e) {
        textArea.append("Window opened\n");
        statusLabel.setText("Status: Window opened");
    }
    
    /**
     * Handle window closing events
     */
    private void handleWindowClosing(WindowEvent e) {
        textArea.append("Window closing\n");
        statusLabel.setText("Status: Window closing");
    }
    
    /**
     * Handle window closed events
     */
    private void handleWindowClosed(WindowEvent e) {
        textArea.append("Window closed\n");
        statusLabel.setText("Status: Window closed");
    }
    
    /**
     * Handle window iconified events
     */
    private void handleWindowIconified(WindowEvent e) {
        textArea.append("Window iconified\n");
        statusLabel.setText("Status: Window iconified");
    }
    
    /**
     * Handle window deiconified events
     */
    private void handleWindowDeiconified(WindowEvent e) {
        textArea.append("Window deiconified\n");
        statusLabel.setText("Status: Window deiconified");
    }
    
    /**
     * Handle window activated events
     */
    private void handleWindowActivated(WindowEvent e) {
        textArea.append("Window activated\n");
        statusLabel.setText("Status: Window activated");
    }
    
    /**
     * Handle window deactivated events
     */
    private void handleWindowDeactivated(WindowEvent e) {
        textArea.append("Window deactivated\n");
        statusLabel.setText("Status: Window deactivated");
    }
    
    /**
     * Handle focus gained events
     */
    private void handleFocusGained(FocusEvent e) {
        textField.setBackground(Color.LIGHT_GRAY);
        statusLabel.setText("Status: Text field focused");
    }
    
    /**
     * Handle focus lost events
     */
    private void handleFocusLost(FocusEvent e) {
        textField.setBackground(Color.WHITE);
        statusLabel.setText("Status: Text field focus lost");
    }
    
    /**
     * Main method to run the application
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EventHandling().setVisible(true);
            }
        });
    }
}
