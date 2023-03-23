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
public class Comment {

    private int id;
    private int userId;
    private int hotelId;
    private String comment;
    private int rating;

    public Comment() {
    }

    public Comment(int userId, int hotelId, String comment, int rating) {
        this.userId = userId;
        this.hotelId = hotelId;
        this.comment = comment;
        this.rating = rating;
    }

    public Comment(int id, int userId, int hotelId, String comment, int rating) {
        this.id = id;
        this.userId = userId;
        this.hotelId = hotelId;
        this.comment = comment;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", userId=" + userId + ", hotelId=" + hotelId + ", comment=" + comment + ", rating=" + rating + '}';
    }

    public static String
            toArrayJSon(ArrayList<Comment> comments) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(comments);

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
