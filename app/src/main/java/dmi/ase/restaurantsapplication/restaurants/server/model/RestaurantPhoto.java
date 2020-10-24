package dmi.ase.restaurantsapplication.restaurants.server.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RestaurantPhoto implements Serializable {

    @SerializedName("imagePath")
    private String photoUrl;
    public String getPhotoUrl() {
        return photoUrl;
    }
}
