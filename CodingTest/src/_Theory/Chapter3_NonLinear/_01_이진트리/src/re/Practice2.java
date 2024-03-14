package _Theory.Chapter3_NonLinear._01_이진트리.src.re;// Practice2
// 연결 리스트를 이용한 이진 트리 구성, 순회

import java.util.LinkedList;
import java.util.Queue;

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
    }
}

class BinaryTree2 {
    Node head;

    public BinaryTree2(char[] arr) {
        //        배열로 노드 구성한 후, 링크트 리스트 엮는 방식 -> 노드를 idx로 접근...
        Node[] tree = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tree[i] = new Node(arr[i]);
        }

        this.head = tree[0];
        for (int i = 0; i < tree.length; i++) {
            Node cur = tree[i];
            int leftIdx = i * 2 + 1; // 배열의 인덱스 이용하여 자식 연결
            int rightIdx = i * 2 + 2;
            if (leftIdx < tree.length) {
                cur.left = tree[leftIdx];
            }
            if (rightIdx < tree.length) {
                cur.right = tree[rightIdx];
            }
        }
    }

    public void preOrder(Node cur) {
        System.out.print(cur.data + " ");
        if (cur.left != null) {
            preOrder(cur.left);
        }
        if (cur.right != null) {
            preOrder(cur.right);
        }
    }

    public void inOrder(Node cur) {
        if (cur.left != null) {
            inOrder(cur.left);
        }
        System.out.print(cur.data + " ");
        if (cur.right != null) {
            inOrder(cur.right);
        }
    }

    public void postOrder(Node cur) {
        if (cur.left != null) {
            postOrder(cur.left);
        }
        if (cur.right != null) {
            preOrder(cur.right);
        }
        System.out.print(cur.data + " ");
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
    }
}


public class Practice2 {
    public static void main(String[] args) {
//        // Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree2 bt = new BinaryTree2(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(bt.head);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(bt.head);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(bt.head);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(bt.head);
        System.out.println();
    }
}
