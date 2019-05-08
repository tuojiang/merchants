package com.chandler.passbook.security;

/**
 * @Date: 19-5-7
 * @version： V1.0
 * @Author: Chandler
 * @Description: 用Threadlocal单独存储每一个线程携带的 token 信息
 */
public class AccessContext {

    public static final ThreadLocal<String> token = new ThreadLocal<>();

    public static String getToken(){
        return token.get();
    }
    public static void setToken(String tokenStr){
        token.set(tokenStr);
    }
    public static void clearAccessKey(){
        token.remove();
    }
}
