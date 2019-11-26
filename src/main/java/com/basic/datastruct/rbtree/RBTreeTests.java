package com.basic.datastruct.rbtree;

public class RBTreeTests {

    public static void main(String[] args) {

        RBTreeTests tests = new RBTreeTests();

        tests.rbtreeTest1();
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
