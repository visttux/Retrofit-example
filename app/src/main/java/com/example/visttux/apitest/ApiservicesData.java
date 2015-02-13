package com.example.visttux.apitest;

import com.google.gson.annotations.Expose;

public class ApiservicesData {

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

}
