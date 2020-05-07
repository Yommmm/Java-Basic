package com.basic.basic;

import java.util.List;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class NumberTest {

    public static void main(String[] args) {
        NumberTest numberTest = new NumberTest();
        numberTest.testInteger();
    }

    public void testInteger() {
        Integer a = 127;
        Integer b = 127;
        Integer c = new Integer(127);

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

        Integer d = -129;
        Integer e = -129;
        System.out.println(d == e); // -128~127在常量池

    }

}
