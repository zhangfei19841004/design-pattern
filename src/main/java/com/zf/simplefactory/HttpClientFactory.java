package com.zf.simplefactory;

import com.zf.simplefactory.impl.HttpClientGet;
import com.zf.simplefactory.impl.HttpClientPostBody;
import com.zf.simplefactory.impl.HttpClientPostForm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public class HttpClientFactory {

    public static HttpClientAbs create(String flag){
        if("get".equals(flag)){
            return new HttpClientGet();
        }else if("postForm".equals(flag)){
            return new HttpClientPostForm();
        }else if("postBody".equals(flag)){
            return new HttpClientPostBody();
        }
        return null;
    }

    public static void main(String[] args) {
        String response = HttpClientFactory.create("get").execute("http://101.200.48.144:8080/api/v3?username=zf");
        System.out.println(response);
        Map<String, String> params = new HashMap<String, String>();
        params.put("username","zf");
        params.put("password","123");
        String res1 = HttpClientFactory.create("postForm").setParams(params).execute("http://101.200.48.144:8080/api/v1");
        System.out.println(res1);
        String res2 = HttpClientFactory.create("postBody").setParams("{\"username\":\"zf\"}").execute("http://101.200.48.144:8080/api/v2");
        System.out.println(res2);
    }

}
