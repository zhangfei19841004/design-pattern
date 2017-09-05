package com.zf.simplefactory;

import com.zf.simplefactory.impl.HttpClientGet;
import com.zf.simplefactory.impl.HttpClientPostBody;
import com.zf.simplefactory.impl.HttpClientPostForm;

/**
 * Created by zhangfei on 2017/9/5.
 */
public enum HttpClientRequest {

    GET(HttpClientGet.class),

    POSTFORM(HttpClientPostForm.class),

    POSTBODY(HttpClientPostBody.class);

    private Class<? extends HttpClientAbs> clazz;

    public Class<? extends HttpClientAbs> getClazz() {
        return clazz;
    }

    private HttpClientRequest(Class<? extends HttpClientAbs> clazz) {
        this.clazz = clazz;
    }

    public static HttpClientAbs getHttpClientRequestInstance(HttpClientRequest request){
        try {
            return request.getClazz().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
