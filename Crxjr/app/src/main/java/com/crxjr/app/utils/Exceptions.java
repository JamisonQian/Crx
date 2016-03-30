package com.crxjr.app.utils;

/**
 * 作者：Arjun
 * 时间： 2016/3/30 15:13
 * 手机：15000112837
 */
public class Exceptions {
    public static void illegalArgument(String msg, Object... params)
    {
        throw new IllegalArgumentException(String.format(msg, params));
    }
}
