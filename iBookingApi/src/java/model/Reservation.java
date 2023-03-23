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
    private int user;
    private int room;
    private int hotel;
    private String checkin;
    private String checkout;

    public Reservation(int user, int room, String checkin, String checkout) {
        this.user = user;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Reservation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getReservation_id() {
        return reservation_id;
    }

    public int getHotel() {
        return hotel;
    }

    public int getUser() {
        return user;
    }

    public int getRoom() {
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

    public void setUser(int user) {
        this.user = user;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setHotel(int hotel) {
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

        public static String
            toObjectJSon(User user) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(user);

        return resp;
    }
}
