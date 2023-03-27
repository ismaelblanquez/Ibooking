package com.ismael.ibooking.lstHoteles.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ismael.ibooking.R;

public class ReservationActivity extends AppCompatActivity {

    private TextView nameEditText;
    private TextView dateEditText;
    private Button confirmButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        nameEditText = findViewById(R.id.hotel_name);
        dateEditText = findViewById(R.id.arrival_date);
        confirmButton = findViewById(R.id.confirm_button);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String date = dateEditText.getText().toString();

                // Do something with name and date, like save them to a database

                // Show a confirmation message to the user
                Toast.makeText(ReservationActivity.this, "Reservation confirmed for " + name + " on " + date, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
