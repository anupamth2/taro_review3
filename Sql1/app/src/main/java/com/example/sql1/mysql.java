package com.example.sql1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class mysql extends SQLiteOpenHelper {

    private String CUSTOMER;
    private String cus;

    public mysql(@Nullable Context context) {
        super( context, "mydatabase123.db", null, 1 );
    }


        @Override
        public void onCreate (SQLiteDatabase db){
        CUSTOMER="CUSTOMER";

            //Toast.makeText( this,"we have reached herere",Toast.LENGTH_LONG ).show();

            String table1 = " CREATE TABLE "+CUSTOMER+"( ID INTEGER PRIMARY KEY AUTOINCREMENT,CNAME TEXT,CAGE INTEGER )";
            db.execSQL( table1 );

        }

        @Override
        public void onUpgrade (SQLiteDatabase db,int i, int i1){


        }


        public boolean addone11 (sql1 sql11)
        {
            SQLiteDatabase mydatabase123;
            mydatabase123 = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put( "n_customer", sql11.getName() );
            cv.put( "age_customer", sql11.getAge() );
            cv.put( "activity", sql11.isIs_active() );
            long k111=0;
            try{
            long k11 = mydatabase123.insert(CUSTOMER, null, cv );
             k111=k11;
            }
            catch (Exception e)
            {
                //Toast.makeText( this,"there is an error",Toast.LENGTH_LONG  );

            }
           // Toast.makeText( MainActivity.this,"this is k11 "+k11,Toast.LENGTH_LONG ).show();
            if(k111==-1)
            {
                return false;
            }
            return  true;

        }
    }

