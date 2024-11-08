package _0_Theory.Chapter3_NonLinear._04_AVL트리.src.re;// 비선형 자료구조 - 이진 탐색 트리_2
// AVL 트리 - 삽입

import java.util.LinkedList;
import java.util.Queue;

/**
 * - insert 시 balance 비교 후 insert.. (height 비교)
 * - Height 구하는 법 기억해두기.. => Node마다 height가 있음..
 * - 노드의 높이 : (해당 node가 leaf node면 0) 해당 노드의 자식의 height 중 가장 높은 값 + 1
 */
class Node {
    int data;
    int height;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.height = 0;
        this.left = left;
        this.right = right;
    }
}

class AVLTree {
    Node head;

    public int getHeight(Node node) {
        // 노드가 null일 때 높이는 -1
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // 좌측 - 우측
    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public void insert(int data) {
        this.head = insert(data, this.head);
    }

    /**
     * AVL 트리 인서트 시 밸런스 체크 후 회전 주의!
     */
    public Node insert(int data, Node node) {
        if (node == null) {
            return new Node(data, null, null);
        }

        if (data < node.data) {
            node.left = insert(data, node.left);
        } else {
            node.right = insert(data, node.right);
        }

        // 높이 조절
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // 밸런스 체크 후 회전
        int bf = getBalance(node);
        // ll
        if (bf > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        // rr
        else if (bf < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        // lr
        else if (bf > 1 && data > node.left.data) {
            return leftRightRotate(node);
        }
        // rl
        else if (bf < -1 && data < node.right.data) {
            return rightLeftRotate(node);
        }

        //회전 안하면 그냥 현재 node 리턴
        return node;
    }

    /**
     * 부모노드의 좌측자식을 좌회전
     * 부모노드 우회전
     */
    public Node leftRightRotate(Node node) { //lr
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    /**
     * 부모노드의 우측자식을 우회전
     * 부모노드 좌회전
     */
    public Node rightLeftRotate(Node node) { //rl
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    /**
     * 부모노드를 우측자식의 좌측으로
     */
    public Node leftRotate(Node node) { //rr
        Node rNode = node.right;
        node.right = rNode.left;
        rNode.left = node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        rNode.height = Math.max(getHeight(rNode.left), getHeight(rNode.right)) + 1;
        return rNode;
    }

    /**
     * 부모를 좌측자식의 우측으로
     */
    public Node rightRotate(Node node) { //ll
        Node lNode = node.left;
        node.left = lNode.right;
        lNode.right = node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        lNode.height = Math.max(getHeight(lNode.left), getHeight(lNode.right)) + 1;
        return lNode;
    }

    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
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
//         Test code
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
