package org.example.model;

public class LatLong {
    private double lat;

    private double longitud;


    public LatLong(double lat, double longitud) {
        this.lat = lat;
        this.longitud = longitud;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
