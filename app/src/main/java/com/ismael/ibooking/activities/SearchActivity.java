package com.ismael.ibooking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ismael.ibooking.utils.APIUtils;
import com.ismael.ibooking.utils.BookingAPI;
import com.ismael.ibooking.entities.Hotel;
import com.ismael.ibooking.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity implements HotelAdapter.ItemClickListener {
    private EditText etSearch;
    private Button btnSearch;
    private RecyclerView rvHotels;
    private HotelAdapter adapter;
    private List<Hotel> hotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etSearch = findViewById(R.id.etSearch);
        btnSearch = findViewById(R.id.search_button);
        rvHotels = findViewById(R.id.rvHotels);
        rvHotels.setLayoutManager(new LinearLayoutManager(this));

        hotels = new ArrayList<>();
        adapter = new HotelAdapter(this, hotels);
        adapter.setClickListener(this);
        rvHotels.setAdapter(adapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchHotels();
            }
        });
    }

    private void searchHotels() {
        String query = etSearch.getText().toString().trim();
        if (query.isEmpty()) {
            Toast.makeText(this, "Ingrese un término de búsqueda válido", Toast.LENGTH_SHORT).show();
            return;
        }

        hotels.clear();
        adapter.notifyDataSetChanged();

        BookingAPI bookingAPI = APIUtils.getBookingAPI();
        Call<List<Hotel>> call = bookingAPI.searchHotels(query);
        call.enqueue(new Callback<List<Hotel>>() {
            @Override
            public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                if (response.isSuccessful()) {
                    hotels.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(SearchActivity.this, "Error al buscar hoteles", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Hotel>> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "Error al buscar hoteles", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, HotelActivity.class);
        intent.putExtra("hotel_id", hotels.get(position).getId());
        startActivity(intent);
    }
}
