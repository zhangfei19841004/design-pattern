package com.zf.decorator;

/**
 * Created by zhangfei on 2017/10/12/012.
 */
public class PackagingBook implements Book {

    private Book book;

    public PackagingBook(Book book) {
        this.book = book;
    }

    @Override
    public void read() {
        System.out.println("开始包装!");
        book.read();
        System.out.println("结束包装!");
    }
}
