package com.ismael.ibooking.utils;

import com.ismael.ibooking.entities.Comment;
import com.ismael.ibooking.entities.Hotel;
import com.ismael.ibooking.entities.Location;
import com.ismael.ibooking.entities.Reservation;
import com.ismael.ibooking.entities.Room;
import com.ismael.ibooking.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BookingAPI {

    @GET("hotels")
    Call<List<Hotel>> getHotels();

    @GET("rooms")
    Call<List<Room>> getRooms();

    @GET("locations")
    Call<List<Location>> getLocation();

    @GET("comments")
    Call<List<Comment>> getComment();

    @GET("reservations")
    Call<List<Reservation>> getReservation();



    @POST("reservations")
    Call<Reservation> createReservation(@Body Reservation reservation);

    @PUT("reservations/{id}")
    Call<Reservation> updateReservation(@Path("id") int id, @Body Reservation reservation);

    @DELETE("reservations/{id}")
    Call<Void> deleteReservation(@Path("id") int id);

    Call<Void> createUser(User user);




}
