package _Theory.Chapter4_Algorithm._02_합병_힙_퀵_정렬.src.re;// 힙 정렬

import java.util.Arrays;

public class Main2 {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬: " + Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int parentIdx = (arr.length / 2) - 1;
        for (int i = parentIdx; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        // 모든 부모가 자식보다 큼
        // idx 0이 최대값
        for (int i = arr.length - 1; i > 0; i--) { //length 마지막에 max를 swap하며 length를 하나씩 줄인다 //마지막 0은 필요없음 (최소값 배치되있음)
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int parentIdx, int length) {
        int maxIdx = parentIdx;
        int leftChildIdx = parentIdx * 2 + 1;
        int rightChildIdx = parentIdx * 2 + 2;

        if (leftChildIdx < length && arr[maxIdx] < arr[leftChildIdx]) {
            maxIdx = leftChildIdx;
        }

        if (rightChildIdx < length && arr[maxIdx] < arr[rightChildIdx]) {
            maxIdx = rightChildIdx;
        }

        if (maxIdx != parentIdx) {
            swap(arr, maxIdx, parentIdx);
            heapify(arr, maxIdx, length); //값이 작은 자식 재귀적으로 내리기..
        }
    }
}
