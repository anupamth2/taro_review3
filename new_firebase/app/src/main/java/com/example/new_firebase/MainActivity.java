package com.example.new_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
        EditText ed1;
        EditText ed2;
        EditText ed3;
        EditText ed4;
        Button b1;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ed1=findViewById( R.id.t1 );
        ed2=findViewById( R.id.t2 );
        ed3=findViewById( R.id.t3 );
        ed4=findViewById( R.id.t4 );
        b1=findViewById( R.id.button );
        b1.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        sendMail();
                }




                });



        }
        private void sendMail() {
        String s1=ed1.getText().toString();
        String s2=ed2.getText().toString();
        String s3=ed3.getText().toString();
        String s4=ed4.getText().toString();

        Intent in=new Intent( Intent.ACTION_SEND );
        in.putExtra( Intent.EXTRA_EMAIL,s1 );
        in.putExtra( Intent.EXTRA_EMAIL,s2 );
        in.putExtra( Intent.EXTRA_SUBJECT,s3 );
        in.putExtra( Intent.EXTRA_TEXT,s4 );
        in.setType( "s4/rfc822" );
        startActivity( in );

        }
}
