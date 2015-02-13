package com.example.visttux.apitest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Iterator;
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
                d("retrofit", error.getMessage());
            }
        });
    }

    private void consumeApiData(List<ApiservicesData> apiservicesData) {
        String items[] = new String[apiservicesData.size()*3];

        for(int i=0; i<apiservicesData.size();++i) {
            items[i*3+0] = apiservicesData.get(i).getNombre();
            items[i*3+1]  = String.valueOf(apiservicesData.get(i).getLatitud());
            items[i*3+2] = String.valueOf(apiservicesData.get(i).getLongitud());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
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
