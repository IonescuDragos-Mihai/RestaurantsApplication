package dmi.ase.restaurantsapplication.models;

import android.content.ClipData;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dmi.ase.restaurantsapplication.R;

public class ItemRestaurantAdapter extends  RecyclerView.Adapter<ItemRestaurantAdapter.ItemViewHolder>{

    private ArrayList<ItemRestaurant> items;
    private Context context;
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
        holder.image.setImageDrawable(ContextCompat.getDrawable(context,item.getIcon()));
        holder.subtitle.setText(item.getSubtitle());
        holder.title.setText(item.getTitle());

    }

    @Override
    public int getItemCount() {
        return  items.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{
        private AppCompatImageView image;
        private AppCompatTextView title;
        private AppCompatTextView subtitle;

        public ItemViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            image=itemView.findViewById(R.id.list_item_icon);
            title=itemView.findViewById(R.id.list_item_title);
            subtitle=itemView.findViewById(R.id.list_item_subtitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        if(listener!=null){
                            int position=getAdapterPosition();
                            if(position!= RecyclerView.NO_POSITION);{
                                listener.onItemClickListener(position);
                            }
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
