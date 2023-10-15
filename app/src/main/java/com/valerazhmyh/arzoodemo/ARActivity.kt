package com.valerazhmyh.arzoodemo

import android.opengl.GLSurfaceView
import android.opengl.GLSurfaceView.Renderer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.valerazhmyh.arzoodemo.databinding.ActivityAractivityBinding
import com.google.ar.core.Config
import com.google.ar.core.Plane
import com.google.ar.core.Session
import com.valerazhmyh.arzoodemo.java.common.helpers.TapHelper

class ARActivity : AppCompatActivity() {

    private lateinit var bindingClass : ActivityAractivityBinding
    lateinit var session: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityAractivityBinding.inflate(layoutInflater)
        session = Session(this)
        setContentView(bindingClass.root)
        val config = Config(session)
        session.configure(config)
        var plane: Plane
    }
/*
    override fun onResume() {
        super.onResume()
        val th : TapHelper = TapHelper(this)
        val tap = th.poll() ?: return
        val hitResultList =
            if (usingInstantPlacement) {
                // When using Instant Placement, the value in APPROXIMATE_DISTANCE_METERS will determine
                // how far away the anchor will be placed, relative to the camera's view.
                frame.hitTestInstantPlacement(tap.x, tap.y, APPROXIMATE_DISTANCE_METERS)
                // Hit-test results using Instant Placement will only have one result of type
                // InstantPlacementResult.
            } else {
                frame.hitTest(tap)
            }
    }*/
    override fun onDestroy() {
        super.onDestroy()
        session.close()
    }
}