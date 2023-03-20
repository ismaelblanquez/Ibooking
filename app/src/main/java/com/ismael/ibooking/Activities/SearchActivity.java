package com.ismael.ibooking.Activities;

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
        btnSearch = findViewById(R.id.btnSearch);
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
