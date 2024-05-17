package _Theory.Chapter4_Algorithm._02_합병_힙_퀵_정렬.src;// 힙 정렬

import java.util.Arrays;

public class Main2 {

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) { // 마지막 부모부터 힙정렬하며 올리기
            heapify(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) { //인덱스 0이 최대값 -> 계속 뒤로 보내며 힙정렬하기
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int parentIdx, int size) {
        int maxIdx = parentIdx;
        int leftChildIdx = parentIdx * 2 + 1;
        int rightChildIdx = parentIdx * 2 + 2;
        if (leftChildIdx < size && arr[maxIdx] < arr[leftChildIdx]) {
            maxIdx = leftChildIdx;
        }

        if (rightChildIdx < size && arr[maxIdx] < arr[rightChildIdx]) {
            maxIdx = rightChildIdx;
        }

        if (parentIdx != maxIdx) {
            swap(arr, parentIdx, maxIdx);
            heapify(arr, maxIdx, size);
        }
    }

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
}
