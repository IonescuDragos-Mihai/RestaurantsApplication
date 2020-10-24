package dmi.ase.restaurantsapplication.restaurants.server;

import dmi.ase.restaurantsapplication.restaurants.server.services.RestaurantService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerProvider {
    private static final String BASE_URL="https://83251966-c3e1-49e6-bc33-33ad1add82b0.mock.pstmn.io";
    public static RestaurantService createRestaurantService(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit.create(RestaurantService.class);
    }
    private ServerProvider(){

    }
}
