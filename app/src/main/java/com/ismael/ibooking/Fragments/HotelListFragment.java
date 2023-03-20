package com.ismael.ibooking.Fragments;

public class HotelListFragment extends Fragment implements HotelAdapter.OnHotelClickListener {

    private List<Hotel> hotelList;
    private RecyclerView recyclerView;
    private HotelAdapter adapter;

    public HotelListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotel_list, container, false);

        // Initialize the recyclerview and adapter
        recyclerView = view.findViewById(R.id.recyclerview_hotel);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HotelAdapter(getContext(), hotelList, this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onHotelClick(int position) {
        // Handle hotel item click event
        Hotel selectedHotel = hotelList.get(position);
        // Start the reservation activity and pass the selected hotel object
        Intent intent = new Intent(getActivity(), ReservationActivity.class);
        intent.putExtra("selectedHotel", selectedHotel);
        startActivity(intent);
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
