package com.example.letstry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.inducesmile.androidcameraapi2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
    public void fun(View view){
        Intent in = new Intent(getApplicationContext(),AndroidCameraApi.java);
        Toast.makeText(this,"intent called ",Toast.LENGTH_LONG).show();

        startActivity( in );



    }
}