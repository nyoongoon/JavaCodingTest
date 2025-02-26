package _2_Java_Algo_Interview._5_데크_우선순위큐;

/**
 * 내풀이엔 front로 값을 가진 첫번쨰 노드로 관리했지만
 * 책풀이는 값이 없는 head, tail 노드로 관리함 -> null 예외 케이스가 없어서 구현 더 간단함
 */
public class _1_원형데크_디자인_내풀이 {
    public static void main(String[] args) {

    }
    class MyCircularDeque {
        class Node{
            int val;
            Node prev;
            Node next;
            Node(int val, Node prev, Node next){
                this.val = val;
                this.prev = prev;
                this.next = next;
            }
        }
        Node front;
        int curSize;
        int maxSize;

        public MyCircularDeque(int k) {
            front = null;
            curSize = 0;
            maxSize = k;
        }

        public boolean insertFront(int value) {
            if(isFull()){
                return false;
            }
            if(isEmpty()){
                front = new Node(value, null, null);
            }else if(curSize == 1){
                Node curNode = new Node(value, front, front);
                front.next = curNode;
                front.prev = curNode;
                front = curNode;
            }else{
                Node prevNode = front.prev;
                Node curNode = new Node(value, prevNode, front);
                front.prev = curNode;
                prevNode.next = curNode;
                front = curNode;
            }

            curSize++;
            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()){
                return false;
            }

            if(isEmpty()){
                front = new Node(value, null, null);
            }else if(curSize == 1){
                Node curNode = new Node(value, front, front);
                front.prev = curNode;
                front.next = curNode;
            }else{
                Node prevNode = front.prev;
                Node curNode = new Node(value, prevNode, front);
                prevNode.next = curNode;
                front.prev = curNode;
            }
            curSize++;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }
            if(curSize == 1){
                front = null;
            }else if (curSize == 2){
                Node nextNode = front.next;
                nextNode.prev = null;
                nextNode.next = null;
                front = nextNode;
            }else{
                Node nextNode = front.next;
                Node prevNode = front.prev;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                front = nextNode;
            }

            curSize--;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }
            if(curSize == 1){
                front = null;
            }else if (curSize == 2){
                front.prev = null;
                front.next = null;
            }else{
                Node targetNode = front.prev;
                Node prevNode = targetNode.prev;
                prevNode.next = front;
                front.prev = prevNode;
            }

            curSize--;
            return true;
        }

        public int getFront() {
            if(isEmpty()){
                return -1;
            }
            return front.val;
        }

        public int getRear() {
            if(isEmpty()){
                return -1;
            }
            if(curSize == 1){
                return front.val;
            }else{
                return front.prev.val;
            }
        }

        public boolean isEmpty() {
            if(curSize == 0){
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if(curSize == maxSize){
                return true;
            }
            return false;
        }
    }
}
