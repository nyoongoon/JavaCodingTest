package _0_Theory.Chapter3_NonLinear._01_이진트리.src.re;// Practice1
// 배열을 이용한 이진 트리 구성, 순회

class BinaryTree {
    char[] tree;

    public BinaryTree(char[] arr) {
        this.tree = arr.clone();
    }


    public void preOrder(int i) {
        // 0 1 2 3 4 5 6 7 8
        int curIdx = i;
        int leftIdx = curIdx * 2 + 1;
        int rightIdx = curIdx * 2 + 2;

        System.out.print(tree[curIdx] + " ");
        if (leftIdx < tree.length) {
            preOrder(leftIdx);
        }
        if (rightIdx < tree.length) {
            preOrder(rightIdx);
        }
    }

    public void inOrder(int i) {
        // 0 1 2 3 4 5 6 7 8
        int curIdx = i;
        int leftIdx = curIdx * 2 + 1;
        int rightIdx = curIdx * 2 + 2;

        if (leftIdx < tree.length) {
            inOrder(leftIdx);
        }
        System.out.print(tree[curIdx] + " ");
        if (rightIdx < tree.length) {
            inOrder(rightIdx);
        }
    }

    public void postOrder(int i) {
        // 0 1 2 3 4 5 6 7 8
        int curIdx = i;
        int leftIdx = curIdx * 2 + 1;
        int rightIdx = curIdx * 2 + 2;

        if (leftIdx < tree.length) {
            postOrder(leftIdx);
        }
        if (rightIdx < tree.length) {
            postOrder(rightIdx);
        }
        System.out.print(tree[curIdx] + " ");
    }

    public void levelOrder(int i) {
        for (int j = 0; j < tree.length; j++) {
            System.out.print(tree[j] + " ");
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
