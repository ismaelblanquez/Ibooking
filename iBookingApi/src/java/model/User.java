/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author Ismael
 */
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", password=" + password + '}';
    }
    public static String 
        toArrayJSon(ArrayList<User> users) {
            GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            String resp = gson.toJson(users);
            
            return resp;
    }
         public static String
        toObjectJSon(User user) {
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            String resp = gson.toJson(user);
           
            return resp;
    }
}
