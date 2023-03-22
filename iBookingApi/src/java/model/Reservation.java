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
public class Reservation {

    private Integer reservation_id;
    private User user;
    private Room room;
    private Hotel hotel;
    private String checkin;
    private String checkout;

    public Reservation(User user, Room room, String checkin, String checkout) {
        this.user = user;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getReservation_id() {
        return reservation_id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setReservation_id(Integer reservation_id) {
        this.reservation_id = reservation_id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Reservation{" + "reservation_id=" + reservation_id + ", user=" + user + ", room=" + room + ", hotel=" + hotel + ", checkin=" + checkin + ", checkout=" + checkout + '}';
    }
    
    public static String 
        toArrayJSon(ArrayList<Reservation> reservations) {
            GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            String resp = gson.toJson(reservations);
            
            return resp;
    }

}
