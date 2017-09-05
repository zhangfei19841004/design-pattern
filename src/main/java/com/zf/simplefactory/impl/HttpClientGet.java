package com.zf.simplefactory.impl;

import com.zf.simplefactory.HttpClientAbs;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public class HttpClientGet extends HttpClientAbs {

    @Override
    public String execute(String url) {
        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity,"utf-8");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(httpGet!=null){
                httpGet.releaseConnection();
            }
            this.close();
        }
        return null;
    }

    @Override
    public <T> HttpClientAbs setParams(T t) {
        return null;
    }

}
