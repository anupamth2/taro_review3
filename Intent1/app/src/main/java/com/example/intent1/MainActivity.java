package com.example.intent1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    public void function1(View view) {
        EditText edit = findViewById( R.id.F1 );
        //edit.setText( "hi i am anupam " );
        Toast.makeText( this, "ram is my friend", Toast.LENGTH_LONG ).show();
        String s11 = edit.getText().toString();
        EditText edit2 = findViewById( R.id.F2 );
        String s12 = edit2.getText().toString();
        Toast.makeText( this, s12, Toast.LENGTH_LONG ).show();
        int k1 = Integer.parseInt( s11 );
        int k2 = Integer.parseInt( s12 );

    }
}

       // Intent in=new Intent( this,Third11.class);
        //in.putExtra( "fno1",k1 );
        /*in.putExtra( "fno2",k2 );
        startActivityForResult(in,100);





    }


    protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
       int r= data.getIntExtra("sum",-1);

        Toast.makeText( getApplicationContext(), "the sum is "+r, Toast.LENGTH_LONG ).show();
    }




}