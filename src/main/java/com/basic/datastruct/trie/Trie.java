package com.basic.datastruct.trie;

import java.util.Stack;
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
     *
     * @param word
     */
    public void add(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (null == cur.next.get(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public void addRc(String word) {
        Node cur = root;

        addRc(cur, word);
    }

    /**
     * 递归添加元素
     *
     * @param cur
     * @param word
     */
    private void addRc(Node cur, String word) {
        if (word.length() == 0) {
            if (!cur.isWord) {
                cur.isWord = true;
                size++;
                return;
            }
        }

        char c = word.charAt(0);
        if (null == cur.next.get(c)) {
            cur.next.put(c, new Node());
        }
        addRc(cur.next.get(c), word.substring(1, word.length()));
    }

    /**
     * 判断元素是否在字典中存在【非递归】
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
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
     * 判断元素是否在字典中存在【递归】
     *
     * @param word
     * @return
     */
    public boolean containsRc(String word) {
        return containsRc(root, word).isWord;
    }

    private Node containsRc(Node cur, String word) {
        if (word.length() == 0) {
            return cur;
        }

        char c = word.charAt(0);
        if (null == cur.next.get(c)) {
            return root;
        }

        Node result = containsRc(cur.next.get(c), word.substring(1, word.length()));
        return result;
    }

    /**
     * Trie 模式匹配
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    /**
     * Trie 模式匹配递归
     *
     * @param node
     * @param word
     * @param index
     * @return
     */
    private boolean match(Node node, String word, int index) {

        if (index == word.length())
            return node.isWord;

        char c = word.charAt(index);

        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        } else {
            for (char nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 移除一个字符串
     *
     * @param word
     */
    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    /**
     * 涉及到路径回溯的操作使用递归更方便
     *
     * @param cur
     * @param word
     * @param index
     * @return
     */
    private boolean delete(Node cur, String word, int index) {

        if (word.length() == index) {
            if (cur.isWord) {
                cur.isWord = false;
                size--;
                return true;
            } else {
                return false;
            }
        }

        char c = word.charAt(index);
        if (!cur.next.containsKey(c)) {
            return false;
        }

        // 递归自顶往下
        boolean result = delete(cur.next.get(c), word, index + 1);

        // 回溯自底往上
        Node nextNode = cur.next.get(c);
        if (!nextNode.isWord && nextNode.next.size() == 0) {
            cur.next.remove(word.charAt(index));
        }

        return result;
    }

    // 删除word, 返回是否删除成功
    public boolean remove(String word) {

        // 将搜索沿路的节点放入栈中
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        for (int i = 0; i < word.length(); i++) {
            if (!stack.peek().next.containsKey(word.charAt(i)))
                return false;
            stack.push(stack.peek().next.get(word.charAt(i)));
        }

        if (!stack.peek().isWord)
            return false;

        // 将该单词结尾isWord置空
        stack.peek().isWord = false;
        size--;

        // 如果单词最后一个字母的节点的next非空，
        // 说明trie中还存储了其他以该单词为前缀的单词，直接返回
        if (stack.peek().next.size() > 0)
            return true;
        else
            stack.pop();

        // 自底向上删除
        for (int i = word.length() - 1; i >= 0; i--) {
            stack.peek().next.remove(word.charAt(i));
            // 如果一个节点的isWord为true，或者是其他单词的前缀，则直接返回
            if (stack.peek().isWord || stack.peek().next.size() > 0)
                return true;
            stack.pop();
        }
        return true;
    }

    /**
     * 前綴
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
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
