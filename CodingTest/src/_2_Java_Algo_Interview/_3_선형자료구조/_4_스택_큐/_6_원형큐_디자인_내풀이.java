package _2_Java_Algo_Interview._3_선형자료구조._4_스택_큐;

/**
 * 프론트 비어있는 개념으로 암기했으므로
 * - 책에 있는 풀이는 기록하지 않음 (다른 방식으로 구현)
 */
public class _6_원형큐_디자인_내풀이 {
    public static void main(String[] args) {

    }
    class MyCircularQueue {
        int[] cirQue;
        int front; //프론트는 비어있는 개념
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
            rear = (rear + 1) % cirQue.length; //front 비어있도록 rear 올린다음에 삽입 주의
            cirQue[rear] = value;
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
            return cirQue[(front + 1) % cirQue.length];
        }

        public int Rear() {
            if(isEmpty()){
                return -1;
            }

            return cirQue[rear];
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
