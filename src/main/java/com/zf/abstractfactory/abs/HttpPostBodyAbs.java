package com.zf.abstractfactory.abs;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public abstract class HttpPostBodyAbs {

    protected HttpFactoryAbs factory;

    public HttpPostBodyAbs(HttpFactoryAbs factory) {
        this.factory = factory;
    }

    public abstract String execute(String url);

    public abstract <T> HttpPostBodyAbs setParams(T t);

}
