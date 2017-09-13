package com.zf.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfei on 2017/9/13/013.
 */
public class Prototype implements Cloneable{

    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    protected Prototype clone() {
        try {
            Prototype prototype = (Prototype) super.clone();
            prototype.list = (List<String>) (((ArrayList<String>)this.list).clone());
            return prototype;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
