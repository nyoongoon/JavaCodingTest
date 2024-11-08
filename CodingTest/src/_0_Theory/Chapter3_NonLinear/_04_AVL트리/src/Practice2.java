package _0_Theory.Chapter3_NonLinear._04_AVL트리.src;// AVL 트리 - 삭제

class AVLTree2 extends AVLTree {


    public void delete(int data) {
        this.head = delete(data, this.head);
    }

    public Node delete(int data, Node cur) {
        if (cur == null) {
            return new Node(data, null, null);
        }

        if (data < cur.data) {
            cur.left = delete(data, cur.left);
        } else if (data > cur.data) {
            cur.right = delete(data, cur.right);
        } else {
            Node target = cur;
            if (target.left == null) {
                if (target == this.head) {
                    this.head = target.right;
                }
                return target.right;
            } else if (target.right == null) {
                if (target == this.head) {
                    this.head = target.left;
                }
                return target.left;
            } else {
                Node changeTarget = target.left;
                Node changeTargetParent = target;

                while (changeTarget.right != null) {
                    changeTargetParent = changeTarget;
                    changeTarget = changeTarget.right;
                }

                target.data = changeTarget.data;
                if (changeTargetParent == target) {
                    changeTargetParent.left = changeTarget.left;
                } else {
                    changeTargetParent.right = changeTarget.left;
                }
            }
        }

        cur.height = Math.max(getHeight(cur.left), getHeight(cur.right)) + 1;

        int bf = getBalance(cur);
        if (bf > 1 && getBalance(cur.left) > 0) { // ll -> 여기는 밸런스 1 이상이 아니라 0 이상임 주의
            return rightRotate(cur);
        }
        if (bf < -1 && getBalance(cur.right) < 0) { // rr -> 여기는 밸런스 1 이상이 아니라 0 이상임 주의
            return leftRotate(cur);
        }
        if (bf < 1 && getBalance(cur.left) < 0) {
            return leftRightRotate(cur);
        }

        if (bf < -1 && getBalance(cur.right) > 0) {
            return rightLeftRotate(cur);
        }

        return cur;
    }
}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        AVLTree2 avl = new AVLTree2();

        avl.insert(30);
        avl.insert(20);
        avl.insert(40);
        avl.insert(10);
        avl.levelOrder(avl.head);
        avl.delete(40);     // LL
        avl.levelOrder(avl.head);

        avl.insert(40);
        avl.delete(10);     // RR
        avl.levelOrder(avl.head);

        avl.insert(25);
        avl.delete(40);     // LR
        avl.levelOrder(avl.head);

        avl.insert(27);
        avl.delete(20);     // RL
        avl.levelOrder(avl.head);
    }
}
