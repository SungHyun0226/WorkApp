package com.example.workapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup companyandparticipant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        companyandparticipant = (RadioGroup) findViewById(R.id.compa_group);

        Button button1 = (Button) findViewById(R.id.open_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int compaorpart = companyandparticipant.getCheckedRadioButtonId();
                if (compaorpart == -1) {
                    //not clicked
                    Toast.makeText(getApplicationContext(), "사용자의 형태를 체크해주세요", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (compaorpart == R.id.company_button) {
                        EditText editText = (EditText) findViewById(R.id.user_id);
                        String text = String.valueOf(editText.getText());
                        Intent myIntent = new Intent(MainActivity.this, CompanymainActivity.class);
                        myIntent.putExtra("ID", text);
                        startActivity(myIntent);
                    } else if (compaorpart == R.id.Participant_button) {
                        EditText editText = (EditText) findViewById(R.id.user_id);
                        String text = String.valueOf(editText.getText());
                        Intent myIntent = new Intent(MainActivity.this, ParticipantMainActivity.class);
                        myIntent.putExtra("ID", text);
                        startActivity(myIntent);
                    }
                }
                //Log.d("test", "button clicked!");
                //Toast.makeText(getApplicationContext(), "로그인 실패!", Toast.LENGTH_SHORT).show();
            }
        });

        Button button2 = (Button) findViewById(R.id.register_button);
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                int compaorpart = companyandparticipant.getCheckedRadioButtonId();
                if (compaorpart == -1) {
                    //not clicked
                    Toast.makeText(getApplicationContext(), "사용자의 형태를 체크해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }   else {
                        if (compaorpart == R.id.company_button) {

                            Intent myIntent = new Intent(MainActivity.this, CompanyRegisterActivity.class);
                            startActivity(myIntent);
                        } else if (compaorpart == R.id.Participant_button) {

                            Intent myIntent = new Intent(MainActivity.this, RegisterActivity.class);
                            startActivity(myIntent);
                        }
                    }
                }
            });
        }
    }