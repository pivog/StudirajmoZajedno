package com.example.studirajmozajednojava;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Console;

public class FakultetCustomAdapter extends BaseAdapter {
    Context context;
    Fakulet [] fakulteti;
    LayoutInflater inflater;
    View convertView;
    public FakultetCustomAdapter(Context ctx, Fakulet [] fakultetiList) {
        this.context = ctx;
        this.fakulteti = fakultetiList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.fakulteti.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        convertView = inflater.inflate(R.layout.activity_custom_list_item, null);
        TextView desc = (TextView) convertView.findViewById(R.id.textDescItem);
        TextView name = (TextView) convertView.findViewById(R.id.textNameItem);
        ImageView icon = (ImageView) convertView.findViewById(R.id.iconImgView);
        desc.setText(fakulteti[i].desc);
        name.setText(fakulteti[i].name);
        icon.setImageResource(fakulteti[i].picId);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent popup_info = new Intent(context, PopupInfoActivity.class);
                popup_info.putExtra("fakultet_index", i);

                context.startActivity(popup_info);
            }
        });
        return convertView;
    }
}
