package com.ismael.ibooking.Model.Pojo;


public class User {
    private int user_id ;
    private String name;
    private String lastName;
    private String email;
    private String password;

    public User() {
    }

    public User(int id, String name, String lastName, String email, String password) {
        this.user_id  = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Object getCurrentUser() {
        return this;
    }

    public int getId() {
        return user_id ;
    }

    public void setId(int id) {
        this.user_id  = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
