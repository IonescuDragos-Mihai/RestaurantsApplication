package dmi.ase.restaurantsapplication.restaurants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import dmi.ase.restaurantsapplication.R;
import dmi.ase.restaurantsapplication.restaurants.adapters.ImageRestaurantAdapter;
import dmi.ase.restaurantsapplication.restaurants.server.model.RestaurantDetail;
import dmi.ase.restaurantsapplication.restaurants.server.model.RestaurantPhoto;

public class RestaurantDetailsActivity extends AppCompatActivity {


    private AppCompatTextView titleRestaurant;
    private RecyclerView recyclerViewPhoto;
    private ImageRestaurantAdapter adapter;
    private AppCompatTextView details;
    private Intent intent;

    private ArrayList<RestaurantPhoto> photoOfRestaurants=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        initComponents();
    }

    private void initComponents() {

        titleRestaurant = findViewById(R.id.title_restaurant_details);
        details = findViewById(R.id.restaurant_details);
        recyclerViewPhoto = findViewById(R.id.recycler_view_photo);

        RestaurantDetail restaurant=getRestaurantDetailFromMainActivity();
        setView(restaurant);

        recyclerViewPhoto.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerViewPhoto.setHasFixedSize(true);
        adapter = new ImageRestaurantAdapter(photoOfRestaurants, getApplicationContext());
        recyclerViewPhoto.setAdapter(adapter);


    }
    private RestaurantDetail getRestaurantDetailFromMainActivity(){
        intent = getIntent();
        return (RestaurantDetail) intent.getSerializableExtra(MainActivity.KEY_PARSE_RESTAURANT);
    }
    private void setView(RestaurantDetail restaurant){
        titleRestaurant.setText(restaurant.getName());
        details.setText(restaurant.getDescription());
        photoOfRestaurants.addAll(restaurant.getListOfPhoto());
    }




}