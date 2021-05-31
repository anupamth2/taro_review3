package com.example.prono_doctor_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.prono_doctor_app.static_data.fragment_2_data;
import static com.example.prono_doctor_app.static_data.patient_id_for_problem_details;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link problem_details_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class problem_details_2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public problem_details_2() {
        // Required empty public constructor


    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment problem_details_2.
     */
    // TODO: Rename and change types and number of parameters
    public static problem_details_2 newInstance(String param1, String param2) {
        problem_details_2 fragment = new problem_details_2();
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
       // static_data st=new static_data();
      //  EditText ed=(EditText)getView().findViewById( R.id.edit1 );
        View view=inflater.inflate( R.layout.fragment_problem_details_2, container, false );
        final EditText ed=(EditText)view.findViewById( R.id.edit1 );
        Button b14=view.findViewById( R.id.button14 );
        b14.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=ed.getText().toString();
                if(s.equals( "Enter here" ))
                {
                    Toast.makeText( getContext(),"enter valid details ",Toast.LENGTH_SHORT ).show();
                    return;
                }
                else
                {
                    fragment_2_data=s;
                    Intent in=new Intent( getContext(),problem_details_page.class );
                    in.putExtra( "destination",4 );
                    in.putExtra( "patient_id",patient_id_for_problem_details );
                    startActivity( in );
                }
            }
        } );


       // ed.setText( s1 );
        return view;
    }
}