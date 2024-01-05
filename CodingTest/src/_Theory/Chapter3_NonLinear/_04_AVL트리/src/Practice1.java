package _Theory.Chapter3_NonLinear._04_AVL트리.src;// 비선형 자료구조 - 이진 탐색 트리_2
// AVL 트리 - 삽입

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    int height;
    Node left;
    Node right;

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.height = 0;
        this.left = left;
        this.right = right;
    }
}

class AVLTree {
    Node head;

    public int height(Node node) {
        // 노드가 null일 때 높이는 -1
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // LL 케이스
    public Node rightRotate(Node node) { // 부모노드를 좌측자식의 우측으로
        Node lNode = node.left;
        node.left = lNode.right;
        lNode.right = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        lNode.height = Math.max(height(lNode.left), height(lNode.right)) + 1;

        return lNode;
    }

    //RR 케이스
    public Node leftRotate(Node node) { // 부모노드를 우측자식의 좌측으로
        Node rNode = node.right;
        node.right = rNode.left;
        rNode.left = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        rNode.height = Math.max(height(rNode.left), height(rNode.right)) + 1;

        return rNode;
    }

    //LR 케이스
    public Node lrRotate(Node node) {
        //node.left를 부모노드로 보고 한 번 leftRotate
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    //RL 케이스
    public Node rlRotate(Node node) {
        //node.right를 부모노드로 보고 한 번 rightRotate
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right); //왼쪽자식높이 - 오른쪽자식높이
    }

    public void insert(int key) {
        this.head = insert(this.head, key); // 회전 시 헤드 바뀔 케이스 있으므로
    }

    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key, null, null);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        // 리프에서 추가되었으므로 높이 다시 계산
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int bf = getBalance(node);
        if (bf > 1 && key < node.left.key) { // ll
            return rightRotate(node);
        }
        if (bf < -1 && key > node.right.key) { // rr
            return leftRotate(node);
        }
        if (bf > 1 && key > node.left.key) { // lr
            return lrRotate(node);
        }
        if (bf < -1 && key < node.right.key) { // rl
            return rlRotate(node);
        }

        //회전 안하면 그냥 현재 node 리턴
        return node;
    }

    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            System.out.print(cur.key + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
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
