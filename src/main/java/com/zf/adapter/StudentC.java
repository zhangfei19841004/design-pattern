package com.zf.adapter;

/**
 * Created by zhangfei on 2017/9/27/027.
 */
public class StudentC extends ClassmateLeader{

    @Override
    public void sweep() {
        System.out.println("区域3打扫完毕");
    }

    @Override
    public void cleanFloor() {
        System.out.println("区域3拖地完毕");
    }
}
