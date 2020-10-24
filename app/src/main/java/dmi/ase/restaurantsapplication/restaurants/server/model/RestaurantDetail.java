package dmi.ase.restaurantsapplication.restaurants.server.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;


public class RestaurantDetail implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("imagePath")
    private String imagePath;
    @SerializedName("latitude")
    private double latitude;
    @SerializedName("longitude")
    private double longitude;
    @SerializedName("photos")
    private ArrayList<RestaurantPhoto> listOfPhoto;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public ArrayList<RestaurantPhoto> getListOfPhoto() {
        return listOfPhoto;
    }
}
