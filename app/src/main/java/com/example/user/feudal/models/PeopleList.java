package com.example.user.feudal.models;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.user.feudal.models.adapter.RecAdapter;

import com.example.user.feudal.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class PeopleList extends AppCompatActivity {

    private RecyclerView recView;
    private HashMap<String, String> map;
    private RecyclerView.Adapter adapter;
    public static String thatName;

    public static final String TAG= PeopleList.class.getSimpleName()+ "_TAG";

    private static final String URL = "https://randomuser.me/api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);

        map = new HashMap<>();

        recView = (RecyclerView) findViewById(R.id.recyclerVwId);

        recView.setHasFixedSize(true);

        recView.setLayoutManager(new LinearLayoutManager(this));


        loadRecyclerData();




        //myTrial();

       // adapter = new RecAdapter(map,this);

       // recView.setAdapter(adapter);


    }

    private void myTrial() {
        String [] jsonArray = {"you","we","old","sah","yer","youyou","wel","told","tsar","yerop"};
        String [] jsonArray2 = {"a","u","y","e","j","ay","uo","yp","er","jo"};

        for(int i = 0; i < jsonArray.length; i++){

            String name = jsonArray[i];

            String img = jsonArray2[i];

            Log.d(TAG, "onResponse: "+name+" "+img);

            map.put(img, name);
        }

        adapter = new RecAdapter(map,getApplicationContext());

        recView.setAdapter(adapter);


    }

    private void loadRecyclerData() {

        StringRequest copyRequest = null;

        for(int i = 0; i < 100; i++){



        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {


                          System.out.println("You got this  "+TAG+" "+response.toString());

                         if(response != null || !(response.isEmpty())){

                             try {

                                 JSONObject jsonObject = new JSONObject(response);
                                 JSONArray jsonArray = jsonObject.getJSONArray("results");
                                 System.out.println("You got this  "+TAG+" "+jsonArray.getJSONObject(0).getString("name"));

                                 // Getting name (first name)
                                 String nameArray =  jsonArray.getJSONObject(0).getString("name");
                                 JSONObject jsonObjectName = new JSONObject(nameArray);
                                 String jsonName = jsonObjectName.getString("first");
                                 System.out.println("You got this  "+TAG+" "+jsonName);

                                 //Getting picture(image)
                                 String pictureArray =  jsonArray.getJSONObject(0).getString("picture");
                                 JSONObject jsonObjectPic = new JSONObject(pictureArray);
                                 String jsonPic = jsonObjectPic.getString("medium");
                                 System.out.println("You got this  "+TAG+" "+pictureArray);

                                  map.put(jsonPic, jsonName);


                                 // JSONArray jsonArray2 = jsonObject.getJSONArray("picture");
                                 //  System.out.println("You got this  "+TAG+" "+jsonArray2.toString());

                                 // JSONArray jsonArray3 = jsonObject.getJSONArray("name");
                                 // System.out.println("You got this  "+TAG+" "+jsonArray3.toString());


                                 // JSONObject name;
                                 // JSONObject img;
                                 //for(int i = 0; i < jsonArray.length(); i++){

                                 // name = jsonArray.getJSONObject(i);
                                 // img = jsonArray2.getJSONObject(i);

                                 //  Log.d(TAG, "onResponse: "+name+" "+img);


                                 //   map.put(img.getString("thumbnail"), name.getString("first"));
                                 //}


                             } catch (JSONException e) {
                                 e.printStackTrace();
                             }
                         }


                     }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

            copyRequest = stringRequest;
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(copyRequest);

        }

        adapter = new RecAdapter(map,getApplicationContext());

        recView.setAdapter(adapter);





    }


    @Override
    protected void onResume() {
        super.onResume();
    }


}
