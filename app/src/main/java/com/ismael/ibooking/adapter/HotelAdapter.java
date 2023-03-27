package com.ismael.ibooking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ismael.ibooking.entities.Hotel;
import com.ismael.ibooking.R;
import com.squareup.picasso.Picasso;



import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private List<Hotel> hotels;
    private Context context;

    private static OnHotelClickListener onHotelClickListener;
    public HotelAdapter(List<Hotel> hotels, Context context) {
        this.hotels = hotels;
        this.context = context;

    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        Hotel hotel = hotels.get(position);
        holder.bind(hotel);
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public void setHotels(List<Hotel> lstHotel) {
        this.hotels = lstHotel;
        notifyDataSetChanged();
    }

    public static class HotelViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView nameTextView;
        private TextView ratingTextView;
        private TextView priceTextView;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hotel_image);
            nameTextView = itemView.findViewById(R.id.hotel_name);
            //ratingTextView = itemView.findViewById(R.id.);
            //priceTextView = itemView.findViewById(R.id.hote);
        }

        public void bind(final Hotel hotel) {
            Picasso.get().load(hotel.getImage_url()).into(imageView);
            nameTextView.setText(hotel.getName());
            ratingTextView.setText(String.valueOf(hotel.getRating()));


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
