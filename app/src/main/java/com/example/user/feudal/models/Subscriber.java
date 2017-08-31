package com.example.user.feudal.models;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.feudal.R;

import java.io.IOException;

public class Subscriber extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "com.example.user.feudal";
    private Intent intent;
    private EditText firstN, lastN, userN, zipCod;
    private Button nextBtn, uploadBtn;
    private Button pictureBtn;
    private ImageView userImage;
    private Uri filePath;

    public static final int REQUEST_IMAGE_CAPTURE = 2;
    private Bitmap imageBitmap;
    private final int NUMBER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscriber_layout);

        intent = getIntent();

        if(intent != null){

            userImage = (ImageView) findViewById(R.id.iv_s_imgId);

            firstN = (EditText) findViewById(R.id.lbl_s_firstNameId);
            lastN = (EditText) findViewById(R.id.lbl_s_lastNameId);
            userN = (EditText) findViewById(R.id.lbl_s_usernameId);
            zipCod = (EditText)findViewById(R.id.lbl_s_zipCodeId);

            pictureBtn = (Button) findViewById(R.id.btn_s_takeId);
            nextBtn = (Button) findViewById(R.id.btn_s_nextId);
            uploadBtn = (Button) findViewById(R.id.btn_s_uploadId);

            nextBtn.setOnClickListener(this);
            pictureBtn.setOnClickListener(this);
            uploadBtn.setOnClickListener(this);

        }

    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_s_takeId:
                takeAPicture();
                break;
            case R.id.btn_s_nextId:
                nextEntry();
                break;
            case R.id.btn_s_uploadId:
                upLoad();
                break;
        }
    }

    private void upLoad() {

        Toast.makeText(this, "upload" , Toast.LENGTH_SHORT).show();
        Intent gallery = new Intent();
        gallery.setType("image/*").setAction(gallery.ACTION_GET_CONTENT);
        startActivityForResult(gallery,NUMBER);

    }

    private void nextEntry() {

        intent = new Intent(Subscriber.this, SubscriberOptions.class);
        startActivity(intent);

    }

    private void takeAPicture() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if( resultCode == RESULT_OK){

            if(requestCode == NUMBER ){

                if(data != null){

                    //Toast.makeText(this,""+requestCode+" "+resultCode, Toast.LENGTH_SHORT).show();


                     Uri path = data.getData();
                    try {

                        imageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                        userImage.setImageBitmap(imageBitmap);
                        userImage.setVisibility(View.VISIBLE);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // imageBitmap = (Bitmap) extras.get("data");

                    //  userImage.setImageBitmap(imageBitmap);

                }

            }

        }

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            userImage.setImageDrawable(null);

            Bundle extras = data.getExtras();

            imageBitmap = (Bitmap) extras.get("data");

            userImage.setImageBitmap(imageBitmap);

        }





    }
}
