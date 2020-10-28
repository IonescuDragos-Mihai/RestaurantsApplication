package dmi.ase.restaurantsapplication.restaurants.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import dmi.ase.restaurantsapplication.R;
import dmi.ase.restaurantsapplication.restaurants.model.ItemRestaurant;

public class ItemRestaurantAdapter extends  RecyclerView.Adapter<ItemRestaurantAdapter.ItemViewHolder>{

    private final ArrayList<ItemRestaurant> items;
    private final Context context;
    private OnItemClickListener listener;

    public ItemRestaurantAdapter(ArrayList<ItemRestaurant> items, Context baseContext) {
        this.items=items;
        this.context=baseContext;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant, parent, false);
        return new ItemViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemRestaurant item=items.get(position);
        holder.subtitle.setText(item.getSubtitle());
        holder.title.setText(item.getTitle());
        Glide.with(context).load(item.getIconURL()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return  items.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        private final AppCompatImageView image;
        private final AppCompatTextView title;
        private final AppCompatTextView subtitle;

        public ItemViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            image=itemView.findViewById(R.id.list_item_icon);
            title=itemView.findViewById(R.id.list_item_title);
            subtitle=itemView.findViewById(R.id.list_item_subtitle);

            itemView.setOnClickListener(view -> {
                    if(listener!=null){
                        int position=getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.onItemClickListener(position);
                        }
                    }
            });
        }
    }
    public interface  OnItemClickListener{
        void onItemClickListener(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }
}
