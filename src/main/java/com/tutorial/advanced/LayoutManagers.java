package com.tutorial.advanced;

import javax.swing.*;
import java.awt.*;

/**
 * Layout Managers - GUI Component Arrangement
 * 
 * This comprehensive tutorial demonstrates Java Swing layout managers,
 * including different layout types, component arrangement,
 * and responsive GUI design.
 * 
 * LEARNING OBJECTIVES:
 * - Understand different layout managers
 * - Use layout managers effectively
 * - Create responsive GUI layouts
 * - Apply layout best practices
 * - Design professional GUI applications
 * - Handle component positioning and sizing
 * 
 * KEY CONCEPTS:
 * 1. Layout Managers: Component arrangement systems
 * 2. BorderLayout: North, South, East, West, Center
 * 3. FlowLayout: Left-to-right, top-to-bottom arrangement
 * 4. GridLayout: Grid-based component arrangement
 * 5. CardLayout: Stacked component arrangement
 * 6. BoxLayout: Vertical or horizontal arrangement
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class LayoutManagers extends JFrame {
    
    public LayoutManagers() {
        setTitle("Layout Managers Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Create tabbed pane for different layouts
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Add different layout demos
        tabbedPane.addTab("BorderLayout", createBorderLayoutDemo());
        tabbedPane.addTab("FlowLayout", createFlowLayoutDemo());
        tabbedPane.addTab("GridLayout", createGridLayoutDemo());
        tabbedPane.addTab("CardLayout", createCardLayoutDemo());
        tabbedPane.addTab("BoxLayout", createBoxLayoutDemo());
        tabbedPane.addTab("GridBagLayout", createGridBagLayoutDemo());
        
        add(tabbedPane);
    }
    
    /**
     * Create BorderLayout demo
     */
    private JPanel createBorderLayoutDemo() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Add components to different regions
        panel.add(new JButton("North"), BorderLayout.NORTH);
        panel.add(new JButton("South"), BorderLayout.SOUTH);
        panel.add(new JButton("East"), BorderLayout.EAST);
        panel.add(new JButton("West"), BorderLayout.WEST);
        panel.add(new JButton("Center"), BorderLayout.CENTER);
        
        return panel;
    }
    
    /**
     * Create FlowLayout demo
     */
    private JPanel createFlowLayoutDemo() {
        JPanel panel = new JPanel(new FlowLayout());
        
        // Add multiple buttons
        for (int i = 1; i <= 10; i++) {
            panel.add(new JButton("Button " + i));
        }
        
        return panel;
    }
    
    /**
     * Create GridLayout demo
     */
    private JPanel createGridLayoutDemo() {
        JPanel panel = new JPanel(new GridLayout(3, 3));
        
        // Add buttons in grid
        for (int i = 1; i <= 9; i++) {
            panel.add(new JButton("" + i));
        }
        
        return panel;
    }
    
    /**
     * Create CardLayout demo
     */
    private JPanel createCardLayoutDemo() {
        JPanel panel = new JPanel(new CardLayout());
        
        // Create different cards
        JPanel card1 = new JPanel();
        card1.add(new JLabel("This is Card 1"));
        card1.add(new JButton("Card 1 Button"));
        
        JPanel card2 = new JPanel();
        card2.add(new JLabel("This is Card 2"));
        card2.add(new JButton("Card 2 Button"));
        
        JPanel card3 = new JPanel();
        card3.add(new JLabel("This is Card 3"));
        card3.add(new JButton("Card 3 Button"));
        
        // Add cards to panel
        panel.add(card1, "Card1");
        panel.add(card2, "Card2");
        panel.add(card3, "Card3");
        
        // Add navigation buttons
        JPanel navPanel = new JPanel(new FlowLayout());
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        
        prevButton.addActionListener(e -> {
            CardLayout layout = (CardLayout) panel.getLayout();
            layout.previous(panel);
        });
        
        nextButton.addActionListener(e -> {
            CardLayout layout = (CardLayout) panel.getLayout();
            layout.next(panel);
        });
        
        navPanel.add(prevButton);
        navPanel.add(nextButton);
        
        // Create main panel with navigation
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panel, BorderLayout.CENTER);
        mainPanel.add(navPanel, BorderLayout.SOUTH);
        
        return mainPanel;
    }
    
    /**
     * Create BoxLayout demo
     */
    private JPanel createBoxLayoutDemo() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Add components vertically
        panel.add(new JButton("Button 1"));
        panel.add(Box.createVerticalStrut(10)); // Spacing
        panel.add(new JButton("Button 2"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JButton("Button 3"));
        panel.add(Box.createVerticalGlue()); // Flexible spacing
        panel.add(new JButton("Button 4"));
        
        return panel;
    }
    
    /**
     * Create GridBagLayout demo
     */
    private JPanel createGridBagLayoutDemo() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Button 1 - Top left
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(new JButton("Button 1"), gbc);
        
        // Button 2 - Top right
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(new JButton("Button 2"), gbc);
        
        // Button 3 - Center
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(new JButton("Button 3"), gbc);
        
        // Button 4 - Bottom left
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        panel.add(new JButton("Button 4"), gbc);
        
        // Button 5 - Bottom right
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(new JButton("Button 5"), gbc);
        
        return panel;
    }
    
    /**
     * Main method to run the application
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LayoutManagers().setVisible(true);
            }
        });
    }
}
