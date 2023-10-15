package com.valerazhmyh.arzoodemo

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.valerazhmyh.arzoodemo.databinding.ActivityMainBinding
import com.google.ar.core.ArCoreApk

class MainActivity : AppCompatActivity() {

    private lateinit var bindingClass : ActivityMainBinding
    private var defaultMessage: String = "There will be your QR"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val availability = ArCoreApk.getInstance().checkAvailability(this)
        if (!availability.isSupported) {
            when (ArCoreApk.getInstance().requestInstall(this, false)) {
                ArCoreApk.InstallStatus.INSTALLED -> println("Do some work")
                ArCoreApk.InstallStatus.INSTALL_REQUESTED ->  println("Just wait for user actions")
            }
        }
        bindingClass.bToScan.setOnClickListener() {
            checkCameraPermission()
        }
        bindingClass.qrText.text = defaultMessage
        Log.d("Pizda", "PASHEM")

    }

    override fun onResume() {
        super.onResume()
        val message = intent.getStringExtra("QRCode")
        bindingClass.qrText.text = message
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA), 10
            )
        } else {
            startActivity(Intent(this, ScannerActivity::class.java))
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 10) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
        }


    }
}


