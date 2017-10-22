package com.example.a1.nailmaster.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import com.example.a1.nailmaster.R;
import com.example.a1.nailmaster.data.DateAndNote;
import com.example.a1.nailmaster.data.ListOfNote;

import java.util.List;

/**
 * Created by nikolaypisarev on 21.10.17.
 */

public class AdapterForNotelistactivity extends Adapter {
    public AdapterForNotelistactivity(Context context, List<DateAndNote> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = layoutInflater.inflate(R.layout.activity_note_list_items_simple, parent, false);
        }

        DateAndNote dateAndNote = ListOfNote.getDateAndNoute(position);

        EditText editText = (EditText) view.findViewById(R.id.title_of_note_in_list);
        editText.setText(dateAndNote.getTitle());

        EditText editText1 = (EditText) view.findViewById(R.id.description_of_note_in_list);
        editText1.setText(dateAndNote.getNote());

        return view;
    }
}
