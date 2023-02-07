package Base_Algorithm.Chapter2_Linear.LinearDS_08.src;// Practice2
// 배열을 이용한 기본 큐 직접 구현 (원형 큐)

class MyQueue2 {
    int[] arr;
    int front = 0;// 원형 큐 관리를 위해 일단 front는 비워둠 !!!!! => 배열길이 size + 1
    int rear = 0;//rear는 마지막 값.


    MyQueue2(int size) {
        arr = new int[size + 1];
    }

    public boolean isEmpty() {
        if (front == rear) {
            return true;
        } else {
            return false;
        }
    }

    //
    public boolean isFull() {
        if ((rear + 1) % arr.length == front) {
            System.out.println("Queue is Full");
            return true;
        } else {
            return false;
        }
    }


    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            rear = (rear + 1) % arr.length;
            arr[rear] = data;
        }
    }


    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty !");
            return null;
        } else {
            front = (front + 1) % arr.length;
            return arr[front]; // 프론트는 논리적으로 빈 값
        }
    }

    public void printQueue() {
        int start = (front + 1) % arr.length;
        int end = (rear + 1) % arr.length;
        for (int i = start; i != end ; i = (i + 1) % arr.length) {
            System.out.print(arr[i] + " ");
        }
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
