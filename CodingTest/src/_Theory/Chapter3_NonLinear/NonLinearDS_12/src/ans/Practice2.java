package _Theory.Chapter3_NonLinear.NonLinearDS_12.src.ans;// Practice2
// 문자열 배열 dictionary 와 문자열 sentence 가 주어졌을 때
// sentence 내의 단어 중 dictionary 의 단어로 시작하는 경우
// 해당 단어로 변경하여 출력하는 프로그램을 작성하세요.

// 입출력 예시
// 입력 dictionary: "cat", "bat", "rat"
// 입력 sentence = "the cattle was rattled by the battery"
// 출력: "the cat was rat by the bat"


// 입력 dictionary: "a", "b", "c"
// 입력 sentence = "apple banana carrot water"
// 출력: "a b c water"


import java.util.HashMap;
import java.util.Map;

public class Practice2 { // dictionary를 트라이로 구성하고 senetence 단어 순서대로 검색 중 terminal 만나면 그대로 출력..
    public static void solution(String[] dictionary, String sentence) {
        Trie trie = new Trie();
        for(String s : dictionary){
            trie.insert(s);
        }
        String[] strs = sentence.split(" ");
        for (String s : strs){
            System.out.println(trie.exchange(s));
        }
    }

    public static void main(String[] args) {
        // Test code
        String[] dictionary = {"cat", "bat", "rat"};
        String sentence = "the cattle was rattled by the battery";
        solution(dictionary, sentence);

        dictionary = new String[]{"a", "b", "c"};
        sentence = "apple banana carrot water";
        solution(dictionary, sentence);
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
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String str) {
            Node cur = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                cur.child.putIfAbsent(c, new Node());
                cur = cur.child.get(c);
            }
            cur.isTerminal = true;
        }

        public String exchange(String str) {
            StringBuffer sb = new StringBuffer();
            Node cur = root;
            for (int i = 0; i < str.length(); i++) {
                if(cur.isTerminal){
                    return sb.toString();
                }
                char c = str.charAt(i);
                if (!cur.child.containsKey(c)) {
                    return str;
                }
                sb.append(c);//자식에 있음..
                cur = cur.child.get(c);
            }
            return str;
        }
    }

}
