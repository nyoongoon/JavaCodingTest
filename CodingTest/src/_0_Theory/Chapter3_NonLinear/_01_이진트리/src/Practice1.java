package _0_Theory.Chapter3_NonLinear._01_이진트리.src;// Practice1
// 배열을 이용한 이진 트리 구성, 순회

class BinaryTree {
    char[] tree;

    BinaryTree(char[] arr) {
        tree = arr.clone();
    }

    public void preOrder(int idx) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;

        System.out.print(tree[idx] + " ");
        if (left < tree.length) {
            preOrder(left);
        }
        if (right < tree.length) {
            preOrder(right);
        }
    }

    public void inOrder(int idx) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;
        if (left < tree.length) {
            inOrder(left);
        }
        System.out.print(tree[idx] + " ");
        if (right < tree.length) {
            inOrder(right);
        }
    }

    public void postOrder(int idx){
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;
        if(left<tree.length){
            preOrder(left);
        }
        if(right<tree.length){
            preOrder(right);
        }
        System.out.print(tree[idx] + " ");
    }

    public void levelOrder(int idx){
        for (int i = idx; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(0);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(0);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(0);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(0);
        System.out.println();
    }
}
