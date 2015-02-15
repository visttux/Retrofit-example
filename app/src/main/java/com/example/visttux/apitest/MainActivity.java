package com.example.visttux.apitest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static android.util.Log.d;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://apiservices.heroku.com")
                .build();

        Apiservice service = restAdapter.create(Apiservice.class);

        service.listPersonas(new Callback<List<PersonaData>>() {
            @Override
            public void success(List<PersonaData> data, Response response) {
                consumeApiData(data);
                return;
            }

            @Override
            public void failure(RetrofitError error) {
                d("retrofit", error.getMessage());
            }
        });
    }

    private void consumeApiData(List<PersonaData> data) {
        ArrayAdapter<PersonaData> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
