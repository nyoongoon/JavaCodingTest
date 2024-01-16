package _Theory.Chapter3_NonLinear._10_힙_연습문제.src;// Practice 1
// 최소 힙에서 특정 값을 변경하는 코드를 작성하세요.
// 특정 값이 여러개라면 모두 바꿔주세요.

import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is empty!");
            return null;
        }

        int target = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) {
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                targetIdx = cur * 2;
            } else {
                break;
            }

            if (heap.get(cur) < heap.get(targetIdx)) {
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }

        return target;
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class Practice1 {
    public static void solution(MinHeap minHeap, int from, int to) {
        for (int i = 0; i < minHeap.heap.size(); i++) {
            if (minHeap.heap.get(i) == from) {
                minHeap.heap.set(i, to);
                moveDown(minHeap, i);
                moveUp(minHeap, i);
            }
        }
    }

    public static void moveDown(MinHeap minHeap, int idx) {
        // moveDown 이므로 --> 부모가 더 작음
        while (true) {
            int childIdx = -1;
            int leftIdx = idx * 2;
            int rightIdx = idx * 2 + 1;
            if (minHeap.heap.size() > rightIdx) {
                childIdx = minHeap.heap.get(leftIdx) > minHeap.heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (minHeap.heap.size() > leftIdx) {
                childIdx = leftIdx;
            } else {
                break;
            }

            if (minHeap.heap.get(idx) < minHeap.heap.get(childIdx)) {
                break;
            } else {
                int parentVal = minHeap.heap.get(idx);
                minHeap.heap.set(idx, minHeap.heap.get(childIdx));
                minHeap.heap.set(childIdx, parentVal);
                idx = childIdx;
            }
        }
    }

    public static void moveUp(MinHeap minHeap, int idx) {
        // 부모가 더 작음..
        while (idx > 1 && minHeap.heap.get(idx / 2) > minHeap.heap.get(idx)) {
            int parentVal = minHeap.heap.get(idx / 2);
            minHeap.heap.set(idx / 2, minHeap.heap.get(idx));
            minHeap.heap.set(idx, parentVal);
            idx /= 2;
        }
    }

    public static void main(String[] args) {
        // Test code
        MinHeap minHeap = new MinHeap();
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.insert(20);
        minHeap.insert(30);
        System.out.println("== 데이터 변경 전 ==");
        minHeap.printTree();

        System.out.println("== 데이터 변경 후 ==");
        solution(minHeap, 30, 100);
        minHeap.printTree();

        solution(minHeap, 60, 1);
        minHeap.printTree();
    }
}
