package com.example.bap_quizzzz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bap_quizzzz.databinding.FragmentHistoryBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class HistoryFragment extends Fragment {

    FragmentHistoryBinding binding;

    public static History current = new History();
    //add result to history list
    public static void AddHistoryList(){
        history_list.add(current);
        //add xong se tao lai 1 bien History moi
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


    public static ArrayList<History> history_list = new ArrayList<>(

    );

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        binding.historyResultRec.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.historyResultRec.setAdapter(new HistoryAdapter(getContext(),history_list));


        return binding.getRoot();
    }



}