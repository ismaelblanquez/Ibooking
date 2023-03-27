package com.ismael.ibooking.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import com.ismael.ibooking.R;
import com.ismael.ibooking.adapter.HotelAdapter;
import com.ismael.ibooking.entities.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HotelAdapter adapter;
    List<Hotel> hotels = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.hotelsRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //hotels traera la lista de hoteles del api

        adapter = new HotelAdapter(hotels ,this);
        recyclerView.setAdapter(adapter);
    }

    private void updateHotels(List<Hotel> hotels) {
        adapter.hotels = hotels;
        adapter.notifyDataSetChanged();
    }
}
