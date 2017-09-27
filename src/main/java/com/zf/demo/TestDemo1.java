package com.zf.demo;

/**
 * Created by zhangfei on 2017/8/21/021.
 */
public class TestDemo1 {

    public void sort(int v) {
        int[] vs = new int[v];
        int cm = -1;
        int cIndex = -1;
        for (int i = v; i > 0; i--) {
            if (i / 10 == cm && cIndex - 1 >= 0 && vs[cIndex - 1] == 0) {
                vs[cIndex - 1] = i;
                cIndex--;
                continue;
            }
            cIndex = this.getIndex(i, v);
            cm = i / 10;
            vs[cIndex] = i;
        }
        //结果输出
        for (int i : vs) {
            System.out.println(i);
        }
    }

    public int getIndex(int value, int v) {
        if (value < 10) {
            if (value * 10 <= v) {
                return (value * 10 / 10 - 1) * 11 + value * 10 % 10;
            }
            return (v / 10 - 1) * 11 + v % 10 + 1 + value - v / 10;
        }
        return (value / 10 - 1) * 11 + value % 10 + 1;
    }

    public static void main(String[] args) {
        TestDemo1 t = new TestDemo1();
        long t1 = System.nanoTime();
        t.sort(19);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
    }

}
