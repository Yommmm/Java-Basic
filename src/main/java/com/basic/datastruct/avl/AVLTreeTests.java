package com.basic.datastruct.avl;

import com.basic.datastruct.trie.FileOperation;

import java.util.ArrayList;

public class AVLTreeTests {

    public static void main(String[] args) {
//        AVLTree2<Integer, Integer> map = new AVLTree2<>();
//        map.add(2, 2);
//        map.add(1, 1);
//        map.add(5, 5);
//        map.add(3, 3);
//        map.add(6, 6);
//        map.add(7, 7);
//
//        map.preOrder();
//        System.out.println(map.isBalanced());

        AVLTreeTests tests = new AVLTreeTests();
        tests.testPerformance();
    }

    public void testPerformance() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree2<String, Integer> map = new AVLTree2<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println("is BST : " + map.isBST());
            System.out.println("is Balanced : " + map.isBalanced());
        }

        System.out.println();
    }

}
