package com.liangdeqi.sensormanager_v1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerActivity extends BaseActivity implements SensorEventListener{

    private TextView mAccelerometerValue1;
    private TextView mAccelerometerValue2;
    private TextView mAccelerometerValue3;
    private  SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        mAccelerometerValue1 = (TextView) findViewById(R.id.accelerometer_value1);
        mAccelerometerValue2 = (TextView) findViewById(R.id.accelerometer_value2);
        mAccelerometerValue3 = (TextView) findViewById(R.id.accelerometer_value3);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 为加速度传感器注册监听器
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float [] values =  event.values;
        //获取传感器类型
        int type = event.sensor.getType();
        if(type == Sensor.TYPE_ACCELEROMETER){
            mAccelerometerValue1.setText(""+values[0]);
            mAccelerometerValue2.setText(""+values[1]);
            mAccelerometerValue3.setText(""+values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
