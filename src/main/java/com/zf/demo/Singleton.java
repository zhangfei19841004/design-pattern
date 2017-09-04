package com.zf.demo;

/**
 * Created by zhangfei on 2017/8/11/011.
 */
public class Singleton {

    /*//懒汉式
    private static Singleton instance;

    private Singleton(){

    }

    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    //饿汉式
    private static Singleton instance = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return instance;
    }*/

    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton(){

    }

    public static Singleton getInstance(){
        return Singleton.instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }

}


