package _Theory.Chapter3_NonLinear._09_최대힙최소힙.src;// 비선형자료구조 - 힙
// ArrayList 로 최소 힙 구현

import java.util.ArrayList;
import java.util.List;

class MinHeap_re {
    List<Integer> heap;

    public MinHeap_re() {
        this.heap = new ArrayList<>();
        this.heap.add(0); // 더미
    }

    // 맨 뒤에 넣고 올리기
    public void insert(int data) {
        this.heap.add(data);
        int curIdx = this.heap.size() - 1;

        // 최상위 노드 && 부모가 더 작으면 멈추기
        while (curIdx > 1 && this.heap.get(curIdx / 2) > this.heap.get(curIdx)) {
            int parentVal = this.heap.get(curIdx / 2);
            this.heap.set(curIdx / 2, this.heap.get(curIdx));
            this.heap.set(curIdx, parentVal);
            curIdx /= 2; // 부모로
        }
    }

    // 최상단 노드 제거 -> 맨 아래 대체 후 내리기...
    public Integer delete() {
        if (this.heap.size() == 1) {
            System.out.println("heap is empty ...");
            return null;
        }

        int target = this.heap.get(1);
        this.heap.set(1, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);

        int curIdx = 1;
//        int childIdx = -1;
        int childIdx = 1; // 이래야 error 안터질듯 ?
        while (true) {
            int leftIdx = curIdx * 2;
            int rightIdx = curIdx * 2 + 1;
            if (heap.size() > rightIdx) {
                childIdx = this.heap.get(leftIdx) < this.heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (heap.size() > leftIdx) {
                childIdx = leftIdx;
            } else {
                break;
            }

            if(this.heap.get(curIdx) < this.heap.get(childIdx)){
                break;
            }else{
                int parentVal = this.heap.get(curIdx);
                this.heap.set(curIdx, this.heap.get(childIdx));
                this.heap.set(childIdx, parentVal);
                curIdx = childIdx;
            }
        }

        return target;
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
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
