package com.liangdeqi.sensormanager_v1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GyroscopeActivity extends BaseActivity implements SensorEventListener {

    private TextView mGyroscopeValue1;
    private TextView mGyroscopeValue2;
    private TextView mGyroscopeValue3;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        mGyroscopeValue1 = (TextView) findViewById(R.id.gyroscope_value1);
        mGyroscopeValue2 = (TextView) findViewById(R.id.gyroscope_value2);
        mGyroscopeValue3 = (TextView) findViewById(R.id.gyroscope_value3);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 为加速度传感器注册监听器
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onStop(){
        super.onStop();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float [] values =  event.values;
        //获取传感器类型
        int type = event.sensor.getType();
        if(type == Sensor.TYPE_GYROSCOPE){
            mGyroscopeValue1.setText(""+values[0]);
            mGyroscopeValue2.setText(""+values[1]);
            mGyroscopeValue3.setText(""+values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
