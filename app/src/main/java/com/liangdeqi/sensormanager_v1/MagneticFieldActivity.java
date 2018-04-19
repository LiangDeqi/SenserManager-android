package com.liangdeqi.sensormanager_v1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MagneticFieldActivity extends AppCompatActivity implements SensorEventListener{

    private TextView mMagneticFieldValue1;
    private TextView mMagneticFieldValue2;
    private TextView mMagneticFieldValue3;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnetic);
        mMagneticFieldValue1 = (TextView) findViewById(R.id.magnetic_field_value1);
        mMagneticFieldValue2 = (TextView) findViewById(R.id.magnetic_field_value2);
       mMagneticFieldValue3 = (TextView) findViewById(R.id.magnetic_field_value3);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }
    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_GAME);
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
        if(type == Sensor.TYPE_MAGNETIC_FIELD){
           mMagneticFieldValue1.setText(""+values[0]);
           mMagneticFieldValue2.setText(""+values[1]);
           mMagneticFieldValue3.setText(""+values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
