package Basic;// Practice4
// 연결 리스트 배열 사용 연습

// 주어진 문자열 배열을 연결 리스트 배열로 관리하는 코드를 작성하시오.
// 관리 규칙은 다음과 같다.
// 각 문자열의 첫 글자가 같은 것끼리 같은 연결 리스트로 관리하기


import java.util.ArrayList;
import java.util.HashSet;

class Node1 {
    String data;
    Node2 next;

    Node1() {}
    Node1(String data, Node2 next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList1 {
    Node2 head;
    char alphabet;

    LinkedList1() {}
    LinkedList1(Node2 Node1, char alphabet) {
        this.head = Node1;
        this.alphabet = alphabet;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addData(String data) {
        if (this.head == null) {
            this.head = new Node2(data, null);
        } else {
            Node2 cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node2(data, null);
        }
    }

    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node2 cur = this.head;
        Node2 pre = cur;
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

        Node2 cur = this.head;
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

        Node2 cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

public class LinkedListArray {

    public static void dataCollect(String[] data) {
        ArrayList<LinkedList2> al = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < data.length; i++) {
            char c = data[i].charAt(0);
            if(set.add(c)){
                LinkedList2 ll = new LinkedList2(new Node2(data[i], null), c);
                al.add(ll);
            }else{
                // 중복
                for (int j = 0; j < al.size(); j++) {
                    if(al.get(j).alphabet == c){
                        al.get(j).addData(data[i]);
                    }
                }

            }
        }

        for (int i = 0; i < al.size(); i++) {
            LinkedList2 ll = al.get(i);
            Node2 cur = ll.head;
            while(cur != null){
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
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
