package com.example.a1.nailmaster;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;



import com.example.a1.nailmaster.adapter.Adapter;
import com.example.a1.nailmaster.data.DateAndNote;
import com.example.a1.nailmaster.data.ListOfNote;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    Adapter adapter;
    private ListOfNote listOfNote;
    private List<DateAndNote> list;
    DateAndNote dateAndNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        listOfNote = new ListOfNote();
        list = listOfNote.getListOfnote();
        if (list.size() == 0) {list = listOfNote.initList();}
        adapter = new Adapter(this, list);
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
        int i = info.position;
        dateAndNote = listOfNote.getDateAndNoute(i);
        switch (item.getItemId()) {
            case R.id.master_list_add:


                adapter.addElement(dateAndNote.getTitle());
                return true;
            case R.id.master_list_edit:

                Intent intent = new Intent(this, NoteDetail.class);
                /* Передача строковой переменной. При отказе в реалиции этого типа передачи нужно удалить инициализацию этой переменной */
//                intent.putExtra("title", dateAndNote.getTitle());
                /* Передача интовой переменной на объект */
                intent.putExtra("id", i);

                startActivity(intent);
                return true;
            case R.id.master_list_delete:
                adapter.delitItem(info.position);
                return true;
        }
        return super.onContextItemSelected(item);
    }



}
