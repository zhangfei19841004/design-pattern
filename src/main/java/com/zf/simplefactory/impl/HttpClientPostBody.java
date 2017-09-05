package com.zf.simplefactory.impl;

import com.zf.simplefactory.HttpClientAbs;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public class HttpClientPostBody extends HttpClientAbs {

    private String body;

    @Override
    public String execute(String url) {
        HttpPost httpPost = null;
        try {
            httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            httpPost.setEntity(new StringEntity(body));
            CloseableHttpResponse response = httpClient.execute(httpPost);
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
            this.close();
        }
        return null;
    }

    @Override
    public <T> HttpClientAbs setParams(T t) {
        body = (String) t;
        return this;
    }

}
