package com.liangdeqi.sensormanager_v1;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn6;
    private Button mBtn7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //为九个按钮注册监听
        mBtn1 = (Button) findViewById(R.id.btn1);  mBtn1.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);  mBtn2.setOnClickListener(this);
        mBtn3 = (Button) findViewById(R.id.btn3);  mBtn3.setOnClickListener(this);
        mBtn4 = (Button) findViewById(R.id.btn4);  mBtn4.setOnClickListener(this);
        mBtn5 = (Button) findViewById(R.id.btn5);  mBtn5.setOnClickListener(this);
        mBtn6 = (Button) findViewById(R.id.btn6);  mBtn6.setOnClickListener(this);
        mBtn7 = (Button) findViewById(R.id.btn7);  mBtn7.setOnClickListener(this);

        Connector.getDatabase();
//        SensorValues sv = new SensorValues();
//        sv.setSensorType(0);
//        sv.setValue1(0);
//        sv.setValue2(0);
//        sv.setValue3(0);
        
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn1:
                Intent intent1 = new Intent(MainActivity.this,AccelerometerActivity.class);
                startActivity(intent1);
                SensorValues sv = new SensorValues();
                sv.setSensorType(0);
                sv.setValue1(0);
                sv.setValue2(0);
                sv.setValue3(0);
                break;
            case R.id.btn2:
                Intent intent2 = new Intent(MainActivity.this,OrientationActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn3:
                Intent intent3 = new Intent(MainActivity.this,GyroscopeActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn4:
                Intent intent4 = new Intent(MainActivity.this,MagneticFieldActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn5:
                Intent intent5 = new Intent(MainActivity.this,GravityActivity.class);
                startActivity(intent5);
                break;
            case R.id.btn6:
                Intent intent6 = new Intent(MainActivity.this,LinearAccelerometerActivity.class);
                startActivity(intent6);
                break;
            case R.id.btn7:
                Intent intent7 = new Intent(MainActivity.this,AtLPActivity.class);
                startActivity(intent7);
                break;

          default:
              break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        
    }
    @Override
    protected void onStop() {
        super.onStop();
      
    }

 


}
