package _Theory.Chapter4_Algorithm._02_합병_힙_퀵_정렬.src;// 알고리즘 - 정렬_2
// 합병 정렬

import java.util.Arrays;


public class Main_ans {

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬: " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid); // arr 길이 2 까지 분할하기
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, right); // 분할된 arr 합병하기
        }
    }

    private static void merge(int[] arr, int[] tmp, int left, int right) {
        int mid = (left + right) / 2;
        int p = left;
        int q = mid + 1;
        int idx = left;

        while (p <= mid || q <= right) {
            if (p <= mid && q <= right) {
                if (arr[p] < arr[q]) {
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
            } else if (p <= mid) {
                tmp[idx++] = arr[p++];
            } else { //q <= right
                tmp[idx++] = arr[q++];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
}
