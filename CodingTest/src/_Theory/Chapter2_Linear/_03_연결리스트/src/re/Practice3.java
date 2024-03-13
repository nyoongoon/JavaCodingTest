package _Theory.Chapter2_Linear._03_연결리스트.src.re;// Practice3
// 원형 연결 리스트 (Circular Linked List) 구현

class CircularLinkedList {
    NodeBi head;
    NodeBi tail;

    CircularLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;

        this.head.next = tail;
        this.head.prev = tail;
    }

    // 전체 조회
    void showData() {
        if (this.head == null) {
            System.out.println("List is empty...");
            return;
        }
        if (this.head == this.tail) {
            System.out.println(this.head.data);
            return;
        }
        NodeBi cur = this.head;
        while (cur != this.tail) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println(this.tail.data);
    }


    // 연결 리스트에 데이터 추가
    // before_data 가 null 인 경우, 가장 뒤에 추가
    // before_data 에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    void addData(int data, Integer beforeData) {
        if (beforeData == null) {
            if (this.head == null) {
                this.head = new NodeBi(data, null, null);
                this.tail = this.head;
                this.head.next = this.tail;
                this.head.prev = this.tail;
                return;
            }
            if (this.head == this.tail) {
                System.out.println(this.head.data);
                this.head.next = new NodeBi(data, tail, head);
                this.tail.prev = this.head.next;
                return;
            }

            NodeBi cur = this.head;
            while (cur != tail) {
                cur = cur.next;
            }
            cur.next = new NodeBi(data, head, tail);
            this.tail = cur.next;
            this.head.prev = this.tail;

        } else {
            if (this.head.data == beforeData && this.head == this.tail) {
                this.head = new NodeBi(data, tail, tail);
                this.tail.prev = this.head;
                this.tail.next = this.head;
            }
            if (this.head.data == beforeData) {

            }
            NodeBi cur = this.head;
            NodeBi prev = cur;
            while (cur.data != beforeData) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = new NodeBi(data, prev, cur);
            cur.prev = prev.next;
        }


    }


    //  연결 리스트에서 특정 값을 가진 노드 삭제
    void removeData(int data) {

    }
}

public class Practice3 {
    public static void main(String[] args) {
        // Test code
        CircularLinkedList myList = new CircularLinkedList(new NodeBi(1, null, null));
        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.showData();  // 1 2 3 4 5

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();  // 100 1 200 2 300 3 400 4 500 5

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();          // 1 2 3 4 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();          // List is empty!
    }
}
