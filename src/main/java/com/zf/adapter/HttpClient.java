package com.zf.adapter;

/**
 * Created by zhangfei on 2017/9/27/027.
 */
public interface HttpClient {

    <T> HttpClientAbs setParams(T t);

    String execute(String url);

    void close();

}
