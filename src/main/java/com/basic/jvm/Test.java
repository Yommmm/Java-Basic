package com.basic.jvm;

public class Test {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static String test() {
        String src = "hello";
        try {
            return src;
        } finally {
            src = "qq";
            System.out.println(src);
        }
    }

}
