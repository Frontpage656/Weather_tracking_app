package com.example.what_next;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button city_id, weather_id, weather_name;
    EditText input;
    ListView list_it;

    TheInstance instance = new TheInstance(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city_id = findViewById(R.id.city_id);
        weather_id = findViewById(R.id.weather_id);
        weather_name = findViewById(R.id.weather_name);
        input = findViewById(R.id.input);
        list_it = findViewById(R.id.list_it);

        city_id.setOnClickListener(this);
        weather_name.setOnClickListener(this);
        weather_id.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.city_id:


                instance.cty_id(input.getText().toString(), new TheInstance.VolleyResponseListener() {
                    @Override
                    public void onResponse(String cty_info) {
                        Toast.makeText(MainActivity.this, cty_info, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
                break;


            case R.id.weather_id:

                instance = new TheInstance(MainActivity.this);
                instance.weather_id(input.getText().toString(), new TheInstance.ForeCastBy_id() {
                    @Override
                    public void onResponse(List<ModClass> modClasses) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,modClasses);
                        list_it.setAdapter(arrayAdapter);
                    }

                    @Override
                    public void onError(String message) {

                    }
                });
                break;

            case R.id.weather_name:
                instance = new TheInstance(MainActivity.this);
                instance.cty_by_name(input.getText().toString(), new TheInstance.ForeCastBy_name() {
                    @Override
                    public void onResponse(List<ModClass> modClasses) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,modClasses);
                        list_it.setAdapter(arrayAdapter);
                    }

                    @Override
                    public void onError(String message) {

                    }
                });
                break;

        }
    }


}