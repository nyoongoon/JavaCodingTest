package _Theory.Chapter3_NonLinear._04_AVL트리.src.re;// AVL 트리 - 삭제

class AVLTree2 extends AVLTree {

    public void delete(int data) {
        this.head = delete(data, this.head);
    }

    /**
     * 자식이 없거나 하나
     * 자식이 둘 경우 각각 처리
     */
    public Node delete(int data, Node node) {
        if (data < node.data) {
            node.left = delete(data, node.left);
        } else if (data > node.data) {
            node.right = delete(data, node.right);
        } else {
            Node target = node;
            if (target.left == null) {
                if (target == this.head) {
                    this.head = target.right;
                }
                return target.right; //nullable
            } else if (target.right == null) {
                if (target == this.head) {
                    this.head = target.left;
                }
                return target.left; //nullable
            } else { //자식이 둘
                Node changeTarget = target.left;
                Node changeTargetParent = target;

                while (changeTarget.right != null) {
                    changeTargetParent = changeTarget;
                    changeTarget = changeTarget.right;
                }

                target.data = changeTarget.data;
                if (target == changeTargetParent) {
                    changeTargetParent.left = changeTarget.left;
                } else {
                    changeTargetParent.right = changeTarget.left;
                }

//                changeTargetParent.height = Math.max(getHeight(changeTargetParent.left), getHeight(changeTargetParent.right)) + 1;
//                target.height = Math.max(getHeight(target.left), getHeight(target.right)) + 1;
                return target;
            }
        }

        // 높이 조절
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // 밸런스 체크 후 회전
        int bf = getBalance(node);
        // ll
        if (bf > 1 && getBalance(node.left) > 0) {
            return rightRotate(node);
        }
        // rr
        if (bf < -1 && getBalance(node.right) < 0) {
            return leftRotate(node);
        }
        //lr
        if (bf > 1 && getBalance(node.left) < 0) {
            return leftRightRotate(node);
        }
        // rl
        if (bf < -1 && getBalance(node.right) > 0) {
            return rightLeftRotate(node);
        }

        //회전 안하면 그냥 현재 node 리턴
        return node;
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
