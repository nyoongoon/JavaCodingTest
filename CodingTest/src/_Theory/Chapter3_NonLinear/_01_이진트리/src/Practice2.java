package _Theory.Chapter3_NonLinear._01_이진트리.src;// Practice2
// 연결 리스트를 이용한 이진 트리 구성, 순회

import java.util.LinkedList;
import java.util.Queue;

class Node {
    char data;
    Node left;
    Node right;

    Node(char data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree2 {
    Node head;

    BinaryTree2(char[] arr) {
//        배열로 노드 구성한 후, 링크트 리스트 엮는 방식 -> 노드를 idx로 접근...
        Node[] nodeList = new Node[arr.length]; // 배열 먼저
        for (int i = 0; i < nodeList.length; i++) {
            nodeList[i] = new Node(arr[i], null, null);
        }
        this.head = nodeList[0];
        for (int i = 0; i < nodeList.length; i++) {
            Node cur = nodeList[i];
            int left = i * 2 + 1; // 배열의 인덱스 이용하여 자식 연결
            int right = i * 2 + 2;

            if (left < nodeList.length) {
                cur.left = nodeList[left];
            }
            if (right < nodeList.length) {
                cur.right = nodeList[right];
            }
        }
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
}


public class Practice2 {
    public static void main(String[] args) {
        // Test code
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
