package com.basic.datastruct.unionfind;

/**
 * 星型的队长-队员结构
 */
public class UnionFind1 implements UF {

    private int id[]; // id[i]表示队长所在位置

    public UnionFind1(int size) {
        this.id = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * O(1)
     *
     * @param p
     * @return
     */
    public int find(int p) {
        if (p < 0 || p > id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        return id[p];
    }

    /**
     * O(2)
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 数组下标
     * 数组值为关联条件
     * 时间复杂度O(n)
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (pId == id[i]) {
                id[i] = qId;
            }
        }

    }
}