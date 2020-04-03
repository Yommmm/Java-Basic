package com.basic.designpattern.structuralPatterns.dynamicProxy.jdk;

import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class Test {

    public static void main(String[] args) {
        JayChou jayChou = new JayChou();
        SingerInvocationHandler singerInvocationHandler = new SingerInvocationHandler(jayChou);
        Sing singer = (Sing) Proxy.newProxyInstance(jayChou.getClass().getClassLoader(), jayChou.getClass().getInterfaces(), singerInvocationHandler);
        singer.sing();
    }

}
