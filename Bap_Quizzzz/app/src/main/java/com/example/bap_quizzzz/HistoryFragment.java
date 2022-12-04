package com.example.bap_quizzzz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HistoryFragment extends Fragment {

    public static History current = new History();
    public static ArrayList<History> history_list = new ArrayList<>();

    public void AddandReset(MainActivity activity){
        history_list.add(current);
        current = new History();
    }

    public static void setLevel(String _level){
        current.level = _level;
    }

    public static void setTopic(String _topic){current.topic = _topic;}

    public static String getTopic() {return current.topic;}
    public static String getLevel(){
        return current.level;
    }

    //luu so cau tra loi dung
    public static void increaseCorrectCount(){
        current.correctCount = current.correctCount + 1;
    }
    public static int getCorrectCount(){
        return current.correctCount;
    }

    //reset so cau tra loi dung ve 0
    public static void resetCorrectCount(){
        current.correctCount = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }
}