package com.tutorial.projects.advanced;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * User Service class for business logic
 */
public class UserService {
    
    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    public UserService() {
        // Initialize with some sample data
        initializeSampleData();
    }
    
    /**
     * Initialize with sample data
     */
    private void initializeSampleData() {
        createUser(new User("John Doe", "john.doe@email.com", 25));
        createUser(new User("Jane Smith", "jane.smith@email.com", 30));
        createUser(new User("Bob Johnson", "bob.johnson@email.com", 35));
        createUser(new User("Alice Brown", "alice.brown@email.com", 28));
        createUser(new User("Charlie Wilson", "charlie.wilson@email.com", 42));
    }
    
    /**
     * Get all users
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
    
    /**
     * Get user by ID
     */
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(users.get(id));
    }
    
    /**
     * Create a new user
     */
    public User createUser(User user) {
        user.setId(idGenerator.getAndIncrement());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        users.put(user.getId(), user);
        return user;
    }
    
    /**
     * Update an existing user
     */
    public User updateUser(User user) {
        if (users.containsKey(user.getId())) {
            user.setUpdatedAt(LocalDateTime.now());
            users.put(user.getId(), user);
            return user;
        }
        throw new RuntimeException("User not found with ID: " + user.getId());
    }
    
    /**
     * Delete a user
     */
    public void deleteUser(Long id) {
        if (users.containsKey(id)) {
            users.remove(id);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }
    
    /**
     * Check if user exists by ID
     */
    public boolean existsById(Long id) {
        return users.containsKey(id);
    }
    
    /**
     * Check if user exists by email
     */
    public boolean existsByEmail(String email) {
        return users.values().stream()
                .anyMatch(user -> user.getEmail().equals(email));
    }
    
    /**
     * Search users by name
     */
    public List<User> searchUsersByName(String name) {
        String searchName = name.toLowerCase();
        return users.values().stream()
                .filter(user -> user.getName().toLowerCase().contains(searchName))
                .collect(Collectors.toList());
    }
    
    /**
     * Get users by age range
     */
    public List<User> getUsersByAgeRange(int minAge, int maxAge) {
        return users.values().stream()
                .filter(user -> user.getAge() >= minAge && user.getAge() <= maxAge)
                .collect(Collectors.toList());
    }
    
    /**
     * Get user statistics
     */
    public UserStatistics getUserStatistics() {
        List<User> allUsers = new ArrayList<>(users.values());
        
        if (allUsers.isEmpty()) {
            return new UserStatistics(0, 0, 0, 0, 0, 0);
        }
        
        int totalUsers = allUsers.size();
        int activeUsers = (int) allUsers.stream()
                .filter(user -> "ACTIVE".equals(user.getStatus()))
                .count();
        
        double averageAge = allUsers.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);
        
        int minAge = allUsers.stream()
                .mapToInt(User::getAge)
                .min()
                .orElse(0);
        
        int maxAge = allUsers.stream()
                .mapToInt(User::getAge)
                .max()
                .orElse(0);
        
        long usersCreatedToday = allUsers.stream()
                .filter(user -> user.getCreatedAt().toLocalDate().equals(LocalDateTime.now().toLocalDate()))
                .count();
        
        return new UserStatistics(totalUsers, activeUsers, averageAge, minAge, maxAge, usersCreatedToday);
    }
    
    /**
     * Create multiple users in bulk
     */
    public List<User> createUsersBulk(List<User> usersToCreate) {
        List<User> createdUsers = new ArrayList<>();
        
        for (User user : usersToCreate) {
            User createdUser = createUser(user);
            createdUsers.add(createdUser);
        }
        
        return createdUsers;
    }
    
    /**
     * Update user status
     */
    public User updateUserStatus(Long id, String status) {
        User user = users.get(id);
        if (user != null) {
            user.setStatus(status);
            user.setUpdatedAt(LocalDateTime.now());
            return user;
        }
        throw new RuntimeException("User not found with ID: " + id);
    }
    
    /**
     * Get users with pagination
     */
    public PaginatedResponse<User> getUsersPaginated(int page, int size) {
        List<User> allUsers = new ArrayList<>(users.values());
        
        // Sort by creation date (newest first)
        allUsers.sort((u1, u2) -> u2.getCreatedAt().compareTo(u1.getCreatedAt()));
        
        int totalElements = allUsers.size();
        int totalPages = (int) Math.ceil((double) totalElements / size);
        
        int startIndex = page * size;
        int endIndex = Math.min(startIndex + size, totalElements);
        
        List<User> pageContent = new ArrayList<>();
        if (startIndex < totalElements) {
            pageContent = allUsers.subList(startIndex, endIndex);
        }
        
        return new PaginatedResponse<>(
                pageContent,
                page,
                size,
                totalElements,
                totalPages,
                page > 0,
                page < totalPages - 1
        );
    }
    
    /**
     * Get users by status
     */
    public List<User> getUsersByStatus(String status) {
        return users.values().stream()
                .filter(user -> user.getStatus().equals(status))
                .collect(Collectors.toList());
    }
    
    /**
     * Get users created in date range
     */
    public List<User> getUsersCreatedInRange(LocalDateTime startDate, LocalDateTime endDate) {
        return users.values().stream()
                .filter(user -> user.getCreatedAt().isAfter(startDate) && user.getCreatedAt().isBefore(endDate))
                .collect(Collectors.toList());
    }
    
    /**
     * Get top users by age
     */
    public List<User> getTopUsersByAge(int limit) {
        return users.values().stream()
                .sorted((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge()))
                .limit(limit)
                .collect(Collectors.toList());
    }
    
    /**
     * Get user count by status
     */
    public Map<String, Long> getUserCountByStatus() {
        return users.values().stream()
                .collect(Collectors.groupingBy(User::getStatus, Collectors.counting()));
    }
    
    /**
     * Get user count by age group
     */
    public Map<String, Long> getUserCountByAgeGroup() {
        return users.values().stream()
                .collect(Collectors.groupingBy(
                        user -> {
                            int age = user.getAge();
                            if (age < 18) return "Under 18";
                            else if (age < 30) return "18-29";
                            else if (age < 50) return "30-49";
                            else return "50+";
                        },
                        Collectors.counting()
                ));
    }
}
