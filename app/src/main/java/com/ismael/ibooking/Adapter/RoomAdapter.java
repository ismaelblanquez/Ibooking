package com.ismael.ibooking.Adapter;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {

    private List<Room> mRooms;
    private Context mContext;

    public RoomAdapter(List<Room> rooms, Context context) {
        mRooms = rooms;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Room room = mRooms.get(position);
        holder.roomType.setText(room.getType());
        holder.roomPrice.setText(String.format(Locale.getDefault(), "$%.2f", room.getPrice()));
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, RoomDetailActivity.class);
            intent.putExtra(RoomDetailActivity.EXTRA_ROOM_ID, room.getId());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mRooms.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView roomType;
        TextView roomPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            roomType = itemView.findViewById(R.id.room_type);
            roomPrice = itemView.findViewById(R.id.room_price);
        }
    }
}
