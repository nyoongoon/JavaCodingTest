package Base_Algorithm.Chapter2_Linear;

import java.util.Stack;

public class Linear_TEST_02_02_ans {

    public static void main(String[] args) {
        int[] a = {8, 2, 6, 3, 4, 1, 5, 7, 2, 8};
        int[] b = {2, 0, 0, 6, 3, 4, 5, 3, 6, 7}; //[1, 0, 2, 6, 9, 7, 6, 1, 0, 9, 5]
        int[] result = solution(a, b);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        int[] a1 = {8, 2, 6, 3, 4, 1, 5, 7, 2, 8};
        int[] b1 = {0}; //[1, 0, 2, 6, 9, 7, 6, 1, 0, 9, 5]
        int[] result1 = solution(a1, b1);

        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
        System.out.println();
        int[] a2 = {8, 2, 6, 3, 4, 1, 5, 7, 2, 8};
        int[] b2 = {}; //[1, 0, 2, 6, 9, 7, 6, 1, 0, 9, 5]
        int[] result2 = solution(a2, b2);

        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
        System.out.println();
    }

    public static int[] solution(int[] a, int[] b) {
        if (a.length == 0) {
            return b;
        }
        if (b.length == 0) {
            return a;
        }
        Stack<Integer> stk = new Stack<>();
        int maxLength = Math.max(a.length, b.length);

        int offsetA = maxLength - a.length;
        int offsetB = maxLength - b.length;

        int overflow = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            int aIdx = i - offsetA;
            int bIdx = i - offsetB;

            int valueA = i - offsetA >= 0 ? a[aIdx] : 0;
            int valueB = i - offsetB >= 0 ? b[bIdx] : 0;
            int sum = valueA + valueB + overflow;

            overflow = sum >= 10 ? 1 : 0;
            stk.push(sum % 10);
        }

        if (overflow > 0) {
            maxLength++;
            stk.push(1);
        }

        int[] resultArr = new int[maxLength];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = stk.pop();
        }

        return resultArr;
    }
}




