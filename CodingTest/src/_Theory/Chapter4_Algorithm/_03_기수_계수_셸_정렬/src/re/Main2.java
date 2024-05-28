package _Theory.Chapter4_Algorithm._03_기수_계수_셸_정렬.src.re;// 계수 정렬

import java.util.Arrays;

public class Main2 {

    public static void countingSort(int[] arr) {
        int max = getMax(arr);
        int[] countArr = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }

        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                System.out.print(i);
                countArr[i]--;
            }
        }

    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 10, 27, 32, 17, 99, 56};
        countingSort(arr);
        System.out.println("계수 정렬: " + Arrays.toString(arr));
    }

    public static int getMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
