package _Theory.Chapter3_NonLinear._09_최대힙최소힙.src; // Practice 1
// ArrayList 로 최대 힙 구현

import java.util.ArrayList;
import java.util.List;

class MaxHeap {
    List<Integer> heap;

    MaxHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0); // 더미
    }

    // 맨 뒤에 추가 -> 올리기...
    public void insert(int data) {
        this.heap.add(data);
        int curIdx = this.heap.size() - 1;
        // 부모가 더 커야함 -> 부모가 작으면 계속
        while (curIdx > 1 && this.heap.get(curIdx / 2) < this.heap.get(curIdx)) {
            int parentVal = this.heap.get(curIdx / 2);
            this.heap.set(curIdx / 2, this.heap.get(curIdx));
            this.heap.set(curIdx, parentVal);
            curIdx /= 2;
        }
    }

    // 최상위 노드 삭제 후 맨 위 교체, 아래로 내리기 ...
    public Integer delete() {
        if (this.heap.size() == 1) {
            System.out.println("heap is empty...");
            return null;
        }
        int target = this.heap.get(1);
        this.heap.set(1, this.heap.size() - 1);
        this.heap.remove(this.heap.size() - 1);

        int curIdx = 1;
        int childIdx = 1;
        while (true) {
            int leftIdx = curIdx * 2;
            int rightIdx = curIdx * 2 + 1;
            if (this.heap.size() > rightIdx) {
                childIdx = this.heap.get(leftIdx) > this.heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (this.heap.size() > leftIdx) {
                childIdx = leftIdx;
            } else {
                break;
            }

            if(this.heap.get(curIdx) > this.heap.get(childIdx)){
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
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        MaxHeap maxHeap = new MaxHeap();
        System.out.println("== 데이터 삽입 ==");
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(10);
        maxHeap.printTree();
        maxHeap.insert(50);
        maxHeap.insert(60);
        maxHeap.insert(70);
        maxHeap.printTree();
        maxHeap.insert(20);
        maxHeap.printTree();
        maxHeap.insert(30);
        maxHeap.printTree();
//
        System.out.println();
        System.out.println("== 데이터 삭제 ==");
        System.out.println("삭제: " + maxHeap.delete());
        maxHeap.printTree();
        System.out.println("삭제: " + maxHeap.delete());
        maxHeap.printTree();
        System.out.println("삭제: " + maxHeap.delete());
        maxHeap.printTree();
    }
}
