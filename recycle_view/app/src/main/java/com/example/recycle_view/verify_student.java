package com.example.recycle_view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class verify_student extends  MainActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.verify_student_xml );
        RecyclerView recl = (RecyclerView) findViewById( R.id.rclview );
        recl.setLayoutManager( new LinearLayoutManager( this ) );
        String arr[] = {"rema", "noje", "siys ", "dataf", "rema", "noje", "siys ", "dataf"};
        recl.setAdapter( new myadapter( arr ) );
        Toast.makeText( this,"we have readcjed he ",Toast.LENGTH_LONG ).show();
        Toast.makeText( this,"ee eew ew ",Toast.LENGTH_LONG ).show();
    }
 }
