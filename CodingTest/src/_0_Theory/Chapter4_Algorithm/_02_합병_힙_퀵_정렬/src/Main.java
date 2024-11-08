package _0_Theory.Chapter4_Algorithm._02_합병_힙_퀵_정렬.src;// 알고리즘 - 정렬_2
// 합병 정렬

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // 중간으로 나누기
            mergeSort(arr, tmp, left, mid); // 재귀로 계속 배열 나누기
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, right); // 다 나누어지면 병합하기
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int right) {
        int mid = (left + right) / 2; // 중간으로 나누기
        int p = left;
        int q = mid + 1;
        int idx = left;

        while (p <= mid || q <= right) { // arr[p] arr[q] 순차 비교하며 tmp[] 채우기
            if (p <= mid && q <= right) {
                if (arr[p] < arr[q]) {
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
            } else if (p <= mid) {
                tmp[idx++] = arr[p++];
            } else if (q <= right) {
                tmp[idx++] = arr[q++];
            }
        }

        for (int i = left; i <= right; i++) { // 임시 배열에 정렬된 값 원본 배열에 채우기
            arr[i] = tmp[i];
        }
    }
}
