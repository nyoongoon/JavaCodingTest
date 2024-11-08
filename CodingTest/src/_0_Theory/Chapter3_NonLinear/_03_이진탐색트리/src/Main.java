package _0_Theory.Chapter3_NonLinear._03_이진탐색트리.src;// 비선형 자료구조 - 이진 탐색 트리

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left;
    Node right;

    Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    Node head;

    BinarySearchTree(int key) {
        this.head = new Node(key, null, null);
    }

    public void addNode(int key) {
        Node cur = this.head;
        Node parent = null;
        while (cur != null) {
            if (key == cur.key) {
                System.out.println("key가 이미 존재");
                return;
            }
            parent = cur;
            if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (key < parent.key) {
            parent.left = new Node(key, null, null);
        } else {
            parent.right = new Node(key, null, null);
        }
    }

    public void removeNode(int key) {
        Node target = this.head;
        Node targetParent = null;

        while (target != null) { // 타겟 찾기
            if (key == target.key) {
                break;
            }
            targetParent = target;
            if (key < target.key) {
                target = target.left;
            } else {
                target = target.right;
            }
        }
        if (target == null) {
            System.out.println("해당하는 key가 없습니다.");
            return;
        }

        if (target.left == null && target.right == null) { // 리프노드
            if (targetParent == null) {
                this.head = null;
            } else {
                if (targetParent.left == target) {
                    targetParent.left = null;
                } else {
                    targetParent.right = null;
                }
            }
        } else if (target.left == null || target.right == null) { // 자식이 하나
            Node child;
            if (target.left != null) {
                child = target.left;
            } else {
                child = target.right;
            }

            if (targetParent == null) {
                this.head = child;
                return;
            }

            if (targetParent.left == target) {
                targetParent.left = child;
            } else {
                targetParent.right = child;
            }
        } else { //자식이 둘
            Node changeTargetParent = target;
            Node changeTarget = target.left;

            while (changeTarget.right != null) { //target의 key 보다 작은 값 중 가장 큰 값 찾기..
                changeTargetParent = changeTarget;
                changeTarget = changeTarget.right;
            }

            if (target == changeTargetParent) { // target.left.right가 null
                target.left = changeTarget.left;
            } else {
                changeTargetParent.right = changeTarget.left;
            }

            // target.key = changeTarget.key; 키값만 바꾸면 아래 코드 필요 없음..
            changeTarget.left = target.left; //target자리에 changeTarget으로 교체
            changeTarget.right = target.right;

            if (targetParent == null) { //head
                this.head = changeTarget;
            } else {
                if (targetParent.left == target) {
                    targetParent.left = changeTarget;
                } else {
                    targetParent.right = changeTarget;
                }
            }
        }
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


public class Main {
    public static void main(String[] args) {
        // Test code
        // 노드 삽입
        BinarySearchTree bst = new BinarySearchTree(20);
        bst.addNode(10);
        bst.addNode(30);
        bst.addNode(1);
        bst.addNode(15);
        bst.addNode(25);
        bst.addNode(13);
        bst.addNode(35);
        bst.addNode(27);
        bst.addNode(40);
        bst.levelOrder(bst.head);

        // 노드 삭제
        bst.removeNode(40);
        bst.levelOrder(bst.head);
        bst.removeNode(25);
        bst.levelOrder(bst.head);
        bst.removeNode(20);
        bst.levelOrder(bst.head);
    }
}
