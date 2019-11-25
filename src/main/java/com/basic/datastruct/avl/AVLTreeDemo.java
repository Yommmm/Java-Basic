package com.basic.datastruct.avl;

import com.basic.datastruct.trie.FileOperation;

import java.util.ArrayList;
import java.util.List;

public class AVLTreeDemo {

    public static void main(String[] args) {
        AVLTreeDemo demo = new AVLTreeDemo();
//        demo.testAVLTree();
//        demo.testDemo1();
        demo.testIsBST();
    }

    public void testIsBST() {
        AVLTree<String, Integer> map = new AVLTree<>();
        map.add("String", 1);
        map.add("Strina", 1);
        map.add("Strinb", 1);
        map.add("Strinc", 1);
        map.add("Strind", 1);
        map.add("Strine", 1);
        map.add("Strinf", 1);

        System.out.println(map.isBST());
    }

    public void testAVLTree() {
        AVLTree<String, Integer> map = new AVLTree<>();
        map.add("String", 1);
        map.add("Strina", 1);
        map.add("Strinb", 1);
        map.add("Strinc", 1);
        map.add("Strind", 1);
        map.add("Strine", 1);
        map.add("Strinf", 1);

        System.out.println(map.contains("String"));
        System.out.println(map.get("String"));
    }

    public void testDemo1() {
        System.out.println("Pride and Prejudice");

        List<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
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
    }

}
