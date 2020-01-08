package com.basic.basic;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String a = " ";
        List<String> strings = Arrays.asList(a.trim().split(","));
        System.out.println(strings);
    }

}
