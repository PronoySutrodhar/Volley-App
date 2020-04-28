package com.example.volleyprac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.volleyprac.helper.Endpoints;
import com.example.volleyprac.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    ArrayList<User> userArrayList;
    ListView listView;
    ArrayAdapter<User> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userArrayList = new ArrayList<>();
        queue = Volley.newRequestQueue(this);
        listView=findViewById(R.id.listview);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Endpoints.GET_PRONOY_USER, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        Log.i("ResponseData", jsonArray.toString());
                        try {
                            Gson gson = new Gson();
                            Type type = new TypeToken<ArrayList<User>>() {

                            }.getType();
                            userArrayList = gson.fromJson(jsonArray.toString(), type);


                            adapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,userArrayList);
                            listView.setAdapter(adapter);
                        } catch (Exception e) {
                            Log.e("PaseError",e.toString());

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VolleyError", error.toString());
            }
        });
        queue.add(jsonArrayRequest);
    }

    public void addData(View view) {
        Intent intent=new Intent(MainActivity.this,add_user.class);
        startActivity(intent);
    }
}
