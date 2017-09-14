package com.zf.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfei on 2017/9/13/013.
 */
public class Person extends Prototype {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Person pi = new Person();
        pi.setName("zhaosi");
        List<String> list = new ArrayList<String>();
        list.add("a");
        pi.setList(list);
        "a".hashCode();
        System.out.println(pi.hashCode());
        System.out.println(pi.getList().hashCode());
        Person pic = (Person) pi.clone();
        System.out.println(pic.getName());
        System.out.println(pic.hashCode());
        System.out.println(pic.getList().hashCode());
        System.out.println(pi.getList()==pic.getList());
    }

}
