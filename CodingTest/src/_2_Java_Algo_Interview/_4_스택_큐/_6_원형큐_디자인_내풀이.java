package _2_Java_Algo_Interview._4_스택_큐;

public class _6_원형큐_디자인_내풀이 {
    public static void main(String[] args) {

    }
    class MyCircularQueue {
        int[] cirQue;
        int front;
        int rear;
        public MyCircularQueue(int k) {
            cirQue = new int[k + 1];
            front = 0;
            rear = 0;
        }

        public boolean enQueue(int value) {
            if(isFull()){
                return false;
            }
            cirQue[rear] = value;
            rear = (rear + 1) % cirQue.length;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }
            front = (front + 1) % cirQue.length;
            return true;
        }

        public int Front() {
            if(isEmpty()){
                return -1;
            }
            return cirQue[front];
        }

        public int Rear() {
            if(isEmpty()){
                return -1;
            }
            int rearIdx = (rear - 1 + cirQue.length) % cirQue.length;
            return cirQue[rearIdx];
        }

        public boolean isEmpty() {
            if(front == rear){
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if((rear + 1) % cirQue.length == front){
                return true;
            }
            return false;
        }
    }
}
