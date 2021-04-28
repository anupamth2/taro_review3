package com.example.anupam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);













    }
    pulic void fun_class(View view){
        EditText text1 = findViewById(R.id.name_field);
        text1.getText().toString();
        EditText text2=findViewById(R.id.class_field);
        text2.getText().toString();
        EditText text3 = findViewById(R.id.email_field);
        text2.getText().toString();
        TextView tx1=findViewById(R.id.textView4);
        tx1.setText(text1);
        TextView tx2=findViewById(R.id.textView5);
        text2.setText(text2);
        




    //public void onbutonclick(View view){

      //  TextView txt_hello=findViewById(R.id.mass);
        ///txt_hello.setText("he i m an");
        //EditText texa = findViewById(R.id.text1);
        //texa.getText().toString();
        //txt_hello.setText("we have recordde your responsed");


    }

}