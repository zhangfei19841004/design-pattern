package com.zf.simplefactory;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public class TestFactory {

    public static TestAbs getInstance(String flag){
        if("test".equals(flag)){
            return new Test();
        }else if("test1".equals(flag)){
            return new Test1();
        }
        return null;
    }

    public static void main(String[] args) {
        TestAbs t = TestFactory.getInstance("test1");
        t.test();
    }
}
