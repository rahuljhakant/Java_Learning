package com.tutorial.projects;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * File Organizer Utility - File Management System
 * 
 * This class demonstrates a comprehensive file organization utility
 * that can organize files by type, date, size, and other criteria.
 * 
 * LEARNING OBJECTIVES:
 * - Implement file system operations
 * - Use Java NIO for file handling
 * - Organize files by various criteria
 * - Handle file operations safely
 * - Build a practical utility application
 * - Apply file management best practices
 * 
 * @author Rahul Kant Jha
 * @version 1.0
 * @since 2024
 */
public class FileOrganizer {
    private Scanner scanner;
    
    public FileOrganizer() {
        scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        FileOrganizer organizer = new FileOrganizer();
        organizer.run();
    }
    
    /**
     * Main application loop
     */
    public void run() {
        System.out.println("=== Welcome to File Organizer Utility ===");
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    organizeByFileType();
                    break;
                case 2:
                    organizeByDate();
                    break;
                case 3:
                    organizeBySize();
                    break;
                case 4:
                    organizeByExtension();
                    break;
                case 5:
                    cleanDuplicateFiles();
                    break;
                case 6:
                    organizeByCustomCriteria();
                    break;
                case 7:
                    analyzeDirectory();
                    break;
                case 8:
                    running = false;
                    System.out.println("Thank you for using File Organizer Utility!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Display main menu
     */
    private void displayMenu() {
        System.out.println("\n=== File Organizer Menu ===");
        System.out.println("1. Organize by File Type");
        System.out.println("2. Organize by Date");
        System.out.println("3. Organize by Size");
        System.out.println("4. Organize by Extension");
        System.out.println("5. Clean Duplicate Files");
        System.out.println("6. Organize by Custom Criteria");
        System.out.println("7. Analyze Directory");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }
    
    /**
     * Organize files by type (Documents, Images, Videos, etc.)
     */
    private void organizeByFileType() {
        System.out.println("\n=== Organize by File Type ===");
        
        String sourcePath = getDirectoryPath("Enter source directory path: ");
        if (sourcePath == null) return;
        
        try {
            Path source = Paths.get(sourcePath);
            if (!Files.exists(source) || !Files.isDirectory(source)) {
                System.out.println("Invalid directory path!");
                return;
            }
            
            Map<String, List<Path>> filesByType = new HashMap<>();
            
            Files.walk(source)
                .filter(Files::isRegularFile)
                .forEach(file -> {
                    String fileType = getFileType(file);
                    filesByType.computeIfAbsent(fileType, k -> new ArrayList<>()).add(file);
                });
            
            System.out.println("\nFiles found by type:");
            filesByType.forEach((type, files) -> {
                System.out.println(type + ": " + files.size() + " files");
            });
            
            System.out.print("\nDo you want to organize these files? (y/n): ");
            if (scanner.next().equalsIgnoreCase("y")) {
                organizeFilesByType(source, filesByType);
            }
            
        } catch (IOException e) {
            System.err.println("Error organizing files: " + e.getMessage());
        }
    }
    
    /**
     * Organize files by date
     */
    private void organizeByDate() {
        System.out.println("\n=== Organize by Date ===");
        
        String sourcePath = getDirectoryPath("Enter source directory path: ");
        if (sourcePath == null) return;
        
        try {
            Path source = Paths.get(sourcePath);
            if (!Files.exists(source) || !Files.isDirectory(source)) {
                System.out.println("Invalid directory path!");
                return;
            }
            
            Map<String, List<Path>> filesByDate = new HashMap<>();
            
            Files.walk(source)
                .filter(Files::isRegularFile)
                .forEach(file -> {
                    try {
                        String date = Files.getLastModifiedTime(file).toString().substring(0, 10);
                        filesByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(file);
                    } catch (IOException e) {
                        System.err.println("Error getting file date: " + e.getMessage());
                    }
                });
            
            System.out.println("\nFiles found by date:");
            filesByDate.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue().size() + " files");
                });
            
            System.out.print("\nDo you want to organize these files? (y/n): ");
            if (scanner.next().equalsIgnoreCase("y")) {
                organizeFilesByDate(source, filesByDate);
            }
            
        } catch (IOException e) {
            System.err.println("Error organizing files: " + e.getMessage());
        }
    }
    
    /**
     * Organize files by size
     */
    private void organizeBySize() {
        System.out.println("\n=== Organize by Size ===");
        
        String sourcePath = getDirectoryPath("Enter source directory path: ");
        if (sourcePath == null) return;
        
        try {
            Path source = Paths.get(sourcePath);
            if (!Files.exists(source) || !Files.isDirectory(source)) {
                System.out.println("Invalid directory path!");
                return;
            }
            
            Map<String, List<Path>> filesBySize = new HashMap<>();
            
            Files.walk(source)
                .filter(Files::isRegularFile)
                .forEach(file -> {
                    try {
                        long size = Files.size(file);
                        String sizeCategory = getSizeCategory(size);
                        filesBySize.computeIfAbsent(sizeCategory, k -> new ArrayList<>()).add(file);
                    } catch (IOException e) {
                        System.err.println("Error getting file size: " + e.getMessage());
                    }
                });
            
            System.out.println("\nFiles found by size:");
            filesBySize.forEach((category, files) -> {
                System.out.println(category + ": " + files.size() + " files");
            });
            
            System.out.print("\nDo you want to organize these files? (y/n): ");
            if (scanner.next().equalsIgnoreCase("y")) {
                organizeFilesBySize(source, filesBySize);
            }
            
        } catch (IOException e) {
            System.err.println("Error organizing files: " + e.getMessage());
        }
    }
    
    /**
     * Organize files by extension
     */
    private void organizeByExtension() {
        System.out.println("\n=== Organize by Extension ===");
        
        String sourcePath = getDirectoryPath("Enter source directory path: ");
        if (sourcePath == null) return;
        
        try {
            Path source = Paths.get(sourcePath);
            if (!Files.exists(source) || !Files.isDirectory(source)) {
                System.out.println("Invalid directory path!");
                return;
            }
            
            Map<String, List<Path>> filesByExtension = new HashMap<>();
            
            Files.walk(source)
                .filter(Files::isRegularFile)
                .forEach(file -> {
                    String extension = getFileExtension(file);
                    filesByExtension.computeIfAbsent(extension, k -> new ArrayList<>()).add(file);
                });
            
            System.out.println("\nFiles found by extension:");
            filesByExtension.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue().size() + " files");
                });
            
            System.out.print("\nDo you want to organize these files? (y/n): ");
            if (scanner.next().equalsIgnoreCase("y")) {
                organizeFilesByExtension(source, filesByExtension);
            }
            
        } catch (IOException e) {
            System.err.println("Error organizing files: " + e.getMessage());
        }
    }
    
    /**
     * Clean duplicate files
     */
    private void cleanDuplicateFiles() {
        System.out.println("\n=== Clean Duplicate Files ===");
        
        String sourcePath = getDirectoryPath("Enter source directory path: ");
        if (sourcePath == null) return;
        
        try {
            Path source = Paths.get(sourcePath);
            if (!Files.exists(source) || !Files.isDirectory(source)) {
                System.out.println("Invalid directory path!");
                return;
            }
            
            Map<String, List<Path>> duplicateFiles = findDuplicateFiles(source);
            
            if (duplicateFiles.isEmpty()) {
                System.out.println("No duplicate files found.");
                return;
            }
            
            System.out.println("\nDuplicate files found:");
            duplicateFiles.forEach((hash, files) -> {
                System.out.println("Hash: " + hash);
                files.forEach(file -> System.out.println("  " + file.getFileName()));
            });
            
            System.out.print("\nDo you want to remove duplicate files? (y/n): ");
            if (scanner.next().equalsIgnoreCase("y")) {
                removeDuplicateFiles(duplicateFiles);
            }
            
        } catch (IOException e) {
            System.err.println("Error cleaning duplicate files: " + e.getMessage());
        }
    }
    
    /**
     * Organize by custom criteria
     */
    private void organizeByCustomCriteria() {
        System.out.println("\n=== Organize by Custom Criteria ===");
        
        String sourcePath = getDirectoryPath("Enter source directory path: ");
        if (sourcePath == null) return;
        
        System.out.println("Custom organization options:");
        System.out.println("1. By file name pattern");
        System.out.println("2. By file content type");
        System.out.println("3. By file permissions");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        switch (choice) {
            case 1:
                organizeByNamePattern(sourcePath);
                break;
            case 2:
                organizeByContentType(sourcePath);
                break;
            case 3:
                organizeByPermissions(sourcePath);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    /**
     * Analyze directory
     */
    private void analyzeDirectory() {
        System.out.println("\n=== Analyze Directory ===");
        
        String sourcePath = getDirectoryPath("Enter directory path to analyze: ");
        if (sourcePath == null) return;
        
        try {
            Path source = Paths.get(sourcePath);
            if (!Files.exists(source) || !Files.isDirectory(source)) {
                System.out.println("Invalid directory path!");
                return;
            }
            
            analyzeDirectoryStructure(source);
            
        } catch (IOException e) {
            System.err.println("Error analyzing directory: " + e.getMessage());
        }
    }
    
    /**
     * Get file type based on extension
     */
    private String getFileType(Path file) {
        String extension = getFileExtension(file).toLowerCase();
        
        if (Arrays.asList("jpg", "jpeg", "png", "gif", "bmp", "svg").contains(extension)) {
            return "Images";
        } else if (Arrays.asList("mp4", "avi", "mkv", "mov", "wmv", "flv").contains(extension)) {
            return "Videos";
        } else if (Arrays.asList("mp3", "wav", "flac", "aac", "ogg").contains(extension)) {
            return "Audio";
        } else if (Arrays.asList("pdf", "doc", "docx", "txt", "rtf").contains(extension)) {
            return "Documents";
        } else if (Arrays.asList("zip", "rar", "7z", "tar", "gz").contains(extension)) {
            return "Archives";
        } else if (Arrays.asList("exe", "msi", "deb", "rpm").contains(extension)) {
            return "Executables";
        } else {
            return "Other";
        }
    }
    
    /**
     * Get file extension
     */
    private String getFileExtension(Path file) {
        String fileName = file.getFileName().toString();
        int lastDotIndex = fileName.lastIndexOf('.');
        return lastDotIndex > 0 ? fileName.substring(lastDotIndex + 1) : "no_extension";
    }
    
    /**
     * Get size category
     */
    private String getSizeCategory(long size) {
        if (size < 1024) {
            return "Small (< 1KB)";
        } else if (size < 1024 * 1024) {
            return "Medium (1KB - 1MB)";
        } else if (size < 1024 * 1024 * 1024) {
            return "Large (1MB - 1GB)";
        } else {
            return "Very Large (> 1GB)";
        }
    }
    
    /**
     * Organize files by type
     */
    private void organizeFilesByType(Path source, Map<String, List<Path>> filesByType) {
        filesByType.forEach((type, files) -> {
            try {
                Path typeDir = source.resolve(type);
                Files.createDirectories(typeDir);
                
                for (Path file : files) {
                    Path target = typeDir.resolve(file.getFileName());
                    if (!Files.exists(target)) {
                        Files.move(file, target);
                        System.out.println("Moved: " + file.getFileName() + " to " + type);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error organizing files by type: " + e.getMessage());
            }
        });
    }
    
    /**
     * Organize files by date
     */
    private void organizeFilesByDate(Path source, Map<String, List<Path>> filesByDate) {
        filesByDate.forEach((date, files) -> {
            try {
                Path dateDir = source.resolve(date);
                Files.createDirectories(dateDir);
                
                for (Path file : files) {
                    Path target = dateDir.resolve(file.getFileName());
                    if (!Files.exists(target)) {
                        Files.move(file, target);
                        System.out.println("Moved: " + file.getFileName() + " to " + date);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error organizing files by date: " + e.getMessage());
            }
        });
    }
    
    /**
     * Organize files by size
     */
    private void organizeFilesBySize(Path source, Map<String, List<Path>> filesBySize) {
        filesBySize.forEach((category, files) -> {
            try {
                Path sizeDir = source.resolve(category.replaceAll("[<>()]", "").trim());
                Files.createDirectories(sizeDir);
                
                for (Path file : files) {
                    Path target = sizeDir.resolve(file.getFileName());
                    if (!Files.exists(target)) {
                        Files.move(file, target);
                        System.out.println("Moved: " + file.getFileName() + " to " + category);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error organizing files by size: " + e.getMessage());
            }
        });
    }
    
    /**
     * Organize files by extension
     */
    private void organizeFilesByExtension(Path source, Map<String, List<Path>> filesByExtension) {
        filesByExtension.forEach((extension, files) -> {
            try {
                Path extDir = source.resolve(extension.toUpperCase());
                Files.createDirectories(extDir);
                
                for (Path file : files) {
                    Path target = extDir.resolve(file.getFileName());
                    if (!Files.exists(target)) {
                        Files.move(file, target);
                        System.out.println("Moved: " + file.getFileName() + " to " + extension.toUpperCase());
                    }
                }
            } catch (IOException e) {
                System.err.println("Error organizing files by extension: " + e.getMessage());
            }
        });
    }
    
    /**
     * Find duplicate files
     */
    private Map<String, List<Path>> findDuplicateFiles(Path source) throws IOException {
        Map<String, List<Path>> fileHashes = new HashMap<>();
        
        Files.walk(source)
            .filter(Files::isRegularFile)
            .forEach(file -> {
                try {
                    String hash = calculateFileHash(file);
                    fileHashes.computeIfAbsent(hash, k -> new ArrayList<>()).add(file);
                } catch (IOException e) {
                    System.err.println("Error calculating hash for " + file + ": " + e.getMessage());
                }
            });
        
        return fileHashes.entrySet().stream()
            .filter(entry -> entry.getValue().size() > 1)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    
    /**
     * Calculate file hash
     */
    private String calculateFileHash(Path file) throws IOException {
        return String.valueOf(Files.hash(file, java.security.MessageDigest.getInstance("MD5")).hashCode());
    }
    
    /**
     * Remove duplicate files
     */
    private void removeDuplicateFiles(Map<String, List<Path>> duplicateFiles) {
        duplicateFiles.forEach((hash, files) -> {
            // Keep the first file, remove the rest
            for (int i = 1; i < files.size(); i++) {
                try {
                    Files.delete(files.get(i));
                    System.out.println("Deleted duplicate: " + files.get(i).getFileName());
                } catch (IOException e) {
                    System.err.println("Error deleting file " + files.get(i) + ": " + e.getMessage());
                }
            }
        });
    }
    
    /**
     * Organize by name pattern
     */
    private void organizeByNamePattern(String sourcePath) {
        System.out.print("Enter file name pattern (e.g., 'IMG_', 'DOC_'): ");
        String pattern = scanner.next();
        
        try {
            Path source = Paths.get(sourcePath);
            Path patternDir = source.resolve("Pattern_" + pattern);
            Files.createDirectories(patternDir);
            
            Files.walk(source)
                .filter(Files::isRegularFile)
                .filter(file -> file.getFileName().toString().startsWith(pattern))
                .forEach(file -> {
                    try {
                        Path target = patternDir.resolve(file.getFileName());
                        if (!Files.exists(target)) {
                            Files.move(file, target);
                            System.out.println("Moved: " + file.getFileName() + " to Pattern_" + pattern);
                        }
                    } catch (IOException e) {
                        System.err.println("Error moving file: " + e.getMessage());
                    }
                });
                
        } catch (IOException e) {
            System.err.println("Error organizing by pattern: " + e.getMessage());
        }
    }
    
    /**
     * Organize by content type
     */
    private void organizeByContentType(String sourcePath) {
        System.out.println("Content type organization not implemented in this demo.");
    }
    
    /**
     * Organize by permissions
     */
    private void organizeByPermissions(String sourcePath) {
        System.out.println("Permission-based organization not implemented in this demo.");
    }
    
    /**
     * Analyze directory structure
     */
    private void analyzeDirectoryStructure(Path source) throws IOException {
        System.out.println("\n=== Directory Analysis ===");
        
        long totalFiles = Files.walk(source).filter(Files::isRegularFile).count();
        long totalDirs = Files.walk(source).filter(Files::isDirectory).count();
        
        System.out.println("Total Files: " + totalFiles);
        System.out.println("Total Directories: " + totalDirs);
        
        // File type analysis
        Map<String, Long> fileTypes = Files.walk(source)
            .filter(Files::isRegularFile)
            .collect(Collectors.groupingBy(
                this::getFileType,
                Collectors.counting()
            ));
        
        System.out.println("\nFile Types:");
        fileTypes.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(entry -> System.out.println("  " + entry.getKey() + ": " + entry.getValue()));
        
        // Size analysis
        long totalSize = Files.walk(source)
            .filter(Files::isRegularFile)
            .mapToLong(file -> {
                try {
                    return Files.size(file);
                } catch (IOException e) {
                    return 0;
                }
            })
            .sum();
        
        System.out.println("\nTotal Size: " + formatFileSize(totalSize));
    }
    
    /**
     * Format file size
     */
    private String formatFileSize(long size) {
        if (size < 1024) return size + " B";
        if (size < 1024 * 1024) return String.format("%.2f KB", size / 1024.0);
        if (size < 1024 * 1024 * 1024) return String.format("%.2f MB", size / (1024.0 * 1024));
        return String.format("%.2f GB", size / (1024.0 * 1024 * 1024));
    }
    
    /**
     * Get directory path from user
     */
    private String getDirectoryPath(String prompt) {
        System.out.print(prompt);
        String path = scanner.next();
        return path.isEmpty() ? null : path;
    }
    
    /**
     * Get user choice
     */
    private int getChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }
}
