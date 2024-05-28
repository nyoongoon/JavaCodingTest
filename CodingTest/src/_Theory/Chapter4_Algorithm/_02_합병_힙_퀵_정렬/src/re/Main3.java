package _Theory.Chapter4_Algorithm._02_합병_힙_퀵_정렬.src.re;// 퀵 정렬

import java.util.Arrays;

public class Main3 {
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
            while (arr[pivot] <= arr[hi] && lo < hi) { // 피봇보다 작거나 같은 값 찾기
                hi--;
            }

            while (arr[pivot] > arr[lo] && lo < hi) { // 피봇보다 큰 값 찾기
                lo++;
            }
            swap(arr, hi, lo);
        }

        swap(arr, pivot, lo);
        return lo;
    }


    public static void swap(int[] arr, int i, int j) {
//        System.out.println("[swap] " + arr[i] + "(" + i + ") <->" + arr[j] + "(" + j + ")");
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
