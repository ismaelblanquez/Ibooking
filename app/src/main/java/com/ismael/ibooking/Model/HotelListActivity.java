package com.ismael.ibooking.Model;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ismael.ibooking.Adapter.HotelsAdapter;

import com.ismael.ibooking.R;

import java.util.List;

public class HotelListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HotelsAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_item);

        recyclerView = findViewById(R.id.hotelsRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //hotels traera la lista de hoteles del api
        List<Hotel> hotels;
        adapter = new HotelsAdapter(hotels);
        recyclerView.setAdapter(adapter);
    }

    private void updateHotels(List<Hotel> hotels) {
        adapter.hotels = hotels;
        adapter.notifyDataSetChanged();
    }
}
