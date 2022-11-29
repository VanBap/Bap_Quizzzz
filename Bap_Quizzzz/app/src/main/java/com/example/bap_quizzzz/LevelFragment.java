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
import com.example.bap_quizzzz.databinding.FragmentQuestionBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LevelFragment extends Fragment {
    FragmentLevelBinding binding;
    FragmentQuestionBinding binding2;
    //tao question
    //List<Question> list;
    private static final List<Question> math1 = new ArrayList<>(Arrays.asList(
            new Question("1. Toan hoc de", true),
            new Question("2. Toan hoc de cau 2", false)
    ));
    private static final List<Question> math2 = new ArrayList<>(Arrays.asList(
            new Question("1. Toan hoc trung binh", true),
            new Question("2. Toan hoc trung binh cau 2", false)
    ));
    private static final List<Question> music1 = new ArrayList<>(Arrays.asList(
            new Question("1. Am nhac de cau 1", false),
            new Question("2. Am nhac de cau 2", true)

    ));
    private static final List<Question> music2 = new ArrayList<>(Arrays.asList(
            new Question("1. Am nhac trung binh cau 1", false),
            new Question("2. Am nhac trung binh cau 2", true)

    ));
    private int questionIndex = 0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLevelBinding.inflate(inflater,container,false);
        //truyen object tu home fragment sang level fragment
        Bundle args = getArguments();
        Category item = (Category) args.getSerializable("object_item");
        binding.catName.setText(item.getCategoryName());
        //binding.catID.setText(String.valueOf(item.getCategoryID()));



        //easy
        binding.easybtn.setOnClickListener(view ->{
            //cau hoi cho category Toan hoc
            if(item.getCategoryID() == 0){
                Question ques =  math1.get(questionIndex);
                Bundle args2 = new Bundle();
                //truyen object vao bundle
                args2.putSerializable("object_question", ques);

                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                QuestionFragment easyQuestionFragment = new QuestionFragment();
                //truyen args2
                easyQuestionFragment.setArguments(args2);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec, easyQuestionFragment).addToBackStack(null).commit();
            }

            //Music
            if(item.getCategoryID() == 1){
                Question ques =  music1.get(questionIndex);
                Bundle args2 = new Bundle();
                //truyen object vao bundle
                args2.putSerializable("object_question", ques);

                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                QuestionFragment easyQuestionFragment = new QuestionFragment();
                //truyen args2
                easyQuestionFragment.setArguments(args2);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec, easyQuestionFragment).addToBackStack(null).commit();
            }

            /*Question ques =  math1.get(questionIndex);
            Bundle args2 = new Bundle();
            //truyen object vao bundle
            args2.putSerializable("object_question", ques);

            AppCompatActivity activity = (AppCompatActivity)view.getContext();
            QuestionFragment easyQuestionFragment = new QuestionFragment();
            //truyen args2
            easyQuestionFragment.setArguments(args2);

            activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec, easyQuestionFragment).addToBackStack(null).commit();*/
        });

        //medium
        binding.mediumbtn.setOnClickListener(view ->{
            /*AppCompatActivity activity = (AppCompatActivity)view.getContext();
            QuestionFragment mediumQuestionFragment = new QuestionFragment();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec, mediumQuestionFragment).addToBackStack(null).commit();*/

            //cau hoi cho category Toan hoc
            if(item.getCategoryID() == 0){
                Question ques =  math2.get(questionIndex);
                Bundle args2 = new Bundle();
                //truyen object vao bundle
                args2.putSerializable("object_question", ques);

                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                QuestionFragment easyQuestionFragment = new QuestionFragment();
                //truyen args2
                easyQuestionFragment.setArguments(args2);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec, easyQuestionFragment).addToBackStack(null).commit();
            }

            //Music
            if(item.getCategoryID() == 1){
                Question ques =  music2.get(questionIndex);
                Bundle args2 = new Bundle();
                //truyen object vao bundle
                args2.putSerializable("object_question", ques);

                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                QuestionFragment easyQuestionFragment = new QuestionFragment();
                //truyen args2
                easyQuestionFragment.setArguments(args2);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec, easyQuestionFragment).addToBackStack(null).commit();
            }

        });

        //hard
        binding.hardbtn.setOnClickListener(view ->{
            //tuong tu
        });

        return binding.getRoot();

    }


}