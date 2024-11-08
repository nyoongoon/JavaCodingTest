package _0_Theory.Chapter3_NonLinear._03_이진탐색트리.src.re;// 비선형 자료구조 - 이진 탐색 트리

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    Node head;

    public BinarySearchTree(int data) {
        this.head = new Node(data, null, null);
    }

    public void addNode(int data) {
        Node cur = this.head;
        Node parent = cur;
        while (cur != null) {
            if (data == cur.data) {
                System.out.println("요소 이미 있음");
                return;
            }
            parent = cur;
            if (data < cur.data) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (data < parent.data) {
            parent.left = new Node(data, null, null);
        } else if (data > parent.data) {
            parent.right = new Node(data, null, null);
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
        System.out.println();
    }

    /**
     * 자식이 없는 경우 | 자식 하나인 경우 | 자식 둘인 경우 -> 케이스 분리 주의
     * -> 각각의 경우 target==head 별도 로직
     * 자식 둘인 경우 => 타겟을 찾아서 -> 타겟 중 작은 것 중에 제일 큰 노드
     */
    public void removeNode(int data) {
        Node target = this.head;
        Node targetParent = null;
        while (target != null) {
            if (data == target.data) {
                break;
            } else if (data < target.data) {
                targetParent = target;
                target = target.left;
            } else {
                targetParent = target;
                target = target.right;
            }
        }
        if (target == null) {
            System.out.println("찾는 요소 없음");
            return;
        }

        if (target.left == null && target.right == null) {
            if (target == this.head) {
                this.head = null;
                return;
            }
            if (targetParent.left == target) {
                targetParent.left = null;
            } else {
                targetParent.right = null;
            }
        } else if (target.left == null || target.right == null) {
            Node child = target.left == null ? target.right : target.left;
            if (target == this.head) {
                this.head = child;
                return;
            }
            if (targetParent.left == target) {
                targetParent.left = child;
            } else {
                targetParent.right = child;
            }
        } else { // 자식이 두 개
            Node changeTarget = target.left;
            Node changeTargetParent = target;
            while (changeTarget.right != null) { //타겟의 작은 요소 중 제일 큰 요소를 찾기 -> 자리바꿈
                changeTargetParent = changeTarget;
                changeTarget = changeTarget.right;
            }
            // chageTarget의 자식을 changeTargetParent의 요소로 바로 이어붙이기..
            if (changeTargetParent == target) { // 바로 while 탈출 상황
                changeTargetParent.left = changeTarget.left;
            } else {
                changeTargetParent.right = changeTarget.left;
            }
            // target과 chageTarget 바꾸기
            // target.key = changeTarget.key; 키값만 바꾸면 아래 코드 필요 없음..
            changeTarget.left = target.left; //왼쪽자식 <<- 틀림 주의 체인지타겟의 자식을 타겟을 자식으로!
            changeTarget.right = target.right; //오른쪽 자식
            // 부모
            if (target == this.head) {
//                target.data = changeTarget.data;
                this.head = changeTarget;
                return;
            }
            if (targetParent.left == target) {
                targetParent.left = changeTarget;
            } else {
                targetParent.right = changeTarget;
            }
        }
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

//        // 노드 삭제
        bst.removeNode(40);
        bst.levelOrder(bst.head);
        bst.removeNode(25);
        bst.levelOrder(bst.head);
        bst.removeNode(20);
        bst.levelOrder(bst.head);
    }
}
