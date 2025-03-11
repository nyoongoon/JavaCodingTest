package _2_Java_Algo_Interview._3_선형자료구조._5_데크_우선순위큐;

/**
 * 내풀이엔 front로 값을 가진 첫번쨰 노드로 관리했지만
 * 책풀이는 값이 없는 head, tail 노드로 관리함 -> null 예외 케이스가 없어서 구현 더 간단함
 */
public class _1_원형데크_디자인_책풀이 {
    public static void main(String[] args) {

    }
    class MyCircularDeque {
        class Node {
            Node left;
            Node right;
            int val;
            Node(int val){
                this.val = val;
            }
        }
        Node head;
        Node tail;
        int len;
        int k;
        public MyCircularDeque(int k) {
            head = new Node(0);
            tail = new Node(0);
            head.right = tail;
            tail.left = head;
            len = 0;
            this.k = k;
        }

        public boolean insertFront(int value) {
            if(isFull()){
                return false;
            }
            Node newNode = new Node(value);
            newNode.left =head;
            newNode.right = head.right;
            head.right.left = newNode;
            head.right = newNode;
            len++;
            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()){
                return false;
            }
            Node newNode = new Node(value);
            newNode.left = tail.left;
            newNode.right = tail;
            tail.left.right = newNode;
            tail.left = newNode;
            len++;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }
            head.right.right.left = head;
            head.right = head.right.right;
            len--;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }
            tail.left.left.right = tail;
            tail.left = tail.left.left;
            len--;
            return true;
        }

        public int getFront() {
            if(isEmpty()){
                return -1;
            }
            return head.right.val;
        }

        public int getRear() {
            if(isEmpty()){
                return -1;
            }
            return tail.left.val;
        }

        public boolean isEmpty() {
            if(len == 0){
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if(len == k){
                return true;
            }
            return false;
        }
    }
}
