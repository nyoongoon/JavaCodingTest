package _Theory.Chapter2_Linear._07_큐.src.my;

class MyQueue_re { //원형큐
    int[] arr;
    int front; // front는 한 칸 비움
    int rear; //rear는 마지막 인덱스.

    public MyQueue_re(int size) {
        arr = new int[size + 1];
        front = 0;
        rear = 0;
    }

    public void enqueue(int data) {
        if ((rear + 1) % arr.length == front) {
            System.out.println("queue is full..");
            return;
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = data;
    }

    public int dequeue() {
//        if((front + 1) % arr.length == rear){
        if (front == rear) { //프론트와 리어가 같으면 빈큐 -> (front + 1) % arr.length == rear는 길이가 1인 상태
            System.out.println("queue is empty ..");
        }
        front = (front + 1) % arr.length;
        return arr[front];
    }

    public void printQueue() {
        for (int i = (front + 1) % arr.length; i != (rear + 1) % arr.length; i = (i + 1) % arr.length) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // Test code
        MyQueue_re myQueue = new MyQueue_re(5);
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