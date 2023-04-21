package com.example.sqlite_th2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PublisherAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private List<String> mPublishers;

    public PublisherAdapter(Context context, int resource, List<String> publishers) {
        super(context, resource, publishers);
        mContext = context;
        mPublishers = publishers;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
        }

        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(mPublishers.get(position));

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(mPublishers.get(position));

        return view;
    }
}
