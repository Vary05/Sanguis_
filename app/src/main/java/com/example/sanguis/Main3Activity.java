package com.example.sanguis;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Main3Activity extends AppCompatActivity {

    private Handler mHandler;
    private ArrayList<Question> ques;
    private Button next;
    private int z=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        next=findViewById(R.id.next);
        mHandler=new Handler(Looper.getMainLooper());
        ques=new ArrayList<>();
        String uri=ApiUrl.BASE_URL+"getQuestions.php";
        OkHttpClient client=new OkHttpClient();
        final Request request=new Request.Builder().url(uri).build();
        client.newCall(request).enqueue(new okhttp3.Callback(){
            @Override
            public void onFailure(okhttp3.Call call, IOException e){}
             @Override
             public void onResponse(okhttp3.Call call, final okhttp3.Response response)throws IOException{
                 final String res=response.body().string();
                 mHandler.post(new Runnable() {
                     @Override
                     public void run() {
                         try {
                             JSONArray ob=new JSONArray(res);
                             Gson gson=new Gson();
                             for (int i = 0; i <ob.length(); i++) {
                                 String f=ob.get(i).toString();
                                 Question q=gson.fromJson(f,Question.class);
                                 ques.add(q);
                             }

                             QuestionLab.get(getApplicationContext()).AddHouses(ques);
                             z=0;
                             FragmentManager fragmentManager=getSupportFragmentManager();
                             Fragment fragment=TestFragment.newInstance(z);
                             FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                             fragmentTransaction.replace(R.id.container,fragment);
                             fragmentTransaction.addToBackStack(null);
                             fragmentTransaction.commit();
                             next.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     if (z<ques.size()-1){
                                         z++;
                                         FragmentManager fragmentManager=getSupportFragmentManager();
                                         Fragment fragment=TestFragment.newInstance(z);
                                         FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                                         fragmentTransaction.replace(R.id.container, fragment);
                                         fragmentTransaction.addToBackStack(null);
                                         fragmentTransaction.commit();
                                     }
                                     else {
                                         next.setVisibility(View.GONE);
                                     }
                                 }
                             });
                         } catch (JSONException e){
                             Log.d("mes",e.getMessage());}
                     }
                 });

            }
        });


}}
