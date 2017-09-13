package com.zf.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangfei on 2017/8/21/021.
 */
public class TestDemo1 {

    public void test(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("a","a");
        map.put("b","b");
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list.add(map);
        map = null;
        System.out.println(list);
        System.out.println(map);
    }

    public static void main(String[] args) {
        new TestDemo1().test();
    }

}
