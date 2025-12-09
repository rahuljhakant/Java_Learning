package com.tutorial.projects;

/**
 * User Statistics class for API responses
 */
public class UserStatistics {
    private int totalUsers;
    private int activeUsers;
    private double averageAge;
    private int minAge;
    private int maxAge;
    private long usersCreatedToday;
    
    public UserStatistics() {}
    
    public UserStatistics(int totalUsers, int activeUsers, double averageAge, 
                         int minAge, int maxAge, long usersCreatedToday) {
        this.totalUsers = totalUsers;
        this.activeUsers = activeUsers;
        this.averageAge = averageAge;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.usersCreatedToday = usersCreatedToday;
    }
    
    // Getters and Setters
    public int getTotalUsers() {
        return totalUsers;
    }
    
    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }
    
    public int getActiveUsers() {
        return activeUsers;
    }
    
    public void setActiveUsers(int activeUsers) {
        this.activeUsers = activeUsers;
    }
    
    public double getAverageAge() {
        return averageAge;
    }
    
    public void setAverageAge(double averageAge) {
        this.averageAge = averageAge;
    }
    
    public int getMinAge() {
        return minAge;
    }
    
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
    
    public int getMaxAge() {
        return maxAge;
    }
    
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
    
    public long getUsersCreatedToday() {
        return usersCreatedToday;
    }
    
    public void setUsersCreatedToday(long usersCreatedToday) {
        this.usersCreatedToday = usersCreatedToday;
    }
    
    @Override
    public String toString() {
        return "UserStatistics{" +
                "totalUsers=" + totalUsers +
                ", activeUsers=" + activeUsers +
                ", averageAge=" + averageAge +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", usersCreatedToday=" + usersCreatedToday +
                '}';
    }
}
