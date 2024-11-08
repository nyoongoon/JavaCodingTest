package _0_Theory.Chapter4_Algorithm._07_투포인터.src;// 알고리즘 - 투 포인터
// for-loop vs two pointers

import java.util.Arrays;

public class Main {
    public static int[] forLoop(int[] arr, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (sum == target) {
                    result[0] = i;
                    result[1] = j - 1;
                    return result;
                }
                sum += arr[j];
            }
        }

        return result;
    }

    public static int[] twoPointers(int[] arr, int target) {
        int[] result = {-1, -1};
        int sum = 0;
        int startIdx = 0;
        int endIdx = 0;

        while (startIdx <= endIdx) {
            if (sum < target && endIdx < arr.length) {
                sum += arr[endIdx++];
            } else if (sum > target) {
                sum -= arr[startIdx++];
            } else {
                break;
            }
        }
        if (target == sum) {
            result[0] = startIdx;
            result[1] = endIdx - 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7, 2, 4, 3, 2};
        System.out.println(Arrays.toString(forLoop(arr, 9)));
        System.out.println(Arrays.toString(forLoop(arr, 14)));
        System.out.println();

        System.out.println(Arrays.toString(twoPointers(arr, 9)));
        System.out.println(Arrays.toString(twoPointers(arr, 14)));
    }
}
