package com.basic.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池溢出
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * -XX:MetaspaceSize=10485760 -XX:MaxMetaspaceSize=10485760
 */
public class RuntimeConstantPoolOOM {

    /*public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }*/

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        String str2 = new StringBuilder("Ja").append("va").toString();// 运行时常量池里面有Java这个字符串了

        System.out.println(str1 == str1.intern());
        System.out.println(str2 == str2.intern());
    }
}
