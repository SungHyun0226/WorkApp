package com.example.workapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CompanymainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companymain);

        Button button1 = (Button) findViewById(R.id.C_mypage);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CompanymainActivity.this, CompanyMypageActivity.class);
                startActivity(myIntent);

            }
        });

        Button button2 = (Button) findViewById(R.id.C_joblist);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CompanymainActivity.this, CompanyJoblistActivity.class);
                startActivity(myIntent);
            }
        });

        Button button3 = (Button) findViewById(R.id.C_participant);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(CompanymainActivity.this, CompanyParticipantActivity.class);
                startActivity(myIntent);
            }
        });

        Button button4 = (Button) findViewById(R.id.C_notice);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(CompanymainActivity.this, NoticeActivity.class);
                startActivity(myIntent);
            }
        });
    }
}