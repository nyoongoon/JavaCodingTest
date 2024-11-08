package _0_Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.Arrays;

public class Practice3 {
    static int maxValue = Integer.MIN_VALUE;

    public static boolean solution(int[] target) {
        for (int i = 0; i < target.length; i++) {
            maxValue = Math.max(maxValue, target[i]);
        }

        int[] array = new int[target.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        return dfs(array, target);
    }

    public static boolean dfs(int[] array, int[] target) {
        if (isEqualArray(array, target)) {
            return true;
        }

        int sum = Arrays.stream(array).sum();
        if (sum > maxValue) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            int originValue = array[i];
            array[i] = sum;
            if (dfs(array, target)) {
                return true;
            }
            array[i] = originValue;
        }

        return false;
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    private static boolean isEqualArray(int[] array, int[] target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != target[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // Test code
        int[] target = {9, 3, 5};
        System.out.println(solution(target));

        target = new int[]{8, 5};
        System.out.println(solution(target));

        target = new int[]{1, 1, 1, 2};
        System.out.println(solution(target));
    }
}
