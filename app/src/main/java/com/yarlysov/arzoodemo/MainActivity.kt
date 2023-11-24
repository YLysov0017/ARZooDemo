package com.yarlysov.arzoodemo

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.yarlysov.arzoodemo.databinding.ActivityMainBinding
import com.google.ar.core.ArCoreApk

val animals : Array<Animal> = arrayOf(Animal("CRT_Monitor", "228",
    modell="models/Monitor001.glb"))

class MainActivity : AppCompatActivity() {

    private lateinit var bindingClass : ActivityMainBinding
    private var message: String = ""
    lateinit var ids: Array<String>
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
        /*
        for (item in animals.indices){
            ids[item] = animals[item].getId()
            Log.d("Working_Log", ids.toString())
        Log.d("Working_Log", "Granted!")
        }
        bindingClass.bToScan.setOnClickListener {
            checkCameraPermission()
        }*/
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        Log.d("Working_Log", "Here!")
        /*
        message = intent.getStringExtra("QRCode").toString()
        Log.d("Working_Log", "Got QR Message!") */
        if (true) {
            val arintent = Intent(this, ARActivity::class.java)
            startActivity(arintent)

        }
        else {
            bindingClass.qrText.text = "Invalid code"
        }
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
                Log.d("Working_Log", "Got Permission!")
            }
        }


    }
}


