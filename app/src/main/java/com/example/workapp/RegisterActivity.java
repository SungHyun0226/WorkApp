package com.example.workapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText idView;
    EditText paView;
    EditText nameView;
    EditText birthView;
    EditText phoneView;
    EditText addressView;
    RadioGroup genderGroup;

    final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idView = (EditText) findViewById(R.id.id_editview);
        paView = (EditText) findViewById(R.id.password_editview);
        nameView = (EditText) findViewById(R.id.name_editview);
        birthView = (EditText) findViewById(R.id.birth_editview);
        phoneView = (EditText) findViewById(R.id.phone_editview);
        addressView = (EditText) findViewById(R.id.address_editview);

        genderGroup = (RadioGroup) findViewById(R.id.gender_group);
        Button registerButton = (Button) findViewById(R.id.register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view) {
                String id = String.valueOf(idView.getText());
                String pa = String.valueOf(paView.getText());
                String name = String.valueOf(nameView.getText());
                String birth = String.valueOf(birthView.getText());
                String phone = String.valueOf(phoneView.getText());
                String address = String.valueOf(addressView.getText());
                int gender = genderGroup.getCheckedRadioButtonId();

                if (id.length() < 8) {
                    Toast.makeText(getApplicationContext(), "아이디는 8자 이상 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                    if (!validatePassword(pa)) {
                        Toast.makeText(getApplicationContext(), "비밀번호에 소문자, 대문자, 특수문자, 숫자를 적어도 하나를 포함해주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(name.length() < 1 ){
                        Toast.makeText(getApplicationContext(), "이름을 입력하여주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(birth.length() != 8){
                        Toast.makeText(getApplicationContext(), "생년월일을 8자리로 입력하여주세요", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(phone.length() != 11){
                        Toast.makeText(getApplicationContext(), "휴대폰 번호는 -를 뺀 11자리를 입력하여주세요", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(address.length() < 1){
                        Toast.makeText(getApplicationContext(), "주소를 입력하여주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                if (gender == -1){
                    //not clicked
                    Toast.makeText(getApplicationContext(), "성별을 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if(gender == R.id.man_Radiobutton){
                        //남자 선택
                        Log.d("register", "man clicked");
                    }
                    else if(gender == R.id.girl_Radiobutton){
                        //여자 선택
                        Log.d("register", "girl clicked");
                    }
                }

                Log.d("register", id + "/" + pa + "/" + name + "/" + birth + "/" + phone + "/" + address + "/" + String.valueOf(gender) );

                finish();
                    }
                });
            }
    public boolean validatePassword(String pa) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(pa);

        return matcher.matches();
                }
}