package com.liangdeqi.sensormanager_v1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AtLPActivity extends BaseActivity implements SensorEventListener {

    private TextView mAtLPValue1;
    private TextView mAtLPValue2;
    private TextView mAtLPValue3;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at_lp);
        mAtLPValue1 = (TextView) findViewById(R.id.at_l_p_value1);
        mAtLPValue2 = (TextView) findViewById(R.id.at_l_p_value2);
        mAtLPValue3 = (TextView) findViewById(R.id.at_l_p_value3);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 为加速度传感器注册监听器
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE), SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float [] values = event.values;
        int type = event.sensor.getType();
        switch (type){
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                mAtLPValue1.setText(""+values[0]);
                break;
            case Sensor.TYPE_LIGHT:
                mAtLPValue2.setText(""+values[0]);
                break;
            case Sensor.TYPE_PRESSURE:
                mAtLPValue3.setText(""+values[0]);
              default:
                  break;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
