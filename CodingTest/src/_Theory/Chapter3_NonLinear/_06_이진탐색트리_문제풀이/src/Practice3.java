package _Theory.Chapter3_NonLinear._06_이진탐색트리_문제풀이.src;// Practice3
// 주어진 BST 에서 두 노드의 합이 target 값이 되는 경우가 있는지 확인하세요.
// 있으면 true, 없으면 false 반환

// 입력 트리: 5, 3, 6, 2, 4, null, 7
// 결과: true

// 입력 트리: 5,3,6,2,4,null,7
// 결과: false

import java.util.HashSet;

public class Practice3 {
    public static void solution(Integer[] data, int target) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(data[0]);
        for (int i = 1; i < data.length; i++) {
            if(data[i] != null){
                binarySearchTree.addNode(data[i]);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        System.out.println(preOrder(binarySearchTree.head, target, set));
    }

    public static boolean preOrder(Node node, int target, HashSet<Integer> set) {
        if(node == null){
            return false;
        }

        if(set.contains(target - node.key)){
            return true;
        }else{
            set.add(node.key);
        }

        boolean left = preOrder(node.left, target, set);
        boolean right = preOrder(node.right, target, set);

        return left || right;
    }

    public static boolean search(Node node, HashSet<Integer> set, int target){
        if(node == null){
            return false;
        }

        if(set.contains(target - node.key)){
            return true;
        }

        set.add(node.key);

        if(search(node.left, set, target)){
            return true;
        }
        if(search(node.right, set, target)){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Integer[] data = {5, 3, 6, 2, 4, null, 7};
        int target = 9;
        solution(data, target);

        data = new Integer[]{5, 3, 6, 2, 4, null, 7};
        target = 28;
        solution(data, target);
    }
}
