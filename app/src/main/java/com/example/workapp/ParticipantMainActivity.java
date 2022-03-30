package com.example.workapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ParticipantMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant_main);

        Button button1 = (Button) findViewById(R.id.P_mypage);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(ParticipantMainActivity.this, ParticipantMypageActivity.class);
                startActivity(myIntent);
            }
        });

        Button button2 = (Button) findViewById(R.id.P_joblist);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(ParticipantMainActivity.this, ParticipantJoblistActivity.class);
                startActivity(myIntent);
            }
        });

        Button button3 = (Button) findViewById(R.id.P_participant);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(ParticipantMainActivity.this, ParticipantStatusActivity.class);
                startActivity(myIntent);
            }
        });

        Button button4 = (Button) findViewById(R.id.P_notice);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(ParticipantMainActivity.this, NoticeActivity.class);
                startActivity(myIntent);
            }
        });
    }
}