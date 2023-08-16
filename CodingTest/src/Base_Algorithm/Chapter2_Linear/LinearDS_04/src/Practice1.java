package Base_Algorithm.Chapter2_Linear.LinearDS_04.src;// Practice1
// 단순 연결 리스트 구현 완성


public class Practice1 {
    public static void main(String[] args) {

//      Test code
        LinkedList2 myList = new LinkedList2(new Node(1, null));
        myList.showData();         // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();         // 1 2 3 4 5

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();         // 100 1 200 2 300 3 400 4 500 5

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();         // 1 2 3 4 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();         // List is empty!
    }
}

class LinkedList2 {
    Node head;

    LinkedList2(Node node) {
        this.head = node;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void showData() {
        if (isEmpty()) {
            System.out.println("data is empty !");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.nextNode;
        }
        System.out.println();
    }

    public void addData(int data) {
        if (isEmpty()) {
            this.head = new Node(data, null);
            return;
        }
        Node cur = this.head;
        while (cur.nextNode != null) {
            cur = cur.nextNode;
        }
        cur.nextNode = new Node(data, null);
    }

    public void addData(int data, int idx) {
        if (isEmpty()) {
            System.out.println("addData Error - Empty List");
            return;
        }
        Node prev = this.head;
        Node cur = this.head;

        while (cur != null) {
            if (idx == cur.data)
            prev = cur;
            cur = cur.nextNode;
        }

        if (cur == null) {
            System.out.println("Error - Not Found Idx !");
            return;
        }

        if (cur == head) {
            this.head = new Node(data, cur);
            return;
        }

        prev.nextNode = new Node(data, cur);
    }

    public void removeData(int idx) {
        if (isEmpty()) {
            System.out.println("Error - List is Empty !");
            return;
        }

        Node prev = this.head;
        Node cur = this.head;

        while (cur != null) {
            if (cur == this.head && cur.data == idx && cur.nextNode == null) {
                this.head = null;
                return;
            }
            if (cur == this.head && cur.data == idx) {
                this.head = cur.nextNode;
                return;
            }
            if (cur.data == idx) {
                prev.nextNode = cur.nextNode;
                return;
            }
            prev = cur;
            cur = cur.nextNode;
        }


        System.out.println("Error - Not Found Error");
        return;
    }
}