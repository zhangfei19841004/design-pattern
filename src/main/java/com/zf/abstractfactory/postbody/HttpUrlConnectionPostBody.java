package com.zf.abstractfactory.postbody;

import com.zf.abstractfactory.abs.HttpFactoryAbs;
import com.zf.abstractfactory.abs.HttpPostBodyAbs;

import java.io.*;
import java.net.MalformedURLException;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public class HttpUrlConnectionPostBody extends HttpPostBodyAbs {

    private String body;

    public HttpUrlConnectionPostBody(HttpFactoryAbs factory) {
        super(factory);
    }

    @Override
    public String execute(String url) {
        factory.httpUrlConnectionInitial(url, "POST");
        BufferedWriter rw = null ;
        BufferedReader rd = null ;
        StringBuilder sb = new StringBuilder ();
        String line;
        String response = null;
        try {
            rw = new BufferedWriter(new OutputStreamWriter(factory.getHttpUrlConnection().getOutputStream(), "UTF-8"));
            rw.write(body);
            rw.flush();
            rd  = new BufferedReader( new InputStreamReader(factory.getHttpUrlConnection().getInputStream(), "UTF-8"));
            while ((line = rd.readLine()) != null ) {
                sb.append(line);
            }
            response = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rw != null){
                    rw.close();
                }
                if(rd != null){
                    rd.close();
                }
                factory.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    @Override
    public <T> HttpPostBodyAbs setParams(T t) {
        body = (String) t;
        return this;
    }

}
