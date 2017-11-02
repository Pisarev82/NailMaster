package com.example.a1.nailmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1.nailmaster.adapter.AdapterForNotelistactivity;
import com.example.a1.nailmaster.data.DateAndNote;
import com.example.a1.nailmaster.data.ListOfNote;

public class NoteListActivity extends AppCompatActivity {

    ListView listView;
    AdapterForNotelistactivity adapter;
    EditText editText;
    Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        initUi();
    }

    private void initUi () {
        adapter = new AdapterForNotelistactivity(this, ListOfNote.getListOfnote());
        listView = (ListView) findViewById(R.id.listView_activity_note_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Клик", Toast.LENGTH_SHORT).show();
                adapter.addElement("ok");
            }
        });

        editText = (EditText) findViewById(R.id.editText_activity_note_list);
        button = (Button) findViewById(R.id.button_activity_note_list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editText.getText().toString();
                splitString(title);
            }
        });
    }

    private void splitString (String string) {
        String text = string.trim();
        String amount = "";
        int i = 0;

        while (i < text.length()) {

            if (Character.isSpaceChar(text.charAt(i)) & Character.isDigit(text.charAt(++i)) ) {
                amount = text.substring( i, text.length() );
                text = text.substring(0, i).trim();
                i = text.length();
            }
        }
        adapter.addElement(text, amount);
        editText.setText("");
        listView.smoothScrollToPosition(adapter.getCount());
    }



}

