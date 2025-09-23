package com.tutorial.projects.advanced;

/**
 * Status Update class for API requests
 */
public class StatusUpdate {
    private String status;
    
    public StatusUpdate() {}
    
    public StatusUpdate(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "StatusUpdate{" +
                "status='" + status + '\'' +
                '}';
    }
}
