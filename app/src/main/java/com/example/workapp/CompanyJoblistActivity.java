package com.example.workapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CompanyJoblistActivity extends AppCompatActivity {
    private ArrayList<Recruit>  RecruitList = new ArrayList<Recruit> (
            Arrays.asList(
                    new Recruit("company1", "A  we are now hiring bad students!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company5", "E  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company2", "B  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company3", "C  we are looking for bad slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company4", "D  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company8", "H  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company6", "F  we are looking for bad slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company7", "G  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company11", "K  we are looking for brilliant slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company9", "I  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company10", "J  we are looking for brilliant slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company11", "K  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company12", "L  we are looking for bad slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company13", "M  we are looking for brilliant slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company14", "N  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01")
            )) ;
    final private ArrayList<Recruit> RecruitList2 = new ArrayList<>(RecruitList);
    private RecruitListAdapter mAdapter;
    private RecyclerView mRecruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_joblist);

        mRecruits = (RecyclerView) findViewById(R.id.recruit_rcview2);

        mAdapter = new RecruitListAdapter(RecruitList2);

        mAdapter.setOnItemClickListener(new RecruitListAdapter.OnItemClickEventListener() {
            @Override
            public void onItemClick(View view, int pos) {
                Intent myIntent = new Intent(CompanyJoblistActivity.this, RecruitActivity.class);
                myIntent.putExtra("recruit", RecruitList2.get(pos));
                startActivity(myIntent);
            }
        });

        mRecruits.setAdapter(mAdapter);
        mRecruits.setLayoutManager(new LinearLayoutManager(this));

        Button companySortButton= (Button) findViewById(R.id.bt_company2);
        companySortButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Collections.sort(RecruitList2, new Comparator<Recruit>(){
                    public int compare(Recruit obj1, Recruit obj2){
                        return obj1.getCompanyName().compareToIgnoreCase(obj2.getCompanyName());
                    }
                });
                mAdapter.notifyDataSetChanged();
            }
        });
        Button titleSortButton= (Button) findViewById(R.id.bt_title2);
        titleSortButton.setOnClickListener(view -> {
            Collections.sort(RecruitList2, (obj1, obj2) -> obj1.getTitle().compareToIgnoreCase(obj2.getTitle()));
            mAdapter.notifyDataSetChanged();
        });
        Button recruitWriteButton = (Button) findViewById(R.id.recruit_Write);
        recruitWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CompanyJoblistActivity.this, RecruitWriteActivity.class);
                startActivity(myIntent);
            }
        });
        EditText recruitSearch = findViewById(R.id.et_recruitsearch2);
        recruitSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("edittextdebugging", s.toString());
                String searchContent = s.toString();
                RecruitList2.clear();
                RecruitList.forEach(item -> {
                    if (item.getTitle().contains(searchContent)) {
                        RecruitList2.add(item);
                    }
                });
                mAdapter.notifyDataSetChanged();
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

}