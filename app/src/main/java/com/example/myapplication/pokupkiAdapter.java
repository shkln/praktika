package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class pokupkiAdapter extends ArrayAdapter<List> {
    
        private LayoutInflater inflater;
        private int layout;
        private ArrayList<List> productList;

        pokupkiAdapter(Context context, int resource, ArrayList<List> list) {
            super(context, resource, list);
            this.productList = list;
            this.layout = resource;
            this.inflater = LayoutInflater.from(context);
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            final ViewHolder viewHolder;
            if(convertView==null){
                convertView = inflater.inflate(this.layout, parent, false);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            }
            else{
                viewHolder = (ViewHolder) convertView.getTag();
            }
            final List pokupki = productList.get(position);

            viewHolder.priceView.setText(pokupki.price.toString());
            viewHolder.placeView.setText(pokupki.place + " " + pokupki.category);

            return convertView;
        }
        private class ViewHolder {
            final TextView priceView, placeView, categoryView ;
            ViewHolder(View view){
                priceView = view.findViewById(R.id.priceList);
                placeView = view.findViewById(R.id.placeList);
                categoryView = view.findViewById(R.id.categoryList);
            }
        }

}
