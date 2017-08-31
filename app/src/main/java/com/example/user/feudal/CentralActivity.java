package com.example.user.feudal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.user.feudal.models.*;
import android.widget.TextView;

public class CentralActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = CentralActivity.class.getSimpleName()+"_TAG";

    Button seeker, login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);

        login = (Button) findViewById(R.id.btn_loginId);
        seeker = (Button) findViewById(R.id.btn_createId);

        login.setOnClickListener(this);
        seeker.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){

            case R.id.btn_createId:
                goCreate(intent);
                break;
            case R.id.btn_loginId:
                goLogin(intent);
                break;
        }
    }


    private void goCreate(Intent intent){

        intent = new Intent(CentralActivity.this,Subscriber.class);
        startActivity(intent);
    }

    private void goLogin(Intent intent ){

        intent = new Intent(CentralActivity.this,Login.class);
        startActivity(intent);
    }


}
