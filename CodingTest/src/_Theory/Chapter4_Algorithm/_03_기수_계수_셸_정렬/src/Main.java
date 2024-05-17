package _Theory.Chapter4_Algorithm._03_기수_계수_셸_정렬.src;// 알고리즘 - 정렬_3
// 기수 정렬

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬: " + Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }

        int maxLen = getMaxLen(arr);

        int idx = 0;
        int div = 1;
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < arr.length; j++) {
                list.get(arr[j] / div % 10).add(arr[j]); // 여기 주의 -> 아래자리부터 비교 !!
            }

            for (int j = 0; j < list.size(); j++) {
                Queue<Integer> queue = list.get(j);
                while (!queue.isEmpty()) {
                    arr[idx++] = queue.poll();
                }
            }

            idx = 0;
            div *= 10;
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
}
