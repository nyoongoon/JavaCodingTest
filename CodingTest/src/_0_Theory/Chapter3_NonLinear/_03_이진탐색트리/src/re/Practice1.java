package _0_Theory.Chapter3_NonLinear._03_이진탐색트리.src.re;// Practice1
// 앞의 BST 삽입, 삭제 코드를 재귀 형태로 구현

import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    int data;
    Node2 left;
    Node2 right;

    public Node2(int data, Node2 left, Node2 right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree2 {
    Node2 head;

    public BinarySearchTree2(int data) {
        this.head = new Node2(data, null, null);
    }


    public Node2 addNodeRecursive(Node2 cur, int data) {
        if (cur == null) {
            return new Node2(data, null, null);
        }
        if (data < cur.data) {
            cur.left = addNodeRecursive(cur.left, data);
        } else {
            cur.right = addNodeRecursive(cur.right, data);
        }
        return cur;
    }


    public Node2 removeNodeRecursive(Node2 cur, int data) {

        if (data < cur.data) {
            cur.left = removeNodeRecursive(cur.left, data);
        } else if (data > cur.data) {
            cur.right = removeNodeRecursive(cur.right, data);
        } else {
            Node2 target = cur;
            // 자식이 없거나 하나
            if (target.left == null) {
                if (target == this.head) { //헤드 설정 주의
                    this.head = target.right;
                }
                return target.right; //nullable
            } else if (target.right == null) {
                if (target == this.head) { //헤드 설정 주의
                    this.head = target.left;
                }
                return target.left; //nullable
            } else { // 자식이 둘
                Node2 changeTarget = target.left;
                Node2 changeTargetParent = target;

                while (changeTarget.right != null) {
                    changeTargetParent = changeTarget;
                    changeTarget = changeTarget.right;
                }

                target.data = changeTarget.data;
                if (changeTargetParent == target) {
                    changeTargetParent.left = changeTarget.left;
                } else {
                    changeTargetParent.right = changeTarget.left;
                }
            }
        }

        return cur;
    }

    public void levelOrder(Node2 cur) {
        if (cur == null) {
            System.out.println("현재 노드가 null");
            return;
        }
        Queue<Node2> queue = new LinkedList<>();
        queue.add(cur);
        while (!queue.isEmpty()) {
            Node2 polled = queue.poll();
            System.out.print(polled.data + " ");
            if (polled.left != null) {
                queue.add(polled.left);
            }
            if (polled.right != null) {
                queue.add(polled.right);
            }
        }
        System.out.println();
    }
}


public class Practice1 {
    public static void main(String[] args) {
//        // Test code
//        // 노드 삽입
        BinarySearchTree2 bst = new BinarySearchTree2(20);
        bst.head = bst.addNodeRecursive(bst.head, 10);
        bst.head = bst.addNodeRecursive(bst.head, 30);
        bst.head = bst.addNodeRecursive(bst.head, 1);
        bst.head = bst.addNodeRecursive(bst.head, 15);
        bst.head = bst.addNodeRecursive(bst.head, 25);
        bst.head = bst.addNodeRecursive(bst.head, 13);
        bst.head = bst.addNodeRecursive(bst.head, 35);
        bst.head = bst.addNodeRecursive(bst.head, 27);
        bst.head = bst.addNodeRecursive(bst.head, 40);
        bst.levelOrder(bst.head);

//        // 노드 삭제
        bst.removeNodeRecursive(bst.head, 40);
        bst.levelOrder(bst.head);
        bst.removeNodeRecursive(bst.head, 25);
        bst.levelOrder(bst.head);
        bst.removeNodeRecursive(bst.head, 20);
        bst.levelOrder(bst.head);

        BinarySearchTree2 bst2 = new BinarySearchTree2(99);
        bst2.removeNodeRecursive(bst2.head, 99);
        bst2.levelOrder(bst2.head); //null
    }
}
