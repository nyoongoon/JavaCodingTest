package _Theory.Chapter3_NonLinear._13_트라이.src.ans;// 비선형 자료구조 - 트라이 (Trie)

import java.util.HashMap;

class Node { // 정답풀이...
    HashMap<Character, Node> child;
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
        Node cur = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            cur.child.putIfAbsent(c, new Node());
            cur = cur.child.get(c);
            if (i == str.length() - 1) {
                cur.isTerminal = true;
            }
        }
    }

    public boolean search(String str) {
        Node cur = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!cur.child.containsKey(c)) {
                return false;
            }
            if (i == str.length() - 1 && !cur.isTerminal) {
                return false;
            }
            cur = cur.child.get(c);
        }
        return true;
    }

    public void delete(String str) { // 재귀...
        delete(str, 0, root);
    }

    public boolean delete(String str, int idx, Node cur) {
        char c = str.charAt(idx); // child 에 맞게 idx 조정..??

        if (!cur.child.containsKey(c)) { // 없을 때 return
            return false;
        }
        if (idx == str.length() - 1 && cur.isTerminal) {
            cur.isTerminal = false;
            if (cur.child.isEmpty()) {
                return true;
            }else{
                return false;
            }
        }

        //terminal 처리는 했고 자식 노드 삭제 필요 체크..
        boolean isDeleted = delete(str, idx + 1, cur.child.get(c));

        if (isDeleted) {
            cur.child.remove(c);
        }

        return isDeleted;
    }
}

public class Main {
    public static void main(String[] args) {
        // Test code
        Trie trie = new Trie();
//        trie.insert("apple");
//        trie.insert("april");
//        trie.insert("app");
//        trie.insert("ace");
//        trie.insert("bear");
//        trie.insert("best");
//        System.out.println(trie.search("apple"));   // true
//        System.out.println(trie.search("april"));   // true
//        System.out.println(trie.search("app"));      // true
//        System.out.println(trie.search("ace"));     // true
//        System.out.println(trie.search("bear"));    // true
//        System.out.println(trie.search("best"));    // true
//        System.out.println(trie.search("abc"));     // false
//
//        System.out.println();
//        trie.delete("apple");
//        System.out.println(trie.search("apple"));   // false
//        System.out.println(trie.search("april"));   // true
//        System.out.println(trie.search("appl"));    // false
//        trie.delete("apple");
    }
}
