package com.ismael.ibooking.lstHoteles.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ismael.ibooking.R;
import com.ismael.ibooking.lstHoteles.presenter.HotelLstPresenter;

public class Hotel_View extends AppCompatActivity {
    private HotelLstPresenter hotelLstPresenter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    init();
    initViewModel();
    initAdapter();
    loadData();
    }

    private void init() {

    }
    private void initAdapter() {
    }

    private void initViewModel() {
    }
    private void loadData() {
    }

}
