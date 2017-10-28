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
        String newString = string;
        newString.trim();
        String stringAmount = new String();
        int lengthOfTitle = string.length();
        int spaseIndex = 0;
        if (lengthOfTitle == 0) {
            Toast.makeText(getApplicationContext(), "Данные отсутсвуют", Toast.LENGTH_SHORT).show();
        } else {
            spaseIndex = newString.trim().indexOf(" ");
            while (spaseIndex != -1 || stringAmount.length() != 0) {
                Boolean isDigital = Character.isDigit(newString.charAt(++spaseIndex));
                if (isDigital) {
                    stringAmount = newString.substring(spaseIndex, lengthOfTitle);
                    spaseIndex = stringAmount.indexOf(" ");

                    Toast.makeText(getApplicationContext(), "stringAmount", Toast.LENGTH_SHORT).show();
                } else {newString = newString.substring(spaseIndex, lengthOfTitle);
                lengthOfTitle = newString.length();
                spaseIndex = newString.indexOf(" ");
                Toast.makeText(getApplicationContext(), newString + isDigital, Toast.LENGTH_SHORT).show();}
            }
            if (stringAmount.length() != 0) {
                string = string.substring(0, string.length() - lengthOfTitle);
                Toast.makeText(getApplicationContext(), string + "  +  " +stringAmount, Toast.LENGTH_SHORT).show();
            } else {Toast.makeText(getApplicationContext(), string + " без количества ", Toast.LENGTH_SHORT).show();}
        }
        adapter.addElement(string.trim(), stringAmount);
        editText.setText("");
        listView.smoothScrollToPosition(adapter.getCount());
    }
}

