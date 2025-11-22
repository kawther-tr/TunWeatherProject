package com.example.tunweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class AllDataActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
   public Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_data);

        btn = (Button)findViewById(R.id.graph);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3= new Intent(AllDataActivity.this,GraphActivity.class);
                startActivity(intent3);
                            }
        });
        Bundle bundle = getIntent().getExtras();
        final String Gouvernorat= bundle.getString("Gouvernorat");


        final String URL = "http://192.168.43.85:80/";
        Retrofit Rf = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiHandler api = (ApiHandler) Rf.create(ApiHandler.class);

        Call<List<temphum>> getAllUsers = api.getAlldata3(Gouvernorat.trim());
        getAllUsers.enqueue(new Callback<List<temphum>>() {
            @Override
            public void onResponse(Response<List<temphum>> response, Retrofit retrofit) {
                List<temphum> lista=new ArrayList<temphum>();
                if(response.isSuccess())
                {
                    lista=(List<temphum>)response.body();
                    recyclerView = findViewById(R.id.all);
                    TempHumAdapter adapter=new TempHumAdapter(AllDataActivity.this,lista);
                    recyclerView.setAdapter(adapter);
                    layoutManager = new LinearLayoutManager(AllDataActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(AllDataActivity.this, "erreur de chargement de la liste" , Toast.LENGTH_LONG).show();

            }
        });



    }

    }
