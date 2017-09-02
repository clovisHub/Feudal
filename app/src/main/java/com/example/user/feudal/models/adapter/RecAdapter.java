package com.example.user.feudal.models.adapter;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.feudal.R;
import com.example.user.feudal.models.Single;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import static android.support.v4.content.ContextCompat.startActivities;
import static android.support.v4.content.ContextCompat.startActivity;


public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    private  HashMap<String,String> listmap;

    private Context curContext;

    private Context activeContext;

    private Intent intent;



    public RecAdapter(HashMap<String,String> outMap, Context context){

          listmap = outMap;
          curContext = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.someone_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

         final HashMap<String,String> innerMap = listmap;

         final ArrayList<String> myList = new ArrayList<String>(innerMap.keySet());

         //holder.imageView.setIm(Integer.parseInt(myList.get(position)));
         holder.textView.setText(innerMap.get(myList.get(position)));

         //holder.position = position;

          holder.curName = innerMap.get(myList.get(position));

          holder.imgHashmap = myList.get(position);

        //  final String you = innerMap.get(myList.get(position));

         Picasso.with(curContext).load(myList.get(position)).into(holder.imageView);

    }

    @Override
    public int getItemCount() {

        return listmap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;
        String curName;
        String imgHashmap;

        public ViewHolder(View itemView) {

            super(itemView);
            activeContext = itemView.getContext();
            itemView.setOnClickListener(this);

            textView = (TextView) itemView.findViewById(R.id.textSomeoneV);
            imageView = (ImageView) itemView.findViewById(R.id.imageSomeoneV);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearCardId);
        }

        @Override
        public void onClick(View view) {

            //Toast.makeText(curContext,"Clicked "+curName,Toast.LENGTH_LONG).show();
            Intent myIntent = new Intent(activeContext,Single.class);
            myIntent.putExtra("name",curName);
            myIntent.putExtra("image",imgHashmap);
            activeContext.startActivity(myIntent);

        }
    }

    /*
    *  holder.linearLayout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(curContext,"You clicked "+ you,Toast.LENGTH_LONG).show();

                 Intent myIntent = new Intent(active,Single.class);
                myIntent.putExtra("name", you);
                //startActivity(myIntent);

             }
         });*/
}
