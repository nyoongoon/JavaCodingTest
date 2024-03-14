package _Theory.Chapter3_NonLinear._04_AVL트리.src;// AVL 트리 - 삭제

class AVLTree2 extends AVLTree {

    public void delete(int key) {
        this.head = delete(this.head, key);
    }

    public Node delete(Node node, int key) { //TODO blog작성
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else { //key == node.key
            if (node.left == null) { // 자식이 없거나 하나
                return node.right; // nullable
            } else if (node.right == null) { // 자식이 없거나 하나
                return node.left; // nullable
            } else { // 자식이 둘
                Node changeNodeParent = node;
                Node changeNode = node.left;

                // changeNode == 삭제할 노드의 자식 중 작은 것 중에 가장 큰 것.
                while (changeNode.right != null) {
                    changeNodeParent = changeNode;
                    changeNode = changeNode.right;
                }

                if (changeNodeParent == node) { //while문 안 탄 경우
                    changeNodeParent.left = changeNode.left;
                } else {
                    changeNodeParent.right = changeNode.left;
                }
                node.key = changeNode.key;
                return node;
            }
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        //삭제 되고 나서 balance 조절
        int bf = getBalance(node);

        // ll => insert와 다르게 data로 bf 판단하는것 아님! -> balance 결과로
        if (bf > 1 && getBalance(node.left) > 0) {
            return rightRotate(node);
        }
        // rr
        if (bf < -1 && getBalance(node.right) < 0) {
            return leftRotate(node);
        }
        //lr
        if (bf > 1 && getBalance(node.left) < 0) {
            return lrRotate(node);
        }
        // rl
        if (bf < -1 && getBalance(node.right) > 0) {
            return rlRotate(node);
        }

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
