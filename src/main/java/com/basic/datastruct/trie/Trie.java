package com.basic.datastruct.trie;

import java.util.TreeMap;

public class Trie {

    private Node root;

    private int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * 非递归添加元素
     * @param word
     */
    public void add(String word) {
        Node cur = root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(null == cur.next.get(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if(!cur.isWord) {
            cur.isWord = true;
            size ++;
        }
    }

    public void addRc(String word) {
        Node cur = root;

        addRc(cur, word);
    }

    /**
     * 递归添加元素
     * @param cur
     * @param word
     */
    public void addRc(Node cur, String word) {
        if(word.length() == 0) {
            if(!cur.isWord) {
                cur.isWord = true;
                size ++;
                return;
            }
        }

        char c = word.charAt(0);
        if(null == cur.next.get(c)) {
            cur.next.put(c, new Node());
        }
        addRc(cur.next.get(c), word.substring(1, word.length()));
    }

    /**
     * 判断元素是否在字典中存在【非递归】
     * @param word
     * @return
     */
    public boolean contains(String word) {
        Node cur = root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(null == cur.next.get(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    /**
     * 判断元素是否在字典中存在【递归】
     * @param word
     * @return
     */
    public boolean containsRc(String word) {
        return containsRc(root, word).isWord;
    }

    public Node containsRc(Node cur, String word) {
        if(word.length() == 0) {
            return cur;
        }

        char c = word.charAt(0);
        if(null == cur.next.get(c)) {
            return root;
        }

        Node result = containsRc(cur.next.get(c), word.substring(1, word.length()));
        return result;
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
