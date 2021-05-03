package com.example.prono_doctor_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import static com.example.prono_doctor_app.static_data.fragment_1_data;
import static com.example.prono_doctor_app.static_data.fragment_2_data;
import static com.example.prono_doctor_app.static_data.fragment_3_data;
import static com.example.prono_doctor_app.static_data.fragment_4_data;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link problem_details_3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class problem_details_3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public problem_details_3() {
        // Required empty public constructor

        Log.d("tableffffffff","my data"+fragment_1_data);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment problem_details_3.
     */
    // TODO: Rename and change types and number of parameters
    public static problem_details_3 newInstance(String param1, String param2) {
        problem_details_3 fragment = new problem_details_3();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate( R.layout.fragment_problem_details_3, container, false );
        Button b9=view.findViewById( R.id.button9 );
        final  EditText edd=view.findViewById( R.id.edit333 );
        b9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss=edd.getText().toString();
                fragment_3_data=ss;
                Toast.makeText( getContext(),"we reach here ",Toast.LENGTH_SHORT ).show();
                String s1=fragment_1_data;
                String s2=fragment_2_data;
                String s3=fragment_3_data;
                String s4=fragment_4_data;
                Random random=new Random(  );
                int id=random.nextInt(10000);
                my_database_class mydb=new my_database_class( getContext(),"ff",null,1 );
                int k=mydb.write_in_disease_table( id,fragment_4_data,fragment_1_data,fragment_2_data,fragment_3_data );
                if(k==1)
                {
                    Toast.makeText( getContext(),"successufully register in data base",Toast.LENGTH_SHORT ).show();

                }
                else
                    Toast.makeText( getContext(),"failed to write",Toast.LENGTH_SHORT ).show();


            }
        } );


        return view;
    }
}