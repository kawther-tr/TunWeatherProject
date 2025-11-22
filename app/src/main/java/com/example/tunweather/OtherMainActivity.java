package com.example.tunweather;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

public class OtherMainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    public Spinner gouv;
    public  Button btninsert;
    /*ProgressDialog dialog;
    Connection parser=new Connection();
    ArrayList<HashMap<String,String>> values= new ArrayList<HashMap<String, String>>();
    int success; */
   public  String g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_main);
        gouv = findViewById(R.id.Gouvernorates_spinner);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(OtherMainActivity.this,R.array.Gouvernorates,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gouv.setAdapter(adapter);
        gouv.setOnItemSelectedListener(this);
        btninsert = (Button)findViewById(R.id.val);
        btninsert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //new All().execute();

                g= gouv.getSelectedItem().toString();
                if(g.isEmpty())
                {
                    Toast.makeText(OtherMainActivity.this,"Select your gouvernorat!" ,Toast.LENGTH_LONG).show();

                }
                else {
                    final Intent intent = new Intent().setClass(OtherMainActivity.this,dhtActivity.class);
                    intent.putExtra("Gouvernorat",gouv.getSelectedItem().toString());
                    startActivity(intent);
                }
                //Toast.makeText(OtherMainActivity.this,"patientez",Toast.LENGTH_LONG).show();

            }
        });

      }
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // String text =adapterView.getItemAtPosition(i).toString();
        //String text =gouv.getSelectedItem().toString();
        Toast.makeText(OtherMainActivity.this,gouv.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView ) {
        Toast.makeText(OtherMainActivity.this,"select your gouvernorate",Toast.LENGTH_LONG).show();
    }


}