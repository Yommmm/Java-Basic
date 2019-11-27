package com.basic.datastruct.hash;

import com.basic.datastruct.trie.FileOperation;

import java.util.ArrayList;

public class HashTests {
    public static void main(String[] args) {
        HashTests hashTests = new HashTests();
        hashTests.testPerformance();
    }

    public void testPerformance() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            HashTable<String, Integer> map = new HashTable<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }

    public void testHashCode() {
        int a = 888888888;

        System.out.println(Integer.valueOf(a).hashCode());

        String str = new String("bbbbbbb");
        System.out.println(str.hashCode());
        System.out.println(str.hashCode());

        Student student = new Student(1, 1, "haha", "lala");
        Student student1 = new Student(1, 1, "haha", "lala");
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());

        System.out.println(student == student1);
        System.out.println(student.equals(student1));
    }

}
