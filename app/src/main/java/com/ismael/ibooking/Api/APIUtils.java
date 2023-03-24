package com.ismael.ibooking.Api;
import com.ismael.ibooking.Model.Pojo.Hotel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIUtils {
    private APIUtils() {}

    public static final String BASE_URL = "http://localhost:8080/api/";

    public static BookingAPI getBookingAPI() {
        return RetrofitClient.getClient(BASE_URL).create(BookingAPI.class);
    }

    public static void getAllHotels(Callback<List<Hotel>> callback) {
        BookingAPI bookingApi = Retrofit.create(BookingAPI.class);
        Call<List<Hotel>> call = bookingApi.getHotels();
        call.enqueue(callback);
    }

}
