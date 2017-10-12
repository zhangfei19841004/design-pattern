package com.zf.decorator;

/**
 * Created by zhangfei on 2017/10/12/012.
 */
public class Student {

    public void learn(){
        Book math = new PackagingBook(new MathBook());
        math.read();
        Book english = new PackagingBook(new EnglishBook());
        english.read();
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.learn();
    }

}
