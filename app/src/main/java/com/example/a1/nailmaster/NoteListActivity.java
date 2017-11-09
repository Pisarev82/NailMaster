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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    ListView listView;
    AdapterForNotelistactivity adapter;
    EditText editText;
    Button button;

    ListOfNote listOfNote = new ListOfNote();
    List<DateAndNote> list;

    private final String FILE_NAME = "SaveData.dat";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        initUi();
    }

    private void initUi () {
//        loadFromInternalFile();

        final String fileName = getFilesDir() + FILE_NAME;
        list = listOfNote.loadFromInternalFile(fileName);
        int i = list.size();
        Toast.makeText(getApplicationContext(), "Код выполнен " + i, Toast.LENGTH_SHORT).show();
        adapter = new AdapterForNotelistactivity(this, list);
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
                if (title.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Поле ввода пустое", Toast.LENGTH_SHORT).show();
                } else {
                    splitString(title);
//                    saveToInternalFile();
                    listOfNote.saveToInternalFile(fileName);
                    Toast.makeText(getApplicationContext(), "Save", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void splitString (String string) {
        String text = string.trim();
        String amount = "";
        int i = 0;

        while (i < text.length()-1) {

            if (Character.isSpaceChar(text.charAt(i)) & Character.isDigit(text.charAt(++i)) ) {
                amount = text.substring( i, text.length() );
                text = text.substring(0, i).trim();
                i = text.length();
                adapter.addElement(text, amount);
            }
        }
        if (amount.length() < 1 ) {
            adapter.addElement(text);
        }
        editText.setText("");
        listView.smoothScrollToPosition(adapter.getCount());

    }

//    private void saveToInternalFile () {
//        File file;
//
//        try {
//            file = new File(getFilesDir() + FILE_NAME);
//
//            FileOutputStream fileOutputStream;
//            ObjectOutputStream objectOutputStream;
//
//            if (file.exists())  {
//                file.createNewFile();
//            }
//            fileOutputStream = new FileOutputStream(file, false);
//            objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(listOfNote);
//
//
//
//        }catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
//    private void loadFromInternalFile () {
//
//        FileInputStream fileInputStream;
//        ObjectInputStream objectInputStream;
//
//        try {
//            fileInputStream = new FileInputStream(getFilesDir() + FILE_NAME);
//            objectInputStream = new ObjectInputStream(fileInputStream);
//
//            listOfNote = (ListOfNote) objectInputStream.readObject();
//            int i = listOfNote.getListOfnote().size();
//            Toast.makeText(getApplicationContext(), "Код выполнен " + i, Toast.LENGTH_SHORT).show();
//
//        } catch (Exception exc) {
//            exc.printStackTrace();
//        }
//    }

}

