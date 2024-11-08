package _0_Theory.Chapter3_NonLinear._17_비선형자료구조_연습문제_3.src;

import java.util.HashMap;
import java.util.Map;

public class Practice4_re {
    public static boolean solution(String[] nums) {
        Trie trie = new Trie();
        for (String str : nums) {
            trie.insert(str);
        }

        for (String str : nums) {
            if (!trie.search(str)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        String[] nums = {"911", "123456789", "911234"};
        System.out.println(solution(nums)); // false

        nums = new String[]{"113", "12345", "12344", "98765"};
        System.out.println(solution(nums)); // true

    }

    public static class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String str) {
            Node cur = this.root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Node());
                }
                cur = cur.children.get(c);
            }
            cur.setTerminal();
        }

        public boolean search(String str) {
            Node cur = this.root;
            for (int i = 0; i < str.length(); i++) {
                if (cur.isTerminal) {
                    return false; //Node 경로에 terminal없어야 함!
                }
                char c = str.charAt(i);
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }

            if (!cur.isTerminal) {
                return false;
            }

            return true;
        }
    }

    public static class Node {
        private Map<Character, Node> children;
        private boolean isTerminal;

        public Node() {
            children = new HashMap<>();
            isTerminal = false;
        }

        public void setTerminal() {
            this.isTerminal = true;
        }
    }
}
