package com.example.prono_doctor_app;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class firebase_class_next {
    DatabaseReference my_db=FirebaseDatabase.getInstance().getReference();
    public void get_pateint_list(int doctor_id)
    {

        try{
            my_db.child( "probono_database" ).child( "Appointment_doctor" ).child( "4433" ).get().addOnCompleteListener( new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    ArrayList<String> arr = new ArrayList<>(  );
                    for(DataSnapshot dt:task.getResult().getChildren())
                    {
                        arr.add(dt.getKey());
                        Log.d("my_log"," the value "+dt.getKey());

                    }
                    get_complete_details(arr);
                }
            } );
        }
        catch (Exception e)
        {
            Log.d("my_log","the error "+e);
        }

    }
    public void get_complete_details(ArrayList<String > arr)
    {
        for(int i=0;i<arr.size();i++)
        {
            String ind=arr.get( i );
            my_db.child("probono_database"  ).child( "Appointment" ).child( ind ).child( "disease_id" ).get().addOnCompleteListener( new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    Log.d("my_log"," the disease_id "+task.getResult().getValue().toString());
                    //get_disease_details(task.getResult().getValue().toString());
                    get_disease_details( "54" );
                    get_patient_details( "44333" );
                    get_doctor_details( "34343" );
                    get_schedule_details( "4444" );


                }
            } );

        }
    }
    public void get_disease_details(String disease_id)
    {
        my_db.child( "probono_database" ).child( "disease_details" ).child( "54" ).get().addOnCompleteListener( new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                disease_details disease_1=task.getResult().getValue(disease_details.class);
                Log.d("my_log"," the id "+disease_1.details2);
            }
        } );
    }
    public void get_patient_details(String patient_id)
    {
        my_db.child( "probono_database" ).child( "patient_details" ).child( "54321" ).get().addOnCompleteListener( new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                patient_details pat_det=task.getResult().getValue(patient_details.class);
                Log.d("my_log","the patient "+pat_det.state);
            }
        } );
    }
    public  void get_doctor_details(String doctor_id)
    {
        my_db.child( "probono_database" ).child( "doctor_details" ).child( "555" ).get().addOnCompleteListener( new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                doctor_details pat_det=task.getResult().getValue(doctor_details.class);
                Log.d("my_log","the doctor "+pat_det.mob_no);

            }
        } );
    }
    public void get_schedule_details(String schedule_id)
    {
        my_db.child( "probono_database" ).child( "schedule_details" ).child( "2905" ).get().addOnCompleteListener( new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                schedule_id pat_det=task.getResult().getValue(schedule_id.class);
                Log.d("my_log","the schedule "+pat_det.end_time);

            }
        } );
    }


}
