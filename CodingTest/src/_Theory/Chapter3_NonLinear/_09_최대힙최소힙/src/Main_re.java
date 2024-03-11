package _Theory.Chapter3_NonLinear._09_최대힙최소힙.src;// 비선형자료구조 - 힙
// ArrayList 로 최소 힙 구현

import java.util.ArrayList;

class MinHeap_re {
    ArrayList<Integer> list = new ArrayList<>();

    // 맨뒤에 넣기 -> 올리기
    public void insert(int value) {
        list.add(value);
        int curIdx = list.size() - 1;
//        System.out.println("curIdx == " + curIdx);
        int parentIdx = (curIdx - 1) / 2;
//        System.out.println("parentIdx == " + parentIdx);

        while (list.get(parentIdx) > list.get(curIdx)) {
            int tmp = list.get(curIdx);
            list.set(curIdx, list.get(parentIdx)); /* 뒤부터설정주의 */
            list.set(parentIdx, tmp);

            curIdx = parentIdx;
            /* parentIdx 뺴먹었었음;;; */
            parentIdx = (curIdx - 1) / 2;
        }
    }


    // 맨위 제거 -> 맨아래 맨위에 놓고 내리기
    public Integer delete() {
        /* 사이즈 체크 빼먹었음..! */
        if (list.size() == 1) {
            System.out.println("Heap is empty");
            return null;
        }

        int target = list.remove(0);
        list.add(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        // 0 1 2 3 4 5 6 7 8
        int curIdx = 0;
        while (true) {
            int leftIdx = curIdx * 2 + 1;
            int rightIdx = curIdx * 2 + 2;
            int targetIdx = -1;

            if (rightIdx < list.size()) {
                // 좌우 둘 다 범위에 들어올 경우엔 둘 중 더 작은 쪽 골라야함!
                targetIdx = list.get(leftIdx) < list.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < list.size()) {
                targetIdx = leftIdx;
            } else {
                break;
            }

            if(list.get(curIdx) < list.get(targetIdx)){
                break;
            }else{
                int tmp = list.get(targetIdx);
                list.set(targetIdx, list.get(curIdx));
                list.set(curIdx, tmp);
                curIdx = targetIdx;
            }
        }

        return target;
    }

    public void printTree() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}

public class Main_re {

    public static void main(String[] args) {
        // Test code
        MinHeap_re minHeap = new MinHeap_re();
        System.out.println("== 데이터 삽입 ==");
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.printTree();
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree();
        minHeap.insert(20);
        minHeap.printTree();
        minHeap.insert(30);
        minHeap.printTree();
//
        System.out.println();
        System.out.println("== 데이터 삭제 ==");
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
    }
}
