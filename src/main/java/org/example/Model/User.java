package org.example.Model;

public abstract class User {
    private String userid;
    private String name;
    private String email;
    public abstract String returnRole();
    User(String userid, String name, String email){
        this.userid = userid;
        this.name = name;
        this.email = email;
    }

    public String getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }
}
