package _0_Theory.Chapter3_NonLinear._09_최대힙최소힙.src;// 비선형자료구조 - 힙
// ArrayList 로 최소 힙 구현

import java.util.ArrayList;

class MinHeap_re {
    ArrayList<Integer> heap;

    public MinHeap_re() {
        this.heap = new ArrayList<>();
    }

    // 맨 뒤에 추가하고 위로 올리기
    public void insert(int value) {
        heap.add(value);
        int curIdx = heap.size() - 1;
        // 0 1 2 3 4 5 6 7 8
        int parentIdx = (curIdx - 1) / 2;
        while (parentIdx >= 0 && heap.get(parentIdx) > heap.get(curIdx)) {
            int tmp = heap.get(curIdx);
            heap.set(curIdx, heap.get(parentIdx));
            heap.set(parentIdx, tmp);

            curIdx = parentIdx;
            parentIdx = (curIdx - 1) / 2;
        }
    }

    public void printTree() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }

    // 맨위 삭제, 마지막 위로 올린 후 내리기
    public int delete() {
        int target = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        // 0 1 2 3 4 5 6 7 8
        int curIdx = 0;
        while (true) {
            int leftIdx = curIdx * 2 + 1;
            int rightIdx = curIdx * 2 + 2;
            int targetIdx = -1;

            if (rightIdx < heap.size()) {
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                targetIdx = leftIdx;
            } else {
                break;
            }

            if (heap.get(curIdx) > heap.get(targetIdx)) {
                int tmp = heap.get(curIdx);
                heap.set(curIdx, heap.get(targetIdx));
                heap.set(targetIdx, tmp);
                // 아이씨.. 자꾸 뺴먹네.. 인덱스 업데이트..
                curIdx = targetIdx;
            } else {
                break;
            }
        }

        return target;
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
