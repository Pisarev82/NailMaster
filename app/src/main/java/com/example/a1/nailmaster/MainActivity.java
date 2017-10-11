package com.example.a1.nailmaster;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;


import com.example.a1.nailmaster.adapter.Adapter;
import com.example.a1.nailmaster.data.DateAndNote;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);


        Adapter adapter = new Adapter(this, initData());
        listView.setAdapter(adapter);
    }

    private List<DateAndNote> initData() {
        List<DateAndNote> list = new ArrayList<DateAndNote>();

        list.add(new DateAndNote("first"));
        list.add(new DateAndNote("second"));
        list.add(new DateAndNote("third"));
        list.add(new DateAndNote("Today1"));

        return list;
    }


}
