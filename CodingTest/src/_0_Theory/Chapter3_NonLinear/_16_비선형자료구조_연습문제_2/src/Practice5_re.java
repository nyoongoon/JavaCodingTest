package _0_Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.ArrayList;
import java.util.LinkedList;


public class Practice5_re {
    public static ArrayList<Boolean> solution(String[] queries, String pattern) {
        ///queries를 Trie에 넣고 pattern으로 search..
        // queries 순회 중 대문자가 등장하면 특정한 판단이 필요.. -> 아마도 다음 패턴의 문자와 일치하는가..?
        ArrayList<Boolean> result = new ArrayList<>();

        LinkedList<Node> ll = new LinkedList<>();
        extracted(ll, pattern);

        for (String str : queries) {
            result.add(check(ll, str));
//            System.out.println("=========");
        }


        return result;
    }

    private static Boolean check(LinkedList<Node> ll, String str) {
        Node cur = ll.getFirst();
        int idx = 0;
        while (cur != null && idx < str.length()) {
            char c = str.charAt(idx++);
            if (cur.data == c) { // 같은 경우 넘긴다
                cur = cur.next;
                continue;
            }
//            System.out.println(c);
            // 다른경우
            if (!Character.isLowerCase(c)) { // query가소문자이면 다음 query문자 아니면 return false;
                return false;
            }
        }
        //query에 남아있는 문자중 대문자 있으면 안됨.!
        while (idx < str.length()) {
            char c = str.charAt(idx++);
            if (Character.isUpperCase(c)) {
                return false;
            }
        }
        // node도 대문자 남아있으면 안됨
        while (cur != null) {
            if (Character.isUpperCase(cur.data)) {
                return false;
            }
            cur = cur.next;
        }

        return true;
    }

    private static void extracted(LinkedList<Node> ll, String pattern) {

        Node cur = null;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (i == 0) {
                cur = new Node(c);
                ll.add(cur);
                continue;
            }

            Node newNode = new Node(c);
            cur.setNext(newNode);
            cur = newNode;

            if (i == pattern.length() - 1) {
                cur.setTerminal();
            }
            ll.add(cur);
        }
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
        char data;
        Node next;
        boolean isTerminal;

        public Node(char data) {
            this.data = data;
            this.isTerminal = false;
        }

        public void setTerminal() {
            this.isTerminal = true;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
