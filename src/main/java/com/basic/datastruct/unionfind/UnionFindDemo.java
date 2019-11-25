package com.basic.datastruct.unionfind;

public class UnionFindDemo {

    public static void main(String[] args) {
        UnionFindDemo ufd = new UnionFindDemo();
//        ufd.testDemo1();
//        ufd.testDemo2();
//        ufd.testDemo3();
//        ufd.testDemo4();
        ufd.testDemo5();
//        ufd.testDemo6();
    }

    public void testDemo1() {
        UF uf = new UnionFind1(100);
        this.coreTest(uf);
    }

    public void testDemo2() {
        UF uf = new UnionFind2(100);
        this.coreTest(uf);
    }

    public void testDemo3() {
        UF uf = new UnionFind4(100);
        this.coreTest(uf);
    }

    public void testDemo4() {
        UF uf = new UnionFind4(100);
        this.coreTest(uf);
    }

    public void testDemo5() {
        UF uf = new UnionFind5(100);
        this.coreTest(uf);
    }

    public void testDemo6() {
        UF uf = new UnionFind6(100);
        this.coreTest(uf);
    }

    private void coreTest(UF uf) {
        System.out.println(uf.getSize());

        uf.unionElements(1, 10);
        uf.unionElements(11, 1);
        uf.unionElements(12, 11);
        uf.unionElements(13, 12);
        uf.unionElements(14, 13);

        System.out.println(uf.isConnected(1, 2));
        System.out.println(uf.isConnected(5, 6));
        System.out.println(uf.isConnected(5, 1));
    }

}
