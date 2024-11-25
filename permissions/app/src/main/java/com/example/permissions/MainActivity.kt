package com.example.permissions

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    val c=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var btn=findViewById<Button>(R.id.btn)
        var imv=findViewById<ImageView>(R.id.imv)
        btn.setOnClickListener{
            if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),c)
                Toast.makeText(this,"Camera Permission Denied",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Camera Permission Granted",Toast.LENGTH_LONG).show()
                var i=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(i)
            }
        }
    }
    override fun onRequestPermissionsResult(requestCode:Int,permissions:Array<out String>,grantResults:IntArray){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults)
        if(requestCode==c){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Camera Permission Granted",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Camera Permission Denied",Toast.LENGTH_LONG).show()
            }
        }
    }

}