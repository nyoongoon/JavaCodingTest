package _Theory.Chapter3_NonLinear._01_이진트리.src.re;// Practice3
// 트리 구조 복습 / 구현

import java.util.LinkedList;
import java.util.Queue;


class Node3 {
    char data;
    Node3 parent;
    Node3 left;
    Node3 right;

    public Node3(char data) {
        this.data = data;
    }
}

class BinaryTree3 {
    Node3 head;

    public BinaryTree3(char[] arr) {
        //        배열로 노드 구성한 후, 링크트 리스트 엮는 방식 -> 노드를 idx로 접근...
        Node3[] tree = new Node3[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tree[i] = new Node3(arr[i]);
        }

        this.head = tree[0];
        for (int i = 0; i < tree.length; i++) {
            Node3 cur = tree[i];
            // 0 1 2 3 4 5 6 7 8
            int parentIdx = (i - 1) / 2;
            int leftIdx = i * 2 + 1; // 배열의 인덱스 이용하여 자식 연결
            int rightIdx = i * 2 + 2;
            if (cur != this.head) {
                cur.parent = tree[parentIdx];
            }
            if (leftIdx < tree.length) {
                cur.left = tree[leftIdx];
            }
            if (rightIdx < tree.length) {
                cur.right = tree[rightIdx];
            }
        }
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

    public Node3 searchNode(char data){  //정답하고 비교하기
        return preOrder(this.head, data);
    }

    public Node3 preOrder(Node3 cur, char data) {
        if (cur.data == data) {
            return cur;
        }

        Node3 found = null;
        if (cur.left != null) {
            found = preOrder(cur.left, data);
        }
        if (found != null) {
            return found;
        }
        if (cur.right != null) {
            return preOrder(cur.right, data);
        }

        return null;
    }
}

public class Practice3 {

    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree3 bt = new BinaryTree3(arr);

        // Root node
        System.out.println(bt.head.data);

        // B's child node
        Node3 b = bt.searchNode('B');
        if (b.left != null) {
            System.out.print(b.left.data + " ");
        }
        if (b.right != null) {
            System.out.print(b.right.data + " ");
        }
        System.out.println();

        // F's parent node
        Node3 f = bt.searchNode('F');
        if (f.parent != null) {
            System.out.println(f.parent.data);
        }

        // Leaf node
        for (int i = 0; i < arr.length; i++) {
            char c = (char) ('A' + i);
            Node3 cur = bt.searchNode(c);
            if (cur.left == null && cur.right == null) {
                System.out.print(cur.data + " ");
            }
        }
        System.out.println();

        // E's Depth
        Node3 cur = bt.searchNode('E');
        int depth = -1;
        while (cur != null) {
            depth++;
            cur = cur.parent;
        }
        System.out.println("E's Depth == " + depth);


        // Level2 Node
        System.out.print("Level2 Node => ");
        for (int i = 0; i < arr.length; i++) {
            char c = (char) ('A' + i);
            Node3 nd = bt.searchNode(c);
            Node3 curNode = nd;
            int level = -1;
            while (curNode != null) {
                level++;
                curNode = curNode.parent;
            }
            if (level == 2) {
                System.out.print(nd.data + " ");
            }
        }
        System.out.println();


        // Height
        int height = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = (char) ('A' + i);
            Node3 nd = bt.searchNode(c);
            Node3 curNode = nd;
            int level = -1;
            while (curNode != null) {
                level++;
                curNode = curNode.parent;
            }
            if (height < level) {
                height = level;
            }
        }
        System.out.println("Height == " + height);
        // B's Size
        Queue<Node3> queue = new LinkedList<>();
        Node3 nodeB = bt.searchNode('B');
        queue.add(nodeB);
        int size = 0;
        while (!queue.isEmpty()) {
            Node3 curNode = queue.poll();
            size++;
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
        System.out.println("B's Size == " + size);
//
    }
}
