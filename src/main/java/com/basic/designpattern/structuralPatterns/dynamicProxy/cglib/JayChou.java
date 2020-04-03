package com.basic.designpattern.structuralPatterns.dynamicProxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class JayChou implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("-------- 我唱一首东风破 ---------");
        Object intercept = methodProxy.invokeSuper(o, objects);
        System.out.println("-------- 唱完了 ---------");
        return intercept;
    }

}
