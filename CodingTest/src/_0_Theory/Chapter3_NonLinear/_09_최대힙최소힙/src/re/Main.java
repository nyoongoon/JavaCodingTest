package _0_Theory.Chapter3_NonLinear._09_최대힙최소힙.src.re;// 비선형자료구조 - 힙
// ArrayList 로 최소 힙 구현

import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    // 맨 아래 넣고 위로 올리기 -> 부모가 더 작아야한다.
    public void insert(int data) {
        // 0 1 2 3 4 5 6 7
        this.heap.add(data);
        int curIdx = this.heap.size() - 1;
        int parentIdx = (curIdx - 1) / 2;

        while (parentIdx >= 0 && this.heap.get(parentIdx) > this.heap.get(curIdx)) {
            int tmp = this.heap.get(curIdx);
            this.heap.set(curIdx, this.heap.get(parentIdx));
            this.heap.set(parentIdx, tmp);
        }
    }

    public void printTree() {
        for (int i = 0; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }

    //맨위에 뺴로 맨 뒤 맨위로 올린 뒤 내리기..
    public Integer delete() {
        if (this.heap.size() == 0) {
            System.out.println("heap is empty..");
            return null;
        }
        int target = this.heap.get(0);
        this.heap.set(0, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);

        int curIdx = 0;
        int leftIdx;
        int rightIdx;
        int targetIdx;

        while (true) {
            leftIdx = curIdx * 2 + 1;
            rightIdx = curIdx * 2 + 1;
            if (rightIdx < this.heap.size()) {
                // 더 작은 값의 인덱스가 targetIdx
                targetIdx = this.heap.get(leftIdx) < this.heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < this.heap.size()) {
                targetIdx = leftIdx;
            } else {
                break;
            }
            // 부모가 더 작아야한다..
            if (this.heap.get(curIdx) > this.heap.get(targetIdx)) {
                int tmp = this.heap.get(targetIdx);
                this.heap.set(targetIdx, this.heap.get(curIdx));
                this.heap.set(curIdx, tmp);
            } else { //부모가 이미 더 작거나 같으면 break
                break;
            }
            curIdx = targetIdx;
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
