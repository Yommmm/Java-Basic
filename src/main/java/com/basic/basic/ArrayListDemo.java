package com.basic.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        list.add(0, "1");
        System.out.println(list);
    }

}
