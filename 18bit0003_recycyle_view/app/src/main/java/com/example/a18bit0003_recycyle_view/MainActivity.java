package com.example.a18bit0003_recycyle_view;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<studentData> studentDataList = new ArrayList<>();
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        studentAdapter = new StudentAdapter(studentDataList);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(studentAdapter);
        StudentDataPrepare();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void StudentDataPrepare() {
        studentData data = new studentData("india" );
        studentDataList.add(data);
        data = new studentData("sai", 25);
        studentDataList.add(data);
        data = new studentData("raghu", 20);
        studentDataList.add(data);
        data = new studentData("raj", 28);
        studentDataList.add(data);
        data = new studentData("amar", 15);
        studentDataList.add(data);
        data = new studentData("bapu", 19);
        studentDataList.add(data);
        data = new studentData("chandra", 52);
        studentDataList.add(data);
        data = new studentData("deraj", 30);
        studentDataList.add(data);
        data = new studentData("eshanth", 28);
        studentDataList.add(data);
        Collections.sort(studentDataList, new Comparator() {
            @Override
            public int compare(studentData o1, studentData o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }
}