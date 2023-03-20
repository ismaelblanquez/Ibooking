package com.ismael.ibooking.Activities;

public class ReservationActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText dateEditText;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        nameEditText = findViewById(R.id.name_edit_text);
        dateEditText = findViewById(R.id.date_edit_text);
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
