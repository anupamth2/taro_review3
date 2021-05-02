package com.example.prono_doctor_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static com.example.prono_doctor_app.static_data.fragment_1_data;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link problem_details_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class problem_details_1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public problem_details_1(int k) {
        // Required empty public constructor
        Log.d("tablegggggggg","it my data "+k);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment problem_details_1.
     */
    // TODO: Rename and change types and number of parameters
    public static problem_details_1 newInstance(String param1, String param2) {
        problem_details_1 fragment = new problem_details_1(45);
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
        View view= inflater.inflate( R.layout.fragment_problem_details_1, container, false );
        String s=fragment_1_data;
        final EditText ed=view.findViewById( R.id.editTextTextMultiLine2 );
        Button button= view.findViewById( R.id.button13 );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String ss=ed.getText().toString();
             fragment_1_data=ss;
             Log.d("tablefffffff"," F "+fragment_1_data);

            }
        } );
        return  view;
    }
}