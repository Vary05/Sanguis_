package com.example.sanguis;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
            ques.setText(question.getQuestion());
            explanation.setText(question.getExplanation());
        return v;
    }

}
