package com.valerazhmyh.arzoodemo

import android.opengl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class MainRenderer : android.opengl.GLSurfaceView.Renderer {

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        println("Surface created")
        //здесь нужно выполнить инициализацию контекста
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        println("Surface changed")
        //здесь можно обновить контекст (например, размеры сцены)
    }

    override fun onDrawFrame(gl: GL10?) {
        println("Draw frame")
        val frame = session.update()
        //... логика отрисовки
    }
}