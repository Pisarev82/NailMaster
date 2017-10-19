package com.example.a1.nailmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.a1.nailmaster.data.DateAndNote;
import com.example.a1.nailmaster.data.ListOfNote;

public class NoteDetail extends AppCompatActivity {

    EditText date;
    EditText title;
    EditText note;
    Button okButton;
    Intent intent;
    DateAndNote dateAndNote = new DateAndNote();
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        initUi();
        getObjectOfList();

    }



        /* Метод для получения интовой переменной, которая использоваться для получения объекта из списка и заполнения теккстовых полей */
    public void getObjectOfList (){
        intent = getIntent();
        position = intent.getIntExtra("id", 1);
        dateAndNote = ListOfNote.getDateAndNoute(position);
        title.setText(dateAndNote.getTitle());
        date.setText(dateAndNote.getDateToString());
        note.setText(dateAndNote.getNote());

    }
        /* Реализация сохранения данных и возврат в основное активити */
    private void saveChanges () {
        dateAndNote.setTitle(title.getText().toString());
        dateAndNote.setNote(note.getText().toString());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
        /* Инициализация элементов активити */
    private void initUi () {
        date = (EditText) findViewById(R.id.date_of_note);
        title = (EditText) findViewById(R.id.title_of_note);
        note = (EditText) findViewById(R.id.note);
        okButton = (Button) findViewById(R.id.save);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChanges();
            }
        });
    }

}
