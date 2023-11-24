package com.yarlysov.arzoodemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView

class ScannerActivity : AppCompatActivity(), ZBarScannerView.ResultHandler {
    private lateinit var zbView: ZBarScannerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Scanner_Log", "Scanner Works!")

        zbView = ZBarScannerView(this)
        setContentView(zbView)


    }

    override fun handleResult(result: Result?) {
        Log.d("Scanner_Log", "Got Result!:${result?.contents}")

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("QRCode", result?.contents)
        startActivity(intent)
    }



    override fun onResume() {
        super.onResume()
        zbView.setResultHandler(this)
        zbView.startCamera()
    }

    override fun onPause() {
        super.onPause()
        zbView.stopCamera()
    }
}