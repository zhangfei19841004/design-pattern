package com.zf.abstractfactory.postform;

import com.zf.abstractfactory.abs.HttpFactoryAbs;
import com.zf.abstractfactory.abs.HttpPostFormAbs;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public class HttpClientPostForm extends HttpPostFormAbs {

    private Map<String, String> params;

    public HttpClientPostForm(HttpFactoryAbs factory) {
        super(factory);
    }

    @Override
    public String execute(String url) {
        factory.httpClientInitial();
        HttpPost httpPost = null;
        try {
            httpPost = new HttpPost(url);
            httpPost.setConfig(factory.getRequestConfig());
            List<NameValuePair> ps = new ArrayList<NameValuePair>();
            for (String pKey : params.keySet()) {
                ps.add(new BasicNameValuePair(pKey, params.get(pKey)));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(ps));
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
    public <T> HttpPostFormAbs setParams(T t) {
        params = (Map<String, String>) t;
        return this;
    }

}
