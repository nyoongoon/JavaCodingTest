package _Theory.Chapter3_NonLinear._01_이진트리.src.re;// Practice3
// 트리 구조 복습 / 구현

import java.util.LinkedList;
import java.util.Queue;



class BinaryTree3 {
}

public class Practice3 {

    public static void main(String[] args) {
//        char[] arr = new char[10];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (char) ('A' + i);
//        }
//
//        BinaryTree3 bt = new BinaryTree3(arr);
//
//        // Root node
//        System.out.println(bt.head.data);
//
//        // B's child node
//        Node3 b = bt.searchNode('B');
//        if (b.left != null) {
//            System.out.print(b.left.data + " ");
//        }
//        if (b.right != null) {
//            System.out.print(b.right.data + " ");
//        }
//        System.out.println();
//
//        // F's parent node
//        Node3 f = bt.searchNode('F');
//        if (f.parent != null) {
//            System.out.println(f.parent.data);
//        }
//
//        // Leaf node
//        for (int i = 0; i < arr.length; i++) {
//            char c = (char) ('A' + i);
//            Node3 cur = bt.searchNode(c);
//            if (cur.left == null && cur.right == null) {
//                System.out.print(cur.data + " ");
//            }
//        }
//        System.out.println();
//
//        // E's Depth
//        Node3 cur = bt.searchNode('E');
//        int depth = -1;
//        while (cur != null) {
//            depth++;
//            cur = cur.parent;
//        }
//        System.out.println("E's Depth == " + depth);
//
//
//        // Level2 Node
//        System.out.print("Level2 Node => ");
//        for (int i = 0; i < arr.length; i++) {
//            char c = (char) ('A' + i);
//            Node3 nd = bt.searchNode(c);
//            Node3 curNode = nd;
//            int level = -1;
//            while (curNode != null) {
//                level++;
//                curNode = curNode.parent;
//            }
//            if (level == 2) {
//                System.out.print(nd.data + " ");
//            }
//        }
//        System.out.println();
//
//
//        // Height
//        int height = 0;
//        for (int i = 0; i < arr.length; i++) {
//            char c = (char) ('A' + i);
//            Node3 nd = bt.searchNode(c);
//            Node3 curNode = nd;
//            int level = -1;
//            while (curNode != null) {
//                level++;
//                curNode = curNode.parent;
//            }
//            if (height < level) {
//                height = level;
//            }
//        }
//        System.out.println("Height == " + height);
//        // B's Size
//        Queue<Node3> queue = new LinkedList<>();
//        Node3 nodeB = bt.searchNode('B');
//        queue.add(nodeB);
//        int size = 0;
//        while (!queue.isEmpty()) {
//            Node3 curNode = queue.poll();
//            size++;
//            if (curNode.left != null) {
//                queue.add(curNode.left);
//            }
//            if (curNode.right != null) {
//                queue.add(curNode.right);
//            }
//        }
//        System.out.println("B's Size == " + size);
//
    }
}
