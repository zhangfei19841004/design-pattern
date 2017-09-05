package com.zf.simplefactory.impl;

import com.zf.simplefactory.HttpClientAbs;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public class HttpClientPostForm extends HttpClientAbs {

    private Map<String, String> params;

    @Override
    public String execute(String url) {
        HttpPost httpPost = null;
        try {
            httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            List<NameValuePair> ps = new ArrayList<NameValuePair>();
            for (String pKey : params.keySet()) {
                ps.add(new BasicNameValuePair(pKey, params.get(pKey)));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(ps));
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
        params = (Map<String, String>) t;
        return this;
    }

}
