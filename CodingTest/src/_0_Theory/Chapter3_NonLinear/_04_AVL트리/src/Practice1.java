package _0_Theory.Chapter3_NonLinear._04_AVL트리.src;// 비선형 자료구조 - 이진 탐색 트리_2
// AVL 트리 - 삽입

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int height;
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.height = 0;
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class AVLTree {
    Node head;

    public int getHeight(Node cur) {
        if (cur == null) {
            return -1;
        }
        return cur.height;
    }

    public int getBalance(Node cur) {
        if (cur == null) {
            return 0;
        }
        return getHeight(cur.left) - getHeight(cur.right);
    }

    public void insert(int data) {
        this.head = insert(data, this.head);
    }

    public Node insert(int data, Node cur) {
        if (cur == null) {
            return new Node(data, null, null);
        }

        if (data < cur.data) {
            cur.left = insert(data, cur.left);
        } else {
            cur.right = insert(data, cur.right);
        }

        cur.height = Math.max(getHeight(cur.left), getHeight(cur.right)) + 1;

        int bf = getBalance(cur);

        if (bf > 1 && data < cur.left.data) { // ll
            return rightRotate(cur);
        }
        if (bf < -1 && data > cur.right.data) { //rr
            return leftRotate(cur);
        }
        if (bf > 1 && data > cur.left.data) { //lr
            return leftRightRotate(cur);
        }
        if (bf < -1 && data < cur.right.data) { //rl
            return rightLeftRotate(cur);
        }

        return cur;
    }

    //부모 좌측의 우측으로
    public Node rightRotate(Node cur) { // ll
        Node lNode = cur.left;
        cur.left = lNode.right;
        lNode.right = cur;

        cur.height = Math.max(getHeight(cur.left), getHeight(cur.right)) + 1;
        lNode.height = Math.max(getHeight(lNode.left), getHeight(lNode.right)) + 1;
        return lNode;
    }

    public Node leftRotate(Node cur) { // rr
        Node rNode = cur.right;
        cur.right = rNode.left;
        rNode.left = cur;

        cur.height = Math.max(getHeight(cur.left), getHeight(cur.right)) + 1;
        rNode.height = Math.max(getHeight(rNode.left), getHeight(rNode.right)) + 1;
        return rNode;
    }

    public Node leftRightRotate(Node cur) {
        cur.left = leftRotate(cur.left);
        return rightRotate(cur);
    }

    public Node rightLeftRotate(Node cur) {
        cur.right = rightRotate(cur.right);
        return leftRotate(cur);
    }

    public void levelOrder(Node cur) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(cur);
        while (!queue.isEmpty()) {
            Node polled = queue.poll();
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
        // Test code
        AVLTree avl = new AVLTree();

        // Insert
        avl.insert(30);
        avl.insert(20);
        avl.insert(10);     // LL
        avl.levelOrder(avl.head);

        avl.insert(40);
        avl.insert(50);     // RR
        avl.levelOrder(avl.head);

        avl.insert(5);
        avl.insert(7);      // LR
        avl.levelOrder(avl.head);

        avl.insert(60);
        avl.insert(55);     // RL
        avl.levelOrder(avl.head);
    }
}
