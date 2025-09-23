package com.tutorial.projects.advanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * RESTful API Controller for User Management
 * 
 * This project demonstrates:
 * - Spring Boot framework usage
 * - RESTful API design
 * - CRUD operations
 * - Exception handling
 * - Dependency injection
 * - HTTP status codes
 * - Request/Response mapping
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    /**
     * Get all users
     * GET /api/users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Get user by ID
     * GET /api/users/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        try {
            Optional<User> user = userService.getUserById(id);
            if (user.isPresent()) {
                return ResponseEntity.ok(user.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Create a new user
     * POST /api/users
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            // Validate required fields
            if (user.getName() == null || user.getName().trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            
            // Check if email already exists
            if (userService.existsByEmail(user.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Update an existing user
     * PUT /api/users/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            // Validate required fields
            if (user.getName() == null || user.getName().trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            
            // Check if user exists
            if (!userService.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            
            // Check if email already exists for another user
            Optional<User> existingUser = userService.getUserById(id);
            if (existingUser.isPresent() && !existingUser.get().getEmail().equals(user.getEmail())) {
                if (userService.existsByEmail(user.getEmail())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).build();
                }
            }
            
            user.setId(id);
            User updatedUser = userService.updateUser(user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Delete a user
     * DELETE /api/users/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            if (!userService.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Search users by name
     * GET /api/users/search?name={name}
     */
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsersByName(@RequestParam String name) {
        try {
            if (name == null || name.trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            
            List<User> users = userService.searchUsersByName(name);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Get users by age range
     * GET /api/users/age-range?min={min}&max={max}
     */
    @GetMapping("/age-range")
    public ResponseEntity<List<User>> getUsersByAgeRange(
            @RequestParam int min, 
            @RequestParam int max) {
        try {
            if (min < 0 || max < 0 || min > max) {
                return ResponseEntity.badRequest().build();
            }
            
            List<User> users = userService.getUsersByAgeRange(min, max);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Get user statistics
     * GET /api/users/statistics
     */
    @GetMapping("/statistics")
    public ResponseEntity<UserStatistics> getUserStatistics() {
        try {
            UserStatistics stats = userService.getUserStatistics();
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Bulk create users
     * POST /api/users/bulk
     */
    @PostMapping("/bulk")
    public ResponseEntity<List<User>> createUsersBulk(@RequestBody List<User> users) {
        try {
            if (users == null || users.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            
            // Validate all users
            for (User user : users) {
                if (user.getName() == null || user.getName().trim().isEmpty()) {
                    return ResponseEntity.badRequest().build();
                }
                if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
                    return ResponseEntity.badRequest().build();
                }
            }
            
            List<User> createdUsers = userService.createUsersBulk(users);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUsers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Update user status
     * PATCH /api/users/{id}/status
     */
    @PatchMapping("/{id}/status")
    public ResponseEntity<User> updateUserStatus(@PathVariable Long id, @RequestBody StatusUpdate statusUpdate) {
        try {
            if (!userService.existsById(id)) {
                return ResponseEntity.notFound().build();
            }
            
            if (statusUpdate.getStatus() == null || statusUpdate.getStatus().trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            
            User updatedUser = userService.updateUserStatus(id, statusUpdate.getStatus());
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Get users with pagination
     * GET /api/users/paginated?page={page}&size={size}
     */
    @GetMapping("/paginated")
    public ResponseEntity<PaginatedResponse<User>> getUsersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            if (page < 0 || size <= 0 || size > 100) {
                return ResponseEntity.badRequest().build();
            }
            
            PaginatedResponse<User> response = userService.getUsersPaginated(page, size);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
