package Sort;

import java.util.Arrays;

public class QuickSort {
    static void quickSort(int[] arr, int left, int right){
        if(left >= right) return;
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot+1, right);
    }

    static int partition(int[]arr, int left, int right){
        int pivot = arr[left];
        int lt = left + 1;
        int rt = right;
        while(lt < rt){
            while(pivot < arr[rt] && lt < rt){ // 작은 것 찾기
                rt--;
            }
            while(pivot >= arr[lt] && lt < rt){ // 크거나 같은 것 찾기
                lt++;
            }
            swap(arr, lt, rt);
        }
        swap(arr, left, lt);
        return lt;
    }

    static void swap(int[]arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬: " + Arrays.toString(arr));
    }
}
