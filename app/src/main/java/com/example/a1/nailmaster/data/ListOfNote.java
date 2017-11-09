package com.example.a1.nailmaster.data;

import android.content.Context;
import android.widget.Toast;

import com.example.a1.nailmaster.NoteListActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.provider.Telephony.Mms.Part.FILENAME;

/**
 * Created by nikolaypisarev on 17.10.17.
 */

public class ListOfNote implements Serializable{

    private static List<DateAndNote> list = new ArrayList<DateAndNote>();


//
//    public List<DateAndNote> initList() {
//
//
//        list.add(new DateAndNote("first"));
//        list.add(new DateAndNote("second"));
//        list.add(new DateAndNote("third"));
//        list.add(new DateAndNote("Today1"));
//
//        return list;
//    }

    public static List<DateAndNote> getListOfnote () {
        return list;
    }

    public static DateAndNote getDateAndNoute(int position) {

        return  list.get(position);
    }

    public void saveToInternalFile (String fileName) {
        File file;

        try {
            file = new File(fileName);

            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;

            if (file.exists())  {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file, false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);



        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public List<DateAndNote> loadFromInternalFile (String fileName) {

        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;

        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);

            list = (List<DateAndNote>) objectInputStream.readObject();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return list;
    }

}
