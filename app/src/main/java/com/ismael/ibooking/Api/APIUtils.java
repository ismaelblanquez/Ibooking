package com.ismael.ibooking.Api;

public class APIUtils {
    private APIUtils() {}

    public static final String BASE_URL = "http://localhost:8080/api/";

    public static BookingAPI getBookingAPI() {
        return RetrofitClient.getClient(BASE_URL).create(BookingAPI.class);
    }
}
