package com.basic.leetcode;

/**
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("");
        System.out.println(wordDictionary.search(".bc.efh"));
    }

    private TrieNode root;

    class TrieNode {

        boolean isWord;
        TrieNode[] next;

        public TrieNode() {
            this.isWord = false;
            this.next = new TrieNode[26];
        }
    }

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        this.addWord(root, word);
    }

    public void addWord(TrieNode node, String word) {
        if(word.length() == 0) return;

        char c = word.charAt(0);
        int ci = c - 'a';
        if (null == node.next[ci]) {
            node.next[ci] = new TrieNode();
            if (word.length() == 1) {
                node.next[ci].isWord = true;
                return;
            }
        }

        addWord(node.next[ci], word.substring(1));
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return this.search(root, word);
    }

    private boolean search(TrieNode node, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 对于 . , 递归的判断所有不为空的孩子
            if (chars[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.next[j] != null) {
                        if (search(node.next[j], word.substring(i + 1))) {
                            return true;
                        }
                    }
                }
                return false;
            }
            // 不含有当前节点
            if (node.next[chars[i] - 'a'] == null) {
                return false;
            }
            node = node.next[chars[i] - 'a'];
        }
        // 当前节点是否为是某个单词的结束
        return node.isWord;

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
