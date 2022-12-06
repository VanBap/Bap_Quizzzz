package com.example.bap_quizzzz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class History {
    public String level = "Empty";
    public String topic = "Empty";
    public int correctCount = 0;

    public String time = "DD/MM/YYYY";

    public History() {
    }

    //init date
    public static History current = new History();
    private final static SimpleDateFormat t = new SimpleDateFormat("dd/MM/yyyy");
    public  String initTime(){
        return current.time = t.format(new Date());
    }
}
