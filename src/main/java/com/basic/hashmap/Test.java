package com.basic.hashmap;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }

    public void test() {
        Map<String, String> map = new HashMap<String, String>();
        int i = 200;
        while (i > 0) {
            map.put(UUID.randomUUID().toString(), "d");
            i--;
        }

        Set<String> keys = map.keySet();
        List<String> list = new ArrayList<>();
        list.addAll(keys);
        System.out.println(list.size());

        for (int j = 0; j < 190; j++) {
            map.remove(list.get(j));
        }

        System.out.println(map.size());
        map.put("ddddd", "ddd");
    }

}
