package com.basic.datastruct.set;

import java.util.ArrayList;

public class SetDemo {

    public static void main(String[] args) {
        SetDemo demo = new SetDemo();

        demo.bstSetTest();
        System.out.println("============================================");
        demo.linkedListSetTest();
    }

    public void bstSetTest() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            long time1 = System.nanoTime();
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.size());
            long time2 = System.nanoTime();
            System.out.println((time2 - time1) / 1000000000.0);
        }

        System.out.println();

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {
            long time1 = System.nanoTime();
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for (String word : words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.size());
            long time2 = System.nanoTime();
            System.out.println((time2 - time1) / 1000000000.0);
        }
    }

    public void linkedListSetTest() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            long time1 = System.nanoTime();
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> set1 = new LinkedListSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.size());
            long time2 = System.nanoTime();
            System.out.println((time2 - time1) / 1000000000.0);
        }

        System.out.println();

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {
            long time1 = System.nanoTime();
            System.out.println("Total words: " + words2.size());

            LinkedListSet<String> set2 = new LinkedListSet<>();
            for (String word : words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.size());
            long time2 = System.nanoTime();
            System.out.println((time2 - time1) / 1000000000.0);
        }
    }

}
