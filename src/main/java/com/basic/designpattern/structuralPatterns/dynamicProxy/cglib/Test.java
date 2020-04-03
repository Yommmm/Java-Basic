package com.basic.designpattern.structuralPatterns.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class Test {

    public static void main(String[] args) {
        JayChou singerProxy = new JayChou();

        // cglib主要的增强类
        Enhancer enhancer = new Enhancer();
        // 设置被代理的对象
        enhancer.setSuperclass(Singer.class);
        // 设置回调函数，一般为MethodInterceptor的实现类
        enhancer.setCallback(singerProxy);

        // 创建代理
        Singer proxy = (Singer) enhancer.create();

        // 代理工作
        proxy.singing();
        proxy.haha("你愁啥？瞅你咋地？");
    }

}
