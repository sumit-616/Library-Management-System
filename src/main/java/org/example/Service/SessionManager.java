package org.example.Service;
import org.example.Configuration.Session;
import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private Map<String, Session> activeSessions;

    public SessionManager(){
        this.activeSessions = new HashMap<>();
    }

    public String login(String userId, String email){
        if(activeSessions.containsKey(userId)){
            return "User is already logged in.";
        }

        Session session = new Session(userId, email);
        activeSessions.put(userId, session);
        return "User logged in successfully at " + session.getLoginTime();
    }

    public String logout(String userId){
        Session session = activeSessions.get(userId);
        if(session == null){
            return "No active session found for this user.";
        }

        session.logout();
        activeSessions.remove(userId);
        return "User logged out successfully.";
    }

    public boolean isActive(String userId){
        return activeSessions.containsKey(userId);
    }

    public Session getSession(String userId){
        return activeSessions.get(userId);
    }

    public void listActiveSessions(){
        if(activeSessions.isEmpty()){
            System.out.println("No active sessions.");
        }else{
            for(Session session : activeSessions.values()){
                System.out.println(session);
            }
        }
    }
}
