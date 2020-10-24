package dmi.ase.restaurantsapplication.restaurants.model;

import android.widget.ImageView;

import java.io.Serializable;

public class ItemRestaurant implements Serializable {
    private String iconURL;
    private String title;
    private String subtitle;

    public ItemRestaurant(String iconURL, String title, String subtitle) {
        this.iconURL = iconURL;
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
