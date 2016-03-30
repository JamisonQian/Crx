package com.crxjr.app.http.builder;


import com.crxjr.app.http.OkHttpManager;
import com.crxjr.app.http.request.OtherRequest;
import com.crxjr.app.http.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpManager.METHOD.HEAD, url, tag, params, headers).build();
    }
}
