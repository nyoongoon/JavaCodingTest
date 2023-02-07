package Base_CodingTest.W4;

import java.util.ArrayList;
import java.util.HashMap;

public class Week4_2_my_re {
    public static void main(String[] args) {
        Week4_2_my_re w = new Week4_2_my_re();
        String[] words = {"hello", "hell", "good", "goose", "children", "card", "teachable"};
        String[] queries = {"hell*", "goo*", "*able", "qua*"};
        int[] answer = w.solution(words, queries);
        for (int n : answer){
            System.out.print(n + " ");
        }
    }

    public int[] solution(String[] words, String[] queries) {
        Trie2 trie = new Trie2();
        int[] result = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            trie.makeTrie(words[i]);
            trie.makeTrieReverse(words[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            result[i] = trie.getResult(queries[i]);
        }
        return result;
    }

    class Node2 {
        char val;
        HashMap<Character, Node2> children;
        ArrayList<String> al;

        Node2(char val) {
            this.val = val;
            children = new HashMap<>();
            al = new ArrayList<>();
        }
    }

    class Trie2 {
        Node2 head;
        Node2 tail;
        Trie2() {
            this.head = new Node2(' ');
            this.tail = new Node2(' ');
            /*for (int i = 0; i < words.length; i++) {
                this.head.al.add(words[i]);
            }*/
        }

        void makeTrie(String word){
            Node2 cur = this.head;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!cur.children.containsKey(c)){
                    cur.children.put(c, new Node2(c));
                }
                cur = cur.children.get(c);
                cur.al.add(word);
            }
        }
        void makeTrieReverse(String word){
            Node2 cur = this.tail;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(word.length()-1 -i);
                if(!cur.children.containsKey(c)){
                    cur.children.put(c, new Node2(c));
                }
                cur = cur.children.get(c);
                cur.al.add(word);
            }
        }

        int getResult(String query) {
            if (query.charAt(0) != '*') {
                Node2 cur = this.head;
                for (int i = 0; i < query.length()-1; i++) {
                    char c = query.charAt(i);
                     if(!cur.children.containsKey(c)){
                         return 0;
                     }
                     cur = cur.children.get(c);
                }
                return cur.al.size();
            }else{
                Node2 cur = this.tail;
                for (int i = query.length()-1; i>= 0; i--) {
                    char c = query.charAt(i);
                    if(!cur.children.containsKey(c)){
                        return 0;
                    }
                    cur = cur.children.get(c);
                }
                return cur.al.size();
            }
        }
    }


}
