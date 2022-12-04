package com.example.bap_quizzzz;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bap_quizzzz.databinding.FragmentQuestionBinding;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuestionFragment extends Fragment {

    FragmentQuestionBinding binding;


    /*private void updateQuestionText() {
        Bundle args = getArguments();
        Question ques = (Question) args.getSerializable("object_question");
        binding.questionTextView.setText(ques.getQuestionText());
    }*/

    List<Question> questionItems;
    int currentQuestionCount = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQuestionBinding.inflate(inflater,container,false);

        /*Bundle args = getArguments();
        List<Question> ques = new ArrayList<>(Arrays.asList((Question) args.getSerializable("object_question")));
        binding.questionTextView.setText(ques.get(0).getQuestionText());*/

        /*Bundle args = getArguments();
        Question ques = (Question) args.getSerializable("object_question");
        //binding.questionTextView.setText(math.get(questionIndex).getQuestionText());
        binding.questionTextView.setText(ques.getQuestionText());*/
        //updateQuestionText();
        //binding.questionTextView.setText(questionItems.get(0).getQuestionText());


        //get all questions
        try {
            loadQuestion(HistoryFragment.getTopic(), HistoryFragment.getLevel());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //shuffle (random) the questions
        Collections.shuffle(questionItems);

        //load first question
        DisplayQuestion(currentQuestionCount);

        //Chon dap an xong next cau hoi
        binding.answerTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check correct answer
                if(questionItems.get(currentQuestionCount).getAnswer1().
                        equals(questionItems.get(currentQuestionCount).getQuestionAnswer())){
                    HistoryFragment.increaseCorrectCount();
                }

                //load next question neu co
                if(currentQuestionCount < 4){  // 4: chi chon 5 cau hoi
                    currentQuestionCount++;
                    DisplayQuestion(currentQuestionCount);
                }else{
                    //end game. show result
                    Toast.makeText(getContext(), String.valueOf(HistoryFragment.getCorrectCount()), Toast.LENGTH_SHORT).show();

                    //go to result Fragment
                    ResultFragment resultFragment = new ResultFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, resultFragment).addToBackStack(null).commit();
                }
            }
        });

        binding.answerFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check correct answer
                if(questionItems.get(currentQuestionCount).getAnswer2().
                        equals(questionItems.get(currentQuestionCount).getQuestionAnswer())){
                    HistoryFragment.increaseCorrectCount();
                }

                //load next question neu co
                if(currentQuestionCount < 4){
                    currentQuestionCount++;
                    DisplayQuestion(currentQuestionCount);
                }else{
                    //end game. show result
                    Toast.makeText(getContext(), String.valueOf(HistoryFragment.getCorrectCount()), Toast.LENGTH_SHORT).show();
                    //go to result Fragment
                    ResultFragment resultFragment = new ResultFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, resultFragment).addToBackStack(null).commit();
                }
            }
        });


        return binding.getRoot();
    }

    //load Json file
    public  String loadJSONFromAsset()
            throws JSONException {
        String json = "";
        try{
            InputStream is = getActivity().getAssets().open("questionbank2.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }

    //make list with all question
    public  void loadQuestion(String topic, String difficulty) throws JSONException {
        questionItems = new ArrayList<>();
        //load all question to string jsonStr
        String jsonStr = loadJSONFromAsset();

        //load all data into the list
        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            String to = jsonObj.getString("math");
            JSONArray all = jsonObj.getJSONObject(topic).getJSONArray(difficulty);
            for(int i = 0; i < all.length(); i++){
                JSONObject question = all.getJSONObject(i);

                String questionString = question.getString("question");
                String answer1String = question.getString("answer1");
                String answer2String = question.getString("answer2");
                String correctString = question.getString("correct");

                questionItems.add(new Question(
                        questionString,
                        answer1String,
                        answer2String,
                        correctString
                ));

            }
        }catch (JSONException e){
            e.printStackTrace();
        }

    }


    private void DisplayQuestion(int number){
        binding.questionTextView.setText(questionItems.get(number).getQuestionText());
    }

}