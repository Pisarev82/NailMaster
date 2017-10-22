package com.example.a1.nailmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.a1.nailmaster.adapter.AdapterForNotelistactivity;
import com.example.a1.nailmaster.data.DateAndNote;
import com.example.a1.nailmaster.data.ListOfNote;

public class NoteListActivity extends AppCompatActivity {

    ListView listView;
    AdapterForNotelistactivity adapter;


    DateAndNote dateAndNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        adapter = new AdapterForNotelistactivity(this,ListOfNote.getListOfnote());
        listView = (ListView) findViewById(R.id.listView_activity_note_list);
        listView.setAdapter(adapter);

    }
}
