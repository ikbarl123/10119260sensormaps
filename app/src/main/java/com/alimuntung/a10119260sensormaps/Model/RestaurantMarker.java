package com.alimuntung.a10119260sensormaps.Model;
// Ikbar Laudza Alviansyah
// IF-7
// 10119260
public class RestaurantMarker {
    private double lat;
    private double lng;
    private String title;

    public RestaurantMarker(double lat, double lng, String title) {
        this.lat = lat;
        this.lng = lng;
        this.title = title;
    }
    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getTitle() {
        return title;
    }
}
