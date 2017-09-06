package com.zf.abstractfactory.abs;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public abstract class HttpGetAbs {

    protected HttpFactoryAbs factory;

    public HttpGetAbs(HttpFactoryAbs factory) {
        this.factory = factory;
    }

    public abstract String execute(String url);

}
