package com.ismael.ibooking.lstHoteles.model;

import com.google.gson.Gson;
import com.ismael.ibooking.entities.Hotel;
import com.ismael.ibooking.lstHoteles.view.LstHotelsContract;
import com.ismael.ibooking.utils.APIUtils;
import com.ismael.ibooking.utils.BookingAPI;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstHotelsModel implements LstHotelsContract.Model {
    private Gson gson = new Gson();

    @Override
    public void lstHotelesWS(Hotel hotel, OnLstHotelsListener onLstHotelsListener) {
        getHotelsService(onLstHotelsListener);
    }

    private void getHotelsService(final OnLstHotelsListener onLstHotelsListener) {
        BookingAPI hotelesApi = APIUtils.getBookingAPI().create(BookingAPI.class);
        Call<List<Hotel>> lstHoteles = hotelesApi.getHotels();
        lstHoteles.enqueue(new Callback<List<Hotel>>() {
            @Override
            public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                if (response.isSuccessful()) {
                    List<Hotel> lstHoteles = response.body();
                    onLstHotelsListener.onSuccess(lstHoteles);
                } else {
                    onLstHotelsListener.onFailure("Error al obtener la lista de hoteles");
                }
            }

            @Override
            public void onFailure(Call<List<Hotel>> call, Throwable t) {
                onLstHotelsListener.onFailure("Error al obtener la lista de hoteles");
            }
        });
    }
}
