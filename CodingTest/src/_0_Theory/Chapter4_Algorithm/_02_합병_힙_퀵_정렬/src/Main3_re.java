package _0_Theory.Chapter4_Algorithm._02_합병_힙_퀵_정렬.src;// 퀵 정렬

import java.util.Arrays;

public class Main3_re {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int lo = left;
        int hi = right;

        while (lo < hi) {

            // arr[hi] 보다 작은 값 찾기
            while (arr[hi] >= arr[pivot] && lo < hi) {
                hi--;
            }

            // arr[lo] 보다 크거나 같은 값 찾기
            while (arr[lo] < arr[pivot] && lo < hi) {
                lo++;
            }

            swap(arr, hi, lo);
        }

        swap(arr, lo, pivot);

        return lo;
    }
}
