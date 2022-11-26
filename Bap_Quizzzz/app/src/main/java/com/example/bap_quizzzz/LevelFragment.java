package com.example.bap_quizzzz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bap_quizzzz.databinding.FragmentLevelBinding;


public class LevelFragment extends Fragment {
    FragmentLevelBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLevelBinding.inflate(inflater,container,false);

        //easy
        binding.easybtn.setOnClickListener(view ->{
            AppCompatActivity activity = (AppCompatActivity)view.getContext();
            QuestionFragment easyQuestionFragment = new QuestionFragment();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec, easyQuestionFragment).addToBackStack(null).commit();
        });

        //medium
        binding.mediumbtn.setOnClickListener(view ->{
            AppCompatActivity activity = (AppCompatActivity)view.getContext();
            QuestionFragment mediumQuestionFragment = new QuestionFragment();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec, mediumQuestionFragment).addToBackStack(null).commit();
        });

        //hard
        binding.hardbtn.setOnClickListener(view ->{

        });

        return binding.getRoot();

    }


}