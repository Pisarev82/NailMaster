package com.example.a1.nailmaster.data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nikolaypisarev on 11.10.17.
 */

public class DateAndNote {

    private String title;
    private String note;

    private Date date;
    private String dateToString;

    public DateAndNote(String title) {
        this.title = title;
        this.note = note;
        date = new Date();
    }

    private static SimpleDateFormat DATA_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
