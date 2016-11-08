package com.example.ruaasamara.customadapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CustomAdapter extends ArrayAdapter<CellContent> {

    private static class ViewHolder {

        TextView title;
        TextView subTitle;
        ImageView image;

    }

    public CustomAdapter(Context context, ArrayList<CellContent> cells) {
        super(context, 0, cells);
    }

    @Override
    public int getItemViewType(int position) {
        // Define a way to determine which layout to use, here it's just evens and odds.
        return position % 2;
    }

    @Override
    public int getViewTypeCount() {
        return 2; // Count of different layouts
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        CellContent cell = getItem(position);
        Log.d("cell position", "<<<<<<<<<<<<"+position);
        ViewHolder viewHolder;

        if (convertView == null){

            if (getItemViewType(position) == 0) {
                Log.d("cell position", "<<<<<<<<<<<<"+position);
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_cellleft, parent, false);
                viewHolder.title = (TextView) convertView.findViewById(R.id.title);
                viewHolder.subTitle = (TextView) convertView.findViewById(R.id.subTitle);
                viewHolder.image = (ImageView) convertView.findViewById(R.id.imgView);
                convertView.setTag(viewHolder);
            }else {
                Log.d("cell position", "<<<<<<<<<<<<"+position);
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_cellright, parent, false);
                viewHolder.title = (TextView) convertView.findViewById(R.id.title);
                viewHolder.subTitle = (TextView) convertView.findViewById(R.id.subTitle);
                viewHolder.image = (ImageView) convertView.findViewById(R.id.imgView);
                convertView.setTag(viewHolder);
            }
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(cell.title);
        viewHolder.subTitle.setText(cell.subTitle);
        String urlOfImage = cell.imgURL;
        try{
            Uri uri = Uri.parse(urlOfImage);
            //viewHolder.image.setImageURI(uri);
            Picasso.Builder builder = new Picasso.Builder(convertView.getContext());
            Picasso picasso = builder.build();
            picasso.load(uri).into(viewHolder.image);

        }catch(Exception e){ // Catch the download exception
            e.printStackTrace();
        }
        return convertView;
    }


}
