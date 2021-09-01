package com.supremehyo.animationpratice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        motionLayout.setOnClickListener {
            Log.v("sdfsdf" ,"ssssssssssss")
            motionLayout2.velocity
            motionLayout2.transitionToEnd()
           // motionLayout2.transitionToStart()
        }
    }
}