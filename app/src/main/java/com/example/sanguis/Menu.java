package com.example.sanguis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    private Button testfirst;
    private Button testsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        testfirst=findViewById(R.id.testfirst);
        testsecond=findViewById(R.id.testsecond);

        testfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Menu.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        testsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Menu.this,Main3Activity.class);
                startActivity(intent);
            }
        });
    }
}
