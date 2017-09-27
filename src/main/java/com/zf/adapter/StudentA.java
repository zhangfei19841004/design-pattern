package com.zf.adapter;

/**
 * Created by zhangfei on 2017/9/27/027.
 */
public class StudentA extends ClassmateLeader{

    @Override
    public void cleanBlackboard() {
        System.out.println("黑板被A擦干净了");
    }

    @Override
    public void sweep() {
        System.out.println("区域1打扫完毕");
    }

    @Override
    public void cleanFloor() {
        System.out.println("区域1拖地完毕");
    }
}
