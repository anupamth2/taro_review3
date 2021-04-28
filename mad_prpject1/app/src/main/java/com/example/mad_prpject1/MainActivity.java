package com.example.mad_prpject1;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int sum=0;
    int kk1=-1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        FloatingActionButton fab = findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        } );
    }
    public void function(View view){
        TextView text1=findViewById( R.id.textView4 );
        text1.setText( "CHOOSE A NUMBER FROM BELOW" );
        TextView text2=findViewById( R.id.textView5 );
        TextView text3=findViewById( R.id.textView6 );
        TextView text4=findViewById( R.id.textView7 );
        TextView text5=findViewById( R.id.textView8 );
        TextView text=findViewById( R.id.textView3 );


        text1.setText("CHOOSE A NO  ");
        Random rand = new Random();
        int r1=rand.nextInt(5);
        int r2=rand.nextInt(5);
        int r3=rand.nextInt(5);
        int r4=rand.nextInt(5);
        int kk=rand.nextInt(5);
        kk1=r1;
        String s1=String.valueOf(r1);
        String s2=String.valueOf(r2);
        String s3=String.valueOf( r3 );
        String s4=String.valueOf( r4 );
        text2.setText( s1 );
        text3.setText( s2 );
        text4.setText( s3 );
        text5.setText( s4 );








    }
    public void fun1(View view)
    {
        TextView text=findViewById( R.id.textView5 );
        Random rand = new Random();
        int k3=rand.nextInt(5);
        String  s1 = text.getText().toString();
        int k12=Integer.parseInt(s1);
        if(k12==k3)
        {
            TextView tex=findViewById( R.id.textView3 );
            tex.setText( "correct guess click play again" );
            TextView tex1=findViewById( R.id.textView9 );
            sum=sum+1;
            tex1.setText( "SCORE  "+sum );




        }
        else
        {
            TextView tex=findViewById( R.id.textView3 );
            tex.setText( "wrong guess play again " );            TextView tex1=findViewById( R.id.textView9 );
            sum=sum-1;
            tex1.setText( "SCORE  "+sum );


        }


    }
    public void fun2(View view)
    {
        TextView text=findViewById( R.id.textView6 );
        Random rand = new Random();
        int k3=rand.nextInt(5);
        String  s1 = text.getText().toString();
        int k12=Integer.parseInt(s1);
        if(k12==k3)
        {
            TextView tex=findViewById( R.id.textView3 );
            tex.setText( "you have guessed the correct answer click play to continue" );
            TextView tex1=findViewById( R.id.textView9 );
            sum=sum+1;
            tex1.setText( "SCORE  "+sum );

        }
        else
        {
            TextView tex=findViewById( R.id.textView3 );
            tex.setText( "wrong guess play again " );
            TextView tex1=findViewById( R.id.textView9 );
            sum=sum-1;
            tex1.setText( "SCORE  "+sum );


        }


    }
    public void fun3(View view)
    {
        TextView text=findViewById( R.id.textView7 );
        Random rand = new Random();
        int k3=rand.nextInt(5);
        String  s1 = text.getText().toString();
        int k12=Integer.parseInt(s1);
        if(k12==k3)
        {
            TextView tex=findViewById( R.id.textView3 );
            tex.setText( "you have guessed the correct answer click play to continue" );
            TextView tex1=findViewById( R.id.textView9 );
            sum=sum+1;
            tex1.setText( "SCORE  "+sum );

        }
        else
        {
            TextView tex=findViewById( R.id.textView3 );
            tex.setText( "wrong guess play again " );
            TextView tex1=findViewById( R.id.textView9 );
            sum=sum-1;
            tex1.setText( "SCORE  "+sum );


        }


    }
    public void fun4(View view)
    {
        TextView text=findViewById( R.id.textView8 );
        Random rand = new Random();
        int k3=rand.nextInt(5);
        String  s1 = text.getText().toString();
        int k12=Integer.parseInt(s1);
        if(k12==k3)
        {
            TextView tex=findViewById( R.id.textView3 );
            tex.setText( "you have guessed the correct answer click play to continue" );
            TextView tex1=findViewById( R.id.textView9 );
            sum=sum+1;
            tex1.setText( "SCORE  "+sum );


        }
        else
        {
            TextView tex=findViewById( R.id.textView3 );
            tex.setText( "wrong guess play again " );
            TextView tex1=findViewById( R.id.textView9 );
            sum=sum-1;
            tex1.setText( "SCORE  "+sum );

        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }
}