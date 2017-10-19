package com.example.a1.nailmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1.nailmaster.data.DateAndNote;
import com.example.a1.nailmaster.data.ListOfNote;

public class NoteDetail extends AppCompatActivity {

    EditText date;
    EditText title;
    EditText note;
    Intent intent;
//    ListOfNote listOfNote;
    DateAndNote dateAndNote = new DateAndNote();
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        date = (EditText) findViewById(R.id.date_of_note);
        title = (EditText) findViewById(R.id.title_of_note);
        note = (EditText) findViewById(R.id.note);

        /*запуск метода для получения объекта из списка */
//        getObjectOfList();
        /* получение строкового ресурса*/
//        intent = getIntent();
//        String titleString = intent.getStringExtra("title");
//        title.setText(titleString);
/* проба реализовать получение объекта через id  в методе onCreate*/
        intent = getIntent();
        position = intent.getIntExtra("id", 1);
        dateAndNote = ListOfNote.getDateAndNoute(position);
        title.setText(dateAndNote.getTitle());


    }
        /* Метод для получения интовой переменной, которая будет использоваться для получения объекта из списка */
    public void getObjectOfList (){
        intent = getIntent();

        position = intent.getIntExtra("id", 1);

//            dateAndNote = new DateAndNote("Work"); // it's work

            /* Дальнейший код не работает, потому что я не знаю как передать объект в новую активити */
//            listOfNote.getListOfnote();
//        dateAndNote = listOfNote.getDateAndNoute(position);
        title.setText(dateAndNote.getTitle());


    }
}
