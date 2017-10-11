package com.example.a1.nailmaster.data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nikolaypisarev on 11.10.17.
 */

public class DateAndNote {

    private String note;
    private String dateToString;
    private Date date;

    public DateAndNote(String note) {
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
}
