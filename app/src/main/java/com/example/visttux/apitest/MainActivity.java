package com.example.visttux.apitest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

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

        service.listPersonas(new Callback<List<ApiservicesData>>() {
            @Override
            public void success(List<ApiservicesData> apiservicesData, Response response) {
                consumeApiData(apiservicesData);
                return;
            }

            @Override
            public void failure(RetrofitError error) {
                d("retrofit", "failure");
            }
        });
    }

    private void consumeApiData(List<ApiservicesData> apiservicesData) {
        String nombre = apiservicesData.get(1).getNombre();
        TextView tv = (TextView) findViewById(R.id.textview);
        tv.setText(nombre);
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
