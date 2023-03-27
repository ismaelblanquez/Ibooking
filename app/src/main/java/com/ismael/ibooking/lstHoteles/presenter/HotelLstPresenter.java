package com.ismael.ibooking.lstHoteles.presenter;

import com.ismael.ibooking.entities.Hotel;

import com.ismael.ibooking.lstHoteles.model.LstHotelsModel;
import com.ismael.ibooking.lstHoteles.view.Hotel_View;
import com.ismael.ibooking.lstHoteles.view.LstHotelsContract;

import java.util.List;

public class HotelLstPresenter implements LstHotelsContract.Presenter {
    private LstHotelsModel lstHotelsModel;
    private LstHotelsContract.View view;


    public HotelLstPresenter(LstHotelsContract.View view) {
        this.lstHotelsModel = new LstHotelsModel();
        this.view = view;
    }


    @Override
    public void lstHotels(Hotel hotel) {
        lstHotelsModel.lstHotelesWS(hotel, new LstHotelsContract.Model.OnLstHotelsListener() {
            @Override
            public void onSuccess(List<Hotel> index) {
                if (index != null && index.size() > 0) {
                    view.successLstHotels(index);
                }
            }

            @Override
            public void onFailure(String error) {
                view.failureLstHotels(error);
            }
        });
    }
}
