package _Theory.Chapter1_Math.Math_09_2.src;

public class Practice1_my {

    public static int solution(int n) {
        if(n == 0){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n ; i++) {
            // 기존 로직
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[(i-1)-j];
            }
        }

        return dp[n];
    }



    public static void main(String[] args) {
        // Test code
        System.out.println(solution(0));
        System.out.println(solution(2));
        System.out.println(solution(5));
        System.out.println(solution(7));
    }
}
