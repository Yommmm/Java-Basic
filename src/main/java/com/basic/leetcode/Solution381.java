package com.basic.leetcode;

import java.util.*;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * <p>
 * 注意: 允许出现重复元素。
 * <p>
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 示例:
 * <p>
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 * <p>
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 * <p>
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 * <p>
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 * <p>
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 * <p>
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution381 {

    class RandomizedCollection {

        private Map<Integer, Set<Integer>> map;
        private List<Integer> list;
        private Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!map.containsKey(val)) map.put(val, new LinkedHashSet<Integer>());
            map.get(val).add(list.size());
            list.add(val);
            return map.get(val).size() == 1;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val) || map.get(val).size() == 0) return false;
            int rmIndex = map.get(val).iterator().next();
            map.get(val).remove(rmIndex);
            int last = list.get(list.size() - 1);
            list.set(rmIndex, last);
            map.get(last).add(rmIndex);
            map.get(last).remove(list.size() - 1);

            list.remove(list.size() - 1);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
