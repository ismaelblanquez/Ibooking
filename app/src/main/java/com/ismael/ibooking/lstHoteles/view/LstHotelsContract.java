package com.ismael.ibooking.lstHoteles.view;

import java.util.ArrayList;


    public interface LstHotelsContract {
            public  interface  View{
                void successLstPeliculas(ArrayList<Index> lstIndex);
                void failureLstPeliculas(String err);
            }
            public interface  Presenter{
                void lstPeliculas(Index index);
            }
            public interface  Model{
                interface  OnLstPeliculasListener{
                    void  onSuccess(ArrayList<Index> index);
                    void  onFailure(String error);
                }
                void lstPeliculasWS(Index index, LstHotelsContract.Model.OnLstPeliculasListener onLstPeliculasListener);

            }

    }
