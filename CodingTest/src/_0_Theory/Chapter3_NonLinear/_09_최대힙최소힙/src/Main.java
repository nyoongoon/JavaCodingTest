package _0_Theory.Chapter3_NonLinear._09_최대힙최소힙.src;// 비선형자료구조 - 힙
// ArrayList 로 최소 힙 구현

import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0); // 더미데이터삽입 -> 인덱스 기준으로 1번부터 사용하기 위함 !!
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }

    // 최소 힙 노드 삽입
    // 트리의 가장 끝(리프) 위치에 데이터 삽입 && 부모 노드와 키 비교한 후 작을 경우 부모 노드와 자리 교체 (반복)
    public void insert(int data) {
        heap.add(data);
        int curIdx = heap.size() - 1; //방금 insert한 대상의 인덱스 -> cur/2 == 부모인덱스
        // while조건 주의 -> //최상위 노드가 아니고, 부모보다 값이 작으면
        while (curIdx > 1 && heap.get(curIdx / 2) > heap.get(curIdx)) {
            int parentVal = heap.get(curIdx / 2);
            heap.set(curIdx / 2, heap.get(curIdx));
            heap.set(curIdx, parentVal);
            curIdx /= 2;
        }
    }

    public Integer delete() {
        if (heap.size() == 1) { // 더미 데이터만 있음
            System.out.println("Heap is empty");
            return null;
        }
        int target = heap.get(1); // 최소값
        // 마지막 데이터를 최상단으로 복사
        heap.set(1, heap.get(heap.size() - 1));
        // 마지막 데이터 삭제
        heap.remove(heap.size() - 1);

        int curIdx = 1;
        while (true) {
            int leftIdx = curIdx * 2;
            int rightIdx = curIdx * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) {
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                targetIdx = leftIdx;
            } else {
                break;
            }

            if (heap.get(curIdx) < heap.get(targetIdx)) {
                break;
            } else {
                int parentVal = heap.get(curIdx);
                heap.set(curIdx, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                curIdx = targetIdx;
            }
        }
        return target;
    }
}

public class Main {
    public static void main(String[] args) {
        // Test code
        MinHeap minHeap = new MinHeap();
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
