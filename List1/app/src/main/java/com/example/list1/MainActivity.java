package com.example.list1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] s1={"india","USA","JAPAN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ListView v1=(ListView) findViewById( R.id.List11 );

        ArrayAdapter<String> adp= new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,s1);
        v1.setAdapter( adp );

        v1.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name= (String) adapterView.getItemAtPosition( i );
                

                Toast.makeText( getApplicationContext(),"we have cliked "+name,Toast.LENGTH_LONG ).show();
            }
        } );
    }
}