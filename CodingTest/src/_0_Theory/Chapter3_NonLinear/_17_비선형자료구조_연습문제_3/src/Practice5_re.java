package _0_Theory.Chapter3_NonLinear._17_비선형자료구조_연습문제_3.src;

import java.util.HashMap;
import java.util.Map;

public class Practice5_re {
    public static double solution(String[] words) {
        int sum = 0;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words) {
            System.out.println(word);
            int result = trie.search(word);
            System.out.println(result);
            sum += result;
        }

        return (double) sum / words.length;
    }

    public static void main(String[] args) {
        // Test code
        String[] words = {"hell", "hello", "heaven", "java"};
        System.out.printf("%.2f\n", solution(words));   // (2 + 3 + 2 + 1) / 4 = 2.00

        words = new String[]{"abca", "abcb", "abcc"};  // (2 + 2 + 2) / 3 = 2.00
        System.out.printf("%.2f\n", solution(words));

        words = new String[]{"cloud", "cloudy", "rain", "rainy", "sun", "sunny"};
        System.out.printf("%.2f\n", solution(words));   // (1 + 2 + 1 + 2 + 1 + 2) / 6 = 1.50
    }

    // 현재 단어가 자식이 1개이고 terminal이 아니라면 continue

    static class Node {
        Map<Character, Node> children;
        boolean isTernimal;

        public Node() {
            this.children = new HashMap<>();
            this.isTernimal = false;
        }
    }

    static class Trie {
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
            cur.isTernimal = true;
        }

        public int search(String str) {
            int cnt = 0;
            Node cur = this.root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (!cur.children.containsKey(c)) {
                    return -1;
                }


                if (cur.children.size() == 1 && !cur.isTernimal) {
                    cur = cur.children.get(c);
                    if (cur == this.root) { // 루트인경우는 항상 + 1
                        cnt++;
                    }
                    continue;
                }


//                System.out.println("c == " + c);
                cur = cur.children.get(c);
                cnt++;
            }

            if (!cur.isTernimal) {
                return -1;
            }

            return cnt;
        }
    }
}
