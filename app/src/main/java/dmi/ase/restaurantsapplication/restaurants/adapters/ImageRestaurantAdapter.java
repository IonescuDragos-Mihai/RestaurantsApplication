package dmi.ase.restaurantsapplication.restaurants.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


import dmi.ase.restaurantsapplication.R;
import dmi.ase.restaurantsapplication.restaurants.server.model.RestaurantPhoto;

public class ImageRestaurantAdapter extends RecyclerView.Adapter<ImageRestaurantAdapter.ImageViewHolder> {

    private final ArrayList<RestaurantPhoto> listURLImage;
    private final Context context;

    public ImageRestaurantAdapter(ArrayList<RestaurantPhoto> mockItems, Context baseContext) {
       this.listURLImage=mockItems;
        this.context = baseContext;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_details_layout_image, parent, false);

        return new ImageRestaurantAdapter.ImageViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        RestaurantPhoto img = listURLImage.get(position);
        Glide.with(context).load(img.getPhotoUrl()).into(holder.imageRestaurant);

    }

    @Override
    public int getItemCount() {
        return listURLImage.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatImageView imageRestaurant;


        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageRestaurant = itemView.findViewById(R.id.image_restaurants);
        }
    }
}
