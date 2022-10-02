package Algorithm_13.src;// Practice
// 정수 n 이 주어졌을 때 아래의 연산을 통해 1로 만들려고 한다.
// 2로 나누어 떨어지면 2로 나누기
// 3으로 나누어 떨어지면 3으로 나누기
// 1 빼기
// 위의 연산을 통해 1로 만들 때 필요한 최소한의 연산 횟수를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// n: 2
// 출력: 1

// n: 9
// 출력: 2

public class Prac_1_my {


    static int[] dp;
    public static int solution(int n) {
        dp = new int [n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        return recur(n);
    }

    public static int recur(int n){
        int min = Integer.MAX_VALUE;
        if(n == 1) return 0;

        if(dp[n] != 0) return dp[n];

        if(n % 2 == 0){
            min = Math.min(min, recur(n/2));
        }
        if(n % 3 == 0){
            min = Math.min(min, recur(n/3));
        }

        min = Math.min(min, recur(n-1));
        dp[n] = min + 1;
        return min + 1;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(2));    // 1
        System.out.println(solution(4));    // 2
        System.out.println(solution(9));    // 2
        System.out.println(solution(10));   // 3
    }
}
