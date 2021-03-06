package com.example.a1.nailmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a1.nailmaster.R;
import com.example.a1.nailmaster.data.DateAndNote;


import java.util.List;

/**
 * Created by nikolaypisarev on 11.10.17.
 */

public class Adapter extends BaseAdapter {

    public List<DateAndNote> list;
    public LayoutInflater layoutInflater;

    public Adapter(Context context, List<DateAndNote> list) {
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = layoutInflater.inflate(R.layout.item_layout, parent, false);
        }

        DateAndNote dateAndNote = getDate(position);

        TextView textView = (TextView) view.findViewById(R.id.title_of_note);
        textView.setText(dateAndNote.getNote());

        TextView textView1 = (TextView) view.findViewById(R.id.note);
        textView1.setText(dateAndNote.getVolume());

        return view;
    }

    private DateAndNote getDate(int position) {

        return (DateAndNote) getItem(position);
    }

    public void addElement (String previous) {
        list.add(new DateAndNote(previous));
        notifyDataSetChanged();
    }




    public void delitItem (int position) {
        list.remove(position);
        notifyDataSetChanged();
    }

}
