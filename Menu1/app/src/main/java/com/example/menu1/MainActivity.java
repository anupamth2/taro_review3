package com.example.menu1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import static com.example.menu1.R.*;
import static com.example.menu1.R.menu.menu11;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( layout.activity_main );
        Button b1=(Button)findViewById( id.b1 );
        Button b2=(Button)findViewById( id.b2 );
        registerForContextMenu( b1 );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu11,menu );

        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate( R.menu.menu11,menu );
        super.onCreateContextMenu( menu, v, menuInfo );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mic1:
                Toast.makeText( getApplicationContext(),"cclick  mic",Toast.LENGTH_LONG ).show();
                break;
            case R.id.mail:
                Toast.makeText( getApplicationContext(),"cclick  mail",Toast.LENGTH_LONG ).show();
                break;
            case id.search:
                Toast.makeText( getApplicationContext(),"cclick  search",Toast.LENGTH_LONG ).show();
                break;

        }
        return super.onOptionsItemSelected( item );
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mic1:
                Toast.makeText( getApplicationContext(),"cclick  mic",Toast.LENGTH_LONG ).show();
                break;
            case R.id.mail:
                Toast.makeText( getApplicationContext(),"cclick  mail",Toast.LENGTH_LONG ).show();
                break;
            case id.search:
                Toast.makeText( getApplicationContext(),"cclick  search",Toast.LENGTH_LONG ).show();
                break;

        }


        return super.onContextItemSelected( item );
    }
    void createpop(View view)
    {
        Button b2=(Button)findViewById( R.id.b2 );
        PopupMenu pop=new PopupMenu( this,b2 );
        pop.getMenuInflater().inflate( R.menu.menu11,pop.getMenu() );


        pop.setOnMenuItemClickListener( new pop.OnMenuItemClickListener(
        );
    }

}