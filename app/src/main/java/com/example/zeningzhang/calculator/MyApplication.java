package com.example.zeningzhang.calculator;

import android.app.Application;

import java.lang.ref.WeakReference;

/**
 * Created by ZeningZhang on 6/29/16.
 */
public class MyApplication extends Application{

    public Double d;

    public void setMyPublicData(Double data){
        this.d = data;
    }

    public Double getMyPublicData(){
        return d;
    }
}