package dmi.ase.restaurantsapplication.restaurants;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Visibility;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import dmi.ase.restaurantsapplication.R;
import dmi.ase.restaurantsapplication.restaurants.adapters.ImageRestaurantAdapter;
import dmi.ase.restaurantsapplication.restaurants.server.model.RestaurantDetail;
import dmi.ase.restaurantsapplication.restaurants.server.model.RestaurantPhoto;
import dmi.ase.restaurantsapplication.restaurants.utils.SharePrefUtil;

public class RestaurantDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {


    public static final String SAVE_FAV = "isFav";
    private AppCompatTextView titleRestaurant;
    private RecyclerView recyclerViewPhoto;
    private ImageRestaurantAdapter adapter;
    private AppCompatTextView details;
    private Intent intent;
    private Toolbar toolbarRestaurantDetail;
    private MapView mapViewRestaurantDetail;
    private RestaurantDetail restaurant;


    private ArrayList<RestaurantPhoto> photoOfRestaurants = new ArrayList<>();


    private boolean isFavorite ;

    private SharePrefUtil sharePrefUtil;
    private String favRestaurant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        initComponents();
        createMapView(savedInstanceState);
    }

    private void initComponents() {

        titleRestaurant = findViewById(R.id.title_restaurant_details);
        details = findViewById(R.id.restaurant_details);
        recyclerViewPhoto = findViewById(R.id.recycler_view_photo);

        mapViewRestaurantDetail = findViewById(R.id.map_view_restaurant_details);


        toolbarRestaurantDetail = findViewById(R.id.tool_bar_restaurant_detail);
        setSupportActionBar(toolbarRestaurantDetail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        restaurant = getRestaurantDetailFromMainActivity();
        setView(restaurant);


        recyclerViewPhoto.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerViewPhoto.setHasFixedSize(true);
        adapter = new ImageRestaurantAdapter(photoOfRestaurants, getApplicationContext());
        recyclerViewPhoto.setAdapter(adapter);


        sharePrefUtil = new SharePrefUtil(getApplicationContext());
        isFavorite=sharePrefUtil.getFavorite(restaurant.getName());

    }


    private void createMapView(Bundle saveInstanceState) {
        mapViewRestaurantDetail.onCreate(saveInstanceState);
        mapViewRestaurantDetail.onResume();

        mapViewRestaurantDetail.getMapAsync(this);
    }

    private RestaurantDetail getRestaurantDetailFromMainActivity() {
        intent = getIntent();
        return (RestaurantDetail) intent.getSerializableExtra(MainActivity.KEY_PARSE_RESTAURANT);
    }

    private void setView(RestaurantDetail restaurant) {
        titleRestaurant.setText(restaurant.getName());
        details.setText(restaurant.getDescription());
        photoOfRestaurants.addAll(restaurant.getListOfPhoto());
        toolbarRestaurantDetail.setTitle(restaurant.getName());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng coordonates = new LatLng(restaurant.getLatitude(), restaurant.getLongitude());
        googleMap.addMarker(new MarkerOptions().position(coordonates)
                .title(restaurant.getName()));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordonates, 16));


    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if (isFavorite) {
            menu.getItem(0).setIcon(R.drawable.ic_baseline_favorite_24);

        } else {
            menu.getItem(0).setIcon(R.drawable.ic_baseline_favorite_border_24);
        }
        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_favorite, menu);
        return true;
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_to_fav) {
            if (isFavorite) {

                item.setIcon(R.drawable.ic_baseline_favorite_border_24);
                isFavorite = false;
                sharePrefUtil.removeFavorite(restaurant.getName());


            } else {
                item.setIcon(R.drawable.ic_baseline_favorite_24);
                isFavorite = true;
                sharePrefUtil.putFavorite(restaurant.getName(), isFavorite);

            }
        }
        return super.onOptionsItemSelected(item);

    }



}