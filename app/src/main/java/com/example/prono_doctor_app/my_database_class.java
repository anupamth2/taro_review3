package com.example.prono_doctor_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class my_database_class extends SQLiteOpenHelper {
    public my_database_class(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super( context, "sql_database4", factory, version );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String s1="CREATE TABLE DOCTOR(DOCTOR_ID INTEGER PRIMARY KEY,NAME VARCHAR(100),PASSWORD VARCHAR (100),CITY VARCHAR(100),SPECIALITY VARCHAR(100),NO_OF_EXPERIENCE INTEGER,ADDRESS VARCHAR(500),MOBILE_NO VARCHAR,PATIENT_ID_1 INTEGER ,DISEASE_ID_1 INTEGER,FOREIGN KEY (PATIENT_ID_1) REFERENCES PATIENT(PATIENT_ID));";
        String s2="CREATE TABLE PATIENT(PATIENT_ID INTEGER PRIMARY KEY,PASSWORD VARCHAR,NAME VARCHAR,AGE INTEGER,CITY VARCHAR,TYPE VARCHAR,HISTORY_OF_DISEASE VARCHAR,DOCTOR_ID_1 INTEGER,FOREIGN KEY(DOCTOR_ID_1) REFERENCES DOCTOR(DOCTOR_ID));";


        String s3="CREATE TABLE DISEASE(DISEASE_ID INTEGER PRIMARY KEY, DOCTOR_ID_2 INTEGER,PATIENT_ID_2 INTEGER,DETAILS_1 VARCHAR,DETAILS_2 VARCHAR,DETAILS_3 VARCHAR,EMERGENCY INTEGER,REMARK VARCHAR,FOREIGN KEY(DOCTOR_ID_2) REFERENCES DOCTOR(DOCTOR_ID),FOREIGN KEY(PATIENT_ID_2) REFERENCES PATIENT(PATIENT_ID));";
        String s4 ="CREATE TABLE SCHEDULE(SCHEDULE_ID INTEGER PRIMARY KEY,DAYS VARCHAR,START_TIME VARCHAR,END_TIME VARCHAR,DOCTOR_ID_3 INTEGER,PATIENT_ID_3 INTEGER,DISEASE_TYPE VARCHAR,DISEASE_ID_3 INTEGER,FOREIGN KEY(DOCTOR_ID_3) REFERENCES DOCTOR(DOCTOR_ID),FOREIGN KEY(PATIENT_ID_3) REFERENCES PATIENT(PATIENT_ID),FOREIGN KEY(DISEASE_ID_3) REFERENCES DISEASE(DISEASE_ID));";
        Log.d("database","we are executing ");

        try {
            sqLiteDatabase.execSQL( s1 );
            sqLiteDatabase.execSQL( s2 );
            sqLiteDatabase.execSQL( s3 );
            sqLiteDatabase.execSQL( s4 );
            Log.d("database","table created DISEASE,DOCTOR,PATIENT,SCHEDULE ");
        }
        catch (Exception e)
        {
            Log.d("database"," "+e);
        }




    }
    int write_in_doctor_table(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cn =new ContentValues(  );
        cn.put( "DOCTOR_ID",Integer.parseInt( s1 ));
        //(DOCTOR_ID INTEGER PRIMARY KEY,NAME VARCHAR(100),PASSWORD VARCHAR (100),
        //
        // CITY VARCHAR(100),SPECIALITY VARCHAR(100),NO_OF_EXPERIENCE INTEGER,
        // ADDRESS VARCHAR(500),MOBILE_NO VARCHAR,
        // PATIENT_ID_1 INTEGER ,DISEASE_ID_1 INTEGER,FOREIGN KEY (PATIENT_ID_1) REFERENCES PATIENT(PATIENT_ID));";
        cn.put("NAME",s8);
        cn.put( "PASSWORD",s2 );
        cn.put("CITY",s3);
        cn.put("SPECIALITY",s4);
        cn.put("NO_OF_EXPERIENCE",Integer.parseInt( s5));
        cn.put("ADDRESS",s6);
        cn.put("MOBILE_NO",s7);
        cn.put( "PATIENT_ID_1",Integer.parseInt( s9 ) );
        cn.put("DISEASE_ID_1",Integer.parseInt( s10 ));


        try
        {
            sqLiteDatabase.insertWithOnConflict( "DOCTOR",null,cn,SQLiteDatabase.CONFLICT_REPLACE );
            return 1;
        }
        catch (Exception e)
        {
            Log.d("database"," exception "+e);
            return 0;
        }


    }

    void read_database_doctor()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

        //String s155="INSERT INTO DOCTOR VALUES("+"1134122161,\"Rodrigo  C       Hurtado\",1890,\"VA\",\"Pulmonologists\",0,\"3450 N Beauregard St\",\"7039310059\",14370,6729"+");";
        String s156="INSERT INTO DOCTOR VALUES("+"1134122161,\"Rodrigo  C       Hurtado\",1890,\"VA\",\"Pulmonologists\",0,\"3450 N Beauregard St\",\"7039310059\",14370,6729);";
        String s157="INSERT INTO DOCTOR VALUES("+"1154324366,\"Ray      Jaime   Rodriguez\",1101,\"MS\",\"Pathologists\",9,\"7730 Old Canton Rd Bldg B\",\"6014990936\",13548,9393);";
       // String s158="INSERT INTO DOCTOR VALUES("+"1720081854,\"William          Spiegel\",1084,\"PA\",\"vascular surgery.\",0,\"470 Sentry Pkwy E\",\"6103970980\",18756,9954);";
        String s158="INSERT INTO DOCTOR VALUES("+"1861495988,\"Eva              Jakabovics\",1376,\"PA\",\"Colon and Rectal Surgeons\",4,\"470 Sentry Pkwy E\",\"6103970980\",16308,8931);";
        //String s11="select * from doctor;";
       // String s12="ALTER TABLE DOCTOR ADD COLUMN DISEASE_ID VARCHAR;";
        try {
            ArrayList<String> arr;
            s158="select * from Doctor";
            Cursor cursor = sqLiteDatabase.rawQuery( s158 ,null);
            if(cursor.moveToFirst() )
            {
                String s="";
                do {
                    s += cursor.getInt( 0 );
                    s+=" "+cursor.getString( 1 );
                    s+=" "+cursor.getString( 2 );
                    s+=" "+cursor.getString( 3 );
                    s+=" "+cursor.getString( 4 );
                    s+=" "+cursor.getInt( 5 );
                    s+=" "+cursor.getString( 6 );
                    s+=" "+cursor.getString( 7 );
                    //s+=" "+cursor.getString( 1 );

                    s+="\n";

                }while (cursor.moveToNext());
                Log.d("database",s);
            }

            Log.d("database","successfulllly inserted in table");

        }
        catch (Exception e)
        {
            Log.d("database"," "+e);
        }
        //Cursor cd=sqLiteDatabase.rawQuery( s11,null );
        int count=0;


        Log.d("database","welcome "+count);

    }
    void read_database_patient()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String s2="INSERT INTO PATIENT VALUES (576829,\"5478\",\"RAM PRASAD\",50,\"VA\",\"Cardiologists\",\"YES\",1154324366); ";
        String s3="INSERT INTO PATIENT VALUES (576830,\"5832\",\"MOHAN DAS\",40,\"MS\",\"Pulmonologists\",\"NO\",1720081854); ";
        String s4="INSERT INTO PATIENT VALUES (576831,\"7633\",\"RAMAN MOHAN \",63,\"PA\",\"Pulmonologists\",\"YES\",1861495988); ";
        String s5="INSERT INTO PATIENT VALUES (576832,\"5532\",\"PRATEEK\",25,\"PA\",\"Neurologists\",\"NO\",1134122161); ";

        try{
            db.execSQL( s5 );
            Log.d("database","successfully inserted in database");

        }catch (Exception e)
        {
            Log.d("database","we got some error"+e);
        }


    }
    void read_database_disease()
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String s1="INSERT INTO DISEASE VALUES(32849,1154324366,576829,\"NA\",\"NA\",\"NA\",0,\"NA\");";
        String s2="INSERT INTO DISEASE VALUES(32850,1720081854,576830,\"NA\",\"NA\",\"NA\",0,\"NA\");";
        String s3="INSERT INTO DISEASE VALUES(32851,1861495988,576831,\"NA\",\"NA\",\"NA\",0,\"NA\");";
        String s4="INSERT INTO DISEASE VALUES(32852,1134122161,576832,\"NA\",\"NA\",\"NA\",0,\"NA\");";
        try {
            sqLiteDatabase.execSQL( s2 );
            sqLiteDatabase.execSQL( s3 );
            sqLiteDatabase.execSQL( s4 );
            Log.d("database","succesffuly inserted in disease database");
        }
        catch (Exception e)
        {
            Log.d("database"," "+e);
        }

    }





    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
