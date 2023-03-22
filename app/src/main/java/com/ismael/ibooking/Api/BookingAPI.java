package com.ismael.ibooking.Api;

import com.ismael.ibooking.Model.Pojo.Hotel;
import com.ismael.ibooking.Model.Pojo.Reservation;
import com.ismael.ibooking.Model.Pojo.User;

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

    @GET("hotels/{id}")
    Call<Hotel> getHotelById(@Path("id") int id);

    @GET("hotels/{id}/rooms")
    Call<List<Room>> getRoomsByHotelId(@Path("id") int id);

    @GET("rooms/{id}")
    Call<Room> getRoomById(@Path("id") int id);

    @GET("rooms/{id}/reservations")
    Call<List<Reservation>> getReservationsByRoomId(@Path("id") int id);

    @POST("reservations")
    Call<Reservation> createReservation(@Body Reservation reservation);

    @PUT("reservations/{id}")
    Call<Reservation> updateReservation(@Path("id") int id, @Body Reservation reservation);

    @DELETE("reservations/{id}")
    Call<Void> deleteReservation(@Path("id") int id);

    Call<Void> createUser(User user);
}
