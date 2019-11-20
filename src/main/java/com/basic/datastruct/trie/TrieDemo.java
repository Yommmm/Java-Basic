package com.basic.datastruct.trie;

import com.basic.datastruct.set.BSTSet;

import java.util.ArrayList;
import java.util.List;

public class TrieDemo {
    public static void main(String[] args) {
        TrieDemo trieDemo = new TrieDemo();

//        trieDemo.testAddAndcontains();

        trieDemo.testPerformance();

    }

    public void testAddAndcontains() {
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

    public void testPerformance() {
        System.out.println("Pride and Prejudice");

        List<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {

            long startTime = System.nanoTime();

            BSTSet<String> set = new BSTSet<>();
            for (String word : words)
                set.add(word);

            for (String word : words)
                set.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + set.size());
            System.out.println("BSTSet: " + time + " s");

            // ---

            startTime = System.nanoTime();

            Trie trie = new Trie();
            for (String word : words)
                trie.add(word);

            for (String word : words)
                trie.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");
        }
    }

}
