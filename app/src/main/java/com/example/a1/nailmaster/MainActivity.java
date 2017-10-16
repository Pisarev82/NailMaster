package com.example.a1.nailmaster;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.a1.nailmaster.adapter.Adapter;
import com.example.a1.nailmaster.data.DateAndNote;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    Adapter adapter;
    private List<DateAndNote> list = new ArrayList<DateAndNote>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);


        adapter = new Adapter(this, initData());
        listView.setAdapter(adapter);

        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.master_list_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.master_list_add:
                adapter.addElement();
                return true;
//            case R.id.master_list_edit:
//                int id = (int) listView.getSelectedItemId();
//                String nout = list.get(id).getNote();
//                Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
//                return true;
        }
        return super.onContextItemSelected(item);
    }

    private List<DateAndNote> initData() {


        list.add(new DateAndNote("first"));
        list.add(new DateAndNote("second"));
        list.add(new DateAndNote("third"));
        list.add(new DateAndNote("Today1"));

        return list;
    }


}
