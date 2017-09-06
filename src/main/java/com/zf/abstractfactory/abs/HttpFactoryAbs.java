package com.zf.abstractfactory.abs;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by zhangfei on 2017/9/6/006.
 */
public abstract class HttpFactoryAbs {

    private CloseableHttpClient httpClient;

    private RequestConfig requestConfig;

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public RequestConfig getRequestConfig() {
        return requestConfig;
    }

    public void httpClientInitial(){
        httpClient = HttpClients.createDefault();
        requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
    }

    public void close() {
        try {
            if (httpClient != null) {
                httpClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HttpURLConnection conn;

    public HttpURLConnection getHttpUrlConnection() {
        return conn;
    }

    public void httpUrlConnectionInitial(String url, String method){
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod(method);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setReadTimeout(20000);
            conn.setConnectTimeout(20000);
            conn.setUseCaches(false);
            conn.connect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        if(conn != null){
            conn.disconnect();
        }
    }

    public abstract HttpGetAbs createHttpGet();

    public abstract HttpPostFormAbs createHttpPostForm();

    public abstract HttpPostBodyAbs createHttpPostBody();
}
