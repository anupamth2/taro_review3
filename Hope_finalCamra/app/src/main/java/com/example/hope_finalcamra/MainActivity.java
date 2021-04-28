package com.example.hope_finalcamra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.inducesmile.androidcameraapi2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
    private void fun(){
        Intent in = new Intent(getApplicationContext(),ANDROIDCAMERAAPI.java);
        Toast.makeText(this,"intent called ",Toast.LENGTH_LONG).show();
        startActivity( in );



    }
}