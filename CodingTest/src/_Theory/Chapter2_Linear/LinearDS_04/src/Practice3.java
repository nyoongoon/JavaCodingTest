package _Theory.Chapter2_Linear.LinearDS_04.src;// Practice3
// 원형 연결 리스트 (Circular Linked List) 구현

class CircularLinkedList {
    NodeBi head;
    NodeBi tail;

    CircularLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;

        this.head.prev = tail;
        this.head.next = tail;
//
//        this.tail.next = head;
//        this.tail.prev = head;
    }

    // 전체 조회
    void showData() {
        if (this.head == null) {
            System.out.println("List is Empty !!");
            return;
        }

        NodeBi cur = this.head;
        System.out.print(cur.data + " ");
        cur = cur.next;

        while (cur != this.head) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    // 연결 리스트에 데이터 추가
    // before_data 가 null 인 경우, 가장 뒤에 추가
    // before_data 에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    void addData(int data, Integer beforeData) {
        if (this.head == null) {
            NodeBi nodeBi = new NodeBi(data, null, null);
            this.head = nodeBi;
            this.tail = nodeBi;
            nodeBi.next = nodeBi;
            nodeBi.prev = nodeBi;
            return;
        }
        if (beforeData == null) {
            NodeBi nodeBi = new NodeBi(data, head, tail);

            this.tail.next = nodeBi;
            this.tail = nodeBi;
            this.head.prev = this.tail;
            return;
        }

        NodeBi cur = this.head;
        do {
//            if (cur.data == beforeData && cur == head && cur == tail) {
//                NodeBi nodeBi = new NodeBi(data, head, head);
//                this.head.prev = nodeBi;
//                this.head.next = nodeBi;
//
//                this.tail = nodeBi;
//
//                break;
//            }
            if (cur.data == beforeData && cur == head) {
                NodeBi nodeBi = new NodeBi(data, head, tail);
                head.prev = nodeBi;
                tail.next = nodeBi;
                head = nodeBi;
                break;
            }
//            if (cur.data == beforeData && cur == tail) {
//                NodeBi nodeBi = new NodeBi(data, head, tail);
//
//                break;
//            }
            if (cur.data == beforeData) {
                NodeBi nodeBi = new NodeBi(data, cur, cur.prev);
                cur.prev.next = nodeBi;
                cur.prev = nodeBi;
                break;
            }

            cur = cur.next;
        } while (cur != this.head);
    }


    //  연결 리스트에서 특정 값을 가진 노드 삭제
    void removeData(int data) {
        if(this.head == null){
            System.out.println("Empty!");
            return;
        }
        NodeBi cur = this.head;

        while (cur != null) {
            if (cur.data == data && cur == head && cur == tail) { // 삭제 시 이부분 체크 (추가 시엔 안하네..)
                this.head = null;
                this.tail = null;
                break;
            }

            if (cur.data == data && cur == head) {
                this.tail.next = head.next;
                this.head.next.prev = this.tail;
                this.head = head.next;
                break;
            }

            if (cur.data == data && cur == tail) {
                this.tail.prev.next = this.head;
                this.head.prev = this.tail.prev;
                this.tail = this.tail.prev;
                break;
            }

            if (cur.data == data) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                break;
            }

            cur = cur.next;
        }
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
