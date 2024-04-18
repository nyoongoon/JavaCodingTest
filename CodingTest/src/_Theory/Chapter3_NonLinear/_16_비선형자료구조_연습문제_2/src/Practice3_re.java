package _Theory.Chapter3_NonLinear._16_비선형자료구조_연습문제_2.src;

import java.util.Arrays;

public class Practice3_re {
    static int maxSum = 0;

    public static boolean solution(int[] target) {
        maxSum = Arrays.stream(target).max().orElseThrow();

        int[] arr = new int[target.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        return dfs(target, arr);
    }

    private static boolean dfs(int[] target, int[] arr) {
        if(isEqual(target, arr)) {
            return true;
        }
        if(Arrays.stream(arr).sum() > maxSum){
            return false;
        }

        int sum = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            arr[i] = sum;
            if(dfs(target, arr)){
                return true;
            }
            arr[i] = tmp;
        }
        return false;
    }

    private static boolean isEqual(int[] target, int[] arr) {
        if(target.length != arr.length){
            return false;
        }
        for (int i = 0; i < target.length; i++) {
            if(target[i] != arr[i]){
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
