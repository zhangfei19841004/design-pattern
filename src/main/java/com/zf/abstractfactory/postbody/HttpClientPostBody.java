package com.zf.abstractfactory.postbody;

import com.zf.abstractfactory.abs.HttpFactoryAbs;
import com.zf.abstractfactory.abs.HttpPostBodyAbs;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public class HttpClientPostBody extends HttpPostBodyAbs {

    private String body;

    public HttpClientPostBody(HttpFactoryAbs factory) {
        super(factory);
    }

    @Override
    public String execute(String url) {
        factory.httpClientInitial();
        HttpPost httpPost = null;
        try {
            httpPost = new HttpPost(url);
            httpPost.setConfig(factory.getRequestConfig());
            httpPost.setEntity(new StringEntity(body));
            CloseableHttpResponse response = factory.getHttpClient().execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity,"utf-8");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(httpPost!=null){
                httpPost.releaseConnection();
            }
            factory.close();
        }
        return null;
    }

    @Override
    public <T> HttpPostBodyAbs setParams(T t) {
        body = (String) t;
        return this;
    }

}
