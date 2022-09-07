package Basic;// 배열을 이용한 기본 데크 직접 구현

class MyDeque2 {
    int[] arr;
    int front = 0;
    int rear = 0;
    public MyDeque2(int size){
        this.arr = new int[size + 1];
    }

    public boolean isEmpty() {
        if(front == rear){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull() {
        if((rear + 1) % arr.length == front){
            return true;
        }else{
            return false;
        }
    }

    public void addFirst(int data) {
        if(isFull()){
            System.out.println("Queue is Full");
        }else{
            arr[front] = data;
            front = ((front - 1) + arr.length) % arr.length;
        }
    }

    public void addLast(int data) {
        if(isFull()){
            System.out.println("Queue is Full");
        }else{
            rear = (rear + 1) % arr.length;
            arr[rear] = data;
        }

    }

    public Integer removeFirst() {
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }else{
            front = (front + 1) % arr.length;
            return arr[front];
        }
    }

    public Integer removeLast() {
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }else{
            int data = arr[rear];
            rear = ((rear - 1) + arr.length) % arr.length;
            return data;
        }
    }


    public void printDeque() {
        int start = (front + 1) % arr.length;
        int end = (rear + 1) % arr.length;
        for (int i = start; i != end; i = (i + 1) % arr.length) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class MyDeque {
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
