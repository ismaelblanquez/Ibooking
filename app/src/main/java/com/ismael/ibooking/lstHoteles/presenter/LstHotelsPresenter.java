package com.ismael.ibooking.lstHoteles.presenter;

import com.ismael.ibooking.entities.Hotel;

import com.ismael.ibooking.lstHoteles.model.LstHotelsModel;
import com.ismael.ibooking.lstHoteles.LstHotelsContract;

import java.util.List;

public class LstHotelsPresenter implements LstHotelsContract.Presenter {
    // Instancia de la clase LstHotelsModel y la interfaz LstHotelsContract.View.
    private LstHotelsModel lstHotelsModel;
    private LstHotelsContract.View view;

    /**
     * Constructor del HotelLstPresenter que inicializa el modelo y la vista.
     * @param view - la vista a la que se comunica.
     */
    public LstHotelsPresenter(LstHotelsContract.View view) {
        this.lstHotelsModel = new LstHotelsModel();
        this.view = view;
    }

    /**
     * Método que se encarga de llamar al método lstHotelesWS() del modelo y le pasa la entidad Hotel y un OnLstHotelsListener
     * como parámetros. Cuando el modelo termine la operación llamará al método onSuccess() o onFailure() del listener.
     * @param hotel - entidad Hotel.
     */
    @Override
    public void lstHotels(Hotel hotel) {
        lstHotelsModel.lstHotelesWS(hotel, new LstHotelsContract.Model.OnLstHotelsListener() {
            @Override
            public void onSuccess(List<Hotel> index) {
                // Si la lista de hoteles no es nula y tiene algún elemento se llama al método successLstHotels de la vista.
                if (index != null && index.size() > 0) {
                    view.successLstHotels(index);
                }
            }

            @Override
            public void onFailure(String error) {
                // Si ha habido algún error en la petición se llama al método failureLstHotels de la vista.
                view.failureLstHotels(error);
            }
        });
    }


}
