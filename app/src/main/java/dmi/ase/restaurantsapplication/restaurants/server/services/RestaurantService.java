package dmi.ase.restaurantsapplication.restaurants.server.services;

import java.util.ArrayList;

import dmi.ase.restaurantsapplication.restaurants.server.model.RestaurantDetail;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestaurantService {
    @GET("/restaurant/list")
    Call<ArrayList<RestaurantDetail>> getRestaurantDetail();
}
