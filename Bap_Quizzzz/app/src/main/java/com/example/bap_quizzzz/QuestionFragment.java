package com.example.bap_quizzzz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bap_quizzzz.databinding.FragmentLevelBinding;
import com.example.bap_quizzzz.databinding.FragmentQuestionBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionFragment extends Fragment {

    FragmentQuestionBinding binding;


    private void updateQuestionText() {
        Bundle args = getArguments();
        Question ques = (Question) args.getSerializable("object_question");
        binding.questionTextView.setText(ques.getQuestionText());
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQuestionBinding.inflate(inflater,container,false);


        /*Bundle args = getArguments();
        Question ques = (Question) args.getSerializable("object_question");
        //binding.questionTextView.setText(math.get(questionIndex).getQuestionText());
        binding.questionTextView.setText(ques.getQuestionText());*/
        updateQuestionText();



        return binding.getRoot();
    }
}