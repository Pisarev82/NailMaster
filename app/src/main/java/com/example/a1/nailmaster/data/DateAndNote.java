package com.example.a1.nailmaster.data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nikolaypisarev on 11.10.17.
 */

public class DateAndNote implements Serializable {

    private String title;
    private String note;
    private String volume;

    private Date date;
    private String dateToString;

    public DateAndNote() {
        this.title = title;
        this.note = note;
        this.volume = volume;
    }

    public DateAndNote(String title) {
        this.title = title;
        this.note = note;
        this.volume = volume;
    }

    public DateAndNote(String title, String volume) {
        this.title = title;
        this.note = note;
        this.volume = volume;
    }

    private static SimpleDateFormat DATA_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDateToString() {

        return dateToString = DATA_FORMAT.format(date);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
