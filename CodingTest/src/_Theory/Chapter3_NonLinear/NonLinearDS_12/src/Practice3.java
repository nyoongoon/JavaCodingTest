package _Theory.Chapter3_NonLinear.NonLinearDS_12.src;// Practice3
// 문자열 배열 strs 와 targets 가 주어졌을 때
// targets 내의 단어 중 한 문자만 바꾸면 strs 중의 단어가 되는지 판별하는 프로그램을 작성하세요.

// 입출력 예시
// 입력 strs: "apple", "banana", "kiwi"
// 입력 target: "applk", "bpple", "apple"
// 출력: true, true, false


import java.util.HashSet;
import java.util.Set;

public class Practice3 {
    public static void solution(String[] strs, String[] targets) {
        Set<String> originSet = new HashSet<>();
        for(String s: strs){
            originSet.add(s);
        }
        for (int i = 0; i < targets.length; i++) {
            if(originSet.contains(targets[i])){
                targets[i] = "@";
            }
        }

//       트라이 구현하여 한 번만 건너 뛰기..? -> 건너 못뜀..
        Set<String> set = new HashSet<>();

        for (String s : strs) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
            }
            for (int i = 0; i < s.length(); i++) {
                char c = sb.charAt(i);
                sb.deleteCharAt(i);
                set.add(sb.toString());
                sb.insert(i, c);
            }
        }

        for (String s : targets) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
            }
            System.out.println(sb);
            for (int i = 0; i < s.length(); i++) {
                char c = sb.charAt(i);
                sb.deleteCharAt(i);
                if (set.contains(sb.toString())) {
                    System.out.println("true");
                    break;
                }
                sb.insert(i, c);
                if (i == s.length() - 1) {
                    System.out.println("false");
                }
            }
        }

//        System.out.println("true");
    }

    public static void main(String[] args) {
        // Test code
        String[] strs = {"apple", "banana", "kiwi"};
        String[] targets = {"applk", "bpple", "apple", "banan", "kiww"};
        solution(strs, targets);    // true, true, false, false, true
    }

//    static class Node {
//        Map<Character, Node> child;
//        boolean isTerminal;
//
//        public Node() {
//            this.child = new HashMap<>();
//            this.isTerminal = false;
//        }
//    }
//
//    static class Trie {
//        Node root;
//
//        public Trie() {
//            this.root = new Node();
//        }
//
//        public void insert(String str) {
//            Node cur = this.root;
//            for (int i = 0; i < str.length(); i++) {
//                char c = str.charAt(i);
//                if (!cur.child.containsKey(c)) {
//                    cur.child.putIfAbsent(c, new Node());
//                }
//                cur = cur.child.get(c);
//            }
//            cur.isTerminal = true;
//        }
//        // a
//        // b c  --> f ?
//        // c d
//
//        public boolean search(String str) {
//            int cnt = 0;
//            Node cur = this.root;
//            for (int i = 0; i < str.length(); i++) {
//                char c = str.charAt(i);
//                if(cur.child.containsKey(c)){
//                    cur = cur.child.get(c);
//                }else{
//                    if(cnt == 0){
//                        cnt++;
//                        continue;;
//                    }else{
//                        return false;
//                    }
//                }
//            }
//        }
//    }
}
