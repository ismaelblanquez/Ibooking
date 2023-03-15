package com.ismael.ibooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ismael.ibooking.Adapter.HotelsAdapter;
import com.ismael.ibooking.Model.Pojo.Hotel;

import java.util.ArrayList;
import java.util.List;

ppublic class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HotelsAdapter hotelsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener referencia del RecyclerView
        recyclerView = findViewById(R.id.hotelsRecyclerView);

        // Crear adapter y asignarlo al RecyclerView
        hotelsAdapter = new HotelsAdapter(getDummyHotels()); // Aquí debes reemplazar getDummyHotels() por una lista real de hoteles
        recyclerView.setAdapter(hotelsAdapter);

        // Configurar el LinearLayoutManager para el RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    // Método para generar una lista dummy de hoteles
    private List<Hotel> getDummyHotels() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("Hotel 1", "Descripción del hotel 1", 4.5f, "https://picsum.photos/id/1/200/300"));
        hotels.add(new Hotel("Hotel 2", "Descripción del hotel 2", 4.2f, "https://picsum.photos/id/2/200/300"));
        hotels.add(new Hotel("Hotel 3", "Descripción del hotel 3", 3.9f, "https://picsum.photos/id/3/200/300"));
        return hotels;
    }
}
