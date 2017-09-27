package com.zf.adapter;

/**
 * Created by zhangfei on 2017/9/27/027.
 */
public class TeacherCheck {

    public static void main(String[] args) {
        CleanClassRoom a = new StudentA();
        CleanClassRoom b = new StudentB();
        CleanClassRoom c = new StudentC();
        a.sweep();
        a.cleanFloor();
        b.sweep();
        b.cleanFloor();
        c.sweep();
        c.cleanFloor();
        a.cleanBlackboard();
    }

}
