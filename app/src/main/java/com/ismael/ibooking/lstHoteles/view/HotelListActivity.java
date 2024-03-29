package com.ismael.ibooking.lstHoteles.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import com.ismael.ibooking.R;
import com.ismael.ibooking.adapter.HotelAdapter;
import com.ismael.ibooking.entities.Hotel;
import com.ismael.ibooking.lstHoteles.LstHotelsContract;
import com.ismael.ibooking.lstHoteles.model.LstHotelsModel;
import com.ismael.ibooking.lstHoteles.presenter.LstHotelsPresenter;

import java.util.ArrayList;
import java.util.List;


    public class HotelListActivity extends AppCompatActivity implements LstHotelsContract.View {

        private RecyclerView recyclerView;
        private HotelAdapter adapter;
        private LstHotelsPresenter presenter;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerView = findViewById(R.id.hotelsRecyclerView);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            adapter = new HotelAdapter(new ArrayList<>(), getApplicationContext());
            recyclerView.setAdapter(adapter);

            presenter = new LstHotelsPresenter(this);
            presenter.lstHotels();
        }




        @Override
        public void successLstHotels(List<Hotel> lstHotel) {
            adapter.setHotels(lstHotel);
        }

        @Override
        public void failureLstHotels(String err) {

        }
    }


