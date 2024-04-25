package _Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Trie로 문제 풀기...
 */
public class Practice5_ans {
    public static ArrayList<Boolean> solution(String[] queries, String pattern) {
        ArrayList<Boolean> results = new ArrayList<>();
        Trie trie = new Trie();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (Character.isUpperCase(c)) {
                trie.capitals.add(c);
            }
        }

        trie.insert(pattern);

        for (String query : queries) {
            results.add(trie.search(query));
        }

        return results;
    }


    public static void main(String[] args) {
        // Test code
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack", "FooB"};
        String pattern = "FB";
        System.out.println(solution(queries, pattern));

        pattern = "FoBa";
        System.out.println(solution(queries, pattern));

        pattern = "FoBaT";
        System.out.println(solution(queries, pattern));
    }

    public static class Node {
        Map<Character, Node> children = new HashMap<>();
    }

    public static class Trie {
        Node root;
        List<Character> capitals = new ArrayList<>();

        public Trie() {
            this.root = new Node();
        }

        public void insert(String pattern) {
            Node cur = this.root;
            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Node());
                }
                cur = cur.children.get(c);
            }
        }

        public boolean search(String query) {
            Node cur = this.root;
            List<Character> copy = new ArrayList<>(this.capitals);
            for (int i = 0; i < query.length(); i++) {
                char c = query.charAt(i);

                if (!cur.children.containsKey(c)) {
                    if (!Character.isUpperCase(c)) {
                        continue;
                    }
//                    System.out.println("not contais and not lowerCase -> " + c);
                    return false;
                }


                if (Character.isUpperCase(c)) {
                    for (int j = 0; j < copy.size(); j++) {
                        if (c == copy.get(j)) {
                            copy.remove(j);
                            break;
                        }
                    }
                }

                cur = cur.children.get(c);
            }


            if (copy.isEmpty()) {
//                System.out.println("isEmpty");
                return true;
            } else {
//                System.out.println("isNotEmpty");
                return false;
            }
        }
    }
}
