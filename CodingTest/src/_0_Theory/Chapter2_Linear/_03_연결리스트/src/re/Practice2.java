package _0_Theory.Chapter2_Linear._03_연결리스트.src.re;// Practice2
// 양방향 연결 리스트 (Doubly Linked List) 구현

class NodeBi {
    int data;
    NodeBi next;
    NodeBi prev;

    NodeBi(int data, NodeBi next, NodeBi prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList {
    NodeBi head;

    public DoublyLinkedList(NodeBi nodeBi) {
        this.head = nodeBi;
    }

    public void showData() {
        if (this.head == null) {
            System.out.println("데이터 없음");
            return;
        }
        NodeBi cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void showDataFromTail() {
        if (this.head == null) {
            System.out.println("데이터 없음");
            return;
        }
        NodeBi cur = head;
        NodeBi prev = cur;
        while (cur != null) {
            prev = cur;
            cur = cur.next;
        }

        while (prev != null) {
            System.out.print(prev.data + " ");
            prev = prev.prev;
        }
        System.out.println();
    }


    public void addData(int num, Integer data) {
        if (this.head == null) { //헤드인 경우
            this.head = new NodeBi(num, null, null);
            return;
        }
        NodeBi cur = head;
        NodeBi prev = cur;
        if (data == null) { //찾는 값 없는 경우
            while (cur != null) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = new NodeBi(num, null, prev);
        } else { // 찾는 값이 있는 경우
            while (true) {
                if (cur == null) {
                    System.out.println("찾으려는 값이 없음");
                    break;
                }
                if (cur.data == data) {
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
            if (cur == head) {
                head = new NodeBi(num, cur, null);
                cur.prev = head; // 기존 노드의 prev에 insert노드 추가 주의
            } else {
                prev.next = new NodeBi(num, cur, prev);
                cur.prev = prev.next; // 기존 노드의 prev에 insert노드 추가 주의
            }
        }
    }

    public void removeData(Integer data) {
        if (this.head == null) {
            System.out.println("연결리스트가 비어있음");
            return;
        }
        if (this.head.data == data) {
            if (this.head.next == null) { //연결리스트에 헤드만 있는 경우..
                this.head = null;
                return;
            }
            this.head = this.head.next;
            this.head.prev = null;
            return;
        }

        NodeBi cur = this.head;
        NodeBi prev = cur;
        while (true) {
            if (cur == null) {
                System.out.println("지우려는 값이 없음");
                break;
            }
            if (cur.data == data) {
                prev.next = cur.next;
                if (cur.next != null) { // 지우려는 노드가 마지막 노드가 아닌 경우
                    cur.next.prev = prev;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }
}


public class Practice2 {
    public static void main(String[] args) {

//      Test code
        DoublyLinkedList myList = new DoublyLinkedList(new NodeBi(1, null, null));
        myList.showData();          // 1

        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.showData();          // 1 2 3 4 5
        myList.showDataFromTail();  // 5 4 3 2 1

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();          // 100 1 200 2 300 3 400 4 500 5
        myList.showDataFromTail();  // 5 500 4 400 3 300 2 200 1 100

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();          // 1 2 3 4 5
        myList.showDataFromTail();  // 5 4 3 2 1

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();          // List is empty!
        myList.showDataFromTail();  // List is empty!
    }
}
