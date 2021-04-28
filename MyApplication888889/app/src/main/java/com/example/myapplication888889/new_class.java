package com.example.myapplication888889;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;

public class new_class extends MainActivity{
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    ListView l1;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    HashMap<String,String> hash=new HashMap(  );
    ArrayList<String> cars = new ArrayList<String>();
    int index=8;
    final ArrayList<String> cars1 = new ArrayList<String>();
    final ArrayList<String> cars2 = new ArrayList<String>();
    final ArrayList<String> car3 = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.new_class_xml );





        String s1="40000";
        DocumentReference docRef = db.collection("QUIZ_DATABASE").document(s1);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        //Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        String s=document.getData().toString();

                        //Toast.makeText( getApplicationContext(),"we have download text ",Toast.LENGTH_LONG ).show();
                        //  TextView t1=findViewById( R.id.textView8 );
                        //  t1.setText( s );
                        int i,j,k;
                        String sk="";
                        for(i=0;i<s.length();i++)
                        {
                            if(s.charAt( i )=='/')
                            {
                                cars.add( sk );
                                sk="";
                            }
                            else
                                sk=sk+s.charAt( i );


                        }
                        for(i=0;i<9;i++)
                        {
                            cars2.add(cars.get( i ));


                        }
                        //Toast.makeText( getApplicationContext(),cars2.get( 8 )+" ",Toast.LENGTH_LONG ).show();







                    } else {
                        //Log.d(TAG, "No such document");
                        //Intent in54=new Intent( getApplicationContext(),student_class.class );
                        Toast.makeText(getApplicationContext(),"no such quiz no exist",Toast.LENGTH_LONG).show();
                        //startActivity( in54 );
                    }
                } else {
                    //Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        String arr[] = new String[40];
        try {



            int kke = 0;
            for (kke = 0; kke < cars2.size(); kke++) {
                arr[kke] = (String) cars2.get( kke );
            }
            Toast.makeText( getApplicationContext(), "go tpo e;; e ", Toast.LENGTH_LONG ).show();
        }
        catch (Exception e)
        {
            Toast.makeText( getApplicationContext(),"we have found error",Toast.LENGTH_LONG ).show();
        }
        String fes[]=cars2.toArray(new String[cars2.size()]);

        fune();
































    }

    public void fune() {

        RecyclerView recl = (RecyclerView) findViewById( R.id.rclview );
        recl.setLayoutManager( new LinearLayoutManager( this ) );

        String arr1[] = {"1.keep the app to cover best view", "2.start recording  before exam", "3.the recording should be same length of quiz time ", "4.In five minute send the video to faculty", "5.Try to maintain good internet"};


        recl.setAdapter( new myadapter(arr1) );
        Toast.makeText( this,"we have readcjed he ",Toast.LENGTH_LONG ).show();
        Toast.makeText( this,"ee eew ew ",Toast.LENGTH_LONG ).show();
    }


}
