package com.example.workapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecruitListAdapter extends RecyclerView.Adapter<RecruitListAdapter.ViewHolder> {
    private ArrayList<Recruit> mRecruits;
    private OnItemClickEventListener mItemClickListener;

    public interface OnItemClickEventListener {
        void onItemClick(View view, int pos);
    }

    public void setOnItemClickListener(OnItemClickEventListener listener){
        mItemClickListener = listener;
    }

    public RecruitListAdapter(ArrayList<Recruit> recruits){
        mRecruits = recruits;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView companyTextview;

        public ViewHolder(View itemView, final OnItemClickEventListener itemClickListener) {
            super(itemView);

            titleTextView = (TextView) itemView.findViewById(R.id.recruit_title);
            companyTextview = (TextView) itemView.findViewById(R.id.recruit_company);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    final int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        itemClickListener.onItemClick(view, position);
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public RecruitListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.recruit_item,parent,false);

        return new ViewHolder(contactView, mItemClickListener);
        //UI 제작
    }

    @Override
    public void onBindViewHolder(@NonNull RecruitListAdapter.ViewHolder holder, int position) {
        Recruit recruit = mRecruits.get(position);

        TextView title = holder.titleTextView;
        TextView company = holder.companyTextview;

        title.setText(recruit.getTitle());
        company.setText(recruit.getCompanyName());
        //UI 내용물 채워넣기
    }

    @Override
    public int getItemCount() {
        return mRecruits.size();
    }
}
