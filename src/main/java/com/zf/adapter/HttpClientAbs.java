package com.zf.adapter;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public abstract class HttpClientAbs implements HttpClient{

    protected CloseableHttpClient httpClient;

    protected RequestConfig requestConfig;

    public void close() {
        try {
            if (httpClient != null) {
                httpClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HttpClientAbs() {
        httpClient = HttpClients.createDefault();
        requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
    }

}
