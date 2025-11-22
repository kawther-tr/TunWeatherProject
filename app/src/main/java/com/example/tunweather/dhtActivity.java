package com.example.tunweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class dhtActivity extends AppCompatActivity {
    TextView te;
    TextView hu;
    Button list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dht);

        te=(TextView) findViewById(R.id.temp);
        hu=(TextView) findViewById(R.id.hum);
        list =(Button) findViewById(R.id.list) ;
        Bundle bundle = getIntent().getExtras();
        final String Gouvernorat= bundle.getString("Gouvernorat");
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5= new Intent(dhtActivity.this,AllDataActivity.class);
                intent5.putExtra("Gouvernorat",Gouvernorat);
                startActivity(intent5);
            }
        });


        final String URL = "http://192.168.43.85:80/";
        Retrofit Rf = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);
        Call<temphum> data = api.getAlldata(Gouvernorat.trim());

        data.enqueue(new Callback<temphum>() {
            @Override
            public void onResponse(Response<temphum> response , Retrofit retrofit) {
                if (response.body().getSuccess().equals("1") ) {
                    float tt = response.body().getTemp();
                    float hh = response.body().getHum();

                    te.setText(Float.toString(tt));
                    hu.setText(Float.toString(hh));
                }
                else
                {
                    Toast.makeText(dhtActivity.this, "No data found  ", Toast.LENGTH_LONG).show();

                }

            }
            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(dhtActivity.this, "Erreur de chargement des données ", Toast.LENGTH_LONG).show();

            }
        });
    }
}