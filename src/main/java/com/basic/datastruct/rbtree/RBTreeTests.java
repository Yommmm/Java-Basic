package com.basic.datastruct.rbtree;

import com.basic.datastruct.avl.AVLTree2;
import com.basic.datastruct.trie.FileOperation;

import java.util.ArrayList;

public class RBTreeTests {

    public static void main(String[] args) {

        RBTreeTests tests = new RBTreeTests();

//        tests.rbtreeTest1();
        tests.testPerformance();
        tests.comparePreformance();
    }

    public void testPerformance() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            RBTree<String, Integer> map = new RBTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

//            System.out.println("is BST : " + map.isBST());
//            System.out.println("is Balanced : " + map.isBalanced());
        }

        System.out.println();
    }

    public void comparePreformance() {
        int n = 20000000;

        ArrayList<Integer> testData = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i ++)
            testData.add(i);

        // Test AVL
        long startTime = System.nanoTime();

        AVLTree2<Integer, Integer> avl = new AVLTree2<>();
        for (Integer x: testData)
            avl.add(x, null);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");


        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x: testData)
            rbt.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");
    }

    public void rbtreeTest1() {
        RBTree<Integer, Integer> rbTree = new RBTree<>();
        rbTree.add(55, 55);
        rbTree.preOrder();
        System.out.println();
        rbTree.add(44, 44);
        rbTree.preOrder();
        System.out.println();
        rbTree.add(33, 33);
        rbTree.preOrder();
        System.out.println();
        rbTree.add(22, 22);
        rbTree.preOrder();
        System.out.println();
        rbTree.add(11, 11);
        rbTree.preOrder();
        System.out.println();
    }

}
