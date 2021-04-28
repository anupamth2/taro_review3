package com.example.debugginh;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
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
    public void funct(View view){
        EditText edt=findViewById( R.id.editName );
        TextView txt=findViewById( R.id.buttton11 );
        txt.setText( "you have successfully log in" );

        EditText ed1=findViewById( R.id.editName );
        String s=ed1.getText().toString();
        edt.setText("this is my pen "+s);





        //EditText ed12=findViewById( R.id.buttton111 );
       // ed12.setText( " " );
        EditText ed122=findViewById( R.id.edttxt9 );
        ed122.setText( "    " );
        System.out.println(ed1);
        //Toast.makeText(Context MainActivity "This is my Toast message!",Toast.LENGTH_LONG).show();
        Toast.makeText(MainActivity.this, "ed1", Toast.LENGTH_LONG).show();






        return;
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