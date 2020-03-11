package lettcode.Q200;

import java.util.TreeMap;

public class Q208 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        System.out.printf(trie.search("app")+"");     // 返回 true
    }
    private static class Trie {
        private class Node {
            public boolean isWord;
            public TreeMap<Character, Node> next;

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new TreeMap<>();
            }

            public Node() {
                this(false);
            }
        }

        private Node root;
        private int size;

        public int getSize() {
            return size;
        }

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
            size = 0;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) {
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            if (!cur.isWord) {
                cur.isWord = true;
                size++;
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) {
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
                if (cur.next.get(c) == null) {
                    return false;
                }
                cur = cur.next.get(c);
            }
            return true;
        }
    }
}
