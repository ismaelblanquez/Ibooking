package com.ismael.ibooking.Api;

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

}
