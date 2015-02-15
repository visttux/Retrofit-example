package com.example.visttux.apitest;

import com.google.gson.annotations.Expose;

public class PersonaData {

    @Expose
    private int id;
    @Expose
    private String nombre;
    @Expose
    private float longitud;
    @Expose
    private float latitud;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public float getLongitude() {
        return longitud;
    }

    public void setLongitude(float longitude) {
        this.longitud = longitude;
    }

    public float getLatitude() {
        return latitud;
    }

    public void setLatitude(float latitude) {
        this.latitud = latitude;
    }

    @Override
    public String toString() {
        return (nombre.toString() + " "  + String.valueOf(longitud) + " " + String.valueOf(latitud)) ;
    }
}
