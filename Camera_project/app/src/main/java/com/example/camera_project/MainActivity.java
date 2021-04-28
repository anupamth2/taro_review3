package com.example.camera_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Camera c1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        c1=null;
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        if(checkCameraHardware( this ))
        {
            //Toast.makeText( this,"this device has camera",Toast.LENGTH_LONG ).show();
            c1=getCameraInstance();
            if(c1==null)
            Toast.makeText( this,"we have get instance of camera camera",Toast.LENGTH_LONG ).show();


        }
        else
        {
            return;
        }

    }
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature( PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }
    public static Camera2 getCameraInstance(){
        Camera2 c = null;
        try {
            //Toast.makeText( this,"this device has camera",Toast.LENGTH_LONG ).show();
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
}