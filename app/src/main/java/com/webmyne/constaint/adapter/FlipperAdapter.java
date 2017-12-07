package com.webmyne.constaint.adapter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.webmyne.constaint.R;
import com.webmyne.constaint.custom.TfButton;

import java.util.List;

/**
 * Created by Chiragpatel on 14-09-2017.
 */

public class FlipperAdapter extends BaseAdapter {
    private AppCompatActivity appCompatActivity;
    private List<String> strings;
    private String[] str = {"Sign in","Sign up"};

    public FlipperAdapter(AppCompatActivity appCompatActivity, List<String> strings) {
        super();
        this.strings = strings;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public String getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return strings.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) appCompatActivity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_page, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtSignUp.setText(getItem(position));
        holder.btnLogin.setText(str[position]);

        return convertView;
    }

    private static class ViewHolder {
        private TextView txtSignUp;
        private TfButton btnLogin;

        public ViewHolder(View v) {
            btnLogin = (TfButton)v.findViewById(R.id.btnLogin);
            txtSignUp = (TextView) v.findViewById(R.id.txtSignUp);
        }
    }
}
