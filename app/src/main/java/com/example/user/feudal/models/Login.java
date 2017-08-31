package com.example.user.feudal.models;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import com.example.user.feudal.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


import com.example.user.feudal.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

     private Intent intent;
     private EditText emailTxt, passwordTxt;
     private Button signInBtn, helpBtn;
     private ImageButton returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        intent = getIntent();

        if(intent != null){

             emailTxt = (EditText)findViewById(R.id.lbl_l_usernameId);
             passwordTxt = (EditText)findViewById(R.id.lbl_passwordId);

             signInBtn = (Button) findViewById(R.id.btn_l_loginId);
             helpBtn = (Button) findViewById(R.id.btn_l_helpId);
             returnBtn = (ImageButton) findViewById(R.id.btn_l_goBackId);

             signInBtn.setOnClickListener(this);
             helpBtn.setOnClickListener(this);
             returnBtn.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_l_goBackId:
                goBack();
                break;
            case R.id.btn_l_helpId:
                help();
                break;
            case R.id.btn_l_loginId:
                logUserIn();
                break;
        }

    }

    private void logUserIn() {

        intent = new Intent(Login.this,AccountUser.class);
        startActivity(intent);
    }

    private void help() {

        intent = new Intent(Login.this,HelpLogin.class);
        startActivity(intent);
    }

    private void goBack() {

        intent = new Intent(Login.this,CentralActivity.class);
        startActivity(intent);

    }
}
