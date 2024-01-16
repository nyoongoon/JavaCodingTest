package _Theory.Chapter3_NonLinear._10_힙_연습문제.src;// Practice 3
// 정수들을 힙 자료구조에 추가하고 n번 삭제 후 절대값이 큰 값부터 출력하세요.

// 입력: 3 0 -2 -5 9 6 -11, 20, -30
// 삭제 횟수: 1
// 출력: 20, -11 9 6 -5 3 -2 0

import java.util.ArrayList;
import java.util.List;

class MaxAbsHeap {
    List<Integer> heap;

    MaxAbsHeap() {
        heap = new ArrayList<>();
        heap.add(0); //더미
    }

    // 맨 뒤에 넣고 올리기
    public void insert(int data) {
        heap.add(data);
        int idx = heap.size() - 1;
        // 부모보다 절대값 큰 경우 올라감
        while (idx > 1 && Math.abs(heap.get(idx / 2)) < Math.abs(heap.get(idx))) {
            int parentVal = heap.get(idx / 2);
            heap.set(idx / 2, heap.get(idx));
            heap.set(idx, parentVal);
            idx /= 2;
        }
    }

    // 맨 위에 삭제 후 맨 아래 맨 위로 이동 -> 아래로 내리기..
    public Integer delete() {
        int target = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int curIdx = 1;
        while (true) {
            int childIdx = -1;
            int leftIdx = curIdx * 2;
            int rightIdx = curIdx * 2 + 1;
            if (heap.size() > rightIdx) {
                childIdx = Math.abs(heap.get(leftIdx)) > Math.abs(heap.get(rightIdx)) ? leftIdx : rightIdx;
            } else if (heap.size() > leftIdx) {
                childIdx = leftIdx;
            } else {
                break;
            }
            // 부모가 더 크면 break
            if (Math.abs(heap.get(curIdx)) > Math.abs(heap.get(childIdx))) {
                break;
            } else {
                int parentVal = heap.get(curIdx);
                heap.set(curIdx, heap.get(childIdx));
                heap.set(childIdx, parentVal);
                curIdx = childIdx;
            }
        }
        return target;
    }
}

public class Practice3 {
    public static void solution(int[] nums, int deleteCnt) {
        MaxAbsHeap maxAbsHeap = new MaxAbsHeap();
        for (int i = 0; i < nums.length; i++) {
            maxAbsHeap.insert(nums[i]);
        }
        for (int i = 0; i < deleteCnt; i++) {
            maxAbsHeap.delete();
        }
        int size = maxAbsHeap.heap.size();
        for (int i = 1; i < size; i++) {
            System.out.print(maxAbsHeap.delete() + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        // Test code
        int nums[] = {3, 0, -2, -5, 9, 6, -11, 20, -30};
        int deleteCnt = 1;
        solution(nums, deleteCnt);
    }
}
