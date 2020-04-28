package com.example.volleyprac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.volleyprac.helper.Endpoints;
import com.example.volleyprac.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class add_user extends AppCompatActivity {
    EditText etUsername,etPhoneNo,etAge,etEmail,etid;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        etid=findViewById(R.id.etid);
        etUsername=findViewById(R.id.addUserName);
        etPhoneNo=findViewById(R.id.addphoNo);
        etAge=findViewById(R.id.addage);
        etEmail=findViewById(R.id.addemail);
        queue= Volley.newRequestQueue(this);
    }

    public void addUser(View view) {
       final User user=new User(Integer.parseInt(etid.getText().toString()),etUsername.getText().toString(),
               etPhoneNo.getText().toString(),Integer.parseInt(etAge.getText().toString()),etEmail.getText().toString());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Endpoints.POST_PRONOY_USER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("postResponse", response);

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
             Log.e("postError",error.toString());
            }
            })
        {
            @Override
            protected Map<String, String> getParams() {
                String jsonString="";
try{
    GsonBuilder gsonBuilder=new GsonBuilder();
    Gson gson=gsonBuilder.create();
    jsonString=gson.toJson(user);



}catch (Exception e){

    Log.e("ArrayException",e.toString());
}
    Map<String,String> params=new HashMap<>();
params.put("jsonData",jsonString);
return params;
            }
        };
        queue.add(stringRequest);
    }
}
