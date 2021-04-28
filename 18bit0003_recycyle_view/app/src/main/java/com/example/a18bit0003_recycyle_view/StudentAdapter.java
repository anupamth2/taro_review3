package com.example.a18bit0003_recycyle_view;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Random;

class StudentAdapter extends RecyclerView.Adapter {
    List studentDataList;
    public StudentAdapter(List studentDataList) {
        this.studentDataList=studentDataList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_list_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        studentData data=studentDataList.get(i);
        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        viewHolder.parent.setBackgroundColor(currentColor);
        viewHolder.name.setText(data.name);
        viewHolder.age.setText(String.valueOf(data.age));
    }
    @Override
    public int getItemCount() {
        return studentDataList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,age;
        LinearLayout parent;
        public MyViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
        }
    }
}
