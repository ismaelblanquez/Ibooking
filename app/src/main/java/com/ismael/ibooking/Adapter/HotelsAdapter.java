package com.ismael.ibooking.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ismael.ibooking.Model.Pojo.Hotel;
import com.ismael.ibooking.R;

import java.util.List;

public class HotelsAdapter extends RecyclerView.Adapter<com.ismael.ibooking.HotelsAdapter.ViewHolder> {

    private List<Hotel> hotels;

    public HotelsAdapter(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public com.ismael.ibooking.HotelsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hotel_item, parent, false);
        return new com.ismael.ibooking.HotelsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(com.ismael.ibooking.HotelsAdapter.ViewHolder holder, int position) {
        Hotel hotel = hotels.get(position);
        holder.hotelName.setText(hotel.getName());
        holder.hotelRating.setText(String.valueOf(hotel.getRating()));
        holder.hotelDetailsButton.setOnClickListener(view -> {
            // Aquí puedes implementar la lógica para abrir la vista de detalles del hotel
        });
        // Aquí puedes cargar la imagen del hotel utilizando alguna biblioteca de imágenes como Picasso o Glide
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView hotelImage;
        public TextView hotelName;
        public TextView hotelRating;
        public Button hotelDetailsButton;

        public ViewHolder(View itemView) {
            super(itemView);
            hotelImage = itemView.findViewById(R.id.hotelImage);
            hotelName = itemView.findViewById(R.id.hotelName);
            hotelRating = itemView.findViewById(R.id.hotelRating);
            hotelDetailsButton = itemView.findViewById(R.id.hotelDetailsButton);
        }
    }

}