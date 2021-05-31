package com.example.prono_doctor_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

import static com.example.prono_doctor_app.static_data.fragment_4_data;

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
    String s4 ="CREATE TABLE SCHEDULE(SCHEDULE_ID INTEGER PRIMARY KEY," +
            "DAYS VARCHAR," +
            "START_TIME VARCHAR,END_TIME VARCHAR," +
            "DOCTOR_ID_3 INTEGER,PATIENT_ID_3 INTEGER," +
            "DISEASE_TYPE VARCHAR,DISEASE_ID_3 INTEGER";
    int write_in_schedule_table(int id,String days,String start_time,String end_time,int doc_id,String no_of_pat)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues cn=new ContentValues(  );
        cn.put( "SCHEDULE_ID",id );
        cn.put( "DAYS",days );
        cn.put( "START_TIME",start_time );
        cn.put( "END_TIME",end_time );
        cn.put( "DOCTOR_ID_3",doc_id );
        cn.put("PATIENT_ID_3",0);
        cn.put( "DISEASE_TYPE","NA" );
        cn.put( "DISEASE_ID_3",0 );
        String dd="";
        dd+=days.charAt( 0 );

        try{
            mydb.insertWithOnConflict( "SCHEDULE",null,cn,SQLiteDatabase.CONFLICT_REPLACE );
            schedule_id sched_id=new schedule_id( dd,start_time,end_time,Integer.parseInt( no_of_pat ),fragment_4_data,doc_id ) ;
            firebase_class fb=new firebase_class();
            int k44=fb.brodcast_schedule( id,sched_id );


            Log.d("database","successful write in schedule ");
            return 1;
        }
        catch (Exception e)
        {
            Log.d("database","failed to write in schedudle "+e);
            return 0;
        }
    }

    int write_in_disease_table(int id,String detail1,String details2,String details3,String details4,String patient_id)
    {
     //        String s3="CREATE TABLE DISEASE
        //        (DISEASE_ID INTEGER PRIMARY KEY, DOCTOR_ID_2 INTEGER,PATIENT_ID_2 INTEGER,
        //        DETAILS_1 VARCHAR,DETAILS_2 VARCHAR,DETAILS_3 VARCHAR,
        //        EMERGENCY INTEGER,REMARK VARCHAR
        int patient_id_;
        try{
            patient_id_=Integer.parseInt( patient_id );

        }catch (Exception e)
        {
            patient_id_=0;

        }
                SQLiteDatabase mydb=this.getWritableDatabase();
                ContentValues cn=new ContentValues(  );
                cn.put( "DISEASE_ID",id);
                cn.put( "DOCTOR_ID_2",0 );
                cn.put(  "PATIENT_ID_2",patient_id_);
                cn.put("EMERGENCY",Integer.parseInt( detail1 ));
                cn.put( "REMARK","NA" );
                cn.put( "DETAILS_1",details2 );
                cn.put( "DETAILS_2",details3 );
                cn.put( "DETAILS_3",details4 );
                try
                {
                    mydb.insertWithOnConflict( "disease",null,cn,SQLiteDatabase.CONFLICT_REPLACE );
                    disease_details did=new disease_details( detail1,details2,details3,details4 );
                    firebase_class fb=new firebase_class();
                    int kkt=fb.broadcast_disease(id, did );

                    Log.d("database","successfully inserted into database");
                    return 1;
                }
                catch (Exception e)
                {
                    Log.d("database","we got some error ");
                    return 0;
                }
    }

    int write_in_doctor_table(String s1,String s8,String s2,String s3,String s4,String s5,String s6,String s7,String s9,String s10)
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
        try {
            cn.put( "NO_OF_EXPERIENCE", Integer.parseInt( s5 ) );
        }catch (Exception e)
        {
            cn.put(  "NO_OF_EXPERIENCE",0);
        }
        cn.put("ADDRESS",s6);
        cn.put("MOBILE_NO",s7);
        cn.put( "PATIENT_ID_1",Integer.parseInt( s9 ) );
        cn.put("DISEASE_ID_1",Integer.parseInt( s10 ));



        try
        {
            sqLiteDatabase.insertWithOnConflict( "DOCTOR",null,cn,SQLiteDatabase.CONFLICT_REPLACE );
            doctor_details doc_details=new doctor_details( s8,s3,s6,s7,s4 );
            firebase_class fb=new firebase_class();
            int k33=fb.broadcast_doctor( doc_details,Integer.parseInt( s1 ) );
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
    int write_in_patient(String Name,String password,String  age,String city,String state,String mob)
    {
        //        String s2="CREATE TABLE PATIENT(PATIENT_ID INTEGER PRIMARY KEY,
        //        PASSWORD VARCHAR,NAME VARCHAR,AGE INTEGER,
        //        CITY VARCHAR,TYPE VARCHAR,HISTORY_OF_DISEASE
        //        VARCHAR,DOCTOR_ID_1 INTEGER,FOREIGN KEY(DOCTOR_ID_1) REFERENCES DOCTOR(DOCTOR_ID));";
        ContentValues cn=new ContentValues(  );
        Random random=new Random(  );
        int kk= random.nextInt(10000);
        cn.put( "PATIENT_ID",kk );
        cn.put( "PASSWORD",password );
        cn.put( "NAME",Name );
        cn.put( "AGE",Integer.parseInt( age ) );
        cn.put( "CITY",city );
        cn.put( "TYPE",mob );
        cn.put("HISTORY_OF_DISEASE",state);
        cn.put("DOCTOR_ID_1",0);
        try
        {
            SQLiteDatabase database=this.getWritableDatabase();
            database.insertWithOnConflict( "PATIENT",null,cn,SQLiteDatabase.CONFLICT_REPLACE );
            patient_details patientDetails=new patient_details( mob,Name,Integer.parseInt( age ),city,state );
            firebase_class fb=new firebase_class();
            int kk1=fb.broadcast_patient(mob, patientDetails );
            return 1;
        }
        catch (Exception e)
        {
            Log.d("database"," "+e);
            return  0;
        }


    }
    int verify_doctor_login(String s1,String s2)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ArrayList<String> arr= new ArrayList<>(  );
        try
        {
            Cursor r=db.rawQuery( "select * from doctor where DOCTOR_ID=? and password=?",new String[]{s1,s2} );
            if(r.moveToFirst())
            {
                do{
                    arr.add(Integer.toString( r.getInt( 0 ) ));
                }while(r.moveToNext());

            }
            Log.d("database","we got the arraysize of doctor "+arr.size());
            if(arr.size()>0)
                return 1;
            return 0;


        }
        catch (Exception e)
        {
            Log.d("database"," falied to verify ");
            return 0;
        }
    }
    int verify_patient_login(String s1,String s2)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ArrayList<String> arr=new ArrayList<>(  );
        try {

            Cursor r = db.rawQuery( "select * from patient where type=? and password=?", new String[]{s1, s2} );
            if(r.moveToFirst());
            {
                do{
                    arr.add(Integer.toString(r.getInt( 0 )));

                }while (r.moveToNext());
            }
            Log.d("database","we got array of size "+arr.size());
            if(arr.size()>0)
            return 1;
            return 0;
        }
        catch (Exception e)
        {
            Log.d("database","there are some error "+e);
            return  0;
        }
       // String  s="Select * from patient where type=? and password=? ",

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
