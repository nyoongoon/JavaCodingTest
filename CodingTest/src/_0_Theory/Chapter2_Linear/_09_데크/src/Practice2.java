package _0_Theory.Chapter2_Linear._09_데크.src;// Practice2
// 배열을 이용한 기본 데크 직접 구현

class MyDeque2 {
    int[] arr;
    int front;
    int rear;

    MyDeque2(int size) {
        this.arr = new int[size + 1]; // front 빈칸이므로 하나 더 크게
    }

    public boolean isEmpty() {
        if(this.front == this.rear){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull() {
        if((this.rear + 1) % this.arr.length == this.front){
            return true;
        }else{
            return false;
        }
    }

    public void addFirst(int data) {
        if(isFull()){
            System.out.println("Deque is Full!");
        }else{
            this.arr[this.front] = data;  // front는 현재 위치에 삽입
            this.front = ((this.front - 1) + this.arr.length) % this.arr.length; // 0에서 마지막으로 가기.
        }
    }

    public void addLast(int data) {
        if(isFull()){
            System.out.println("Deque is Full!");
        }else{
            this.rear = (this.rear + 1) % this.arr.length; // rear는 현재 + 1에 삽입
            this.arr[this.rear] = data;
        }
    }

    public Integer removeFirst() {
        if(isEmpty()){
            System.out.println("Queue is Empty !");
            return null;
        }else{
            this.front = (this.front + 1) % this.arr.length;
            return this.arr[this.front];
        }
    }

    public Integer removeLast() {
        if(isEmpty()){
            System.out.println("Queue is Empty !");
            return null;
        }else{
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

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        MyDeque2 myDeque = new MyDeque2(5);
        // Front 부분 입력
        myDeque.addFirst(1);
        myDeque.addFirst(2);
        myDeque.addFirst(3);
        myDeque.printDeque();   // 3 2 1

        // Rear 부분 입력
        myDeque.addLast(10);
        myDeque.addLast(20);
        myDeque.addLast(30);    // Deque is full!
        myDeque.printDeque();        // 3 2 1 10 20

        // Front 부분 출력
        System.out.println(myDeque.removeFirst());  // 3
        myDeque.printDeque();   // 2 1 10 20

        // Rear 부분 출력
        System.out.println(myDeque.removeLast());   // 20
        myDeque.printDeque();    // 2 1 10

        System.out.println(myDeque.removeLast());   // 10
        System.out.println(myDeque.removeLast());   // 1
        System.out.println(myDeque.removeLast());   // 2
        System.out.println(myDeque.removeLast());   // Deque is empty!
    }
}
