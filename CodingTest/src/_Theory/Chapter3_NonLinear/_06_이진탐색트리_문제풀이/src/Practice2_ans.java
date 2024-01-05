package _Theory.Chapter3_NonLinear._06_이진탐색트리_문제풀이.src;// Practice2
// 주어진 BST 에서 노드 간의 차이값 중 최소 값을 구하세요.

// 입력 트리: 4, 2, 6, 1, 3
// 출력: 1

// 입력 트리: 5, 1, 48, null, null, 12, 51
// 출력: 3

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Practice2_ans {

    public static void solution(Integer[] data) {
        BST bst = new BST();
        for (int i = 0; i < data.length; i++) {
            if(data[i] != null){
                bst.addNode(data[i]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        bst.levelOrder(list);

        System.out.println(Collections.min(list));
        System.out.println(list.stream().min((x, y) -> x > y ? 1 : -1).get());
        list.sort((x, y) -> x > y ? 1 : -1);
        System.out.println(list.get(0));

    }

    public static void main(String[] args) {
        // Test code
        Integer[] data = {3, 1, 4, null, 2};
        solution(data);
        data = new Integer[]{5, 1, 48, null, null, 12, 51};
        solution(data);
    }


    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    static class BST {
        Node head = null;

        public void addNode(int key) {
            this.head = addNode(this.head, key);
        }

        public Node addNode(Node node, int key) {
//            System.out.println(key);
            if (node == null) {
                if (this.head == null) {
                    this.head = new Node(key, null, null);
                    return this.head;
                }
                return new Node(key, null, null);
            }

            if (key < node.key) {
                node.left = addNode(node.left, key);
            } else {
                node.right = addNode(node.right, key);
            }
            return node;
        }

        public void levelOrder(ArrayList<Integer> list) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this.head);

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    list.add(Math.abs(cur.key - cur.left.key));
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    list.add(Math.abs(cur.key - cur.right.key));
                }
            }
        }

    }

}
