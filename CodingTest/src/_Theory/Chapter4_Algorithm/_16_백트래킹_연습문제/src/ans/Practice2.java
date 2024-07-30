package _Theory.Chapter4_Algorithm._16_백트래킹_연습문제.src.ans;// Practice2
// 숫자 7193 은 7193 도 소수이고,
// 719, 71, 7 도 각각 소수이다.
// n 이 주어졌을 때, n 자리 수 중에 위와 같은 소수를 찾는 프로그램을 작성하세요.

// 입출력 예시
// 입력 n: 3
// 출력: 233, 239, 293, 311, 313, 317, 373, 379, 593, 599, 719, 733, 739, 797


import java.util.ArrayList;

public class Practice2 {
    public static ArrayList<Integer> result;

    public static ArrayList<Integer> solution(int n) {
        result = new ArrayList<>();

        int[] primes = {2, 3, 5, 7};
        for (int prime : primes) {
            backtracking(prime, n, 1);
        }

        return result;
    }

    private static void backtracking(int prime, int n, int cnt) {
        if (n == cnt) {
            result.add(prime);
            return;
        }

        for (int i = 0; i < 10; i++) {
            int target = prime * 10 + i;

            if (isPrime(target)) {
                // 프루닝
                backtracking(target, n, cnt + 1);
            }
        }
    }

    private static boolean isPrime(int prime) {
        for (int i = 2; i <= Math.sqrt(prime); i++) {
            if (prime % i == 0) {
//                System.out.println("prime == " + prime + ", i == " + i);
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // Test code
        System.out.println(solution(3));
        System.out.println();
        System.out.println(solution(4));
    }
}
