package com.example.prono_doctor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Switch;

public class docto_scedule_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_docto_scedule_page );
        Button b8=findViewById( R.id.button8 );

        final RadioGroup radioGroup=findViewById( R.id.radioGroup );
        b8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int select_id=radioGroup.getCheckedRadioButtonId();
                int day;
                if(select_id==R.id.radioButton1)
                    day=1;
                if(select_id==R.id.radioButton2)
                    day=2;
                if(select_id==R.id.radioButton3)
                    day=3;
                if(select_id==R.id.radioButton4)
                    day=4;
                if(select_id==R.id.radioButton5)
                    day=5;
                if(select_id==R.id.radioButton6)
                    day=6;
                if(select_id==R.id.radioButton7)
                    day=7;

            }
        } );
    }
}