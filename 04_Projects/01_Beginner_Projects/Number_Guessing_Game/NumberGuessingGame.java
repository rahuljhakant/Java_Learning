package com.tutorial.projects.beginner;

import java.util.*;

/**
 * Number Guessing Game - Beginner Project
 * 
 * This comprehensive project demonstrates a complete number guessing game
 * with multiple difficulty levels, scoring system, and interactive gameplay.
 * Perfect for beginners to practice random number generation, user input
 * validation, and game logic implementation.
 * 
 * LEARNING OBJECTIVES:
 * - Work with random number generation and Math.random()
 * - Implement interactive game logic and flow control
 * - Handle user input validation and error handling
 * - Create engaging user interfaces and feedback
 * - Apply conditional statements and loops effectively
 * - Implement scoring systems and game statistics
 * 
 * KEY FEATURES:
 * 1. Random Number Generation: Generate random numbers within specified ranges
 * 2. Multiple Difficulty Levels: Easy, Medium, Hard difficulty settings
 * 3. Hint System: Provide helpful hints to guide players
 * 4. Score Tracking: Track attempts, wins, and statistics
 * 5. Interactive Gameplay: Engaging user experience with feedback
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class NumberGuessingGame {
    
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static GameStatistics statistics = new GameStatistics();
    
    public static void main(String[] args) {
        System.out.println("=== Number Guessing Game ===");
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the secret number within the given range.");
        System.out.println();
        
        boolean playing = true;
        while (playing) {
            displayMainMenu();
            int choice = getValidChoice(1, 4);
            
            switch (choice) {
                case 1:
                    startNewGame();
                    break;
                case 2:
                    displayStatistics();
                    break;
                case 3:
                    displayInstructions();
                    break;
                case 4:
                    playing = false;
                    System.out.println("Thank you for playing Number Guessing Game!");
                    break;
            }
        }
        
        scanner.close();
    }
    
    /**
     * Display the main menu
     */
    private static void displayMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Start New Game");
        System.out.println("2. View Statistics");
        System.out.println("3. Instructions");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }
    
    /**
     * Start a new game
     */
    private static void startNewGame() {
        System.out.println("\n=== Start New Game ===");
        
        // Select difficulty level
        DifficultyLevel difficulty = selectDifficulty();
        
        // Generate random number based on difficulty
        int secretNumber = generateSecretNumber(difficulty);
        int maxAttempts = difficulty.getMaxAttempts();
        int attempts = 0;
        boolean gameWon = false;
        
        System.out.println("\n🎮 Game Started!");
        System.out.println("Difficulty: " + difficulty.getName());
        System.out.println("Range: 1 to " + difficulty.getMaxNumber());
        System.out.println("Max attempts: " + maxAttempts);
        System.out.println("Good luck! 🍀");
        System.out.println();
        
        // Game loop
        while (attempts < maxAttempts && !gameWon) {
            attempts++;
            System.out.println("Attempt " + attempts + "/" + maxAttempts);
            
            int guess = getValidGuess(1, difficulty.getMaxNumber());
            
            if (guess == secretNumber) {
                gameWon = true;
                System.out.println("🎉 Congratulations! You guessed it right!");
                System.out.println("The secret number was: " + secretNumber);
                System.out.println("You won in " + attempts + " attempts!");
                
                // Update statistics
                statistics.recordWin(attempts, difficulty);
                
            } else {
                // Provide hints
                provideHint(guess, secretNumber, difficulty);
                
                if (attempts < maxAttempts) {
                    System.out.println("Try again! 💪");
                } else {
                    System.out.println("😞 Game Over! You've used all your attempts.");
                    System.out.println("The secret number was: " + secretNumber);
                    
                    // Update statistics
                    statistics.recordLoss(difficulty);
                }
            }
            System.out.println();
        }
        
        // Ask if player wants to play again
        if (askPlayAgain()) {
            startNewGame();
        }
    }
    
    /**
     * Select difficulty level
     */
    private static DifficultyLevel selectDifficulty() {
        System.out.println("Select Difficulty Level:");
        System.out.println("1. Easy (1-10, 5 attempts)");
        System.out.println("2. Medium (1-50, 7 attempts)");
        System.out.println("3. Hard (1-100, 10 attempts)");
        System.out.println("4. Expert (1-1000, 15 attempts)");
        System.out.print("Enter your choice (1-4): ");
        
        int choice = getValidChoice(1, 4);
        
        switch (choice) {
            case 1: return DifficultyLevel.EASY;
            case 2: return DifficultyLevel.MEDIUM;
            case 3: return DifficultyLevel.HARD;
            case 4: return DifficultyLevel.EXPERT;
            default: return DifficultyLevel.MEDIUM;
        }
    }
    
    /**
     * Generate secret number based on difficulty
     */
    private static int generateSecretNumber(DifficultyLevel difficulty) {
        return random.nextInt(difficulty.getMaxNumber()) + 1;
    }
    
    /**
     * Get valid guess from user
     */
    private static int getValidGuess(int min, int max) {
        while (true) {
            System.out.print("Enter your guess (" + min + "-" + max + "): ");
            try {
                int guess = Integer.parseInt(scanner.nextLine().trim());
                if (guess >= min && guess <= max) {
                    return guess;
                } else {
                    System.out.println("❌ Please enter a number between " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number");
            }
        }
    }
    
    /**
     * Provide hints based on the guess
     */
    private static void provideHint(int guess, int secretNumber, DifficultyLevel difficulty) {
        int difference = Math.abs(guess - secretNumber);
        int range = difficulty.getMaxNumber();
        
        if (difference == 0) {
            // This shouldn't happen as we check for win before calling this method
            return;
        } else if (difference <= range * 0.05) { // Within 5% of range
            System.out.println("🔥 Very close! You're almost there!");
        } else if (difference <= range * 0.1) { // Within 10% of range
            System.out.println("🔥 Close! You're getting warmer!");
        } else if (difference <= range * 0.2) { // Within 20% of range
            System.out.println("🌡️ Getting warmer...");
        } else if (difference <= range * 0.3) { // Within 30% of range
            System.out.println("🌡️ Warm...");
        } else {
            System.out.println("❄️ Cold...");
        }
        
        // Direction hint
        if (guess < secretNumber) {
            System.out.println("📈 The secret number is higher than " + guess);
        } else {
            System.out.println("📉 The secret number is lower than " + guess);
        }
    }
    
    /**
     * Display game statistics
     */
    private static void displayStatistics() {
        System.out.println("\n=== Game Statistics ===");
        System.out.println("Total Games Played: " + statistics.getTotalGames());
        System.out.println("Games Won: " + statistics.getGamesWon());
        System.out.println("Games Lost: " + statistics.getGamesLost());
        
        if (statistics.getTotalGames() > 0) {
            double winRate = (double) statistics.getGamesWon() / statistics.getTotalGames() * 100;
            System.out.println("Win Rate: " + String.format("%.1f", winRate) + "%");
        }
        
        if (statistics.getGamesWon() > 0) {
            System.out.println("Average Attempts to Win: " + String.format("%.1f", statistics.getAverageAttemptsToWin()));
            System.out.println("Best Score: " + statistics.getBestScore() + " attempts");
        }
        
        System.out.println("\nDifficulty Breakdown:");
        for (DifficultyLevel difficulty : DifficultyLevel.values()) {
            int wins = statistics.getWinsByDifficulty(difficulty);
            int losses = statistics.getLossesByDifficulty(difficulty);
            System.out.println(difficulty.getName() + ": " + wins + " wins, " + losses + " losses");
        }
    }
    
    /**
     * Display game instructions
     */
    private static void displayInstructions() {
        System.out.println("\n=== Game Instructions ===");
        System.out.println("🎯 Objective: Guess the secret number within the given range");
        System.out.println("🎮 How to Play:");
        System.out.println("  1. Select a difficulty level");
        System.out.println("  2. Enter your guess when prompted");
        System.out.println("  3. Use the hints to guide your next guess");
        System.out.println("  4. Try to guess the number within the allowed attempts");
        System.out.println();
        System.out.println("💡 Tips:");
        System.out.println("  • Start with the middle of the range");
        System.out.println("  • Use the hints to narrow down your search");
        System.out.println("  • Pay attention to the temperature hints");
        System.out.println("  • Higher difficulty = larger range but more attempts");
        System.out.println();
        System.out.println("🏆 Scoring:");
        System.out.println("  • Fewer attempts = better score");
        System.out.println("  • Track your statistics to improve");
        System.out.println("  • Try to beat your best score!");
    }
    
    /**
     * Ask if player wants to play again
     */
    private static boolean askPlayAgain() {
        System.out.print("Would you like to play again? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y") || response.equals("yes");
    }
    
    /**
     * Get valid choice from user
     */
    private static int getValidChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
    
    /**
     * Difficulty level enum
     */
    public enum DifficultyLevel {
        EASY("Easy", 10, 5),
        MEDIUM("Medium", 50, 7),
        HARD("Hard", 100, 10),
        EXPERT("Expert", 1000, 15);
        
        private final String name;
        private final int maxNumber;
        private final int maxAttempts;
        
        DifficultyLevel(String name, int maxNumber, int maxAttempts) {
            this.name = name;
            this.maxNumber = maxNumber;
            this.maxAttempts = maxAttempts;
        }
        
        public String getName() { return name; }
        public int getMaxNumber() { return maxNumber; }
        public int getMaxAttempts() { return maxAttempts; }
    }
    
    /**
     * Game statistics tracking class
     */
    public static class GameStatistics {
        private int totalGames = 0;
        private int gamesWon = 0;
        private int gamesLost = 0;
        private int totalAttemptsToWin = 0;
        private int bestScore = Integer.MAX_VALUE;
        private Map<DifficultyLevel, Integer> winsByDifficulty = new HashMap<>();
        private Map<DifficultyLevel, Integer> lossesByDifficulty = new HashMap<>();
        
        public void recordWin(int attempts, DifficultyLevel difficulty) {
            totalGames++;
            gamesWon++;
            totalAttemptsToWin += attempts;
            
            if (attempts < bestScore) {
                bestScore = attempts;
            }
            
            winsByDifficulty.put(difficulty, winsByDifficulty.getOrDefault(difficulty, 0) + 1);
        }
        
        public void recordLoss(DifficultyLevel difficulty) {
            totalGames++;
            gamesLost++;
            lossesByDifficulty.put(difficulty, lossesByDifficulty.getOrDefault(difficulty, 0) + 1);
        }
        
        public int getTotalGames() { return totalGames; }
        public int getGamesWon() { return gamesWon; }
        public int getGamesLost() { return gamesLost; }
        
        public double getAverageAttemptsToWin() {
            return gamesWon > 0 ? (double) totalAttemptsToWin / gamesWon : 0;
        }
        
        public int getBestScore() { 
            return bestScore == Integer.MAX_VALUE ? 0 : bestScore; 
        }
        
        public int getWinsByDifficulty(DifficultyLevel difficulty) {
            return winsByDifficulty.getOrDefault(difficulty, 0);
        }
        
        public int getLossesByDifficulty(DifficultyLevel difficulty) {
            return lossesByDifficulty.getOrDefault(difficulty, 0);
        }
    }
}
