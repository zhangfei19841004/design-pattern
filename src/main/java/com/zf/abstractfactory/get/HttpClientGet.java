package com.zf.abstractfactory.get;

import com.zf.abstractfactory.abs.HttpFactoryAbs;
import com.zf.abstractfactory.abs.HttpGetAbs;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public class HttpClientGet extends HttpGetAbs {

    public HttpClientGet(HttpFactoryAbs factory) {
        super(factory);
    }

    @Override
    public String execute(String url) {
        factory.httpClientInitial();
        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(url);
            httpGet.setConfig(factory.getRequestConfig());
            CloseableHttpResponse response = factory.getHttpClient().execute(httpGet);
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
            factory.close();
        }
        return null;
    }

}
