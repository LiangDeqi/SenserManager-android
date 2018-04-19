package com.liangdeqi.sensormanager_v1;

import org.litepal.crud.DataSupport;

public class SensorValues extends DataSupport{

    private int SensorType;
    private float Value1;
    private float Value2;
    private float Value3;

    public float getSensorType(){
        return SensorType;
    }
    public void setSensorType(int i){
        this.SensorType=i;
    }

    public float getValue1() {
        return Value1;
    }
    public void setValue1(float val){
        this.Value1=val;
    }

    public float getValue2(){
        return Value2;
    }
    public void setValue2(float val){
        this.Value2=val;
    }

    public float getValue3(){
        return Value3;
    }
    public void setValue3(float val){
        this.Value3=val;
    }

}
