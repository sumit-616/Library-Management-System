package org.example.Model;

public class Admin extends User{
    public Admin(String id, String name, String email){
        super(id, name, email);
    }
    @Override
    public String returnRole() {
        return "Admin";
    }
}
