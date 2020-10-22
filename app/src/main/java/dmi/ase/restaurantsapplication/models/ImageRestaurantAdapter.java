package dmi.ase.restaurantsapplication.models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


import dmi.ase.restaurantsapplication.R;

public class ImageRestaurantAdapter extends RecyclerView.Adapter<ImageRestaurantAdapter.ImageViewHolder> {

    private ArrayList<ImageURL> listURLImage;
    private Context context;

    public ImageRestaurantAdapter(ArrayList<ImageURL> mockItems, Context baseContext) {
        this.listURLImage = mockItems;
        this.context = baseContext;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_details_layout, parent, false);

        return new ImageRestaurantAdapter.ImageViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        ImageURL img = listURLImage.get(position);
        Glide.with(context).load(img.getImageUrl()).into(holder.imageRestaurant);

    }

    @Override
    public int getItemCount() {
        return listURLImage.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView imageRestaurant;


        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageRestaurant = itemView.findViewById(R.id.image_restaurants);
        }
    }
}
