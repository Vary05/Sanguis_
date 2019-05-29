package com.example.sanguis;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class QuestionLab
{
    private static QuestionLab houseLab;
    private List<Question> houses;
    public static QuestionLab get(Context context) {
        if (houseLab == null) {
            houseLab = new QuestionLab(context);
        }
        return houseLab;
    }
    private QuestionLab(Context context) {
        houses=new ArrayList<Question>();
    }
    public List<Question> getCrimes() {
        return houses;
    }
    public void AddHouses(List<Question> h)
    {
        houses.addAll(h);
    }
    public static void Destroy()
    {
        houseLab=null;
    }
}
