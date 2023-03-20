public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private List<Hotel> hotels;
    private OnHotelClickListener onHotelClickListener;

    public HotelAdapter(List<Hotel> hotels, OnHotelClickListener onHotelClickListener) {
        this.hotels = hotels;
        this.onHotelClickListener = onHotelClickListener;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hotel, parent, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        Hotel hotel = hotels.get(position);
        holder.bind(hotel, onHotelClickListener);
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public static class HotelViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView nameTextView;
        private TextView ratingTextView;
        private TextView priceTextView;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            ratingTextView = itemView.findViewById(R.id.rating_text_view);
            priceTextView = itemView.findViewById(R.id.price_text_view);
        }

        public void bind(final Hotel hotel, final OnHotelClickListener onHotelClickListener) {
            Picasso.get().load(hotel.getImageUrl()).into(imageView);
            nameTextView.setText(hotel.getName());
            ratingTextView.setText(String.valueOf(hotel.getRating()));
            priceTextView.setText(String.valueOf(hotel.getPrice()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onHotelClickListener.onHotelClick(hotel);
                }
            });
        }
    }

    public interface OnHotelClickListener {
        void onHotelClick(Hotel hotel);
    }
}
