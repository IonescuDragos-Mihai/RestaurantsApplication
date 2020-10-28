package dmi.ase.restaurantsapplication.restaurants.model;


import java.io.Serializable;

public class ItemRestaurant implements Serializable {
    private final String iconURL;
    private final String title;
    private final String subtitle;

    public ItemRestaurant(String iconURL, String title, String subtitle) {
        this.iconURL = iconURL;
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getIconURL() {
        return iconURL;
    }

    public String getTitle() {
        return title;
    }


    public String getSubtitle() {
        return subtitle;
    }


}
