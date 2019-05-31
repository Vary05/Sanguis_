package com.example.sanguis;

import java.util.ArrayList;

public class Question {

    private String question;
    private String explanation;
    private ArrayList<Answer> answer;
    private int tstnbr;

    public Question(String question, String explanation, ArrayList<Answer> ques,int tstnbr) {
        this.question = question;
        this.explanation = explanation;
        this.answer = ques;
        this.tstnbr=tstnbr;
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

    public int getTstnbr(){return tstnbr;}
}
