package com.example.devfest

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast


import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener

class ServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)


        tvShakeService = findViewById(R.id.title)

        Dexter.withActivity(this )
            .withPermission(Manifest.permission.CALL_PHONE)
            .withListener(object : PermissionListener {
                @SuppressLint("MissingPermission")
                override fun onPermissionGranted(response: PermissionGrantedResponse) {

                    val intent = Intent(this@ServiceActivity, ShakeService::class.java)
                    //Start Service
                    startService(intent)
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) {
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest,
                    token: PermissionToken
                ) {
                    Toast.makeText(
                        applicationContext,
                        "You need to grant me permission !",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }).check()
    }

    companion object {

        lateinit var tvShakeService: TextView
    }
}