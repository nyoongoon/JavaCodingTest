package _Theory.Chapter4_Algorithm._02_합병_힙_퀵_정렬.src.re;// 알고리즘 - 정렬_2
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
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, tmp, left, mid);
        mergeSort(arr, tmp, mid + 1, right);
        merge(arr, tmp, left, right);
    }

    public static void merge(int[] arr, int[] tmp, int left, int right) {
        int mid = (left + right) / 2;
        int lo = left;
        int hi = mid + 1;

        int idx = left;
        while (lo <= mid || hi <= right) {
            while (lo <= mid && hi <= right) {
                if (arr[lo] < arr[hi]) {
                    tmp[idx++] = arr[lo++];
                } else {
                    tmp[idx++] = arr[hi++];
                }
            }

            while (lo <= mid) {
                tmp[idx++] = arr[lo++];
            }

            while (hi <= right) {
                tmp[idx++] = arr[hi++];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
}
