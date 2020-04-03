package com.basic.designpattern.structuralPatterns.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvocationHandler
 * 动态代理处理类
 *
 * @author 85374
 * @date
 */
public class SingerInvocationHandler implements InvocationHandler {

    private Object singer;

    public SingerInvocationHandler(Object singer) {
        this.singer = singer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 被代理对象处理前
        System.out.println("-------- start ---------");

        // 被代理对象处理
        Object invoke = method.invoke(singer, args);

        // 被代理对象处理后
        System.out.println("-------- end ---------");
        return invoke;
    }

}
