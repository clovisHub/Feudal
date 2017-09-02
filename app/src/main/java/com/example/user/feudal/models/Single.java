package com.example.user.feudal.models;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.feudal.R;
import com.squareup.picasso.Picasso;

public class Single extends AppCompatActivity {

    TextView name;
    ImageView photo;
    Intent mySingleIntent;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_layout);

        photo = (ImageView) findViewById(R.id.imgSingle_id);
        name  = (TextView) findViewById(R.id.itemSingle_tvId);

        mySingleIntent = getIntent();

        name.setText(mySingleIntent.getStringExtra("name"));

        Picasso.with(Single.this).load(mySingleIntent.getStringExtra("image")).into(photo);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
