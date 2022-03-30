package com.example.workapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ParticipantJoblistActivity extends AppCompatActivity {
    private ArrayList<Recruit>  RecruitList = new ArrayList<Recruit> (
            Arrays.asList(
                    new Recruit("company1", "A  we are now hiring good students!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company5", "E  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company2", "B  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company3", "C  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company4", "D  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company8", "H  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company6", "F  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company7", "G  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company11", "K  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company9", "I  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company10", "J  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company11", "K  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company12", "L  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company13", "M  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01"),
                    new Recruit("company14", "N  we are looking for good slaves!","18만원","2022/04/10","충주시 단월동", "단순 작업인부", "2022/04/01")
             )) ;
    private RecruitListAdapter mAdapter;
    private RecyclerView mRecruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant_joblist);

        mRecruits = (RecyclerView) findViewById(R.id.recruit_rcview);

        mAdapter = new RecruitListAdapter(RecruitList);

        mAdapter.setOnItemClickListener(new RecruitListAdapter.OnItemClickEventListener() {
            @Override
            public void onItemClick(View view, int pos) {
                Intent myIntent = new Intent(ParticipantJoblistActivity.this, RecruitActivity.class);
                myIntent.putExtra("recruit", RecruitList.get(pos));
                startActivity(myIntent);
            }
        });

        mRecruits.setAdapter(mAdapter);
        mRecruits.setLayoutManager(new LinearLayoutManager(this));

        Button companySortButton= (Button) findViewById(R.id.bt_company);
        companySortButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Collections.sort(RecruitList, new Comparator<Recruit>(){
                    public int compare(Recruit obj1, Recruit obj2){
                        return obj1.getCompanyName().compareToIgnoreCase(obj2.getCompanyName());
                    }
                });
                mAdapter.notifyDataSetChanged();
            }
        });
        Button titleSortButton= (Button) findViewById(R.id.bt_title);
        titleSortButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(RecruitList, new Comparator<Recruit>(){
                    public int compare(Recruit obj1, Recruit obj2){
                        return obj1.getTitle().compareToIgnoreCase(obj2.getTitle());
                    }
                });
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}