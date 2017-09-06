package com.zf.abstractfactory.abs;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public abstract class HttpPostFormAbs {

    protected HttpFactoryAbs factory;

    public HttpPostFormAbs(HttpFactoryAbs factory) {
        this.factory = factory;
    }

    public abstract String execute(String url);

    public abstract <T> HttpPostFormAbs setParams(T t);

}
