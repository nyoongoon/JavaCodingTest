package _Theory.Chapter3_NonLinear._17_비선형자료구조_연습문제_3.src;

import java.util.HashMap;
import java.util.Map;

public class Practice4 {
    public static boolean solution(String[] nums) {
        Trie trie = new Trie();
        boolean result = true;
        for (String str : nums) {
            result = !result ? false : trie.insertTrie(str);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        String[] nums = {"911", "123456789", "911234"};
        System.out.println(solution(nums)); // false

        nums = new String[]{"113", "12345", "12344", "98765"};
        System.out.println(solution(nums)); // true

    }

    static class Node {
        Map<Character, Node> child;
        boolean isTerminal;

        public Node() {
            this.child = new HashMap<>();
            this.isTerminal = false;
        }

        public void setTerminal() {
            this.isTerminal = true;
        }
    }

    static class Trie {
        Node head;

        public Trie() {
            this.head = new Node();
        }

        //root
        //9
        //1
        //1
        //
        public boolean insertTrie(String data) {
            Node cur = this.head;
            for (int i = 0; i < data.length(); i++) {
                if (cur.isTerminal) {
                    return false;
                }
                char c = data.charAt(i);
                if (!cur.child.containsKey(c)) {
                    cur.child.put(c, new Node());
                }
                cur = cur.child.get(c);
            }
            cur.setTerminal();
            return true;
        }
    }
}
