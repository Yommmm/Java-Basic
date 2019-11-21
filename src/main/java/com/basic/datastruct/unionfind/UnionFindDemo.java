package com.basic.datastruct.unionfind;

public class UnionFindDemo {

    public static void main(String[] args) {
        UnionFindDemo ufd = new UnionFindDemo();
        ufd.testDemo1();
    }

    public void testDemo1() {
        UF uf = new UnionFind1(100);
        System.out.println(uf.getSize());

        uf.unionElements(1, 10);
        uf.unionElements(2, 10);
        uf.unionElements(4, 10);
        uf.unionElements(5, 9);
        uf.unionElements(6, 5);

        System.out.println(uf.isConnected(1, 2));
        System.out.println(uf.isConnected(5, 6));
        System.out.println(uf.isConnected(5, 1));
    }

}
