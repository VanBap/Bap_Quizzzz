package com.example.bap_quizzzz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question implements Serializable {
    private final String questionText;
    private final Boolean questionAnswer;

    public Question(String questionText, Boolean questionAnswer) {
        this.questionText = questionText;
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Boolean getQuestionAnswer() {
        return questionAnswer;
    }

    public static final List<Question> math = new ArrayList<>(Arrays.asList(
            new Question("1. Toan hoc", true),
            new Question("2. Toan hoc cau 2", true)
    ));

    public static final List<Question> music = new ArrayList<>(Arrays.asList(
            new Question("1. Am nhac...", true),
            new Question("2. Am nhac cau 2", true)
    ));

}
