package com.ismael.ibooking.utils;

import com.ismael.ibooking.entities.Comment;
import com.ismael.ibooking.entities.Hotel;
import com.ismael.ibooking.entities.Location;
import com.ismael.ibooking.entities.Reservation;
import com.ismael.ibooking.entities.Room;
import com.ismael.ibooking.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIUtils {


    public static final String BASE_URL = "http://localhost:8080/api/";

    private  static Retrofit retrofit = null;

    public static Retrofit getAll() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
