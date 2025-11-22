package com.example.tunweather;



        import androidx.appcompat.app.AppCompatActivity;

        import android.app.AlertDialog;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText mail,pass;
    Button b;
    ProgressDialog dialog;
    Connection parser=new Connection();

    int success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail=findViewById(R.id.mail);
        pass=findViewById(R.id.pass);
        b=findViewById(R.id.buttonConn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Log().execute();
            }
        });


    }

    class Log extends AsyncTask<String,String,String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog=new ProgressDialog(MainActivity.this);
            dialog.setMessage("Patientez SVP");
            dialog.show();

        }

        @Override
        protected String doInBackground(String... strings) {

            HashMap<String,String> map=new HashMap<>();

            map.put("Mail",mail.getText().toString());
            map.put("Password",pass.getText().toString());

            JSONObject object=parser.makeHttpRequest("http://192.168.43.85/webservicestunweather/login.php","POST",map);

            try {
                success = object.getInt("success");
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.cancel();

            if(success==1)
            {
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setMessage("Login done successfully");
                alert.setNeutralButton("ok",null);
                alert.show();
                final Intent intent = new Intent().setClass(MainActivity.this,OtherMainActivity.class);
                startActivity(intent);

            }
            else
            {

                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setMessage("No user with this email or password");
                alert.setNeutralButton("ok",null);
                alert.show();
            }

        }
    }

}