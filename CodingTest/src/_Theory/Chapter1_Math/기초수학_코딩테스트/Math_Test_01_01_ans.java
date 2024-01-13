package _Theory.Chapter1_Math.기초수학_코딩테스트;

import java.util.Arrays;

public class Math_Test_01_01_ans {

    public static int solution(int n) {
        int[] arr = new int[n + 1];
        for (int i = 2; i < arr.length - 1; i++) {
            arr[i] = 1;
        }


        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(arr[i] == 0){
                continue;
            }
            for (int j = 2; j <= n / i; j++) {
                arr[i * j] = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                System.out.println(i);
            }
        }

        return Arrays.stream(arr).sum();
    }

    public static boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(100));
    }
}
