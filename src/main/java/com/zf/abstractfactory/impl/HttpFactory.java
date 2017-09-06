package com.zf.abstractfactory.impl;

import com.zf.abstractfactory.abs.HttpFactoryAbs;
import com.zf.abstractfactory.abs.HttpGetAbs;
import com.zf.abstractfactory.abs.HttpPostBodyAbs;
import com.zf.abstractfactory.abs.HttpPostFormAbs;
import com.zf.abstractfactory.get.HttpUrlConnectionGet;
import com.zf.abstractfactory.postbody.HttpUrlConnectionPostBody;
import com.zf.abstractfactory.postform.HttpUrlConnectionPostForm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangfei on 2017/9/6/006.
 */
public class HttpFactory extends HttpFactoryAbs{

    @Override
    public HttpGetAbs createHttpGet() {
        return new HttpUrlConnectionGet(this);
    }

    @Override
    public HttpPostFormAbs createHttpPostForm() {
        return new HttpUrlConnectionPostForm(this);
    }

    @Override
    public HttpPostBodyAbs createHttpPostBody() {
        return new HttpUrlConnectionPostBody(this);
    }

    public static void main(String[] args) {
        HttpFactory hf = new HttpFactory();
        String res = hf.createHttpGet().execute("http://101.200.48.144:8080/api/v3?username=zf");
        System.out.println(res);
        Map<String, String> params = new HashMap<String, String>();
        params.put("username","zf");
        params.put("password","123");
        String res1 = hf.createHttpPostForm().setParams(params).execute("http://101.200.48.144:8080/api/v1");
        System.out.println(res1);
        String res2 = hf.createHttpPostBody().setParams("{\"username\":\"zf\"}").execute("http://101.200.48.144:8080/api/v2");
        System.out.println(res2);
    }

}
