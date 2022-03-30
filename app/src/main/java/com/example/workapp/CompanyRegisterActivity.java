package com.example.workapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompanyRegisterActivity extends AppCompatActivity {
    EditText idView;
    EditText pwView;
    EditText CompanynameView;
    EditText CEOView;
    EditText callView;
    EditText CompanyAddressView;

    final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_register);

        idView = (EditText) findViewById(R.id.Cid_editview);
        pwView = (EditText) findViewById(R.id.Cpw_editview);
        CompanynameView = (EditText) findViewById(R.id.Cname_editview);
        CEOView = (EditText) findViewById(R.id.CEO_editview);
        callView = (EditText) findViewById(R.id.Ccall_editview);
        CompanyAddressView = (EditText) findViewById(R.id.Caddress_editview);

        Button registerButton = (Button) findViewById(R.id.register2);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = String.valueOf(idView.getText());
                String pw = String.valueOf(pwView.getText());
                String Companyname = String.valueOf(CompanynameView.getText());
                String CEO = String.valueOf(CEOView.getText());
                String call = String.valueOf(callView.getText());
                String address = String.valueOf(CompanyAddressView.getText());

                if (id.length() < 8) {
                    Toast.makeText(getApplicationContext(), "아이디는 8자 이상 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!validatePassword(pw)) {
                    Toast.makeText(getApplicationContext(), "비밀번호에 소문자, 대문자, 특수문자, 숫자를 적어도 하나를 포함해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Companyname.length() < 1 ){
                    Toast.makeText(getApplicationContext(), "기업명을 입력하여주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(CEO.length() < 1 ){
                    Toast.makeText(getApplicationContext(), "대표명을 입력하여주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(call.length() != 11){
                    Toast.makeText(getApplicationContext(), "-를 뺀 전화번호를 올바르게 입력하여주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(address.length() < 1){
                    Toast.makeText(getApplicationContext(), "주소를 입력하여주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d("register", id + "/" + pw + "/" + Companyname + "/" + CEO + "/" + call + "/" + address );

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