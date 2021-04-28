package com.example.my_camera_app2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView resultImage;
    Button captureBtn;
    private static final int RC_PIC_CODE=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        resultImage=(ImageView)findViewById(R.id.resultImage);
        captureBtn=(Button)findViewById(R.id.captureBtn);

        captureBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capture();
            }


        } );

    }
    private void capture() {
        Intent takepictureIntent=new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult( takepictureIntent,RC_PIC_CODE );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if(requestCode==RC_PIC_CODE)
        {
            if(resultCode==RESULT_OK)
            {
                Bitmap bp=(Bitmap) data.getExtras().get("data");
                resultImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                resultImage.setImageBitmap(bp);
            }
            else if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(this,"cancelled",Toast.LENGTH_LONG).show();
            }
        }

    }
}