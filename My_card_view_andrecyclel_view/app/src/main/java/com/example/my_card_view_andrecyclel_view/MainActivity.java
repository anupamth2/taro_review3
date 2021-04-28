package com.example.my_card_view_andrecyclel_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    String[] St={"india","USA","japan"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.llist_view, mobileArray);

        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.getLayoutManager(new LinearLayoutManager( getApplicationContext())





    }
}

