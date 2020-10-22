package dmi.ase.restaurantsapplication.restaurants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import dmi.ase.restaurantsapplication.MainActivity;
import dmi.ase.restaurantsapplication.R;
import dmi.ase.restaurantsapplication.models.ImageRestaurantAdapter;
import dmi.ase.restaurantsapplication.models.ImageURL;
import dmi.ase.restaurantsapplication.models.ItemRestaurant;
import dmi.ase.restaurantsapplication.models.ItemRestaurantAdapter;

public class RestaurantDetailsActivity extends AppCompatActivity {
    private AppCompatTextView titleRestaurant;
    private RecyclerView recyclerViewPhoto;
    private ImageRestaurantAdapter adapter;
    private AppCompatTextView details;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        initComponents();
    }

    private void initComponents() {


        titleRestaurant = findViewById(R.id.title_restaurant_details);
        details = findViewById(R.id.restaurant_details);
        intent = getIntent();
        ItemRestaurant restaurant = (ItemRestaurant) intent.getSerializableExtra(MainActivity.KEY_PARSE_RESTAURANT);
        titleRestaurant.setText(restaurant.getTitle());
        details.setText(restaurant.getSubtitle());


        recyclerViewPhoto = findViewById(R.id.recycler_view_photo);
        recyclerViewPhoto.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerViewPhoto.setHasFixedSize(true);
        adapter = new ImageRestaurantAdapter(getMockItems(), getApplicationContext());
        recyclerViewPhoto.setAdapter(adapter);


    }

    private ArrayList<ImageURL> getMockItems() {
        ArrayList<ImageURL> list = new ArrayList<>();
        list.add(new ImageURL("https://media-cdn.tripadvisor.com/media/photo-l/06/c6/e4/7e/the-clink-restaurant.jpg"));
        list.add(new ImageURL("https://media-cdn.tripadvisor.com/media/photo-l/06/c6/e3/d2/the-clink-restaurant.jpg"));
        list.add(new ImageURL("https://media-cdn.tripadvisor.com/media/photo-l/19/5f/35/54/salmon-teriyaki.jpg"));
        list.add(new ImageURL("https://media-cdn.tripadvisor.com/media/photo-l/06/c6/e4/7e/the-clink-restaurant.jpg"));
        list.add(new ImageURL("https://media-cdn.tripadvisor.com/media/photo-l/06/c6/e3/d2/the-clink-restaurant.jpg"));
        list.add(new ImageURL("https://media-cdn.tripadvisor.com/media/photo-l/19/5f/35/54/salmon-teriyaki.jpg"));
        return list;
    }


}