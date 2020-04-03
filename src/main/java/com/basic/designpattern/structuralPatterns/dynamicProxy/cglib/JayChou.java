package com.basic.designpattern.structuralPatterns.dynamicProxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class JayChou implements MethodInterceptor {

    /**
     * JayChou对Singer的所有方法进行拦截处理
     *
     * @param o 被代理对象
     * @param method 被代理方法
     * @param objects 被代理方法参数
     * @param methodProxy JDK的java.lang.reflect.Method类的代理类
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("-------- 我唱一首东风破 ---------");
        String name = method.getName();
        System.out.println(name);
        System.out.println(Arrays.toString(objects));
        Object intercept = methodProxy.invokeSuper(o, objects);
        System.out.println("-------- 唱完了 ---------");
        return intercept;
    }

}
