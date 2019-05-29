package com.example.sanguis;

public class Answer {
    private String ans;
    private int wrong;

    public Answer(String answers, int wrong) {
        this.ans = answers;
        this.wrong = wrong;
    }

    public String getAnswers() {
        return ans;
    }

    public int getWrong() {
        return wrong;
    }
}
