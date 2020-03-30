package com.basic.leetcode;

import java.util.TreeMap;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trie {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (null == cur.next.get(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (null == cur.next.get(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node cur = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (null == cur.next.get(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }

        return true;
    }

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }
}
