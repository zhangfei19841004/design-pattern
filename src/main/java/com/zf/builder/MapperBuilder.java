package com.zf.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangfei on 2017/9/6/006.
 */
public class MapperBuilder {

    public static <K, V> Builder<K, V> getBuilder(){
        return new Builder<K, V>();
    }

    public static class Builder<K, V>{

        public Map<K, V> map;

        private Builder(){
            map = new HashMap<K, V>();
        }

        public Builder<K, V> put(K k, V v){
            map.put(k, v);
            return this;
        }

        public Map<K, V> build(){
            return map;
        }

    }

    public static void main(String[] args) {
        Map<String, String> map = MapperBuilder.<String, String>getBuilder().put("a", "a").put("b", "b").build();
        System.out.println(map);

        Map<Integer, Integer> map1 = MapperBuilder.<Integer, Integer>getBuilder().put(1, 1).put(2, 2).build();
        System.out.println(map1);
        StringBuilder sb = new StringBuilder();
        sb.append("a").append("b").append("c").append("d");

    }

}
