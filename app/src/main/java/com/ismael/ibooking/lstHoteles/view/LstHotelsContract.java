package com.ismael.ibooking.lstHoteles.view;

import com.ismael.ibooking.entities.Hotel;

import java.util.ArrayList;
import java.util.List;


public interface LstHotelsContract {
            public  interface  View{
                void successLstHotels(List<Hotel> lstHotel);
                void failureLstHotels(String err);
            }

            public interface  Presenter{
                void lstHotels(Hotel hotel);

            }

            public interface  Model{
                interface  OnLstHotelsListener{
                    void  onSuccess(List<Hotel> index);
                    void  onFailure(String error);
                }
                void lstHotelesWS(Hotel hotel, LstHotelsContract.Model.OnLstHotelsListener onLstPeliculasListener);

            }

    }
