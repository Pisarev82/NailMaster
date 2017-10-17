package com.example.a1.nailmaster.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolaypisarev on 17.10.17.
 */

public class ListOfNote {

    private List<DateAndNote> list = new ArrayList<DateAndNote>();

    public ListOfNote () {
        initList();
    }

    private List<DateAndNote> initList() {


        list.add(new DateAndNote("first"));
        list.add(new DateAndNote("second"));
        list.add(new DateAndNote("third"));
        list.add(new DateAndNote("Today1"));

        return list;
    }

    public List<DateAndNote> getListOfnote () {
        return list;
    }
}
