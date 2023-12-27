package _Theory.Chapter2_Linear.LinearDS_08.src.my;

class MyQueue {
    int[] arr;
    int front; //배열로 만든 원형큐에서 front는 항상 비워둔다
    int rear;

    MyQueue(int size) {
        arr = new int[size + 1]; //front를 비워두므로 길이 + 1
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if ((rear + 1) % arr.length == front) {
            return true;
        }
        return false;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full ...");
            return;
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = data;
    }

    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty ...");
            return null;
        }
        front = (front + 1) % arr.length;
        return arr[front];
    }

    public void printQueue() {
        int start = (front + 1) % arr.length;
        int end = (rear + 1) % arr.length; //rear는 자체에 마지막 값이 있으므로 rear+1 % arr.length은 출력하지 않는다.
        for (int i = start; i != end; i = (i + 1) % arr.length) { // 조건문 != end 주의!!!
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        MyQueue myQueue = new MyQueue(5);
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