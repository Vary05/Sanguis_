package com.example.sanguis;

import java.util.ArrayList;

public class Question {

    private String question;
    private String explanation;
    private ArrayList<Answer> answer;

    public Question(String question, String explanation, ArrayList<Answer> ques) {
        this.question = question;
        this.explanation = explanation;
        this.answer = ques;
    }

    public String getQuestion() {
        return question;
    }

    public String getExplanation() {
        return explanation;
    }

    public ArrayList<Answer> getQues() {
        return answer;
    }
}
