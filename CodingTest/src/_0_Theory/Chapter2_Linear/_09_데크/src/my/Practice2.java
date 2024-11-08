package _0_Theory.Chapter2_Linear._09_데크.src.my;// Practice2
// 배열을 이용한 기본 데크 직접 구현

class MyDeque {
    int[] arr;
    int front;
    int rear;

    MyDeque(int size) {
        arr = new int[size + 1]; //front 비어있으므로 + 1
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % arr.length == front;
    }

    public void addFirst(int data) {
        if (isFull()) {
            System.out.println("Deque is full ...");
            return;
        }
        arr[front] = data; // front는 비어있는 개념이므로 들어갈 데이터 먼저 넣기
        front = (front - 1 + arr.length) % arr.length; // 원형일 경우 인덱스 마이너스 경우 주의
    }

    public void addLast(int data) {
        if (isFull()) {
            System.out.println("Deque is full ...");
            return;
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = data;
    }

    public Integer removeFirst() {
        if (isEmpty()) {
            System.out.println("Deque is empty ...");
            return null;
        }
        front = (front + 1) % arr.length;
        return arr[front]; //프론트는 비어있는 개념이므로...
    }

    public Integer removeLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty ...");
            return null;
        }
        int removeData = arr[rear];
        rear = (rear - 1 + arr.length) % arr.length;
        return removeData;
    }

    public void printDeque() {
        int start = front + 1;
        int end = rear + 1;
        for (int i = start; i != end; i = (i + 1) % arr.length) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        MyDeque_re myDequeRe = new MyDeque_re(5);
        // Front 부분 입력
        myDequeRe.addFirst(1);
        myDequeRe.addFirst(2);
        myDequeRe.addFirst(3);
        myDequeRe.printDeque();   // 3 2 1

        // Rear 부분 입력
        myDequeRe.addLast(10);
        myDequeRe.addLast(20);
        myDequeRe.addLast(30);    // Deque is full!
        myDequeRe.printDeque();        // 3 2 1 10 20

        // Front 부분 출력
        System.out.println(myDequeRe.removeFirst());  // 3
        myDequeRe.printDeque();   // 2 1 10 20

        // Rear 부분 출력
        System.out.println(myDequeRe.removeLast());   // 20
        myDequeRe.printDeque();    // 2 1 10

        System.out.println(myDequeRe.removeLast());   // 10
        System.out.println(myDequeRe.removeLast());   // 1
        System.out.println(myDequeRe.removeLast());   // 2
        System.out.println(myDequeRe.removeLast());   // Deque is empty!
    }
}
