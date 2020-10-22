package dmi.ase.restaurantsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import dmi.ase.restaurantsapplication.models.ItemRestaurant;
import dmi.ase.restaurantsapplication.models.ItemRestaurantAdapter;
import dmi.ase.restaurantsapplication.restaurants.RestaurantDetailsActivity;


public class MainActivity extends AppCompatActivity {
    public static final String KEY_PARSE_RESTAURANT = "KEY";
    private RecyclerView recyclerView;
    private Intent intent;
    private ItemRestaurantAdapter adapter;
    private ProgressBar progressBar;
    private   ArrayList<ItemRestaurant>  itemRestaurantList=new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        progressBar=findViewById(R.id.progress_bar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        adapter=new ItemRestaurantAdapter(getMockItems(),getBaseContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }, 2000);

        onClickItemRestaurant();

        
    }
    private void onClickItemRestaurant(){
        adapter.setOnItemClickListener(new ItemRestaurantAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                intent=new Intent(getApplicationContext(), RestaurantDetailsActivity.class);
                intent.putExtra(KEY_PARSE_RESTAURANT,itemRestaurantList.get(position));
                startActivity(intent);
            }
        });
    }


    private ArrayList<ItemRestaurant> getMockItems() {

        itemRestaurantList.add(new ItemRestaurant(R.drawable.ic_launcher_background,
                "The Chelsea Corner","Authentic Italian for us always means the freshest ingredients that are rightly dictated by the season. Everything here is homemade and sourced with love and passion, from our daily landed fish to vegetables from New Covent Garden Market. The Chelsea Corner offers a rich Italian menu choice and something for everyone."));
        itemRestaurantList.add(new ItemRestaurant(R.drawable.ic_launcher_background,"Companero","Compañero is the new Street Tapas brought to you by Nikolaus Greig and utilising his vast experience in food & wine. After many years working in successful restaurants he has taken his cooking skills and knowledge a step further. Compañero is a street food concept that will exhibit fine Spanish Tapas in Londons best locations."));
        itemRestaurantList.add(new ItemRestaurant(R.drawable.ic_launcher_background,"The Gojk","The Gojk, pronounced “G-oi-k”, is a family run contemporary restaurant & lounge designed with great passion. We are a dynamic and authentic restaurant in the heart of Kensington & Chelsea. We wanted to create a space that we ourselves would like to go to, in which to enjoy exciting food, fantastic wines and original cocktails. We are here to create a unique and memorable experience and we pride ourselves in having exceptional dishes, great service and delightful atmosphere. The Gojk family warmly invites you to dine at our restaurant!"));

         return  itemRestaurantList;
    }
}
