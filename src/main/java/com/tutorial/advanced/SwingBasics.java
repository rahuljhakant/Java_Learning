package com.tutorial.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Swing Basics - Introduction to Java GUI Programming
 * 
 * This comprehensive tutorial demonstrates the fundamentals of Java GUI programming
 * using Swing components. Learn how to create windows, add components, handle events,
 * and build interactive desktop applications.
 * 
 * LEARNING OBJECTIVES:
 * - Understand Swing architecture and components
 * - Create and configure JFrame windows
 * - Add and arrange components using layout managers
 * - Handle user events and interactions
 * - Apply styling and customization
 * - Build complete GUI applications
 * 
 * KEY CONCEPTS:
 * 1. Swing Components: JFrame, JPanel, JButton, JLabel, JTextField
 * 2. Layout Managers: BorderLayout, FlowLayout, GridLayout
 * 3. Event Handling: ActionListener, MouseListener, KeyListener
 * 4. Component Properties: Size, position, colors, fonts
 * 5. Window Management: Show, hide, close, minimize
 * 6. Best Practices: Component organization and event handling
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class SwingBasics extends JFrame {
    
    private JLabel statusLabel;
    private JTextField inputField;
    private JButton clickButton;
    private JButton clearButton;
    private int clickCount = 0;
    
    public SwingBasics() {
        initializeComponents();
        setupLayout();
        addEventHandlers();
        configureWindow();
    }
    
    /**
     * Initialize all GUI components
     */
    private void initializeComponents() {
        // Create main components
        statusLabel = new JLabel("Welcome to Swing Basics!", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusLabel.setForeground(Color.BLUE);
        
        inputField = new JTextField(20);
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField.setToolTipText("Enter your text here");
        
        clickButton = new JButton("Click Me!");
        clickButton.setFont(new Font("Arial", Font.BOLD, 12));
        clickButton.setBackground(Color.GREEN);
        clickButton.setForeground(Color.WHITE);
        
        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.BOLD, 12));
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
    }
    
    /**
     * Setup the layout of components
     */
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // Create panels for better organization
        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel centerPanel = new JPanel(new FlowLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout());
        
        // Add components to panels
        topPanel.add(statusLabel);
        centerPanel.add(new JLabel("Enter text: "));
        centerPanel.add(inputField);
        bottomPanel.add(clickButton);
        bottomPanel.add(clearButton);
        
        // Add panels to main frame
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Add event handlers to components
     */
    private void addEventHandlers() {
        // Button click event
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick();
            }
        });
        
        // Clear button event
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClearClick();
            }
        });
        
        // Text field event
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTextInput();
            }
        });
    }
    
    /**
     * Handle button click events
     */
    private void handleButtonClick() {
        clickCount++;
        String inputText = inputField.getText().trim();
        
        if (inputText.isEmpty()) {
            statusLabel.setText("Button clicked " + clickCount + " times!");
        } else {
            statusLabel.setText("Hello, " + inputText + "! Button clicked " + clickCount + " times!");
        }
        
        // Change button color based on click count
        if (clickCount % 2 == 0) {
            clickButton.setBackground(Color.BLUE);
        } else {
            clickButton.setBackground(Color.GREEN);
        }
    }
    
    /**
     * Handle clear button events
     */
    private void handleClearClick() {
        inputField.setText("");
        statusLabel.setText("Welcome to Swing Basics!");
        clickCount = 0;
        clickButton.setBackground(Color.GREEN);
    }
    
    /**
     * Handle text input events
     */
    private void handleTextInput() {
        String inputText = inputField.getText().trim();
        if (!inputText.isEmpty()) {
            statusLabel.setText("You entered: " + inputText);
        }
    }
    
    /**
     * Configure window properties
     */
    private void configureWindow() {
        setTitle("Swing Basics Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the window
        setResizable(true);
        
        // Set window icon (if available)
        try {
            setIconImage(createDefaultIcon());
        } catch (Exception e) {
            // Use default icon if custom icon fails
        }
    }
    
    /**
     * Create a simple default icon
     */
    private Image createDefaultIcon() {
        // Create a simple colored square as icon
        BufferedImage icon = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = icon.createGraphics();
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, 32, 32);
        g2d.setColor(Color.WHITE);
        g2d.drawString("J", 12, 20);
        g2d.dispose();
        return icon;
    }
    
    /**
     * Main method to run the application
     */
    public static void main(String[] args) {
        // Set look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
            System.err.println("Could not set look and feel: " + e.getMessage());
        }
        
        // Create and show the GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingBasics app = new SwingBasics();
                app.setVisible(true);
                
                // Show welcome message
                JOptionPane.showMessageDialog(app, 
                    "Welcome to Swing Basics Demo!\n\n" +
                    "Features:\n" +
                    "• Click the button to see it in action\n" +
                    "• Enter text and press Enter\n" +
                    "• Use Clear button to reset\n" +
                    "• Notice the dynamic color changes",
                    "Welcome", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    
    /**
     * Utility method to create a simple dialog
     */
    public static void showInfoDialog(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Information", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Utility method to create a confirmation dialog
     */
    public static boolean showConfirmDialog(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, "Confirm", 
            JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }
    
    /**
     * Utility method to create an input dialog
     */
    public static String showInputDialog(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message);
    }
}
