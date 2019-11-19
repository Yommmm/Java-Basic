package com.basic.datastruct.trie;

import java.util.TreeMap;

public class Trie {

    private Node root;

    private int size;

    public Trie(Node root) {
        this.root = new Node();
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

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
