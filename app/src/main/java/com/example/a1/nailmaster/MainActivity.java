package com.example.a1.nailmaster;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.CardView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.a1.nailmaster.adapter.Adapter;
import com.example.a1.nailmaster.adapter.AdapterForNotelistactivity;
import com.example.a1.nailmaster.data.DateAndNote;
import com.example.a1.nailmaster.data.ListOfNote;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textViewTitle;
    private CardView cardView;
    Adapter adapter;
    private ListOfNote listOfNote;
    private List<DateAndNote> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();

//      Временный метод. Надо реализовать отображение через рециклервью и вью холдер, с его методами отработки нажатий

        View.OnClickListener cardViewOnclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Клик", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, NoteListActivity.class);
                startActivity(intent);
            }
        } ;
        cardView.setOnClickListener(cardViewOnclick);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu_about:
                intent = new Intent(this, NoteListActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_openNoteList:
                intent = new Intent(this, NoteListActivity.class);
                startActivity(intent);
                return true;
        }
        super.onOptionsItemSelected(item);
        return true;
    }

    private void initUi () {
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        cardView = (CardView) findViewById(R.id.card_view);

        listView = (ListView) findViewById(R.id.listView);
        listOfNote = new ListOfNote();
        list = listOfNote.getListOfnote();
//        if (list.size() == 0) {list = listOfNote.initList();}
        adapter = new Adapter (this, list);
        listView.setAdapter(adapter);
    }
}
