package _Theory.Chapter4_Algorithm._03_기수_계수_셸_정렬.src;// 계수 정렬

import java.util.Arrays;

public class Main2 {

    public static void countingSort(int[] arr) {
        int maxNumber = Arrays.stream(arr).max().getAsInt(); // 스트림으로 최대값 구하기
        int[] countSortArr = new int[maxNumber + 1];
        for (int number : arr) {
            countSortArr[number]++;
        }

        int idx = 0;
        for (int i = 0; i < countSortArr.length; i++) {
            if (countSortArr[i] > 0) {
                while (countSortArr[i] > 0) { //count배열열 0이 될때까지 빼기..!
                    arr[idx++] = i; //count배열의 인덱스가 정렬배열의 값이 된다..!
                    countSortArr[i]--;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 10, 27, 32, 17, 99, 56};
        countingSort(arr);
        System.out.println("계수 정렬: " + Arrays.toString(arr));
    }
}
