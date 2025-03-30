package org.example.model;

public class User {
    private Long id;
    private String name;
    private String email;

    // Constructor, getters, and setters
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
