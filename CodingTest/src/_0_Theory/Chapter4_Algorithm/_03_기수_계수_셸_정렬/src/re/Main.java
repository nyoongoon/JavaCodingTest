package _0_Theory.Chapter4_Algorithm._03_기수_계수_셸_정렬.src.re;// 알고리즘 - 정렬_3
// 기수 정렬

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    private static void radixSort(int[] arr) {
        //최대 자리수 구하기
        int maxLen = getMaxLen(arr);
        Queue<Integer>[] queueArr = new Queue[10];
        for (int i = 0; i < queueArr.length; i++) {
            queueArr[i] = new LinkedList<>();
        }

        int div = 1;
        int idx = 0;
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < arr.length; j++) {
                queueArr[(arr[j] / div) % 10].add(arr[j]);
            }

            for (int j = 0; j < queueArr.length; j++) {
                while (!queueArr[j].isEmpty()) {
                    arr[idx++] = queueArr[j].poll();
                }
            }
            idx = 0;
            div *= 10;
        }

    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬: " + Arrays.toString(arr));
    }

    public static int getMaxLen(int[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int) Math.log10(arr[i]) + 1;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
