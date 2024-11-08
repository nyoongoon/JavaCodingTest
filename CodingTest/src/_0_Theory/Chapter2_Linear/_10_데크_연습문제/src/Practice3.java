package _0_Theory.Chapter2_Linear._10_데크_연습문제.src;// Practice2
// 데크 변형
// 기본 데크 구조에서 중간에 데이터를 추가하는 기능을 구현하세요.
// 단, 추가적인 자료구조 생성하지 말고 구현

// 입력 예시)
// 초기 데크 상태 (size: 5)
// -> 1, 2, 3, 4
// 중간 입력: 10     //데크 크기 증가는 아님...
// 결과 데크
// -> 1, 2, 10, 3, 4

// front(0)       rear(4)
//         1, 2, 4, 5

//         rear(1) front(2)
//         2, 3,            1, 2

// front에서 rear까지 for문 돌고 돈 결과의 /2 한 값으로 중간 길이를 찾아야할거같은데..

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
        if (isFull()) {
            return;
        }

        int size = 0;
        int start = (front + 1) % arr.length;
        int end = (rear + 1) % arr.length;
        for (int i = start; i != end; i = (i + 1) % arr.length) {
            size++;
        }

        int idx = start;
        for (int i = 0; i < size / 2; i = (i + 1) % arr.length) {
            idx = (idx + 1) % arr.length;
        }


        for (int i = idx; i != (end + 1) % arr.length; i = (i + 1) % arr.length) {
            int tmp = arr[i];
            arr[i] = data;
            data = tmp;
        }

//        rear++; // 리어 1증가 << 이렇게 증가하면 안됨...
        rear = (rear + 1) % arr.length;
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
        MyDequeRe myDequeRe1 = new MyDequeRe(5);
        myDequeRe1.addLast(1);
        myDequeRe1.addLast(2);
        myDequeRe1.addLast(3);
        myDequeRe1.addLast(4);
        myDequeRe1.printDeque();

        myDequeRe1.addMiddle(10);
        myDequeRe1.printDeque();

        MyDequeRe myDequeRe2 = new MyDequeRe(5);
        myDequeRe2.addLast(10);
        myDequeRe2.addLast(10);
        myDequeRe2.addLast(10);
        myDequeRe2.addLast(10);
        myDequeRe2.addLast(10);
        myDequeRe2.removeFirst();
        myDequeRe2.removeFirst();
        myDequeRe2.removeFirst();
        myDequeRe2.removeFirst();
        myDequeRe2.addLast(11);
        myDequeRe2.addLast(12);
        myDequeRe2.addLast(13);
        myDequeRe2.printDeque();

        myDequeRe2.addMiddle(100);
        myDequeRe2.printDeque();
    }
}
