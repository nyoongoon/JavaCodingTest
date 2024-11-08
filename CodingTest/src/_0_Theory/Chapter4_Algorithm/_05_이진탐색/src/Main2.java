package _0_Theory.Chapter4_Algorithm._05_이진탐색.src;// 자바 기본 binarySearch

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println("=== 데이터가 있는 경우 ===");
        Arrays.binarySearch(arr, 1);
        Arrays.binarySearch(arr, 10);
        Arrays.binarySearch(arr, 30);
        System.out.println("=== 데이터가 없는 경우 ===");
        Arrays.binarySearch(arr, 3); //있어야하는 자리 인덱스*-1 -1
        Arrays.binarySearch(arr, 11);
        Arrays.binarySearch(arr, 35);
    }
}
