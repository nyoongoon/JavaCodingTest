package _0_Theory.Chapter2_Linear._04_연결리스트_연습문제.src.P4;
// Practice4
// 연결 리스트 배열 사용 연습

// 주어진 문자열 배열을 연결 리스트 배열로 관리하는 코드를 작성하시오.
// 관리 규칙은 다음과 같다.
// 각 문자열의 첫 글자가 같은 것끼리 같은 연결 리스트로 관리하기


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Node {
    String data;
    Node next;

    Node() {
    }

    Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;
    char alphabet;

    LinkedList() {
    }

    LinkedList(Node node, char alphabet) {
        this.head = node;
        this.alphabet = alphabet;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addData(String data) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur;
        while (cur != null) {
            if (cur.data.equals(data)) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }

    public boolean findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return false;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.data.equals(data)) {
                System.out.println("Data exist!");
                return true;
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
        return false;
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

public class Practice4 {

    public static void dataCollect(String[] data) {
        Set<Character> set = new HashSet<>();
        Arrays.stream(data)
                .map(x -> set.add(x.charAt(0)));
        Arrays.stream(data).forEach(x -> set.add(x.charAt(0)));

        LinkedList[] linkedLists = new LinkedList[set.size()];

        for (String str : data) {
            for (int i = 0; i < linkedLists.length; i++) {
                if (linkedLists[i] == null) {
                    linkedLists[i] = new LinkedList(new Node(str, null), str.charAt(0));
                    break;
                }

                if(linkedLists[i].alphabet == str.charAt(0)){
                    linkedLists[i].addData(str);
                    break;
                }
            }
        }


       for (LinkedList list : linkedLists){
           list.showData();
           System.out.println();
       }


    }

    public static void main(String[] args) {
        // Test code
        String[] input = {"apple", "watermelon", "banana", "apricot", "kiwi", "blueberry", "cherry", "orange"};
        dataCollect(input);

        System.out.println();
        String[] input2 = {"ant", "kangaroo", "dog", "cat", "alligator", "duck", "crab", "kitten", "anaconda", "chicken"};
        dataCollect(input2);

    }
}
