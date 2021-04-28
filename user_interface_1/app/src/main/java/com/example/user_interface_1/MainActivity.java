package com.example.user_interface_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListner, View.OnClickListener {

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnhellow11;
                Toast.makeText( this, "its my first toast", Toast.LENGTH_SHORT ).show();
                break;
            default:
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnhellow=findViewById(R.id.btnhellow11);
        btnhellow.setOnClickListener(this);
        btnhellow.setOnLongClickListener(View v){
            Toast.makeText(Context:MainActivity.this,text:"hello its anupam",Toast.LENGTH_SHORT).show();








        }


    }


}