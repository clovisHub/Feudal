package com.example.user.feudal.models.adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.user.feudal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;


public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    private  HashMap<String,String> listmap;
    private Context curContext;


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
    public void onBindViewHolder(ViewHolder holder, int position) {

         HashMap<String,String> innerMap = listmap;

         ArrayList<String> myList = new ArrayList<String>(innerMap.keySet());

         //holder.imageView.setIm(Integer.parseInt(myList.get(position)));
         holder.textView.setText(innerMap.get(myList.get(position)));

         Picasso.with(curContext).load(myList.get(position)).into(holder.imageView);

    }

    @Override
    public int getItemCount() {

        return listmap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textSomeoneV);
            imageView = (ImageView) itemView.findViewById(R.id.imageSomeoneV);
        }
    }
}
