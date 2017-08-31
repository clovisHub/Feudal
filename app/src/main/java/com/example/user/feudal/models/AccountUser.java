package com.example.user.feudal.models;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.user.feudal.models.dataconnector.*;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.feudal.R;

import org.w3c.dom.Text;

public class AccountUser extends AppCompatActivity implements View.OnClickListener{

    //private Text
    private EditText searchText;

    //private ListView listView;
    private View relative;

    //textView
    private TextView resultTv;

    //Buttons
    private Button hiddenBtn, browseBtn;

    //Java variables
    private String checkSearch, checkResult;

    // Intent
    Intent intentAcc;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_layout);
        // Java variables
        checkSearch ="";
        checkResult ="";


        //Edit
        searchText = (EditText)findViewById(R.id.ed_ac_searchId);

        //TextView
        resultTv = (TextView) findViewById(R.id.tv_ac_availServiceId);

        //Views
        relative = (View) findViewById(R.id.ly_ac_relativeId);

        checkSearch = " Yesouy"; //searchText.getText().toString();
        checkResult = checkSearch;



        //Buttons
        hiddenBtn = (Button) findViewById(R.id.btn_ac_showId);
        hiddenBtn.setOnClickListener(this);

        browseBtn = (Button) findViewById(R.id.btn_ac_browserId);
        browseBtn.setOnClickListener(this);

        intentAcc = new Intent();


    }

    public void textClick(View view){

        relative.setVisibility(View.INVISIBLE);
        hiddenBtn.setVisibility(View.VISIBLE);
        hiddenBtn.setEnabled(true);
    }
    @Override
    public void onClick(View view) {
        Toast.makeText(this,"yes",Toast.LENGTH_SHORT).show();
        switch (view.getId()){

            case R.id.btn_ac_showId:
                showUserImage();
                break;
            case R.id.btn_sign_outId:
                break;
            case R.id.btn_ac_statusId:
                break;
            case R.id.btn_ac_userId:
                break;
            case R.id.btn_ac_browserId:
                if(!(checkSearch.isEmpty())){
                    Toast.makeText(this,"Browse",Toast.LENGTH_SHORT).show();
                    goToPeopleList();
                }
                break;
            case R.id.btn_ac_mailId:
                break;

        }
    }

    private void goToPeopleList() {

        intentAcc = new Intent(AccountUser.this,PeopleList.class);
        startActivity(intentAcc);

    }

    @Override
    protected void onResume() {
        super.onResume();




    }

    private void showUserImage() {

        relative.setVisibility(View.VISIBLE);
        hiddenBtn.setVisibility(View.INVISIBLE);
        hiddenBtn.setEnabled(false);

    }
}
