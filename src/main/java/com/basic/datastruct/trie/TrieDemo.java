package com.basic.datastruct.trie;

public class TrieDemo {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("String");
        trie.add("String");
        trie.add("Strini");
        trie.add("Strinh");
        trie.add("Strinj");
        System.out.println(trie.contains("String"));

        Trie trie1 = new Trie();
        trie1.addRc("String");
        trie1.addRc("Strini");
        trie1.addRc("Strinh");
        trie1.addRc("Strinj");
        System.out.println(trie.containsRc("Strinj"));


        System.out.println("String");
    }
}
