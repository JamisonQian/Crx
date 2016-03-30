package com.crxjr.app.http.cookies;

import com.crxjr.app.application.MyApplication;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * 作者：Arjun
 * 时间：2016/3/28 22:39
 * 邮箱：qianjun942030@163.com
 */
public class CookiesManager implements CookieJar{
    private final PersistentCookieStore cookieStore = new PersistentCookieStore(MyApplication.getmContext());
    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (cookies != null && cookies.size() > 0) {
            for (Cookie item : cookies) {
                cookieStore.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        return cookies;
    }

}
