package com.ismael.ibooking.activities;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.ismael.ibooking.R;
import com.ismael.ibooking.entities.Reservation;
import com.ismael.ibooking.entities.User;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private ListView historyListView;
    private HistoryAdapter historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // Obtener la lista de reservas del usuario
        ArrayList<Reservation> userReservations = User.getCurrentUser().getReservations();

        // Inicializar el ListView y el Adapter
        historyListView = findViewById(R.id.history_list);
        historyAdapter = new HistoryAdapter(this, userReservations);
        historyListView.setAdapter(historyAdapter);
    }

    //comment, hotel, location, reservation, room, user
}
