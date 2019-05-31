package com.example.sanguis;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionsFragment extends Fragment {

    private int pageNumber;
    private List<Question> list;
    private Question question;
    private TextView ques;
    private TextView explanation;
    private int wrong;

    public static QuestionsFragment newInstance(int page) {
        QuestionsFragment fragment = new QuestionsFragment();
        Bundle args=new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }
    public QuestionsFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
        list=new ArrayList<>();
        list=QuestionLab.get(getActivity()).getCrimes();
        question=list.get(pageNumber);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_questions, container, false);
            ques=v.findViewById(R.id.question);
            explanation=v.findViewById(R.id.explanation);
        explanation.setVisibility(View.GONE);
        LinearLayout linearLayout=v.findViewById(R.id.linear);
        RadioGroup radioGroup=new RadioGroup(getActivity());
        for (int i=0;i<question.getQues().size();i++)
        {
            final RadioButton radioButton=new RadioButton(getActivity());
            if(question.getTstnbr()==1){
            radioButton.setText(question.getQues().get(i).getAnswers());
            radioGroup.addView(radioButton);
            wrong=question.getQues().get(i).getWrong();
            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (radioButton.isChecked()) {
                        explanation.setVisibility(View.VISIBLE); }
                }
            } );}
        }
        linearLayout.addView(radioGroup);

            ques.setText(question.getQuestion());
            explanation.setText(question.getExplanation());
        return v;
    }

}
