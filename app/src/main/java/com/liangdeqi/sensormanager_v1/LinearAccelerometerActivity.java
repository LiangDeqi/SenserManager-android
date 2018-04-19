package com.liangdeqi.sensormanager_v1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LinearAccelerometerActivity extends BaseActivity implements SensorEventListener {

    private TextView mLinearAcceValue1;
    private TextView mLinearAcceValue2;
    private TextView mLinearAcceValue3;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_accelerometer);
        mLinearAcceValue1 = (TextView) findViewById(R.id.li_accelerometer_value1);
        mLinearAcceValue2 = (TextView) findViewById(R.id.li_accelerometer_value2);
        mLinearAcceValue3 = (TextView) findViewById(R.id.li_accelerometer_value3);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 为线性加速度传感器注册监听器
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION), SensorManager.SENSOR_DELAY_GAME);
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
        if(type == Sensor.TYPE_LINEAR_ACCELERATION){
           mLinearAcceValue1.setText(""+values[0]);
           mLinearAcceValue2.setText(""+values[1]);
           mLinearAcceValue3.setText(""+values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
