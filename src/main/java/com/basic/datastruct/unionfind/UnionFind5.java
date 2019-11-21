package com.basic.datastruct.unionfind;

/**
 * 树形结构
 */
public class UnionFind5 implements UF {

    private int[] parent; // parent[i]表示元素所指向的父节点
    private int[] rank;   // rank[i]表示以i为根的集合所表示的树的层数

    public UnionFind5(int size) {
        this.parent = new int[size];
        this.rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 最终的跟节点的下标和值是一样的，不一样的都是子节点
     * 每个子节点的值为父节点的下标UnionFind3
     *
     * @param p
     * @return
     */
    public int find(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        while (p != parent[p]) {
            /**
             * 压缩路径
             * 前四个版本是我拿你当爸爸
             * 这个版本是我拿你爸当爸爸
             * 我要和你当兄弟
             * 压缩一个路径
             */
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    /**
     * 找出两个元素是不是同一个祖宗
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
     * 1.找出两个祖宗
     * 2.比对两个祖宗
     * 3.p祖宗子孙代数比q祖宗少，p祖宗给q祖宗当儿子
     * <p>
     * 时间复杂度都是O(h)
     * h为树的高度
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 根据两个元素所在树的rank不同判断合并方向
        // 将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;
        else if (rank[qRoot] < rank[pRoot])
            parent[qRoot] = pRoot;
        else { // rank[pRoot] == rank[qRoot]
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;   // 此时, 我维护rank的值
        }
    }
}
