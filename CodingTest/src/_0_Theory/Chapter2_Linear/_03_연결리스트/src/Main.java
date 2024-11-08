package _0_Theory.Chapter2_Linear._03_연결리스트.src;// 선형 자료구조 - 연결 리스트
// 단순 연결 리스트 (simple ver.) 기본 구조 구현

// 노드
class Node {
    int data;
    Node nextNode;

    Node(int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }
}

class LinkedList {
    Node head;

    LinkedList(Node head) {
        this.head = head;
    }

    Node findLastNode() {
        if (this.head == null) {
            System.out.println("head is null");
            return null;
        }

        Node curNode = this.head;
        while (curNode.nextNode != null) {
            curNode = curNode.nextNode;
        }
        return curNode;
    }

    //  연결 리스트 비어있는지 확인
    boolean isEmpty() {
        return (head == null);
    }

    //  연결 리스트의 맨 뒤에 데이터 추가
    void addData(int data) {
        Node newNode = new Node(data, null);

        Node lastNode = this.findLastNode();
        if (lastNode == null) {
            this.head = newNode;
            return;
        }
        lastNode.nextNode = newNode;
    }


    //  연결 리스트의 맨 뒤의 데이터 삭제
    void removeData() {
        if (this.head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curNode = this.head;
        if (curNode.nextNode == null) {
            this.head = null;
            return;
        }

        while (curNode.nextNode.nextNode != null) {
            curNode = curNode.nextNode;
        }
        curNode.nextNode = null;
    }

    void removeData2() {
        Node cur = this.head;
        Node prev = this.head;

        while (cur.nextNode != null) {
            prev = cur;
            cur = cur.nextNode;
        }

        if(cur == head){
            head.nextNode = null;
            return;
        }

        prev.nextNode = null;
    }

    //  연결 리스트에서 데이터 찾기
    Node findData(int data) {
        Node curNode = this.head;
//        if (curNode == null) {
//            System.out.println("data not found !");
//            return null;
//        }
        while (curNode != null) {
            if (curNode.data == data) {
                System.out.println("data exist !");
                return curNode;
            }
            curNode = curNode.nextNode;
        }
        System.out.println("data not found !");
        return null;
    }


    //  연결 리스트의 모든 데이터 출력
    void showData() {
        Node curNode = this.head;
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.nextNode;
        }
        System.out.println();
    }
}


public class Main {

    public static void main(String[] args) {

//      Test Code
        LinkedList myList = new LinkedList(new Node(1, null));
        myList.showData();      // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();      // 1 2 3 4 5
//
        myList.findData(3);     // Data exist!
        myList.findData(100);   // Data not found!
//
        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.showData();      // 1 2

        myList.removeData();
        myList.removeData();
        myList.removeData();    // List is empty

    }

}
