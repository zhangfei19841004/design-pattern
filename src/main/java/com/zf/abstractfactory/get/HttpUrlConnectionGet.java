package com.zf.abstractfactory.get;

import com.zf.abstractfactory.abs.HttpFactoryAbs;
import com.zf.abstractfactory.abs.HttpGetAbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public class HttpUrlConnectionGet extends HttpGetAbs {

    public HttpUrlConnectionGet(HttpFactoryAbs factory) {
        super(factory);
    }

    @Override
    public String execute(String url) {
        factory.httpUrlConnectionInitial(url, "GET");
        BufferedReader rd = null ;
        StringBuilder sb = new StringBuilder ();
        String line;
        String response;
        try {
            rd  = new BufferedReader( new InputStreamReader(factory.getHttpUrlConnection().getInputStream(), "UTF-8"));
            while ((line = rd.readLine()) != null ) {
                sb.append(line);
            }
            response = sb.toString();
            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rd != null){
                    rd.close();
                }
                factory.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
