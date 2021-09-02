package com.supremehyo.animationpratice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun nextState(view: View) {
        when (motionlayout.currentState ) {
            R.id.state1 -> motionlayout.transitionToState(R.id.state2)
            R.id.state2 -> motionlayout.transitionToState(R.id.state3)
            R.id.state3 -> motionlayout.transitionToState(R.id.state4)
            R.id.state4 -> motionlayout.transitionToState(R.id.state5)
            R.id.state5 -> motionlayout.transitionToState(R.id.state1)
        }
    }
}