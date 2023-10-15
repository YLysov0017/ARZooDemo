package com.valerazhmyh.arzoodemo

import android.opengl.GLSurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.valerazhmyh.arzoodemo.databinding.ActivityAractivityBinding
import com.google.ar.core.Config
import com.google.ar.core.Session

class ARActivity : AppCompatActivity() {

    private lateinit var bindingClass : ActivityAractivityBinding
    lateinit var session: Session


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityAractivityBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val config = Config(session)
        session.configure(config)
        bindingClass.surface.setRenderer(MainRenderer)
        surface.setRenderer(MainRenderer())
        surface.requestRender()

    }
    override fun onDestroy() {
        super.onDestroy()
        session.close()
    }
}