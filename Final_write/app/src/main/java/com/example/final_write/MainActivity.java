package com.example.final_write;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    String s1="hey my name is anupam do you want to contact me ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Button saveButton;
        saveButton=findViewById(R.id.main);
        saveButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                createAndSaveFile();
                return_binary11();
            }


        });
    }


    private void createAndSaveFile(){
        Intent intent=new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TITLE,"testFile.txt");
        startActivityForResult(intent,1);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == 1){
            if(resultCode==RESULT_OK){

                try{
                    Uri uri=data.getData();
                    OutputStream outputstream=getContentResolver().openOutputStream(uri);
                    outputstream.write(s1.getBytes());
                    outputstream.close();
                } catch(IOException e){
                    System.out.println( "there is some errroe" );

                }


            }

        }
    }
    protected void return_binary11()
    {
        String s1="hi";
        String s2="hi";
       s2=return_binary(s1);
        Toast.makeText( this,s2,Toast.LENGTH_LONG ).show();
       // System.out.println(s2);
        return;

    }
    protected String return_binary(String s1)
    {
        System.out.println(s1);
        int i,j,k;

        String s12="";
        System.out.println(" FF");
        System.out.println(return_binary_of_no(64));
        System.out.println("FDDE");
        for(i=0;i<s1.length();i++)
        {
            //int k1=s1[i];
            System.out.println(s1);
            String s22="";

            int k1=s1.charAt(i);
            s22=return_binary_of_no(k1);
            s12=s12+s22;
        }

        return s12;
    }
    protected  String return_binary_of_no(int n)
    {
        int m=n;
        int i;
        String s112="";
        while(m>0)
        {
            s112=s112+(m%2);
            m=m/2;

        }

        String s23="";
        for(i=s112.length()-1;i>=0;i--)
        {
            s23=s23+s112.charAt(i);
        }
        System.out.print(n+" ");
        System.out.println(s23);
        return s23;
    }




}
