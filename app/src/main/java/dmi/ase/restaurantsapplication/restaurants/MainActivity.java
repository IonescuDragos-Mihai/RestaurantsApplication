package dmi.ase.restaurantsapplication.restaurants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import dmi.ase.restaurantsapplication.R;
import dmi.ase.restaurantsapplication.restaurants.model.ItemRestaurant;
import dmi.ase.restaurantsapplication.restaurants.adapters.ItemRestaurantAdapter;
import dmi.ase.restaurantsapplication.restaurants.server.model.RestaurantDetail;
import dmi.ase.restaurantsapplication.restaurants.server.ServerProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    public static final String KEY_PARSE_RESTAURANT = "KEY";

    private RecyclerView recyclerView;
    private Intent intent;
    private ItemRestaurantAdapter adapter;
    private ProgressBar progressBar;

    private ArrayList<ItemRestaurant> itemRestaurantList = new ArrayList<>();
    private ArrayList<RestaurantDetail> restaurantDetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        onClickItemRestaurant();

        getRestaurantsDetail();

    }

    private void initComponents() {
        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress_bar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        adapter = new ItemRestaurantAdapter(itemRestaurantList, getBaseContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }


    private void getRestaurantsDetail() {
        ServerProvider.createRestaurantService().getRestaurantDetail().enqueue(new Callback<ArrayList<RestaurantDetail>>() {
            @Override
            public void onResponse(Call<ArrayList<RestaurantDetail>> call, Response<ArrayList<RestaurantDetail>> response) {
                if (response.body() != null) {
                    restaurantDetails = response.body();
                    for (RestaurantDetail restaurant : restaurantDetails) {
                        itemRestaurantList.add(new ItemRestaurant(restaurant.getImagePath(),
                                restaurant.getName(), restaurant.getDescription()));
                    }
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<RestaurantDetail>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), R.string.message_failed_load_data, Toast.LENGTH_LONG).show();
            }
        });
    }


    private void onClickItemRestaurant() {
        adapter.setOnItemClickListener(position -> {
            intent = new Intent(getApplicationContext(), RestaurantDetailsActivity.class);
            intent.putExtra(KEY_PARSE_RESTAURANT, restaurantDetails.get(position));
            startActivity(intent);
        });
    }


}
