package com.example.intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Third11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.thirdclass );


        TextView t1= findViewById( R.id.t1 );
        TextView t2=findViewById( R.id.t2 );
        Intent rin=getIntent();
        int k11=0;
        int k12=1;
        k11=rin.getIntExtra( "fno1",0);
        k12=rin.getIntExtra( "fno2",1 );
        t1.setText(Integer.toString(k11));
        t2.setText(Integer.toString(k12) );


    }
    public void func(View view)
    {
        TextView t1= findViewById( R.id.t1 );
        TextView t2=findViewById( R.id.t2 );
        String s1=t1.getText().toString();
        String s2=t2.getText().toString();
        int x=Integer.parseInt( s1 );
        int y=Integer.parseInt( s2 );
        int sum=x+y;
        Intent result=getIntent();
        result.putExtra( "sum ",sum );
        setResult( 101,result );


    }



}
