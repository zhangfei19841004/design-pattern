package com.zf.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangfei on 2017/9/6/006.
 */
public class MapBuilder<K, V> {

    public Map<K, V> map;

    public MapBuilder() {
        map = new HashMap<K, V>();
    }

    public MapBuilder<K, V> put(K k, V v) {
        map.put(k, v);
        return this;
    }

    public V get(K k){
        return map.get(k);
    }

    public static void main(String[] args) {
        MapBuilder<String, String> builder = new MapBuilder<String, String>().put("a","1").put("b","2").put("c","3");
        System.out.println(builder.get("a"));
    }

}
