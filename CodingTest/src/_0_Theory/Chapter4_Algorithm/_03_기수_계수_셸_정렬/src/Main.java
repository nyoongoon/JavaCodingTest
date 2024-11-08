package _0_Theory.Chapter4_Algorithm._03_기수_계수_셸_정렬.src;// 알고리즘 - 정렬_3
// 기수 정렬

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    // 기수정렬 -> 큐를 이용하여 낮은 자리수부터 비교..
    private static void radixSort(int[] arr) {
        Queue<Integer>[] queueArr = new Queue[10]; //0부터 9까지
        for (int i = 0; i < queueArr.length; i++) {
            queueArr[i] = new LinkedList<>();
        }

        int maxLen = getMaxLen(arr);

        int div = 1;
        int idx = 0;
        for (int i = 0; i < maxLen; i++) { // 최대 자리수 만큼 반복
            for (int j = 0; j < arr.length; j++) {
                queueArr[(arr[j] / div) % 10].add(arr[j]); // 특정 수의 자리수 구하는 방법 !
            }

            for (int j = 0; j < queueArr.length; j++) {
                while (!queueArr[j].isEmpty()) {
                    arr[idx++] = queueArr[j].poll();
                }
            }
            div *= 10;
            idx = 0;
        }
    }

    private static int getMaxLen(int[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int) Math.log10(arr[i]) + 1;
            if (maxLen < len) {
                maxLen = len;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬: " + Arrays.toString(arr));
    }
}
