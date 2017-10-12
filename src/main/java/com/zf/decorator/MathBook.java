package com.zf.decorator;

/**
 * Created by zhangfei on 2017/10/12/012.
 */
public class MathBook implements Book {

    @Override
    public void read() {
        System.out.println("开始学习数学!");
    }
}
