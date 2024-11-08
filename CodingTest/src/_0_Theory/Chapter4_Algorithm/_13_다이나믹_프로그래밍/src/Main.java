package _0_Theory.Chapter4_Algorithm._13_다이나믹_프로그래밍.src;// 알고리즘 - 다이나믹 프로그래밍

public class Main {
    // 피보나치 수열 일반풀이 방법 O(n^2)
    // 계산했던 부분도 다시 계산
    // f(n) = f(n-1)+f(n-2)
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    // 타뷸레이션 방식 -> for문 - O(n)
    public static int fibDP(int n) {
        int[] arr = new int[n < 2 ? 2 : n + 1];
        arr[0] = 0;
        arr[1] = 1;


        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    // 메모이제이션 방식 -> 재귀 - O(n)
    static int[] arr = new int[8];
    public static int fibDP2(int n) {
        if (n <= 2) {
            return 1;
        }

        if (arr[n] != 0) {
            return arr[n];
        }

        arr[n] = fibDP2(n - 1) + fibDP2(n - 2);
        return arr[n];
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(fib(7));
        System.out.println(fibDP(7));
        System.out.println(fibDP2(7));
    }
}
