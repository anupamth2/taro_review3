package com.example.cameraxapp4

import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.camera.core.Camera
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    var preview: Preview?=null
    var imageCapture: ImageCapture?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)==PERMISSION_GRANTED)
        {
            startCamera()

        }
        else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA,0))


        }
        captureBtn.setOnClickListener{
           // takephoto()
        }
    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)==PERMISSION_GRANTED)
        {
          startCamera()
        }
        else{
            Toast.makeText(this,"please accept permissiion",Toast.LENGTH_LONG).show()



        }
    }

    private fun startCamera() {
        //TODO("Not yet implemented")
        val cameraProviderFuture=ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener(Runnable {
            val cameraProvider=cameraProviderFuture.get()
            //val cameraProvider=cameraProviderFuture
            preview=Preview.Builder().build()

            //preview?.setSurfaceProvider(cameraView.createSurfaceProvider(camera?.cameraInfo))
            preview?.setSurfaceProvider(cameraView.createSurfaceProvider(camera.cameraInfo))
            imageCapture=ImageCapture.Builder().build()



            camera=cameraProvider.bindToLifecycle()
        },ContextCompat.getMainExecutor(this))

    }
    private fun takephoto() {
        TODO("Not yet implemented")
    }


}

private fun PreviewView.createSurfaceProvider(cameraInfo: Any): Preview.SurfaceProvider {
    return  camera?.camerainfo

}
