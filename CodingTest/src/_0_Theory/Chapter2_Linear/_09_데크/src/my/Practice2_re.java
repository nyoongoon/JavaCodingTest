package _0_Theory.Chapter2_Linear._09_데크.src.my;// Practice2
// 배열을 이용한 기본 데크 직접 구현

class MyDeque_re {
    int[] arr;
    int front;
    int rear;

    public MyDeque_re(int size) {
        this.arr = new int[size + 1];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isFull() {
        if ((rear + 1) % arr.length == front) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    public void addFirst(int data) {
        if (isFull()) {
            System.out.println("queue is full..");
            return;
        }
        arr[front] = data;
        front = (front - 1 + arr.length) % arr.length;
    }


    public void addLast(int data) {
        if (isFull()) {
            System.out.println("queue is full..");
            return;
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = data;
    }


    public Integer removeFirst() {
        if (isEmpty()) {
            System.out.println("queue is empty..");
            return null;
        }
        front = (front + 1) % arr.length;
        return arr[front];
    }

    public Integer removeLast() {
        if (isEmpty()) {
            System.out.println("queue is empty..");
            return null;
        }
        int target = arr[rear];
        rear = (rear - 1 + arr.length) % arr.length;
        return target;
    }

    public void printDeque() {
        int start = (front + 1) % arr.length;
        int end = rear;
        for (int i = start; i != (end + 1) % arr.length; i = (i + 1) % arr.length) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

public class Practice2_re {
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
