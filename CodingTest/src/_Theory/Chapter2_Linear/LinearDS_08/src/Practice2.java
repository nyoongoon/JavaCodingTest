package _Theory.Chapter2_Linear.LinearDS_08.src;// Practice2
// 배열을 이용한 기본 큐 직접 구현 (원형 큐)

class MyQueue2 {
    int[] arr;
    int front;
    int rear;

    MyQueue2(int size) {
        arr = new int[size + 1];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
       if(front == rear){
           return true;
       }
       return false;
    }

    //
    public boolean isFull() {
        if((rear + 1) % arr.length == front){
            return true;
        }
        return false;
    }


    public void enqueue(int data) {
        if(isFull()){
            System.out.println("Queue is full ...");
            return;
        }

        arr[++rear%arr.length] = data;

    }


    public Integer dequeue() {
        if(isEmpty()){
            System.out.println("Queue is Empty ,,,");
            return null;
        }

        return arr[++front%arr.length];
    }

    public void printQueue() {
        int start = (front+1)%arr.length;
        int end = (rear+1)%arr.length;
        for (int i = start; i < end; i = (i+1)%arr.length) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        MyQueue2 myQueue = new MyQueue2(5);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.enqueue(6); // Queue is full!

        myQueue.printQueue();   // 1, 2, 3, 4, 5

        System.out.println(myQueue.dequeue());  // 1
        myQueue.printQueue();   // 2, 3, 4, 5

        System.out.println(myQueue.dequeue());  // 2
        myQueue.printQueue();   // 3, 4, 5

        myQueue.enqueue(6);
        myQueue.enqueue(7);
        myQueue.printQueue();   // 3, 4, 5, 6, 7

        System.out.println(myQueue.dequeue());  // 3
        System.out.println(myQueue.dequeue());  // 4
        System.out.println(myQueue.dequeue());  // 5
        myQueue.printQueue();   // 6, 7
        System.out.println(myQueue.dequeue());  // 6
        System.out.println(myQueue.dequeue());  // 7
        myQueue.dequeue();      // Queue is empty!
    }
}
