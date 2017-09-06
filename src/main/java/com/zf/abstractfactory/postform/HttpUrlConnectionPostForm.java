package com.zf.abstractfactory.postform;

import com.zf.abstractfactory.abs.HttpFactoryAbs;
import com.zf.abstractfactory.abs.HttpPostFormAbs;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Map;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public class HttpUrlConnectionPostForm extends HttpPostFormAbs {

    private Map<String, String> params;

    public HttpUrlConnectionPostForm(HttpFactoryAbs factory) {
        super(factory);
    }

    @Override
    public String execute(String url) {
        factory.httpUrlConnectionInitial(url, "POST");
        BufferedWriter rw = null ;
        BufferedReader rd = null ;
        StringBuilder out = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        String line;
        String response = null;
        for (String key : params.keySet()) {
            if(out.length()!=0){
                out.append("&");
            }
            out.append(key).append("=").append(params.get(key));
        }
        try {
            rw = new BufferedWriter(new OutputStreamWriter(factory.getHttpUrlConnection().getOutputStream(), "UTF-8"));
            rw.write(out.toString());
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
    public <T> HttpPostFormAbs setParams(T t) {
        params = (Map<String, String>) t;
        return this;
    }

}
