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
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node cur = this.root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            cur.child.putIfAbsent(c, new Node());
            cur = cur.child.get(c);
        }
        cur.isTerminal = true; // 마지막 터미널 설정
    }

    public boolean search(String str) {
        Node cur = this.root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!cur.child.containsKey(c)) {
                return false;
            }
            cur = cur.child.get(c);
        }
        return cur.isTerminal; // 마지막 노드의 터미널 판단
    }

    public void delete(String str) {
        delete(str, 0, this.root);
    }

    public boolean delete(String str, int idx, Node cur) {
        // 문자열 마지막에서 terminal 체크.. -> 부모에서 childMap 체크하는 것이므로 idx==str.length
        if (idx == str.length() && cur.isTerminal) {
            cur.isTerminal = false;
            return cur.child.isEmpty(); //empty면 삭제 가능..
        }
       if(idx == str.length()){ //지났는데 terminal false
           System.out.println("not found...");
           return false;
       }

        // 문자열 존재 x 체크..
        char c = str.charAt(idx);
        if (!cur.child.containsKey(c)) {
            System.out.println("not found...");
            return false;
        }

        // 재귀적으로 result true (지워도 되는지 체크.. -> 자식 여부 && 현재 terminal 여부..
        boolean result = delete(str, idx + 1, cur.child.get(c));

        if(result){ //child Map empty && child 노드 !terminal
            cur.child.remove(c);
        }
        // 현재 노드의 empty와 terminal 체크..
        if(!cur.child.isEmpty() || cur.isTerminal){
            result = false;
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
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
        System.out.println(trie.search("ace"));     // true
        System.out.println(trie.search("bear"));    // true
        System.out.println(trie.search("best"));    // true
        System.out.println(trie.search("abc"));     // false
//
        System.out.println();
        trie.delete("apple");
        System.out.println(trie.search("apple"));   // false
        System.out.println(trie.search("april"));   // true
        System.out.println(trie.search("appl"));    // false
        trie.delete("apple");

        trie.insert("application");
        trie.delete("app");
    }
}
