package dmi.ase.restaurantsapplication.restaurants.utils;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;



public class SharePrefUtil {
    private static final String NAME_FILE="Favorites";
    private static final boolean defaultValue=false;
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    public SharePrefUtil(Context context) {
        this.sharedPreferences = context.getSharedPreferences(NAME_FILE, Activity.MODE_PRIVATE);
        this.editor =sharedPreferences.edit();
    }
    public boolean getFavorite(String nameRestaurant){
        return sharedPreferences.getBoolean(nameRestaurant,defaultValue);

    }
    public  void  putFavorite(String keyNameRestaurant,boolean isFavorite){
           editor.putBoolean(keyNameRestaurant,isFavorite);
           editor.apply();
    }
    public void removeFavorite(String keyNameRestaurant){
        editor.remove(keyNameRestaurant);
        editor.apply();
    }

}
