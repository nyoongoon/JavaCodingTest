package _0_Theory.Chapter3_NonLinear._06_이진탐색트리_문제풀이.src;// Practice2
// 주어진 BST 에서 노드 간의 차이값 중 최소 값을 구하세요.

// 입력 트리: 4, 2, 6, 1, 3
// 출력: 1

// 입력 트리: 5, 1, 48, null, null, 12, 51
// 출력: 3

public class Practice2 {
    static int min = Integer.MAX_VALUE;

    public static void solution(Integer[] data) {

        BST bst = new BST();
        for (int i = 0; i < data.length; i++) {
            if(data[i] != null){
                bst.addNode(data[i]);
            }
        }
        bst.postOrder(bst.head);
        System.out.println(min);
    }

    public static void main(String[] args) {
        // Test code
        Integer[] data = {3, 1, 4, null, 2};
        solution(data);
        System.out.println("================");
        min = Integer.MAX_VALUE;
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

        public void postOrder(Node node) {
            if (node == null) {
                return;
            }

            postOrder(node.left);
            postOrder(node.right);


            if(node.left != null){
                min = Math.min(min, Math.abs(node.key - node.left.key));
            }
            if(node.right != null){
                min = Math.min(min, Math.abs(node.key - node.right.key));
            }

        }

    }

}
