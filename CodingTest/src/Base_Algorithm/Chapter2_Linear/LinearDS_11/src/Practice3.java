package Base_Algorithm.Chapter2_Linear.LinearDS_11.src;// Practice2
// 데크 변형
// 기본 데크 구조에서 중간에 데이터를 추가하는 기능을 구현하세요.
// 단, 추가적인 자료구조 생성하지 말고 구현

// 입력 예시)
// 초기 데크 상태 (size: 5)
// -> 1, 2, 3, 4
// 중간 입력: 10
// 결과 데크
// -> 1, 2, 10, 3, 4


class MyDeque {
    int[] arr;
    int front;
    int rear;

    MyDeque(int size) {
        this.arr = new int[size + 1]; // front 빈칸이므로 하나 더 크게
    }

    public boolean isEmpty() {
        if (this.front == this.rear) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if ((this.rear + 1) % this.arr.length == this.front) {
            return true;
        } else {
            return false;
        }
    }


    public void addMiddle(int data) {
        if (this.isFull()) {
            System.out.println("Deque is full!");
            return;
        }
        int elements = this.rear - this.front;
        if (elements < 0) {
            elements = this.arr.length + elements;
        }

        int mid = (this.rear - elements / 2 + this.arr.length) % this.arr.length + 1;
        int start = (this.rear + 1) % this.arr.length;
        int end = (this.rear - elements / 2 + this.arr.length) % this.arr.length;

        for (int i = start; i != end; i=(i - 1 + this.arr.length) % this.arr.length) {
            this.arr[i] = this.arr[(i - 1 + this.arr.length) % this.arr.length];
        }
        this.arr[mid] = data;
        this.rear = (this.rear + 1) % this.arr.length;
    }

    public void addFirst(int data) {
        if (isFull()) {
            System.out.println("Deque is Full!");
        } else {
            this.arr[this.front] = data;  // front는 현재 위치에 삽입
            this.front = ((this.front - 1) + this.arr.length) % this.arr.length; // 0에서 마지막으로 가기.
        }
    }

    public void addLast(int data) {
        if (isFull()) {
            System.out.println("Deque is Full!");
        } else {
            this.rear = (this.rear + 1) % this.arr.length; // rear는 현재 + 1에 삽입
            this.arr[this.rear] = data;
        }
    }

    public Integer removeFirst() {
        if (isEmpty()) {
            System.out.println("Queue is Empty !");
            return null;
        } else {
            this.front = (this.front + 1) % this.arr.length;
            return this.arr[this.front];
        }
    }

    public Integer removeLast() {
        if (isEmpty()) {
            System.out.println("Queue is Empty !");
            return null;
        } else {
            int data = this.arr[this.rear];
            this.rear = ((this.rear - 1) + this.arr.length) % this.arr.length;
            return data;
        }
    }

    public void printDeque() {
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;
        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

}

public class Practice3 {
    public static void main(String[] args) {
        // Test code
        MyDeque myDeque1 = new MyDeque(5);
        myDeque1.addLast(1);
        myDeque1.addLast(2);
        myDeque1.addLast(3);
        myDeque1.addLast(4);
        myDeque1.printDeque();

        myDeque1.addMiddle(10);
        myDeque1.printDeque();

        MyDeque myDeque2 = new MyDeque(5);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.addLast(11);
        myDeque2.addLast(12);
        myDeque2.addLast(13);
        myDeque2.printDeque();

        myDeque2.addMiddle(100);
        myDeque2.printDeque();
    }
}
