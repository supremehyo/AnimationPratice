package com.supremehyo.animationpratice

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Half.EPSILON
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() , SensorEventListener {

    var accelXValue =0
    var accelYValue =0
    var  accelZValue =0

    var gyroX =0
    var gyroY =0
    var gyroZ =0

    lateinit var mSensorManager : SensorManager
    lateinit var mGyroscope : Sensor
    lateinit var  accSensor : Sensor




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

                //센서 매니저 얻기
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        //자이로스코프 센서(회전)
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        //엑셀러로미터 센서(가속)
        accSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);



    }

    //센서값 얻어오기
    override fun onSensorChanged(event : SensorEvent) {
        var sensor : Sensor = event.sensor

        if (sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            gyroX = Math.round(event.values[0] * 1000);
            gyroY = Math.round(event.values[1] * 1000);
            gyroZ = Math.round(event.values[2] * 1000);
            Log.v("sdfdddsdf","gyroX ="+gyroX + "    gyroY ="+gyroY + "    gyroZ ="+gyroZ)
        }
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            accelXValue = event.values[0].toInt();
        accelYValue =  event.values[1].toInt()
        accelZValue =  event.values[2].toInt()
        Log.v("sdfsdf" ,"accelXValue="+accelXValue+ "   accelYValue="+accelYValue + "    accelZValue="+accelZValue)
    }




    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    //리스너 등록
    override fun  onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mGyroscope,SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, accSensor,SensorManager.SENSOR_DELAY_FASTEST);
    }

    //리스너 해제
    override fun onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
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