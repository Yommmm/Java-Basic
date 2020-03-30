package com.basic.datastruct.map;

import java.util.ArrayList;

import com.basic.datastruct.set.FileOperation;

public class BSTMapDemo {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            long time1 = System.nanoTime();
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.size());

            System.out.println("Ferquency of pride: " + map.get("pride"));
            System.out.println("Ferquency of prejudice: " + map.get("prejudice"));

            long time2 = System.nanoTime();
            System.out.println((time2 - time1) / 1000000000.0);
        }

        System.out.println();

    }

}
