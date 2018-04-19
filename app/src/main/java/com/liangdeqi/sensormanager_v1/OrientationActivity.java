package com.liangdeqi.sensormanager_v1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OrientationActivity extends BaseActivity implements SensorEventListener {

    private TextView mOrientationValue1;
    private TextView mOrientationValue2;
    private TextView mOrientationValue3;
    private SensorManager mSensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);
        mOrientationValue1 = (TextView) findViewById(R.id.orientation_value1);
        mOrientationValue2 = (TextView) findViewById(R.id.orientation_value2);
        mOrientationValue3 = (TextView) findViewById(R.id.orientation_value3);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume(){
        super.onResume();
        // 为方向传感器注册监听器
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_GAME);
    }
    @Override
    protected void onStop(){
        super.onStop();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {

        float [] values = event.values;
        int type = event.sensor.getType();
        if(type == Sensor.TYPE_ORIENTATION){
            mOrientationValue1.setText(""+values[0]);
            mOrientationValue2.setText(""+values[1]);
            mOrientationValue3.setText(""+values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }
}
