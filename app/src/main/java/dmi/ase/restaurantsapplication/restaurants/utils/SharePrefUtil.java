package dmi.ase.restaurantsapplication.restaurants.utils;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class SharePrefUtil {
    private static final String NAME_FILE="Favorites";
    private static final String defaultRestaurant="defaultRestaurant";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharePrefUtil(Context context) {
        this.sharedPreferences = context.getSharedPreferences(NAME_FILE, Activity.MODE_PRIVATE);
        this.editor =sharedPreferences.edit();
    }
    public String getFavorite(String nameRestaurant){
        return sharedPreferences.getString(nameRestaurant,defaultRestaurant);

    }
    public  void  putFavorite(String key,String nameRestaurant){
           editor.putString(key,nameRestaurant);
           editor.apply();
    }
    public void removeFavorite(String key){
        editor.remove(key);
        editor.apply();
    }
}
