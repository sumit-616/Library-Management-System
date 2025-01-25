package org.example.Configuration;

import java.time.LocalDateTime;

public class Session {
    private String currentUserId;
    private String email;
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;

    public Session(String currentUserId, String email){
        this.currentUserId = currentUserId;
        this.email = email;
        this.loginTime = LocalDateTime.now();
        this.logoutTime = null;
    }

    public String getCurrentUserId() {
        return currentUserId;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    public void logout(){
        this.logoutTime = LocalDateTime.now();
        System.out.println("User email: " + email + " logged out at " + logoutTime);
    }

    public boolean isActive(){
        return logoutTime == null;
    }

    @Override
    public String toString(){
        return "Session{" +
                "currentUserId='" + currentUserId + '\'' +
                ", userEmail='" + email + '\'' +
                ", loginTime=" + loginTime +
                ", logoutTime=" + (logoutTime != null ? logoutTime : "Active") +
                '}';
    }
}
