package pers.wellhor.main;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现 Trie (前缀树)
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/14 9:54 下午
 **/
public class Question208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
//        trie.insert("apple");
//        System.out.println(trie.search("apple"));
//        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    /**
     * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
     * <p>
     * 请你实现 Trie 类：
     * <p>
     * Trie() 初始化前缀树对象。
     * void insert(String word) 向前缀树中插入字符串 word 。
     * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
     * boolean startsWith(String prefix) 如果之前已经插入的字符串word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入
     * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
     * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
     * 输出
     * [null, null, true, false, true, null, true]
     * <p>
     * 解释
     * Trie trie = new Trie();
     * trie.insert("apple");
     * trie.search("apple");   // 返回 True
     * trie.search("app");     // 返回 False
     * trie.startsWith("app"); // 返回 True
     * trie.insert("app");
     * trie.search("app");     // 返回 True
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= word.length, prefix.length <= 2000
     * word 和 prefix 仅由小写英文字母组成
     * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
     */
    static class Trie {

        private final static String FINAL_FLAG = "\0";

        private char c;

        private Map<Character, Trie> nextTreeNode = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public Trie() {
        }

        public Trie(Character c) {
            this.c = c;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if(word != null && word.length() > 0) {
                Character head = word.substring(0, 1).charAt(0);
                Trie trie = nextTreeNode.get(head);
                if(trie == null) {
                    trie = new Trie(head);
                    nextTreeNode.put(head, trie);
                }
                if(word.length() > 1) {
                    String subWord = word.substring(1);
                    trie.insert(subWord);
                } else if(!FINAL_FLAG.equals(word)) {
                    trie.insert(FINAL_FLAG);
                }
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if(word != null) {
                if(word.length() > 0) {
                    Character head = word.substring(0, 1).charAt(0);
                    Trie trie = nextTreeNode.get(head);
                    if(trie == null) {
                        return false;
                    } else {
                        if(word.length() > 1) {
                            String subWord = word.substring(1);
                            return trie.search(subWord);
                        } else if(!FINAL_FLAG.equals(word)) {
                            return trie.search(FINAL_FLAG);
                        } else {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if(prefix != null) {
                if(prefix.length() > 0) {
                    Character head = prefix.substring(0, 1).charAt(0);
                    Trie trie = nextTreeNode.get(head);
                    if(trie == null) {
                        return false;
                    } else {
                        if(prefix.length() > 1) {
                            String subWord = prefix.substring(1);
                            return trie.startsWith(subWord);
                        } else {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }


}
