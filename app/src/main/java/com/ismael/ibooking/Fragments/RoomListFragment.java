package com.ismael.ibooking.Fragments;

public class RoomListFragment extends Fragment {
    private RecyclerView recyclerView;
    private RoomAdapter roomAdapter;
    private List<Room> roomList;
    private Hotel hotel;

    public RoomListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room_list, container, false);

        // Obtener el objeto Hotel seleccionado en HotelListFragment
        hotel = getArguments().getParcelable("selectedHotel");

        // Configurar RecyclerView y RoomAdapter
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        roomList = hotel.getRoomList();
        roomAdapter = new RoomAdapter(roomList);
        recyclerView.setAdapter(roomAdapter);

        return view;
    }
}
