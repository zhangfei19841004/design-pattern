package com.zf.simplefactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangfei on 2017/9/5/005.
 */
public class HttpClientFactory {

    public static HttpClientAbs create(HttpClientRequest request){
        return HttpClientRequest.getHttpClientRequestInstance(request);
    }

    public static void main(String[] args) {
        String response = HttpClientFactory.create(HttpClientRequest.GET).execute("http://101.200.48.144:8080/api/v3?username=zf");
        System.out.println(response);
        Map<String, String> params = new HashMap<String, String>();
        params.put("username","zf");
        params.put("password","123");
        String res1 = HttpClientFactory.create(HttpClientRequest.POSTFORM).setParams(params).execute("http://101.200.48.144:8080/api/v1");
        System.out.println(res1);
        String res2 = HttpClientFactory.create(HttpClientRequest.POSTBODY).setParams("{\"username\":\"zf\"}").execute("http://101.200.48.144:8080/api/v2");
        System.out.println(res2);
    }

}
