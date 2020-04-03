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

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Singer.class);
        enhancer.setCallback(singerProxy);

        Singer proxy = (Singer) enhancer.create();
        proxy.singing();
    }

}
