package com.example.visttux.apitest;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface Apiservice {
    @GET("/personas.json")
    void listPersonas(Callback<List<PersonaData>> personasCallback);
}
