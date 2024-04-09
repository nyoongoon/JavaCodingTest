package _Theory.Chapter3_NonLinear._17_비선형자료구조_연습문제_3.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice5 {
    public static double solution(String[] words) {
        Trie trie = new Trie();
//        Arrays.stream(words).forEach(trie::insert);
        for (String str : words) {
            trie.insert(str);
        }

        List<Integer> results = new ArrayList<>();

        for (String str : words) {
            results.add(trie.select(str));
        }
//        for (int num : results) {
//            System.out.print(num + " ");
//        }

        return (double) results.stream().mapToInt(e -> e).sum() / results.size();
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

    static class Node {
        Map<Character, Node> child;
        boolean isTerminal;

        public Node() {
            this.child = new HashMap<>();
            this.isTerminal = false;
        }
    }

    static class Trie {
        Node head;

        public Trie() {
            this.head = new Node();
        }

        public void insert(String word) {
            Node cur = this.head;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
//                System.out.println("c == " + c);
                if (!cur.child.containsKey(c)) {
                    cur.child.put(c, new Node());
                }
                cur = cur.child.get(c);
            }
            cur.isTerminal = true;
        }

        public int select(String target) {
            //root의 자식이 하나면 +1 하고 시작 (카운트에 넣어야하는데 카운트가 안됨)
            int times = this.head.child.size() == 1 ? 1 : 0;
            Node cur = this.head;
            for (int i = 0; i < target.length(); i++) {

                char c = target.charAt(i);
                if (!cur.child.containsKey(c)) {
                    return -1;
                }
                if (cur.child.size() != 1 || cur.isTerminal) {
//                    System.out.println("size!=1 || cur.isTerminal => " + c);
                    times++;
                } else {
//                    System.out.println("size==1 => " + c);
                }
                cur = cur.child.get(c);
            }
            if (!cur.isTerminal) {
                return -1;
            }
            // 마지막 단어
            return times;
        }
    }
}
