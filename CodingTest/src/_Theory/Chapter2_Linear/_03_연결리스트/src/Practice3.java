package _Theory.Chapter2_Linear._03_연결리스트.src;// Practice3
// 원형 연결 리스트 (Circular Linked List) 구현

class CircularLinkedList {
    NodeBi head;
    NodeBi tail;

    CircularLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;

        this.head.prev = tail;
        this.head.next = tail;
    }

    // 전체 조회
    void showData() {
        if (this.head == null) {
            System.out.println("List is Empty !!");
            return;
        }
        NodeBi cur = this.head;
        while (true) {
            System.out.print(cur.data + " ");
            cur = cur.next;
            if (cur == this.head) {
                break;
            }
        }
        System.out.println();
    }


    // 연결 리스트에 데이터 추가
    // before_data 가 null 인 경우, 가장 뒤에 추가
    // before_data 에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    /**
     * add()하거나 remove() 할때 기본적으로 head와 tail 부분 각각 고려를 다해줘야함
     * -> 논리적으로 합쳐지는 경우가 있긴 하나 원래는 각각 고려 상황.
     * 1. head == null // 요소 없는 경우
     * 2. target == head == tail
     * 3. target == head
     * 4. target == tail
     * 그 외 일반적인 경우
     *
     * @param data
     * @param beforeData
     */
    void addData(int data, Integer beforeData) {
        if (this.head == null) { // 요소 없는 경우
            NodeBi nodeBi = new NodeBi(data, null, null);
            this.head = nodeBi;
            this.tail = nodeBi;
            nodeBi.next = nodeBi;
            nodeBi.prev = nodeBi;
            return;
        }
        if (beforeData == null) { //맨 마지막에 추가만 하는 경우
            NodeBi nodeBi = new NodeBi(data, head, tail);
            this.tail.next = nodeBi;
            this.tail = nodeBi;
            this.head.prev = this.tail;
            return;
        }

        NodeBi cur = this.head;
        while (true) {
//            해당 로직은 아래 로직에 포함될 수 있음
//            if (cur.data == beforeData && cur == head && cur == tail) {
//                NodeBi nodeBi = new NodeBi(data, head, head);
//                this.head.prev = nodeBi;
//                this.head.next = nodeBi;
//                this.tail = nodeBi;
//                break;
//            }
            if (cur.data == beforeData && cur == this.head) {
                NodeBi nodeBi = new NodeBi(data, this.head, this.tail);
                this.head.prev = nodeBi;
                this.tail.next = nodeBi;
                this.head = nodeBi;
                break;
            }
//            cur == tail 이라고 해도 tail앞으로 들어가는 것이기 떄문에 head~tail 관계 변하지 않음.
//            if (cur.data == beforeData && cur == tail) {
//            }
            if (cur.data == beforeData) {
                NodeBi nodeBi = new NodeBi(data, cur, cur.prev);
                cur.prev.next = nodeBi;
                cur.prev = nodeBi;
                break;
            }

            cur = cur.next;
            if (cur == this.head) {
                System.out.println("찾고자 하는 요소 없음");
                break;
            }
        }
    }


    //  연결 리스트에서 특정 값을 가진 노드 삭제
    void removeData(int data) {
        if (this.head == null) { // 요소 없는 경우
            System.out.println("Empty!");
            return;
        }

        NodeBi cur = this.head;
        while (true) {
            if (cur.data == data && cur == this.head && cur == this.tail) { // 헤드 == 테일 없애는 경우
                this.head = null;
                this.tail = null;
                break;
            }
            if (cur.data == data && cur == this.head) { // 헤드 없애는 경우
                this.tail.next = head.next;
                this.head.next.prev = this.tail;
                this.head = head.next;
                break;
            }
            if (cur.data == data && cur == this.tail) { // 테일 없애는 경우
                this.tail.prev.next = this.head;
                this.head.prev = this.tail.prev;
                this.tail = this.tail.prev;
                break;
            }
            if (cur.data == data) { // 그 외
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                break;
            }

            cur = cur.next;
            if (cur == this.head) {
                System.out.println("삭제할 요소를 찾을 수 없음");
                break;
            }
        }
    }

    public void showDataFromTail() {
        if (this.head == null) {
            System.out.println("데이터 없음");
            return;
        }
        NodeBi cur = tail; // tail부터 시작
        while (true) {
            System.out.print(cur.data + " ");
            cur = cur.prev;
            if (cur == tail) {
                break;
            }
        }
        System.out.println();
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

        myList.addData(99, 5);
        myList.showDataFromTail(); // 5 99 4 3 2 1
        myList.addData(5, 6);
        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();  // 100 1 200 2 300 3 400 4 99 500 5

        myList.removeData(98);
        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();          // 1 2 3 4 99 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();          // 99

        myList.removeData(99);
        myList.showData();          // List is empty!
    }
}
