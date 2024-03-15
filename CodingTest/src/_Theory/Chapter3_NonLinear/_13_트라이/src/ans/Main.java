package _Theory.Chapter3_NonLinear._13_트라이.src.ans;// 비선형 자료구조 - 트라이 (Trie)

import java.util.HashMap;
import java.util.Map;

class Node {
    Map<Character, Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie {
    Node head;

    public Trie() {
        this.head = new Node();
    }

    public void insert(String data) {
        Node cur = this.head;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            cur.child.putIfAbsent(c, new Node());
            cur = cur.child.get(c);

            if (i == data.length() - 1) { // 마지막 노드 terminal = true
                cur.isTerminal = true;
            }
        }
    }

    public boolean search(String data) {
        Node cur = this.head;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (!cur.child.containsKey(c)) {
                return false;
            }
            cur = cur.child.get(c);
            if (i == data.length() - 1 && cur.isTerminal) { //마지막 노드 terminal 여부
                return true;
            }
        }
        return false;
    }

    /**
     * trie의 delete 는 재귀로 ..
     */
    public void delete(String data) {
        if (!delete(this.head, data, 0)) {//boolean result는 삭제 여부
            System.out.println("삭제할 단어 " + data + " 없음");
            return;
        }
        System.out.println(data + " 삭제");
    }

    public boolean delete(Node cur, String data, int idx) {
        // idx == data.length()는 data 범위는 넘어섰고
        // 마지막 단어 노드의 terminal 여부 체크
        // head가 데이터를 갖고 있지 않으므로 마지막 노드의 idx == data.length()
        if (idx == data.length()) { // 종료 조건 - 마지막 노드 terminal 체크
            if (!cur.isTerminal) {
//                System.out.println("있지만 터미널 아님");
                return false;
            }
            cur.isTerminal = false; //실질적인 node의 remove()는 상위 스택에서
            return true;
        }

        char c = data.charAt(idx);
        if (!cur.child.containsKey(c)) { // 종료 조건 - 찾는 단어 없음
            return false;
        }

        // 재귀 작업 로직
        Node nextNode = cur.child.get(c);
        boolean isDeleted = delete(nextNode, data, idx + 1);

        // 재귀 스택 없애면서 (트리 올라가면서) terminal 아닌 child.isEmpty 파악 -> 삭제여부는 상관x
        if (!nextNode.isTerminal && nextNode.child.isEmpty()) {
//            System.out.println("터미널 아닌 빈 노드 삭제 => c == " + c);
            cur.child.remove(c); //nextNode 삭제
        }

        return isDeleted;
    }
}

public class Main {
    public static void main(String[] args) {// 정답
        // Test code
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("april");
        trie.insert("ace");
        trie.insert("bear");
        trie.insert("best");

        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("april"));   // true
        System.out.println(trie.search("app"));      // false
        trie.insert("app");
        System.out.println(trie.search("app"));      // true
        System.out.println(trie.search("ace"));     // true
        System.out.println(trie.search("bear"));    // true
        System.out.println(trie.search("best"));    // true
        System.out.println(trie.search("abc"));     // false
////
        System.out.println();
        trie.delete("app");
        System.out.println(trie.search("apple"));   // true
        trie.delete("apple");
        System.out.println(trie.search("apple"));   // false
        System.out.println(trie.search("april"));   // true
        System.out.println(trie.search("appl"));    // false
        trie.delete("apple"); //삭제할 단어 apple 없음
        trie.delete("app"); //삭제할 단어 app 없음
        trie.insert("application");
        System.out.println(trie.search("application")); // true
        trie.delete("application");
        System.out.println(trie.search("application")); // false
    }
}
