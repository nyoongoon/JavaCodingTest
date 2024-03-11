package _Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Practice5 {
    public static ArrayList<Boolean> solution(String[] queries, String pattern) {
        ArrayList<Boolean> result = new ArrayList<>();
        Trie trie = new Trie();
        trie.add(pattern);

        for (String str : queries) {
            result.add(trie.search(str));
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        System.out.println(solution(queries, pattern));

        pattern = "FoBa";
        System.out.println(solution(queries, pattern));

        pattern = "FoBaT";
        System.out.println(solution(queries, pattern));
    }

    public static class Node {
        Character value;
        boolean isTerminal;
        Map<Character, Node> child;

        public Node(Character value, boolean isTerminal) {
            this.value = value;
            this.isTerminal = isTerminal;
            this.child = new HashMap<>();
        }
    }

    public static class Trie {
        Node root;

        public Trie() {
            this.root = new Node(null, false);
        }

        public void add(String str) {
            Node cur = this.root;

            for (int i = 0; i < str.length() - 1; i++) {
                char c = str.charAt(i);
                if (!cur.child.containsKey(c)) {
                    cur.child.put(c, new Node(c, false));
                }
                cur = cur.child.get(c);
            }

            char lastC = str.charAt(str.length() - 1);
            cur.child.put(lastC, new Node(lastC, true));
        }

        public boolean search(String str) {
            Node cur = this.root;

            // 맨처음은 무조건 패턴..?
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(Character.isUpperCase(c) && !cur.child.containsKey(c)){
                    return false;
                }

                if (cur.child.containsKey(c)) {
                    cur = cur.child.get(c);
                }
            }

            if (cur.isTerminal) {
                return true;
            }

            return false;
        }
    }
}
